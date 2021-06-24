package ru.netology.netologyjdbctask.service;

import org.springframework.stereotype.Service;
import ru.netology.netologyjdbctask.dao.ProductDAO;

import java.util.List;

@Service
public class ProductService {

    private final ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<String> getProductName(String name) {
        return productDAO.getProductName(name);
    }

}
