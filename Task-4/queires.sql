CREATE TABLE customers (id INT PRIMARY KEY, name VARCHAR(100), city VARCHAR(50));
CREATE TABLE products (id INT PRIMARY KEY, name VARCHAR(100), price DECIMAL(10,2));
CREATE TABLE orders (
id	INT PRIMARY KEY AUTO_INCREMENT,
customer_id INT, product_id INT, quantity INT, order_date DATE,
FOREIGN KEY (customer_id) REFERENCES customers(id), FOREIGN KEY (product_id) REFERENCES products(id)
);
-- Customer order history (JOIN)
SELECT c.name AS customer, p.name AS product, o.quantity, p.price, (o.quantity * p.price) AS total, o.order_date
FROM orders o
JOIN customers c ON o.customer_id = c.id JOIN products p ON o.product_id = p.id ORDER BY o.order_date DESC;
-- Highest value order (Subquery) SELECT * FROM orders
WHERE (quantity * (SELECT price FROM products WHERE id = product_id))
= (SELECT MAX(o2.quantity * p2.price)
FROM orders o2 JOIN products p2 ON o2.product_id = p2.id);
-- Most active customer
SELECT customer_id, COUNT(*) AS order_count
 
FROM orders
GROUP BY customer_id ORDER BY order_count DESC LIMIT 1;
