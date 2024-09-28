package com.mindHub.waveCenter.DTO;

public class ProductDTO {

    private long id;

    private ProductType productType;

    private double price;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.price = product.getPrice();
        this.productType = product.getProductType();
    }

    public long getId() {
        return id;
    }

    public ProductType getProductType() {
        return productType;
    }

    public double getPrice() {
        return price;
    }
}
