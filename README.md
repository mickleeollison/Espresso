# README #

This README would normally document whatever steps are necessary to get your application up and running.

### What is this repository for? ###

* Final project

### How do I get set up? ###

* there is no special set up to this project as I use eclipse and postgres for the project with database name finalproject.
### Features Completed ###

•	Ingredients has all the basic crud features with fields name cost, unit of measure and inventory.
•	Bakery Goods also have all the basic crud features with fields name, cost, vendor, category, allergens, and inventory.
•	Coffee drink recipes have all the basic crud operations with fields name, cost, Description, and recipe
•	The application contains a coffee shop UI theme.
•	The application has front end user validation:
1.	Names, description, vendor, unit of measure all are validated regex with errors displayed to the user after bad input. (This validation is also utilized for number values cost and inventory). This validation is also repeated in the service layer.
2.	Category and allergens are both implemented via lookup table and displayed in selects restricting the user to a given set of options to choose from.
3.	Name values are unique and cannot be repeated.
4.	Ingredients that are used in coffee projects cannot be deleted.
5.	Drink recipes cannot be created/ updated if there’s not enough inventory.
6.	Each ingredient must have nonnegative amounts in a drink recipe.
•	The application utilizes a MVC RESTful design.
•	Unit test coverage is 88.8% for services and 96.8% in validation
•	Selenium has happy and sad paths on all crud operation for happy and some sad paths.
•	The application is implemented in Spring Boot, CSS, HTML, jQuery, and JavaScript as suggested.
•	The app has a mobile first design, via Bootstrap, with responsiveness to changes to page sizes and nonessential, omitted features at smaller sizes.
•	Frontend Templating with Handlebars is implemented on all put a few parts of the application—I couldn’t figure out how to add variable dynamic elements that require templating themselves in the given time period. 
•	Inventory fields are added to ingredients and baked goods, with the ability to continuously track ingredients inventory with the adding, removal, and updating of drink recipes, and the prevention of adding/updating drinks beyond their inventory amounts. 
•	The price of a coffee recipe is the sum multiple of the given ingredients and ingredients costs in the drink


### Bugs Observed ###

•	The selenium test happyCreateDrink()  sometimes fails on the first time through but passes every subsequent time