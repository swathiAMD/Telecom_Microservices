# Telecom Microservices



Minimal [Spring Boot](http://projects.spring.io/spring-boot/) sample app.

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.example.telecommicroservices.TelecomMicroservicesApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

This program contains following api:
1. http://localhost:8090/ or http://localhost:8090/Phonenumbers : for viewing all the exisitng Phone numbers irrespective of the Customer.
2.  http://localhost:8090/Phonenumbers/{fullname} : for retrieving the phone numbers of a particular customer.
3. http://localhost:8090/Phonenumbers/{phonenumber}/enable/{enable} : to activate an particular phone number.

Please note since Spring security is used in the application, once you start the  credentials are required for login.

Username : user
Password: Once the application is started the password is created and printed in the console. 
