package com.devsuperior.dsmeta.services;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SellerMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.projections.SellerMinProjection;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    private static final LocalDate TODAY = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

    public SaleMinDTO findById(Long id) {
        Optional<Sale> result = repository.findById(id);
        Sale entity = result.get();
        return new SaleMinDTO(entity);
    }

    @Transactional(readOnly = true)
    public List<SellerMinDTO> getSummary(String minDate, String maxDate, String name) {
        LocalDate max = parseDateOrDefault(maxDate, TODAY);
        LocalDate min = parseDateOrDefault(minDate, max.minusYears(1L));
        List<SellerMinProjection> result = repository.getSummary(min, max, name);
        return result.stream().map(SellerMinDTO::new).toList();
    }

    private LocalDate parseDateOrDefault(String date, LocalDate defaultValue) {
        return date.isBlank() ? defaultValue : LocalDate.parse(date);
    }
}
