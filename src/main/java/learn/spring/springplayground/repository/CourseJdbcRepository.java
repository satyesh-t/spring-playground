package learn.spring.springplayground.repository;

import learn.spring.springplayground.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

@Repository
public class CourseJdbcRepository implements CourseRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Course> findAll() {
        return jdbcTemplate.query("SELECT * FROM COURSE",new BeanPropertyRowMapper<>(Course.class));
    }

    @Override
    public Course findById(Integer id) {
        String sql="SELECT * FROM COURSE WHERE COURSE_ID=?";
        Object args[]=new Object[]{id};
        int[] argsType=new int[]{Types.INTEGER};
        Course c=jdbcTemplate.queryForObject(sql,args,argsType,new BeanPropertyRowMapper<>(Course.class));
        return c;
    }

    @Override
    public void insert(Course course) {
jdbcTemplate.
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void update(Course course) {

    }
}
