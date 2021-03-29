# SleipnJS - Hackarök 2021 - Aplikacja Obywatelska | Backend
<img src="/readme/hackathon-logo5.b20e6cfb.png" align="left"
width="100" hspace="10" vspace="10">
<img src="/readme/logo.svg" align="left"
width="100" hspace="10" vspace="10">


## Ankieta Obywatelska - Backend

Serwer do strony Ankieta obywatelska. Projektu Stworzonego na Hackarök 2021

## Skład zespołu
Dominik Pająk
[![Github](https://img.shields.io/badge/-Github-000?style=flat&logo=Github&logoColor=white)](https://github.com/dpajak99)
[![Linkedin](https://img.shields.io/badge/-LinkedIn-blue?style=flat&logo=Linkedin&logoColor=white)](https://www.linkedin.com/in/dominikpajak/)

Jakub Serwin 
[![Github](https://img.shields.io/badge/-Github-000?style=flat&logo=Github&logoColor=white)](https://github.com/Isaayy)


## Technology Stack
- Java Spring
- Maven
- MySql
 
## Run Spring Boot application
```
mvn spring-boot:run
```

## Endpoints
```
@Post - authenticateUser
/signin @RequestBody Entity of LoginRequest
```
```
@Post - registerUser
/signup @RequestBody Entity of SignUpRequest
```
```
@Get - getForm
/data/forms @Param id @Param stage
```
```
@Get - getMostLiked
/data/formsMostLiked @Param amount 
```
```
@Post - setForm
/data/forms  @RequestBody Entity of JsonObject
```
```
@Put - updateForm
/data/forms @RequestBody Entity of FormStage
```
```
@Get - getFormResponses
/data/formResponse @Param id
```
```
@Post - setForm
/data/formResponse @Param id @RequestBody responses
```
```
@Put - updateUser
/api/user/{id} @Param id @RequestBody Entity of User
```
```
@Put - updateUserPassword
/api/userPassword/{id} @Param id @RequestBody Entity of User
```
```
@Get - getAllUsers
/api/admin/users @Param name
```
```
@Get - getUserById
/api/admin/users/{id} @Param id
```
```
@Put - updateUser
/api/admin/users/{id} @Param id @RequestBody Emtity of User
```
```
@Put - updateUserPassword
/api/admin/usersPassword/{id} @Param id @RequestBody Emtity of User
```
```
@Delete - deleteUser
/api/admin/users/{id} @Param id
```
```
@Get - getRoles
/api/admin/users/roles
```
=======
