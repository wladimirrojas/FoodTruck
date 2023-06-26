# Java version : 17.0.7 with Spring
# RXjava version : 3.1.6
# Mockito version : 5.3.1
# Dependencies :
## Lombok
## Mysql connector
## MongoDb springboot

# FoodTruck
Testing Java with Spring, and Async

The main reason for this repository is to keep practicing and experimenting with apis,
rxjava, arquitecture, and all the stuff to improve.
Also, saving the knowledge adquired within the year in my current work as a software developer junior.

As for now, we few endpoints with it:
> since it is not working, but local, all urls work only with localhost
> I will keep the name "FoodTruck", because it is the main reason on this repository, to recreate a food oriented project, with payment, users, online menu, etc.
---

# Api documentation

| METHOD | PARAMETER | RESPONSE | URL |
| :------: | :---------: | :--------: | :-----: |
| GET | NONE | get all users | /list |
| POST | BODY USER | save an user to mongodb database | /save |
| DELETE | BODY USER | delete that user from the database | /delete |

Calling the pokemon api, that simply imitate the behavior

| METHOD | PARAMETER | RESPONSE | URL |
| :------: | :---------: | :--------: | :-----: |
| GET | numeric id | get the pokemon with that id | /getById/{id} |

