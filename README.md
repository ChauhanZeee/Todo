# TODO Api Project 
## Frameworks and language used:
-  Spring Boot
-  Java
- SQL database


## Data Flow

* **Model** :
  There are ONE Model class in this application.
    1. Todo Model Class.

* **Controller** :

  There are One Controller class in this application.

    1. Todo Controller Class.

**Functions/Endpoints used in User Controller Class.**
- To add Todo data :
- http://localhost:8080/api/v1/todo-app/add-todo

- To get all Todo's information:
- http://localhost:8080/api/v1/todo-app/find-all

- To update Todo's details:
- http://localhost:8080/api/v1/todo-app/update-todo/id/{id}

- To delete Todo by id:
- http://localhost:8080/api/v1/todo-app/to-delete/id/{id}

- To get Todo by id:
- http://localhost:8080/api/v1/todo-app/find-todo/id/{id}


* **Service** :

      * In this application there are One service class .
        * Todo Service Class

* **Repository**

    * In this application there Four Repository class.
        * ITodoRepository

* **Database**

    * I have used SQL Database to store the data.

## Project Summary

In this application by using various RestApi we can add Todo.
we fetch various data using different ewndpoints.
