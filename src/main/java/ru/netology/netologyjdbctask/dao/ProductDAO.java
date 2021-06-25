package ru.netology.netologyjdbctask.dao;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ProductDAO {
    private String scriptName = "product_name.sql";
    private String getProductNameSQLScript = read(scriptName);

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ProductDAO(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public List<String> getProductName(String name) {
        List<Map<String, Object>> productName = namedParameterJdbcTemplate.queryForList(getProductNameSQLScript, Map.of("name", name));
        List<String> products = new ArrayList<>();
        for (Map<String, Object> map:
             productName) {
            products.add((String) map.get("product_name"));
        }
        return products;
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
