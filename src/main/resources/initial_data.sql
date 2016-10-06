INSERT INTO expense_user(user_email, user_password) VALUES ('dummy@gmail.com', '$2a$10$F.tNwMhgMazE4V49BJRN/eY86pqfIvRSabhnQ0IJePqd/sPV7a98a');

insert into allergen (name) values ('milk');
insert into allergen (name) values ('eggs');
insert into allergen (name) values ('wheat');
insert into allergen (name) values ('fish');
insert into allergen (name) values ('soy');
insert into allergen (name) values ('peanuts');

insert into category (name) values ('bread');
insert into category (name) values ('cakes and pies');
insert into category (name) values ('candy');
insert into category (name) values ('sandwiches');
insert into category (name) values ('cookies');
insert into category (name) values ('pastries');

insert into bakedgood (cost, name, vendor, category_id, inventory) values (3.44, 'muffin', 'songs', 6, 10);
insert into bakedgood (cost, name, vendor, category_id, inventory) values (4.50, 'tart','elephants delicatessin', 2, 10);
insert into bakedgood (cost, name, vendor, category_id, inventory) values (6.99, 'breakfast sandwich','grand central', 4, 10);
insert into bakedgood (cost, name, vendor, category_id, inventory) values (5, 'keylime pie','beaverton bakery', 2, 10);
insert into bakedgood (cost, name, vendor, category_id, inventory) values (2.50, 'kaiser roll','resers', 1, 10);

insert into bakedgood_allergen (bakedgood_id, allergens_id) values (1,1);
insert into bakedgood_allergen (bakedgood_id, allergens_id) values (1,2);
insert into bakedgood_allergen (bakedgood_id, allergens_id) values (1,3);
insert into bakedgood_allergen (bakedgood_id, allergens_id) values (2,1);
insert into bakedgood_allergen (bakedgood_id, allergens_id) values (2,2);
insert into bakedgood_allergen (bakedgood_id, allergens_id) values (3,1);
insert into bakedgood_allergen (bakedgood_id, allergens_id) values (3,2);
insert into bakedgood_allergen (bakedgood_id, allergens_id) values (5,3);

insert into ingredient (cost, name, unitofmeasure, inventory) values (2, 'espresso','shot', 100);
insert into ingredient (cost, name, unitofmeasure, inventory) values (0, 'water','cup', 100);
insert into ingredient (cost, name, unitofmeasure, inventory) values (0, 'ice','cup', 100);
insert into ingredient (cost, name, unitofmeasure, inventory) values (.25, 'whip','shot', 100);
insert into ingredient (cost, name, unitofmeasure, inventory) values (.5, 'cream','shot', 100);
insert into ingredient (cost, name, unitofmeasure, inventory) values (.5, 'milk','shot', 100);
insert into ingredient (cost, name, unitofmeasure, inventory) values (.5, 'carameal','tablespoon', 100);
insert into ingredient (cost, name, unitofmeasure, inventory) values (.5, 'chocolate','tablespoon', 100);

insert into drink (name, description, cost) values ('mocha','smooth and rich',3);
insert into drink (name, description, cost) values ('drip coffee','dark and bitter', 2 );
insert into drink (name, description, cost) values ('americano','smooth and dark' , 2);
insert into drink (name, description, cost) values ('frappichino','heavy and delicious', 4);
insert into drink (name, description, cost) values ('latte','tasty and bubbly', 3);

insert into recipeitem (amount, ingredient_id) values (1, 2);
insert into recipeitem(amount, ingredient_id) values (2, 3);
insert into recipeitem (amount, ingredient_id) values (3, 4);
insert into recipeitem (amount, ingredient_id) values (4, 5);
insert into recipeitem (amount, ingredient_id) values (5, 6);
insert into recipeitem (amount, ingredient_id) values (3, 4);
insert into recipeitem (amount, ingredient_id) values (4, 5);
insert into recipeitem (amount, ingredient_id) values (5, 6);

insert into drink_recipeitem (drink_id, items_id) values(1,1);
insert into drink_recipeitem (drink_id, items_id) values(1,5);
insert into drink_recipeitem (drink_id, items_id) values(1,4);
insert into drink_recipeitem (drink_id, items_id) values(1,6);
insert into drink_recipeitem (drink_id, items_id) values(1,8);
insert into drink_recipeitem (drink_id, items_id) values(2,1);
insert into drink_recipeitem (drink_id, items_id) values(2,2);
insert into drink_recipeitem (drink_id, items_id) values(3,1);
insert into drink_recipeitem (drink_id, items_id) values(3,2);
insert into drink_recipeitem (drink_id, items_id) values(4,1);
insert into drink_recipeitem (drink_id, items_id) values(4,3);
insert into drink_recipeitem (drink_id, items_id) values(4,4);
insert into drink_recipeitem (drink_id, items_id) values(4,6);
insert into drink_recipeitem (drink_id, items_id) values(4,8);
insert into drink_recipeitem (drink_id, items_id) values(4,7);
insert into drink_recipeitem (drink_id, items_id) values(5,1);
insert into drink_recipeitem (drink_id, items_id) values(5,6);
insert into drink_recipeitem (drink_id, items_id) values(5,4);

