package learn.spring.springplayground.repository;

import learn.spring.springplayground.model.Course;

import java.util.List;

public interface CourseRepository {

    public List<Course> findAll();
    public Course findById(final Integer id);
    public  Course insert(Course course);
    public void deleteById(final Integer id);
    public void update(Course course);
}
