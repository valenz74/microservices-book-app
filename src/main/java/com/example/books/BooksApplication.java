package com.example.books;

import com.example.books.model.Book;
import com.example.books.repository.BookRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class BooksApplication {

	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
	}

	@Bean
	InitializingBean sendData() {
		return () -> {
			Book book1 = Book.builder()
					.nombre("Harry Potter y la piedra filosofal")
					.autor("J. K. Rowling")
					.generos(List.of("fantasia", "aventuras", "novela")).build();
			bookRepository.save(book1);

			Book book2 = Book.builder()
					.nombre("El ancho mundo")
					.autor("Pierre Lemaitre")
					.generos(List.of("narrativa", "novela")).build();
			bookRepository.save(book2);

			Book book3 = Book.builder()
					.nombre("El cuco de cristal")
					.autor("Javier Castillo")
					.generos(List.of("novela negra", "novela")).build();
			bookRepository.save(book3);

			Book book4 = Book.builder()
					.nombre("Las formas del querer")
					.autor("Inés Rodrigo")
					.generos(List.of("novela", "narrativa")).build();
			bookRepository.save(book4);

			Book book5 = Book.builder()
					.nombre("Lejos de Luisiana")
					.autor("Luz Gabás")
					.generos(List.of("novela", "novela historica")).build();
			bookRepository.save(book5);

			Book book6 = Book.builder()
					.nombre("El señor de los anillos la comunidad del anillo")
					.autor("J. R. R. Tolkien")
					.generos(List.of("novela", "fantasia", "aventuras")).build();
			bookRepository.save(book6);
		};
	}

}
