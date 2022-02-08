# CreditCardApplication
This application will allow user to add credit card data and retrieve from an in-memory hazelcast instance

Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 

Prerequisites
In order to run this project, we need any IDE, Java 8 or higher version, Maven

Installing
A step by step series of examples that tell you how to get a development env running

Check java is installed
java -version

Check maven is configured
mvn -version

Development Specific Details
Clone CreditCardApplication Repo
git clone https://github.com/puneetpandita/CreditCardApplication.git

Run below maven command to compile project
mvn clean install

This is a ‘spring boot’ based web project running on maven repository. It includes JUnit test structures also.
The project is set to a fixed authorization with CSRF disabled by default. User can set desired credentials in application.yml file and same needs to use for authorization during testing. A handler is enabled for CSRF token-based authorization as well. Refer SecurityConfig.java for enabling it. Once enabled user will need to specify CSRF token and Cookie in request header along with credentials.

Deployment
Run/Start application
java -jar CreditCardProcessing-0.0.1-SNAPSHOT.jar

Sample postman collection is also provided for execution of web end points.

