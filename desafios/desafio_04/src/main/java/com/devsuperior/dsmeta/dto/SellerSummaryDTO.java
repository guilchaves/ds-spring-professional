package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.projections.SellerSummaryProjection;

public class SellerSummaryDTO {

    private String nameSeller;
    private Double total;

    public SellerSummaryDTO(String nameSeller, Double total) {
        this.nameSeller = nameSeller;
        this.total = total;
    }

    public SellerSummaryDTO(SellerSummaryProjection projection)  {
        nameSeller = projection.getSellerName();
        total = projection.getTotal();
    }

    public String getNameSeller() {
        return nameSeller;
    }

    public void setNameSeller(String name) {
        this.nameSeller = name;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}


