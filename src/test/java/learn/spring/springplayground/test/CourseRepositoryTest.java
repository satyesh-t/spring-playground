package learn.spring.springplayground.test;


import learn.spring.springplayground.model.Course;
import learn.spring.springplayground.repository.CourseRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
    public void findAllTest()

    {
        List<Course> allCourse=cr.findAll();
        Assertions.assertTrue(allCourse.size()>0);
    }

    @Test
    public void findByIdV()
    {
       Course course=cr.findById(1);
        Assertions.assertNotNull(course);
    }
    @Test
    public void findByIdException()
    {
        Assertions.assertThrowsExactly(EmptyResultDataAccessException.class,() -> cr.findById(99));
    }

    @Test
    public void insert()
    {
        Course c=new Course();
        c.setCourseId(101);
        c.setName("DS");
        c.setStudentCount(1);
        c.setStartDate(LocalDate.now());
        cr.insert(c);
        Assertions.assertNotNull(cr.findById(101));
    }
    @Test
    public void delete()
    {
        Course c=new Course();
        c.setCourseId(102);
        c.setName("DS");
        c.setStudentCount(1);
        c.setStartDate(LocalDate.now());
        cr.insert(c);
        Assertions.assertNotNull(cr.findById(102));
        cr.deleteById(102);
        Assertions.assertThrowsExactly(EmptyResultDataAccessException.class,()->cr.findById(102));

    }
}
