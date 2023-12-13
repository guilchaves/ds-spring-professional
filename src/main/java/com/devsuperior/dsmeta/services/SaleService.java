package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import com.devsuperior.dsmeta.dto.SellerMinDTO;
import com.devsuperior.dsmeta.projections.SellerMinProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    public SaleMinDTO findById(Long id) {
        Optional<Sale> result = repository.findById(id);
        Sale entity = result.get();
        return new SaleMinDTO(entity);
    }


    LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

    @Transactional(readOnly = true)
    public List<SellerMinDTO> searchTotalSalesBySeller(String minDate, String maxDate, String name) {
        LocalDate min;
        LocalDate max;
        if (minDate.isBlank()) {
            minDate = (today.minusYears(1L)).toString();
        }

        if (maxDate.isBlank()) {
            maxDate = today.toString();
        }

        if(name.isBlank()){
            name = "";
        }

        min = LocalDate.parse(minDate);
        max = LocalDate.parse(maxDate);

        List<SellerMinProjection> result = repository.searchTotalSalesBySeller(min, max, name);
        return result.stream().map(SellerMinDTO::new).toList();
    }
}
