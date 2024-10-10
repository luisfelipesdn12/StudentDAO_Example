package br.dev.joaquim.StudentApp.ihm;

import java.util.Scanner;

import br.dev.joaquim.StudentApp.dao.H2CourseDAO;
import br.dev.joaquim.StudentApp.dao.H2StudentDAO;

public class MainIHM implements GenericIHM {

    public MainIHM() {
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int option = -1;

        while (option != 0) {
            System.out.println("=== Main Menu ===");
            System.out.println("1. Manage Students");
            System.out.println("2. Manage Courses");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            GenericIHM ihm;

            switch (option) {
                case 1:
                    ihm = new StudentIHM(new H2StudentDAO(), new H2CourseDAO());
                    ihm.start();
                    break;
                case 2:
                    ihm = new CourseIHM(new H2CourseDAO());
                    ihm.start();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }


}
