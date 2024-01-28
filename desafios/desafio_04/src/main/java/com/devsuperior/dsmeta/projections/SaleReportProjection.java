package com.devsuperior.dsmeta.projections;

import java.time.LocalDate;

public interface SaleReportProjection {
    public Long getId();

    public LocalDate getDate();

    public Double getAmount();

    public String getSellerName();
}
