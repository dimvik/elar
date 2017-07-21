package vklvdm.elar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by vikulov.d on 20.07.2017.
 */
@SpringBootApplication
@EnableJpaRepositories
public class ElarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElarApplication.class, args);
	}
}
