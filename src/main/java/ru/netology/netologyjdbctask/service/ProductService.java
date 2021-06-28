package ru.netology.netologyjdbctask.service;

import org.springframework.stereotype.Service;
import ru.netology.netologyjdbctask.dao.ProductDAO;
import ru.netology.netologyjdbctask.dto.ProductDTO;
import ru.netology.netologyjdbctask.entity.Order;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public List<ProductDTO> getProductsNames(String name) {
        List<Order> orders = productDAO.getProductsNames(name);
        List<ProductDTO> products = new ArrayList<>();
        for (Order order:
             orders) {
            products.add(new ProductDTO(order.getProductName()));
        }
        return products;
    }

}
