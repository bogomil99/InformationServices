package my.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

/**
 * @author bborisov
 */
@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class SpringStarter {

	public static void main(String args[]) {
		SpringApplication.run(SpringStarter.class, args);
	}

}
