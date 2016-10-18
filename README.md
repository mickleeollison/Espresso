# README #

### Motivation ###

This project is a coffee shop application which allows users to register and login and
once logged in create, update, remove, and view baked goods, ingredients, and drink recipes.
There is also inventory tracking of ingredents through the amount of ingredents used in drink recipies.

### Technologies used and dependencies ###

Written in Java use Spring Boot, Maven, JPA, Hibernate, AngularJS, HTML, and LESS

Dependencies include reflections, spring-boot-starter-web, spring-bot-starter-data-jpa, spring-boot-starter-security, hibernate-entitymanager, mysql-connector-java, mockito-all, selenium-java, and junit

### Installation ###

In order to run the project it must first be connected to a MySQL database which can be configured in the application.properties file under the spring.datasource username, password, and url properties

To run, import this project into your prefered IDE as a Maven project and run as a Java Application.

### Tests ###

To run unit tests for services click on the ExpresssoServiceTests class and run as JUnit tests and for validation tests navigate to the ExpressoValidationTests class
To run selenium testsclick on any of the page object classes under com.catalyst.training.expresso.pageobject.pages

### Additional Notes ###

Initial Data is loaded via initial_data.sql file in the src/main/resources/public folder and all date is removed each time the project is ran