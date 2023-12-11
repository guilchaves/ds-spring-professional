package com.devsuperior.uri2621;

import com.devsuperior.uri2621.dto.ProductMinDTO;
import com.devsuperior.uri2621.projections.ProductMinProjection;
import com.devsuperior.uri2621.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2621Application implements CommandLineRunner {

	@Autowired
	private ProductRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2621Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<ProductMinProjection> list = repository.filterByAmount(10, 20, "P");
		List<ProductMinDTO> resultSql = list.stream().map(ProductMinDTO::new).collect(Collectors.toList());
		System.out.println("*** RESULTADO SQL ***");
		resultSql.forEach(System.out::println);


		System.out.println("\n\n");
		List<ProductMinDTO> resultJpql = repository.filterByAmount2(10, 20, "P");
		System.out.println("*** RESULTADO JPQL ***");
		resultJpql.forEach(System.out::println);
	}
}
