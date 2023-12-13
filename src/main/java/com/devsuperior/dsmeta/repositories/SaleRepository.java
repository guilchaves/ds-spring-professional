package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.projections.SellerMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query(nativeQuery = true, value =
            "SELECT tb_seller.name AS sellerName, ROUND(SUM(tb_sales.amount), 1) as total "
                    + "FROM tb_seller "
                    + "INNER JOIN tb_sales ON tb_seller.id = tb_sales.seller_id "
                    + "WHERE tb_sales.date > :minDate AND tb_sales.date < :maxDate "
                    + "AND (:name IS NULL OR tb_seller.name LIKE CONCAT('%', :name, '%')) "
                    + "GROUP BY sellerName;")
    List<SellerMinProjection> getSummary(LocalDate minDate, LocalDate maxDate, String name);
}
