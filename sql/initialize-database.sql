# cleanup everything before creation
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS product;

# create users table
CREATE TABLE user(
    id BIGINT NOT NULL AUTO_INCREMENT,
    username VARCHAR(15) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    is_enabled BIT NOT NULL,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    role VARCHAR(5) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (id),
    UNIQUE (username),
    UNIQUE (email)
);

# create products table
CREATE TABLE product(
    id BIGINT NOT NULL AUTO_INCREMENT,
    description VARCHAR(255) NOT NULL,
    name VARCHAR(15) NOT NULL,
    price DECIMAL(20) NOT NULL,
    currency VARCHAR(5) NOT NULL,
    quantity INTEGER NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (id),
    UNIQUE (name),
    UNIQUE (description)
);

# insert users
INSERT INTO user VALUES(1, 'admin', 'admin@admin.com', '$2a$10$IPb.s4dQc.Y34X/L0gf2jeZCn3WLvXguBNIhK8LJM6IaFiiAyHjcm', true, 'admin', 'admin', 'ADMIN');

# insert products
INSERT INTO product VALUES(1, 'Modern smartphone', 'Phone', 1500, 'USD', 5);
INSERT INTO product VALUES(2, 'Modern laptop', 'Laptop', 2750, 'USD', 5);
INSERT INTO product VALUES(3, 'Great headphones', 'Headphones', 475, 'USD', 25);
INSERT INTO product VALUES(4, 'Tiny postcard', 'Postcard', 5, 'USD', 1000);
INSERT INTO product VALUES(5, 'Ordinary cap', 'Cap', 15, 'USD', 75);