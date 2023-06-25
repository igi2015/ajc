DROP TABLE IF EXISTS item_categories;
DROP TABLE IF EXISTS items;
DROP TABLE IF EXISTS categories;

CREATE TABLE items (
                     id           INTEGER AUTO_INCREMENT PRIMARY KEY,
                     name         VARCHAR(30),
                     price        NUMERIC(10, 2),
                     description  VARCHAR(255)
);
CREATE INDEX items_name ON items (name);

CREATE TABLE categories (
                          id   INTEGER AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(80)
);
CREATE INDEX categories_name ON categories (name);

CREATE TABLE item_categories (
                               item_id       INTEGER NOT NULL,
                               category_id   INTEGER NOT NULL,
                               FOREIGN KEY (item_id) REFERENCES items (id),
                               FOREIGN KEY (category_id) REFERENCES categories (id)
);
