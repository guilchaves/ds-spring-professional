package br.com.chaves.desafio;

import br.com.chaves.desafio.entities.Order;
import br.com.chaves.desafio.services.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioApplication implements CommandLineRunner {

	@Autowired
	public ShippingService shippingService;

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("\nHello world!");
		Order o = new Order(1309, 230.00, 20.00);

		System.out.println(shippingService.shipment(o));

	}
}
