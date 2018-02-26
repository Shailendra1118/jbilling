--PRODUCT table
INSERT INTO "PRODUCT" (id, product_name, description, base_price, product_type) 
VALUES(1L, 'MotoG4','Fourth generation', 8000, 'Phone');
INSERT INTO "PRODUCT" (id, product_name, description, base_price, product_type) 
VALUES(2L, 'iPhoneX','With face recognition', 42000, 'Phone');
INSERT INTO "PRODUCT" (id, product_name, description, base_price, product_type) 
VALUES(3L, 'RedMi4','By Xiomi', 9000, 'Phone');


--STORE table
INSERT INTO "STORE" (id, store_name, description, location) VALUES(1L, 'iStore','iStore', 'Pune');
INSERT INTO "STORE" (id, store_name, description, location) VALUES(2L, 'MobileShopy','MobileShopy', 'Pune');
INSERT INTO "STORE" (id, store_name, description, location) VALUES(3L, 'Mobilewalas','MobileShopy','Pune');
INSERT INTO "STORE" (id, store_name, description, location) VALUES(4L, 'VijaySales','Electronix', 'Pune');
INSERT INTO "STORE" (id, store_name, description, location) VALUES(5L, 'Croma','Tata shopy', 'Pune');
INSERT INTO "STORE" (id, store_name, description, location) VALUES(6L, 'Relience','Electro','Pune');
INSERT INTO "STORE" (id, store_name, description, location) VALUES(7L, 'Dave','Express Store', 'Pune');
INSERT INTO "STORE" (id, store_name, description, location) VALUES(8L, 'Jumbo','Electronix', 'Pune');
INSERT INTO "STORE" (id, store_name, description, location) VALUES(9L, 'Amazon B&M','NoSwipe shop','Pune');
INSERT INTO "STORE" (id, store_name, description, location) VALUES(10L, 'LG Shopee','Exclusive','Pune');


--PRICE_STORE table
INSERT INTO "STORE_PRICE" (id, product_id, store_id, store_price) 
VALUES(1L, 1, 1, 8500);
INSERT INTO "STORE_PRICE" (id, product_id, store_id, store_price) 
VALUES(2L, 1, 2, 9300);
INSERT INTO "STORE_PRICE" (id, product_id, store_id, store_price) 
VALUES(3L, 1, 3, 8200);
INSERT INTO "STORE_PRICE" (id, product_id, store_id, store_price) 
VALUES(4L, 1, 4, 9000);
INSERT INTO "STORE_PRICE" (id, product_id, store_id, store_price) 
VALUES(5L, 1, 5, 9200);
INSERT INTO "STORE_PRICE" (id, product_id, store_id, store_price) 
VALUES(6L, 1, 6, 8300);
INSERT INTO "STORE_PRICE" (id, product_id, store_id, store_price) 
VALUES(7L, 1, 7, 8400);

INSERT INTO "STORE_PRICE" (id, product_id, store_id, store_price) 
VALUES(8L, 2, 1, 45000);
INSERT INTO "STORE_PRICE" (id, product_id, store_id, store_price) 
VALUES(9L, 2, 2, 42000);
INSERT INTO "STORE_PRICE" (id, product_id, store_id, store_price) 
VALUES(10L, 2, 3, 47000);
INSERT INTO "STORE_PRICE" (id, product_id, store_id, store_price) 
VALUES(11L, 2, 4, 46000);
INSERT INTO "STORE_PRICE" (id, product_id, store_id, store_price) 
VALUES(12L, 2, 5, 48000);
INSERT INTO "STORE_PRICE" (id, product_id, store_id, store_price) 
VALUES(13L, 2, 6, 44000);

INSERT INTO "STORE_PRICE" (id, product_id, store_id, store_price) 
VALUES(14L, 3, 1, 9200);
INSERT INTO "STORE_PRICE" (id, product_id, store_id, store_price) 
VALUES(15L, 3, 2, 9500);
INSERT INTO "STORE_PRICE" (id, product_id, store_id, store_price) 
VALUES(16L, 3, 3, 10000);
INSERT INTO "STORE_PRICE" (id, product_id, store_id, store_price) 
VALUES(17L, 3, 4, 9700);
INSERT INTO "STORE_PRICE" (id, product_id, store_id, store_price) 
VALUES(18L, 3, 5, 9100);
INSERT INTO "STORE_PRICE" (id, product_id, store_id, store_price) 
VALUES(19L, 3, 6, 9600);

--PRICE_INFO table
INSERT INTO "PRICE_INFO" (id, product_id, ideal_price, currency) 
VALUES(1L, 1, 8200, 'INR');
INSERT INTO "PRICE_INFO" (id, product_id, ideal_price, currency) 
VALUES(2L, 2, 43000, 'INR');
INSERT INTO "PRICE_INFO" (id, product_id, ideal_price, currency) 
VALUES(3L, 3, 9500, 'INR');