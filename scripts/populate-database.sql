# roles
INSERT INTO role VALUES(1, 'ROLE_USER');
INSERT INTO role VALUES(2, 'ROLE_ADMIN');

# users
INSERT INTO user VALUES(1, 'admin@admin.com', 'admin', true, 'admin', '$2a$10$IPb.s4dQc.Y34X/L0gf2jeZCn3WLvXguBNIhK8LJM6IaFiiAyHjcm', 'admin', 2);

# products
INSERT INTO product VALUES(1, 'Modern smartphone', 'Phone', 1500, 5);
INSERT INTO product VALUES(2, 'Modern laptop', 'Laptop', 2750, 5);
INSERT INTO product VALUES(3, 'Great headphones', 'Headphones', 475, 25);
INSERT INTO product VALUES(4, 'Tiny postcard', 'Postcard', 5, 1000);
INSERT INTO product VALUES(5, 'Ordinary cap', 'Cap', 15, 75);