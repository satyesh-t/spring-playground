package learn.spring.springplayground.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import learn.spring.springplayground.model.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseJpaRepository implements CourseRepository {

    @PersistenceContext
    EntityManager em;


    @Override
    public List<Course> findAll() {
        return null;
    }

    @Override
    public Course findById(Integer id) {

        return em.find(Course.class, id);

    }

    @Override
    @Transactional
    public Course insert(Course course) {
        return em.merge(course);
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
}
