package ru.netology.netologyjdbctask.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.netologyjdbctask.entity.Order;
import ru.netology.netologyjdbctask.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products/fetch-product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Order> getProduct(@RequestParam String name) {
        return productService.getProductName(name);
    }
}
