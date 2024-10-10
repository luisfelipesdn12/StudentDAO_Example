package br.dev.joaquim.StudentApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.dev.joaquim.StudentApp.ihm.GenericIHM;
import br.dev.joaquim.StudentApp.ihm.MainIHM;

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

		GenericIHM ihm = new MainIHM();
		ihm.start();
	}
}
