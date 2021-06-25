select o.product_name from orders o
INNER JOIN customers c ON(o.customer_id = c.id)
WHERE c.name = :name;