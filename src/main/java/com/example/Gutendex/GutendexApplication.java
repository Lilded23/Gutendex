package com.example.Gutendex;

import com.example.Gutendex.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class GutendexApplication implements CommandLineRunner {

	@Autowired
	private BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(GutendexApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("1. Buscar libro por título");
			System.out.println("2. Listar todos los libros");
			System.out.println("3. Salir");
			int option = scanner.nextInt();
			scanner.nextLine();  // Consume newline
			switch (option) {
				case 1:
					System.out.print("Ingrese el título del libro: ");
					String title = scanner.nextLine();
					bookService.searchAndSaveBookByTitle(title);
					break;
				case 2:
					bookService.listAllBooks().forEach(System.out::println);
					break;
				case 3:
					return;
				default:
					System.out.println("Opción no válida.");
			}
		}
	}
}
