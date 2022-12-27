package learn.spring.springplayground.test;


import learn.spring.springplayground.model.Course;
import learn.spring.springplayground.repository.CourseRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@DirtiesContext
public class CourseRepositoryTest {

    @Autowired
    CourseRepository cr;

    @Test
    //@Disabled
    public void findAllTest() {
        List<Course> allcourse = cr.findAll();
        Assertions.assertTrue(allcourse.size() > 0);
    }

    @Test
    public void findById() {
        Course course = cr.findById(101);
        Assertions.assertNotNull(course);
    }

    @Test
    public void findByIdException() {
        Assertions.assertNull(cr.findById(1888));
        //Assertions.assertThrowsExactly(EmptyResultDataAccessException.class, () -> cr.findById(99));
    }

    @Test
    public void insert() {
        Course course = new Course();
        course.setName("GS-1");
        course.setStartDate(LocalDate.now());
        Course c1 = cr.insert(course);
        Assertions.assertNotNull(cr.findById(c1.getCourseId()));

    }

    @Test
    public void delete() {
        Course course = new Course();
        course.setName("GS-1");
        course.setStartDate(LocalDate.now());
        Course c1 = cr.insert(course);
        Assertions.assertNotNull(cr.findById(c1.getCourseId()));
        cr.deleteById(c1.getCourseId());
        Assertions.assertNull(cr.findById(c1.getCourseId()));
    }

    @Test
    public void update() {

        Course course = cr.findById(101);
        course.setStudentCount(77);
        cr.update(course);
        Assertions.assertEquals(cr.findById(101).getStudentCount(),
                77);
    }
}
