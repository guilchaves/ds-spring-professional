package br.com.guilchaves.dscommerce.repositories;

import br.com.guilchaves.dscommerce.entities.Order;
import br.com.guilchaves.dscommerce.entities.User;
import br.com.guilchaves.dscommerce.projections.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}