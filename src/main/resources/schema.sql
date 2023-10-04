DROP TABLE IF EXISTS invoice_detail;
CREATE TABLE proyecto_coder.invoice_detail (
    id INT NOT NULL AUTO_INCREMENT,
    invoice_id INT NOT NULL,
    amount INT NOT NULL,
    product_id INT NOT NULL,
    price DOUBLE NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (invoice_id) REFERENCES proyecto_coder.invoice(id),
    FOREIGN KEY (product_id) REFERENCES proyecto_coder.product(id)
);


DROP TABLE IF EXISTS invoice;
CREATE TABLE proyecto_coder.invoice(
    id INT NOT NULL AUTO_INCREMENT,
    client_id INT NOT NULL,
    created_at DATE NOT NULL,
    total DOUBLE NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (client_id) REFERENCES proyecto_coder.client(id)
);

DROP TABLE IF EXISTS product;
CREATE TABLE proyecto_coder.product(
    id INT NOT NULL AUTO_INCREMENT,
    description VARCHAR(150) NOT NULL,
    code VARCHAR(50) NOT NULL,
    stock INT NOT NULL,
    price DOUBLE NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS client;
CREATE TABLE proyecto_coder.client (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(75) NOT NULL,
    last_name VARCHAR(75) NOT NULL,
    doc_number VARCHAR(45) NOT NULL,
    PRIMARY KEY (id)
);
