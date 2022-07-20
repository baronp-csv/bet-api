## Environment
- Java version: 1.8
- Maven version: 3.*
- Spring Boot version: 2.3.4.RELEASE

## Data
Example of a Bet data JSON object:
```json
{
    "id":1,
    
    "ticker": "Apple",
    
    "startDate": "2022-01-01",
    
    "endDate": "2022-01-16",

    "prediction": 130.0
}
```

## Requirements
Here you are provided a bet REST API where you have to secure the following REST endpoints using spring security rest. Implementation of those endpoints has already provided.

`GET` request to `/api/bet/{id}`:
* returns the bet entry with given id and status code 200

`GET` request to `/api/bet`:
* returns all the bet entries and status code 200

## Security flow to be implemented

[1] Login and get JWT Access Token(API KEY)

```
curl -X POST localhost:8000/api/login/auth -H 'Content-Type: application/json' -d '{"username":"test","password":"test"}'

RESPONSE:
eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0IiwiaWF0IjoxNjQ5NjUxMzg1LCJleHAiOjE2NDk3Mzc3ODV9.2HzB39kW2wVseYoLyo5kBDaEVHItAF0zFWK-AyamC8aPmHk1U-bClrVmCjtillH_mYOPK7brqCasW_ziz6-Gag
```

`NOTE`
user table has already been populated with username 'test' and password 'test'.

[2] Get data using Access Token(API KEY) as Authorization Header

```
curl -X GET 'localhost:8000/api/bet/1' --header 'Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0IiwiaWF0IjoxNjQ5NjUxMzg1LCJleHAiOjE2NDk3Mzc3ODV9.2HzB39kW2wVseYoLyo5kBDaEVHItAF0zFWK-AyamC8aPmHk1U-bClrVmCjtillH_mYOPK7brqCasW_ziz6-Gag'
'

RESPONSE:
{
    id:  1,
    ticker:  "Apple",
    startDate:  "2022-01-01",
    endDate:  "2022-01-15",
    prediction:  153.0
}
```
- complete the implementation of `AuthController`'s `/api/login/auth` method which needs to authenticate and return JWT token.
- complete the implementation of `JwtSecurityConfig`'s `configure` method which needs to permit `/api/login/auth` and `/ready` but authenticate all other endpoints.

## Commands
- run: 
```bash
mvn clean spring-boot:run
```
- install: 
```bash
mvn clean install
```
- test: 
```bash
mvn clean test
```