package ru.netology.netologyjdbctask.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.netologyjdbctask.dto.ProductDTO;
import ru.netology.netologyjdbctask.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/fetch-product")
    public List<ProductDTO> getProducts(@RequestParam String name) {
        return productService.getProductsNames(name);
    }

    @GetMapping ("/hello")
    public String Hello() {
        return "Hello everyone!";
    }
}
