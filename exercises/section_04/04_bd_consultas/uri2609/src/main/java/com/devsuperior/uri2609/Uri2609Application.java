package com.devsuperior.uri2609;

import com.devsuperior.uri2609.dto.CategorySumDTO;
import com.devsuperior.uri2609.projections.CategorySumProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2609.repositories.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2609Application implements CommandLineRunner {

	@Autowired
	private CategoryRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2609Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<CategorySumProjection> list = repository.productsByCategory();
		List<CategorySumDTO> result1 = list.stream().map(CategorySumDTO::new).collect(Collectors.toList());

		System.out.println("\n***RESULTADO SQL***");
		result1.forEach(System.out::println);

		System.out.println("\n\n");

		List<CategorySumDTO> result2 = repository.productsByCategory2();

		System.out.println("\n***RESULTADO JPQL***");
		result2.forEach(System.out::println);

	}
}