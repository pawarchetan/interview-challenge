# Pleo challenge

We would like you to create a user interface using any framework of your choise that solves the following problem.

## The problem

In this challenge, you are given a vector of heights and these heights form a structure like shown in the following figure.
 
![Figure 1](figure1.png)

Vector : **[2, 5, 1, 3, 1, 2, 1, 7, 7, 6]**
 
It is now raining over the structure and the water starts flowing onto the cells.  The water in a cell always flows to the neighboring cell of least height - if it is not already occupied by water or a block. All the neighboring cells that drains into a sink are said to form a basin. 
 
![Figure 2](figure1.2.png)
 
Observe that the structure is thereby partitioned into basins. You need to determine the number of unit of water contained in all basins. In this example the input for this program is [2, 5, 1, 3, 1, 2, 1, 7, 7, 6] and the output is 17 units of water.

## The objective

The goal is to create an optimal algorithm that given any array will output the correct units of water. Please make a user interface to enter the values and visualize the solution.

## Solution 

#### Technology used :
* Java8
* Spring Boot
* Spring MVC test
* ReactJS
* Swagger
* Junit
* Lombok
* Gradle
* Development methodology used : TDD (for backend service)
* IDE used --> IntelliJ

#### How to run :
* If you are running service from IDE, please install Lombok plugin and enable annotation processing in annotation processor settings (Intellij).
* To run service from terminal/command prompt please follow below steps :
    * To run backend service : go to directory `drain-water-container`  and run command **`gradle bootRun`**
    * Access the swagger API at _**http://localhost:8080/swagger-ui.html**_
    * Swagger API is all documented.
    * To run client / frontend : go to directory `pleo-client` and run command **`npm start`**
    * Access the client application at _**http://localhost:3000**_
    * Default number of rows and column are set to 5 but we can increase/decrease the count using the buttons given at the bottom. Once you reduce the number of rows/column , please use the button `Reset/Apply’ to apply changes. 

#### Code coverage :
* Approximately 99% code has been covered. (Backend service)
* Test has been written using JUnit, Mockito and Spring MVC test (to test controllers).
* Code coverage is measured using Intellij IDEA code coverage plugin.

#### Implementation details :
* **Backend service : (drain-water-container)**
    * All algorithmic implementation of problem statement is in service class.
    * Used single dimensional array `waterContainedCells` to represent cells contained water and same is consumed on the client side.
    * `Why we used single dimensional array, not 2 dimensional array\` : The input we are getting from client or mentioned in problem 
    statement is one dimensional, so I wanted to keep it aligned with what we are consuming and what we are producing.
    * StructureDto  model class is used to transfer result from service to client like total units of water contained in structure and cells which contain water.
    * To handle exception in more better way, used ControllerAdvice.
    * Cross origin request has been handled using annotation **`@CrossOrigin`**
    * Setter, Getters and Logging is handled by Lombok.
    * Unit testing has been done by JUnit and Spring MVC test. Spring MVC test has been used for controller (RestController) testing.
* **Client : (pleo-client)**
    * Client application has been developed using react. 
    * React project has been created using `create-react-app` tool.
    * To display structure, used grid which is created using matrix like structure (2 dimensional array)
    * Square component is used for displaying the box like structure in grid.

#### Limitations/Future scope:
* Number of rows and columns are same from client side. In future we can change/ modify it.
* Unit tests for React components
* Integration tests
* If required, integration of code coverage tools like Jacoco and Implementation of BDD using cucumber.

#### Screenshots: 
* please find it file screenshot.md
