package hancheol.PenguinMall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PenguinMallApplication {

	public static void main(String[] args) {
		SpringApplication.run(PenguinMallApplication.class, args);
	}

}
