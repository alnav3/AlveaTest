CREATE TABLE IF NOT EXISTS BRAND(
    brand_id BIGINT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS PRICE(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    brand_id BIGINT,
    start_date TIMESTAMP,
    end_date TIMESTAMP,
    price_list INT,
    product_id INT,
    priority INT,
    price DOUBLE,
    currency VARCHAR(255),
    FOREIGN KEY (brand_id) REFERENCES brand(brand_id)
);

INSERT INTO BRAND (brand_id, name)
VALUES (1, 'ZARA');

INSERT INTO PRICE (id,brand_id, start_date, end_date, price_list, product_id, priority, price, currency)
VALUES 
(1,1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 35455, 0, 35.50, 'EUR'),
(2,1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 2, 35455, 1, 25.45, 'EUR'),
(3,1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 3, 35455, 1, 30.50, 'EUR'),
(4,1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 4, 35455, 1, 38.95, 'EUR');


