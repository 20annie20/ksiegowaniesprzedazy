package ee.pw.edu.pl.Sprzedaze;

import ee.pw.edu.pl.Sprzedaze.model.Sprzedawca;
import ee.pw.edu.pl.Sprzedaze.model.Sprzedaz;
import ee.pw.edu.pl.Sprzedaze.repository.SprzedawcaRepository;
import ee.pw.edu.pl.Sprzedaze.repository.SprzedazRepository;
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
		Sprzedawca sprzedawca = new Sprzedawca("FAJNAFIRMA", "Anna Semrau", "Piękna 122, Warszawa", "12-123-123-12", "111-111-111", "example@gmail.com", "47 2121 1009 0000 0002 3569 8741");
		sprzedawcaRepository.save(sprzedawca);
		sprzedawca = new Sprzedawca("FIRMA2", "Jan Kowalski", "ul. Długa 3, Bydgoszcz", "12-127-127-12", "131-123-171", "example2@gmail.com", "49 1020 2892 2276 3005 0000 0000");
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
