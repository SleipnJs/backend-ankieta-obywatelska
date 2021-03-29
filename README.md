# SleipnJS - Hackarök 2021 - Ankieta Obywatelska
<img src="/readme/hackathon-logo5.b20e6cfb.png" align="left"
width="100" hspace="10" vspace="10">
<img src="/readme/logo.svg" align="left"
width="100" hspace="10" vspace="10">


## Ankieta Obywatelska - Backend

Serwer do strony Ankieta obywatelska. Projektu Stworzonego na Hackarök 2021
<br />
<br />
## Skład zespołu
> Dominik Pająk<br />
> [![Github](https://img.shields.io/badge/-Github-000?style=flat&logo=Github&logoColor=white)](https://github.com/dpajak99)
> [![Linkedin](https://img.shields.io/badge/-LinkedIn-blue?style=flat&logo=Linkedin&logoColor=white)](https://www.linkedin.com/in/dominikpajak/)

> Jakub Serwin<br />
> [![Github](https://img.shields.io/badge/-Github-000?style=flat&logo=Github&logoColor=white)](https://github.com/Isaayy)

## About

**Wstęp**
Hej! Z tej strony zespół SleipnJs. Temat tegorocznego hackatonu był dosyć skomplikowany ale widzimy, że większość zdała egzamin. Teraz nasza kolej. Na Hackarok 2021 przygotowaliśmy projekt o nazwie Ankieta Obywatelska.

**Zgodność z tematyką konkursu**
**Prawdziwa teraźniejszość** - temat mocno otwarty, ale za to dający szerokie pole do popisu. Z czym nam się  kojarzy obecna teraźniejszość? Dyskusje ekologiczne, Protesty, Covid, Nauczanie i praca zdalna, ... To są tematy, które w ostatnim czasie mocno dominują w naszym społeczeństwie. Dlatego też długo wisiały na naszej tablicy zanim ostatecznie wybraliśmy projekt. Ankieta Obywatelska to podsumowanie tych szystkich tematów, dla 
którego nie znaleźliśmy bezpośredniej konkurencji. Jasne, istnieją stronki typu Google Formsy czy podobne,
ale tam ciężko trafić na coś co naprawdę nas interesuje. Ankieta Obywatelska to generator a jednocześnie zbiór
ankiet i petycji poruszających różne tematy społeczne. Teraźniejszość? Bo dotyczy tu i teraz, bo troszczy
się o obywateli, bo pozwala im odnaleźć miejsce, w którym mogą wyrazić swoje zdanie. A myślimy, że każdy lubi myśleć, że jego głos ma znaczenie. Dlaczego "prawdziwa"? Bo odpowiednio dobrany system weryfikacji w maksymalnie możliwym stopniu ograniczy możliwość zagłosowania wielokrotnie przez tą samą osobę, jednocześnie nie narażając użytkownika na niepotrzebne męczenie się z wypełnianiem groma formularzy rejsetracyjnych

W trakcie projektu zmagaliśmy się z kilkoma problemami, lecz najbardziej dotknął nas chyba brak snu. Całe szczęście wszystko co sobie zaplanowaliśmy, udało nam się dociągnąć do końca! Jesteśmy z tego powodu zadowoleni!

Hacknarök to była świetna zabawa! Widzimy się w następnym roku!


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
