package br.dev.joaquim.StudentApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.dev.joaquim.dao.H2StudentDAO;
import br.dev.joaquim.ihm.StudentIHM;

@SpringBootApplication
public class StudentAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("-------------------------");
		System.out.println("APLICACAO INICIALIZADA");
		System.out.println("-------------------------");

		StudentIHM ihm = new StudentIHM(new H2StudentDAO());
		ihm.start();
	}

}
