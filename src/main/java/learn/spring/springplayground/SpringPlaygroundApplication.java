package learn.spring.springplayground;

import learn.spring.springplayground.repository.CourseJpaRepository;
import learn.spring.springplayground.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringPlaygroundApplication implements CommandLineRunner {

	@Autowired
	private CourseJpaRepository cr;

	public static void main(String[] args) {
		SpringApplication.run(SpringPlaygroundApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		cr.play();
	}
}
