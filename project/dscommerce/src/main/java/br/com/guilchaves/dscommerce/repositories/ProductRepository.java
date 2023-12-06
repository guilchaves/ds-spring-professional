package br.com.guilchaves.dscommerce.repositories;

import br.com.guilchaves.dscommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
