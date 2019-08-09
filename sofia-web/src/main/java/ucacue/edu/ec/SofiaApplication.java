package ucacue.edu.ec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"ucacue.edu.ec"})
@EnableJpaRepositories(basePackages = {"ucacue.edu.ec.persistence"})
@EntityScan(basePackages = {"ucacue.edu.ec.persistence.entity"})
@PropertySource("classpath:data.properties")
public class SofiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SofiaApplication.class, args);
	}


}