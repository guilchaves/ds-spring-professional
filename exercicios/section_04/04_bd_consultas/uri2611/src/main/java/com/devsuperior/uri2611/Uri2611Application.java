package com.devsuperior.uri2611;

import com.devsuperior.uri2611.dto.MovieMinDTO;
import com.devsuperior.uri2611.projections.MovieMinProjection;
import com.devsuperior.uri2611.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner {

	@Autowired
	private MovieRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<MovieMinProjection> list = repository.filterMovieByGenre("Action");
		List<MovieMinDTO> result1 = list.stream().map(MovieMinDTO::new).collect(Collectors.toList());
		System.out.println("\n*** RESULTADO SQL VANILLA***");
		result1.forEach(System.out::println);

		System.out.println("\n\n");

		List<MovieMinDTO> result2 = repository.filterMovieByGenre2("Action");
		System.out.println("\n*** RESULTADO JPQL***");
		result2.forEach(System.out::println);

	}
}
