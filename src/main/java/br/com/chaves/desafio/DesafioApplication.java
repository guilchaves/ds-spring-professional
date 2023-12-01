package br.com.chaves.desafio;

import br.com.chaves.desafio.entities.Order;
import br.com.chaves.desafio.services.OrderService;
import br.com.chaves.desafio.services.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class DesafioApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DesafioApplication.class, args);
    }

    @Autowired
    public OrderService orderService;

    @Override
    public void run(String... args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Entre com o código do pedido: ");
        Integer code = sc.nextInt();
        System.out.print("Entre com o valor básico do pedido: ");
        Double basic = sc.nextDouble();
        System.out.print("Entre com a porcentagem de desconto: ");
        Double discount = sc.nextDouble();

        Order o = new Order(code, basic, discount);
        System.out.println("Pedido código " + o.getCode());
        System.out.println("Valor total: R$ " + String.format("%.2f", orderService.total(o)));


        sc.close();
    }
}
