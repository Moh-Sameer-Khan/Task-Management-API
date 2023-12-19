
## **Welcome to README-FILE[Documentation]👋**
___
___

# Task Management API[**(Basic Design-SignIn, SignUp, signout, user and Admin controller)**](#heading-ids) 
![Blogging Platform Logo](https://images.unsplash.com/photo-1611224923853-80b023f02d71?q=80&w=1000&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8dGFza3xlbnwwfHwwfHx8MA%3D%3D)

____

## Table of Contents
1. [Introduction](#introduction)
2. [Technologies & Framework Used](#technologies-used)
3. [Features](#features)
4. [Prerequisites](#features)
5. [Installation](#installation)
6. [Usage](#usage)
7. [API Endpoints](#api-endpoints)
8. [Data Structures](#database-schema)
9. [Security](#security)
10. [Project Summary](#project-summary)
11. [Contributing](#contributing)
12. [License](#Licesne)

> ## Introduction 
*Task Management System API is a backend project that aims to provide a robust and scalable platform for users to create and manage Tasks, update on tasks, delte the tasks, and authorize user and Adming can control all Task Management System. The platform is designed to offer a seamless user experience and allow tasks to showcase their writing skills and engage with a wider audience.*

-  ## [**Framework and Technologies Used :**](#heading-ids) ##
___
- Java Spring Boot: For building the backend server and managing RESTful endpoints.

- MySQL: As the relational database management system to store user and blog-related data.

- Hibernate: For object-relational mapping between Java entities and the MySQL database.


- Swagger: For API documentation and testing.

- Maven: As the build tool to manage dependencies and run tasks.
- ### Framework : **SpringBoot**
- ### Technologies : **Java, MySQL**
- ### Others : **Java Persistence API (JPA), Swagger UI, Email**


> ## Features

- User Registration and Authentication: Users can sign up, log in, and log out securely using email and password credentials.
- Admin Registration and Authentication: Admin can sign up, log in, and log out securely using email and password credentials 
and Admin can also control all activity of any user.
- Create and Manage Tasks: Authenticated users can create new Tasks, edit their existing task, and delete their tasks.

- Pagination: Tasks are paginated to enhance the user experience.

- User-Friendly API: The project provides a well-documented and user-friendly API for easy integration with front-end applications.

-  ## [**Prerequisites :**](#heading-ids) ##
*To run this project, ensure that you have the following installed:*
> - Java Development Kit (JDK)
>- MySQL
>- Maven

-  ## [**Installation :**](#heading-ids) ##

1. Clone the repository from [GitHub link](https://github.com/Moh-Sameer-Khan/Task-Management-API.git).
2. Install Java JDK and Maven on your machine.
3. Set up a MySQL database and configure the database connection in the application.properties file.
4. Run the Maven build to compile the project.
5. Start the application using the command.

## [Usage](#heading-ids) ##

1. After starting the application, access the API documentation at [http://localhost:8080/swagger-ui.html](http://43.204.236.74:8080/swagger-ui/index.html#/) for information on available endpoints and how to interact with the API.

2. Use tools like Postman or any API client to test the various API endpoints.

## [**Data Flow**](#heading-ids) ##

- ## [**API Endpoints Used:**](#heading-ids) ##
___
- ### 1. **Controller (User, Task, AuthenticationToken):-** ###
> - **User/Task Controller :-**  
> 1. `POST /user/signUp` - *Register a new user with the system.*
> 2. `POST /user/signIn` - *Authenticate and obtain a token for the Tasks user and By Hashing Password and Using Email*
> 3. `POST /user/signOut` - 
*Log out a user.*
> 4. `POST /task/add` - 
*Create a new Tasks post.*
> 5. `DELETE /task/undone` - 
*Delte a Task by adimin or user.*
> 6. `POST /task/done` - 
*Add a task as done*

> 10. `GET /task/todo` - 
*Get all tasks of a particular user*
> 11. `PUT /task/update` - 
*Update by admin or user any tasks information*

> 13. `POST /task/taskId/pagination` - 
*get paginated tasks of a user*



> - **Admin Controller :-**  
> 1. `POST /admin/signUp` - *Register a new admin with the system.*
> 2. `POST /admin/signIn` - *Authenticate and obtain a token for the Tasks admin and By Hashing Password and Using Email*
> 3. `POST /admin/signOut` - 
*Log out a admin.*


- ### 2. **DataBase Design:-** ###
> - **Database Used :-**  *SQL/Hibernate Database using*

The database schema consists of the following tables:

1. User: Stores user details like name, email, and password.
2. Post: Contains task information, including title, content, and user author.
3. Task: Stores Task name, task date along with the user who made the task.
4. AuthenticationToken: Manages user authentication tokens.


- ### 3. **Model / Entity(User, Task, Admin, AuthenticationToken):-** ###
> - **Annotation Used :-**  *@Data, @NoArgsConstructor, @AllArgsConstructor, @Id, @OneToOne, @Column, @JoinColumn, @Entity, @GeneratedValue, @Enumerated, @NotBlank, @Min, @Max, @ManyToMany, @ManyToOne, @JoinTable, @JsonProperty, @NotNull, @Column, @Validated, @Pattern*

## [**Data Structure used in my Project**](#heading-ids) ##
____
> - **[Used :-](#heading-ids)** *SQL Database --> But Mostly used Java Concept, oops, collection, ENUM*

## [**Security**](#heading-ids) ##
____
*Authentication is implemented using an Authentication Token class. This token is generated upon successful sign-in and must be included in the headers of subsequent requests to authorized endpoints.*

## [**Encryption**](#heading-ids) ##
____
*Authentication is implemented using an Authentication Token class. This token is generated upon successful sign-in and must be included in the headers of subsequent requests to authorized endpoints.*


## [**Project Summary**](#heading-ids) ##
____
> - **[Aim :-](#heading-ids)** *This is basically good project for learning purpose springBoot basics, Mappings, Annotation, API, spring mvc and CRUD Operation, swagger, crud Repository inbuilt method, and Custom Finder and Custom Query. In this project i just add Posts, get all psots a particular user,  update User inforamtion lot of things i learned from this project.*

## **[👨‍💻 Sameer](#heading-ids)** ##
____

- Twitter: [@Sameer.twitter](https://twitter.com/Sameerr1819)

- Github: [@Sameer-Github](https://github.com/Moh-Sameer-Khan)


🤝 **Contributing**
___
Contributions, Thanks to everyone , contributing with me and know about more myself [visit my profile](https://www.instagram.com/sameer181911/).

**Show Your Support**
___
Give a ⭐if this project helped you!

- ```bash
  BECOME A SOFTWARE DEVELOPER 👩‍💻

<!-- Here something icon -->

📝 **License**
___
Copyright © 2023 [Moh Sameer Khan](#heading-ids).

This project is [Task Management API](https://choosealicense.com/licenses/mit/) licensed.

___
*This README was generated with* 🧡 *by [readme-md-generator](https://www.makeareadme.com/)*








