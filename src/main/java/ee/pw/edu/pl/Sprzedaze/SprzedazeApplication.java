package ee.pw.edu.pl.Sprzedaze;

import ee.pw.edu.pl.Sprzedaze.model.Sprzedawca;
import ee.pw.edu.pl.Sprzedaze.repository.SprzedawcaRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"ee/pw/edu/pl/Sprzedaze/controller", "ee/pw/edu/pl/Sprzedaze/services"})
@EntityScan("ee/pw/edu/pl/Sprzedaze/model")
@EnableJpaRepositories("ee/pw/edu/pl/Sprzedaze/repository")
public class SprzedazeApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SprzedazeApplication.class, args);
	}

	@Autowired
	private SprzedawcaRepository sprzedawcaRepository;

	@Override
	public void run(String... args) throws Exception {
		Sprzedawca sprzedawca = new Sprzedawca("FAJNAFIRMA", "Ann Sem", "Piękna 122, Warszawa", "12-123-123-12", "111-111-111", "example@gmail.com", "nrkontabankowegoshouldbevalidatedinapp");
		sprzedawcaRepository.save(sprzedawca);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}
		};
	}

}
