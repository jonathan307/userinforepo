# userinforepo

1. Created the Github Repository UserInfo
2. Checkout repository UserInfo in IntelliJ IDE using "git clone" command
3. Created feature branch from master branch using "git checkout -b" command
4. Add maven framework to project (Right click on project name and select "add framework")
5. Created packages and java files
6. Created Spring boot java class UserInfoApplication with main method which starts up the application. @SpringBootApplication annotation is used to mark the
   class with the main method as a configuration and to do component scan.
7. Created Java class UserController with a @RestController annotation. This class has the mappings needed for the endpoints. Also interacts with the
   UserService class using a constructor.
8. Created the repository interface UserRepository which holds the database queries.
9. Created the Service class UserService to interact with UserRepository using a constructor.
10. Created a application.properties file in the resources directory to define the spring datasource variables.
11. Created a data.sql file in the resources directory to define the sql statements to load the csv file.
12. Copied the csv file to the resources directory.
13. Created a java class object UserInfo to hold the database rows.
14. Created a java class RequestDates to hold the start and end date for the date range endpoint.

How the application works

At startup, the application will create an in memory database table UserInfo and load it with the csv file.

http://localhost:8080/getspecificuser/109
- This endpoint will go to the controller class, then to the service class, then the repository and return the response for the specific user.

http://localhost:8080/getspecificdates
- This endpoint will go to the controller class, then to the service class, then the repository and return the response for the start date and end date.
- This endpoint uses a @RequestBody
  {
  "startdate": "6/30/2022",
  "enddate": "7/20/2023"
  }

http://localhost:8080/getspecificprofession/doctor
- This endpoint will go to the controller class, then to the service class, then the repository and return the response for the specific profession.

http://localhost:8080/customaddUser
- This endpoint will go to the controller class, then to the service class, then the repository to add a new user to the database.
- This endpoint uses a @RequestBody
  {
  "userId": 2000,
  "firstName": "Jonathan",
  "lastName": "Cole",
  "email": "jonathancole356@gmail.com",
  "profession": "Software Developer",
  "datecreated": "11/14/2022",
  "country": "USA",
  "city": "Clermont"
  }


Notes
-----
1. This application uses a in memory database and not a regular database instance so that it can be scalable to another user for testing.
2. The in memory database fails to load the String dates to the date column so the dates have to be loaded as String and the comparison done by the java
   program. 
