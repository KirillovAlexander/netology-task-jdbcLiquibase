package ru.netology.netologyjdbctask.dto;

public class ProductDTO {
    private String productName;

    public ProductDTO(String productName) {
        this.productName = productName;
    }

    public ProductDTO() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
