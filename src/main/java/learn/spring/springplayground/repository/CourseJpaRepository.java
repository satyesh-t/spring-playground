package learn.spring.springplayground.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import learn.spring.springplayground.model.Course;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class CourseJpaRepository implements CourseRepository {

    @PersistenceContext
    EntityManager em;


    @Override

    public List<Course> findAll() {

        Query allCourse=em.createQuery("Select c1 FROM course c1");
        return allCourse.getResultList();
    }

    @Override
    public Course findById(Integer id) {

        return em.find(Course.class, id);

    }

    @Override
    @Transactional
    public Course insert(Course course) {
        return em.merge(course);
        //we can also use em.pesist(course)
        // with persist  hibernate tracks the object and tracks changes and persists again
        //Persist takes an entity instance,
        // adds it to the context and makes that instance managed (i.e. future updates to the entity will be tracked).
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {

        Course course = em.find(Course.class, id);
        em.remove(course);
    }

    @Override
    @Transactional
    public void update(Course course) {
        Course foundCourse = em.find(Course.class, course.getCourseId());
        foundCourse.setName(course.getName());
        foundCourse.setStartDate(course.getStartDate());
        foundCourse.setStudentCount(course.getStudentCount());
        em.merge(foundCourse);
    }


    @Transactional
    public void play()
    {

        Course course=new Course();

        course.setStudentCount(11);
        course.setStartDate(LocalDate.now());
        course.setName("DS");
        em.persist(course);

        course.setName("DS-update1");
        em.flush(); // flush the query / persitance context
                    // if flush is not called before detach() the persistence of Entity will not happen
        em.detach(course); // detaches the tracking of Entity/Entity from Entitymanager
                          // futher changes in entity will not be saved.

        course.setName("DS-update2");
        course.setName("DS-update3");
    }
}
