package ru.netology.netologyjdbctask.dao;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.netology.netologyjdbctask.entity.Order;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductDAO {
    private static final String scriptName = "product_name.sql";

    @PersistenceContext
    EntityManager entityManager;

    public List<Order> getProductName(String ownerName) {
        Query query = entityManager.createQuery("Select o from Order o where o.customer.name =: name");
        query.setParameter("name", ownerName);
        List<Order> orders = query.getResultList();
        return orders;
    }
}
