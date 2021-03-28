# Statement

The server will handle requests to view statements by performing simple search on date and
amount ranges.
- The request should specify the account id.
- The request can specify from date and to date (the date range).
- The request can specify from amount and to amount (the amount range).
- If the request does not specify any parameter, then the search will return three months
back statement.
- If the parameters are invalid a proper error message should be sent to user.
- The account number should be hashed before sent to the user.
- All the exceptions should be handled on the server properly.

# Technologies
- Java 1.8
- Spring MVC with Spring Boot
- MS Access
- Maven
# Getting started
 - Clone the git statement project from Github
 - execute following commands 
   - mvn clean install
   - mvn spring-boot:build-image
   - docker run -it -p8080:8080 statement:0.0.1-SNAPSHOT
 - Browse to http://localhost:8080/nagarro

# Welcome Page
![image](https://user-images.githubusercontent.com/5140477/112759068-62fcc880-9002-11eb-906b-e5bdeccfac1b.png)
# Login Page
 - URL: http://localhost:8080/nagarro/login
 - ![image](https://user-images.githubusercontent.com/5140477/112759097-845db480-9002-11eb-9e9e-7de3ae65008a.png)

# User Home
 - URL: http://localhost:8080/nagarro/user
 - ![image](https://user-images.githubusercontent.com/5140477/112759164-d8689900-9002-11eb-8e29-db4c9964fcd1.png)
# User Search
  - URL: http://localhost:8080/nagarro/statement/?accountId=5
  - ![image](https://user-images.githubusercontent.com/5140477/112759226-21205200-9003-11eb-8b1c-61fc4cc1554b.png)
# Admin Home
  - URL: http://localhost:8080/nagarro/admin
  - ![image](https://user-images.githubusercontent.com/5140477/112759264-46ad5b80-9003-11eb-9dc9-ba0cbcabf6fa.png)

# Admin Search:
  -URL: http://localhost:8080/nagarro/statement/?accountId=3&fromDate=2020-01-01&toDate=2021-03-28&fromAmount=100&toAmount=1000
  -  ![image](https://user-images.githubusercontent.com/5140477/112759314-78bebd80-9003-11eb-86be-1a00afd3e04d.png)


