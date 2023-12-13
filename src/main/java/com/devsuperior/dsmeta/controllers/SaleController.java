package com.devsuperior.dsmeta.controllers;

import com.devsuperior.dsmeta.dto.SellerMinDTO;
import com.devsuperior.dsmeta.projections.SellerMinProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.services.SaleService;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<SaleMinDTO> findById(@PathVariable Long id) {
        SaleMinDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/report")
    public ResponseEntity<?> getReport() {
        // TODO
        return null;
    }

    LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

    @GetMapping(value = "/summary")
    public ResponseEntity<List<SellerMinDTO>> getSummary(
            @RequestParam(name = "minDate", defaultValue = "") String minDate,
            @RequestParam(name = "maxDate", defaultValue = "") String maxDate,
            @RequestParam(name = "name", defaultValue = "") String name
    ) {
        List<SellerMinDTO> dto = service.getSummary(minDate, maxDate, name);
        return ResponseEntity.ok(dto);
    }
}
