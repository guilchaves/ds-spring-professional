package br.com.guilchaves.dscommerce.dto;

import br.com.guilchaves.dscommerce.entities.Product;

public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String igmUrl;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, String description, Double price, String igmUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.igmUrl = igmUrl;
    }

    public ProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
        price = entity.getPrice();
        igmUrl = entity.getImgUrl();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getIgmUrl() {
        return igmUrl;
    }
}
