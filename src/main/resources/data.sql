--PRODUCT table
INSERT INTO "PRODUCT" (id, product_name, description, base_price, product_type) 
VALUES(1L, 'MotoG4','Fourth generation', 8000, 'Phone');
INSERT INTO "PRODUCT" (id, product_name, description, base_price, product_type) 
VALUES(2L, 'iPhoneX','With face recognition', 45000, 'Phone');
INSERT INTO "PRODUCT" (id, product_name, description, base_price, product_type) 
VALUES(3L, 'RedMi4','By Xiomi', 9000, 'Phone');


--STORE table
INSERT INTO "STORE" (id, store_name, description, location) VALUES(1L, 'iStore','iStore', 'Pune');
INSERT INTO "STORE" (id, store_name, description, location) VALUES(2L, 'MobileShopy','MobileShopy', 'Pune');
INSERT INTO "STORE" (id, store_name, description, location) VALUES(3L, 'Mobilewalas','MobileShopy','Pune');


--PRICE_STORE table
INSERT INTO "PRICE_STORE" (id, product_id, store_id, store_price) 
VALUES(1L, 1, 2, 8500);
INSERT INTO "PRICE_STORE" (id, product_id, store_id, store_price) 
VALUES(2L, 1, 3, 9000);
INSERT INTO "PRICE_STORE" (id, product_id, store_id, store_price) 
VALUES(3L, 3, 2, 9000);
INSERT INTO "PRICE_STORE" (id, product_id, store_id, store_price) 
VALUES(4L, 3, 3, 10000);
INSERT INTO "PRICE_STORE" (id, product_id, store_id, store_price) 
VALUES(5L, 2, 1, 47000);

