# tarBUS - Android App

<img src="/readme/logo.svg" align="left"
width="200" hspace="10" vspace="10">

Ankieta Obywatelska - Backend

Aplikacja została stworzona z myślą o tych mieszkańcach okolic Tarnowa, którzy na co dzień przyzwyczajeni byli do nowoczesnych rozwiązań oferowanych przez linie miejskie, a przez zmianę na prywatnego przewoźnika - całkowicie stracili do nich dostęp.

<p align="left">
<a href="https://play.google.com/store/apps/details?id=com.dpajak99.tarbus2021">
    <img alt="Get it on Google Play"
        height="83"
        src="https://inspirationapps.com/wp-content/uploads/2020/01/google-play-badge.png" />
</a>  
<a href="https://apps.apple.com/pl/app/tarbus/id1554556128">
    <img alt="Get it on AppStore"
        height="80"
        src="https://inspirationapps.com/wp-content/uploads/2020/01/app-store-badge.png" />
        </a>
        </p>

## About

Jesteśmy małą grupką uczniów i studentów z tarnowskich szkół. Chcemy pomóc mieszkańcom naszych miejscowości w codziennym życiu. Naszym pierwszym projektem jest aplikacja tarBUS, która  wspomaga i upraszcza podróże komunikacją zbiorową na terenie miasta i gmin ościennych. Nasza idea przewodnia: Razem możemy uczynić nasze miasto lepszym miejscem!  

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
