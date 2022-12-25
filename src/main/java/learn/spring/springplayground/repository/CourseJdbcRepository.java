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
        Object []args=new Object[]{id};
        int[] argsType=new int[]{Types.INTEGER};
        Course c=jdbcTemplate.queryForObject(sql,args,argsType,new BeanPropertyRowMapper<>(Course.class));
        return c;
    }

    @Override
    public void insert(Course course)
    {
        Object[] args=new Object[]{course.getCourseId(),
                course.getName(),
                course.getStudentCount(),
                course.getStartDate()};
        int[] argsTypes=new int[]{Types.INTEGER,
                Types.VARCHAR,
                Types.INTEGER,
                Types.TIMESTAMP};
        jdbcTemplate.update("insert into course(course_id,name,student_count,start_date) values(?,?,?,?)",args,
                argsTypes);

    }

    @Override
    public void deleteById(Integer id) {

        String sql="DELETE from COURSE where course_id=?";
        int [] argTypes=new int[]{Types.INTEGER};
        Object[] args=new Object[]{id};
        jdbcTemplate.update(sql,
                args,
                argTypes);

    }

    @Override
    public void update(Course course) {
       String sql= "Update  course set name=?,student_count=?,start_date=? where course_id=?";
       int[] argTypes=new int[]{Types.VARCHAR,
               Types.INTEGER,
               Types.TIMESTAMP,
               Types.INTEGER};
       Object[] args=new Object[]{course.getName(),
               course.getStudentCount(),
               course.getStartDate(),
               course.getCourseId()};
       jdbcTemplate.update(sql,args,argTypes);

    }
}
