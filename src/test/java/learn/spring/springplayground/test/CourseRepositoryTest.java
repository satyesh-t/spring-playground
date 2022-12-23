package learn.spring.springplayground.test;


import learn.spring.springplayground.model.Course;
import learn.spring.springplayground.repository.CourseRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;

@SpringBootTest
public class CourseRepositoryTest {

    @Autowired
    CourseRepository cr;

    @Test
    public void findAllTest()
    {
        List<Course> allcourse=cr.findAll();
        Assertions.assertTrue(allcourse.size()>0);
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
        Course course=cr.findById(1);

        Assertions.assertThrowsExactly(EmptyResultDataAccessException.class,() -> cr.findById(99));
    }
}
