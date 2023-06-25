INSERT INTO items (name, price, description) VALUES
                                               ('Headphones', 49.99, 'Over-ear headphones with noise cancellation'),
                                               ('T-shirt', 19.99, 'Comfortable cotton t-shirt'),
                                               ('The Great Gatsby', 12.99, 'Classic novel by F. Scott Fitzgerald'),
                                               ('Blu-ray Movie', 9.99, 'Action-packed blockbuster film'),
                                               ('Notebook', 3.99, 'Spiral-bound notebook for jotting down ideas'),
                                               ('Smartphone', 599.99, 'High-end smartphone with advanced features'),
                                               ('Running Shoes', 79.99, 'Lightweight running shoes for athletes'),
                                               ('Guitar', 199.99, 'Acoustic guitar for music enthusiasts'),
                                               ('Digital Camera', 349.99, 'Professional-grade digital camera'),
                                               ('Laptop', 899.99, 'Powerful laptop for work and entertainment'),
                                               ('Graphic Novel', 15.99, 'Illustrated novel with captivating artwork'),
                                               ('Dumbbells Set', 49.99, 'Set of adjustable dumbbells for home workouts'),
                                               ('Coffee Maker', 79.99, 'Automatic coffee maker for brewing delicious coffee'),
                                               ('Bluetooth Speaker', 39.99, 'Portable speaker with wireless connectivity'),
                                               ('Dress Shirt', 29.99, 'Formal dress shirt for special occasions'),
                                               ('Cookbook', 19.99, 'Collection of delicious recipes'),
                                               ('Tablet', 299.99, 'Versatile tablet for productivity and entertainment'),
                                               ('Yoga Mat', 24.99, 'Non-slip yoga mat for exercise and meditation'),
                                               ('External Hard Drive', 89.99, 'Portable storage device for backing up data'),
                                               ('Desk Lamp', 14.99, 'Adjustable desk lamp for study or work');
INSERT INTO categories (name) VALUES
                                ('Electronics'),
                                ('Clothes'),
                                ('Books'),
                                ('Other Media'),
                                ('Office Accessories');

INSERT INTO item_categories (item_id, category_id) VALUES
                                                     (1, 1),
                                                     (2, 2),
                                                     (3, 3),
                                                     (4, 4),
                                                     (5, 5),
                                                     (6, 1),
                                                     (7, 2),
                                                     (8, 4),
                                                     (9, 1),
                                                     (10, 1),
                                                     (11, 3),
                                                     (12, 5),
                                                     (13, 1),
                                                     (14, 1),
                                                     (15, 2),
                                                     (16, 3),
                                                     (17, 1),
                                                     (18, 5),
                                                     (19, 5),
                                                     (20, 5);