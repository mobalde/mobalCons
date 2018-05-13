package mobalDev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@PropertySource("classpath:application.properties")
@EnableJpaAuditing
public class MobalConstApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(MobalConstApplication.class, args);
	}
	
}
