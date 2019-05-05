# Spark Authentication

A simple spark java implementation of login and signup.

## Technologies and frameworks used
    1. java 11
    2. spark core 2.12
    3. Gradle 4.10
    4. Spark Template Velocity
    5. Junit 5
    6. Postgres database

## Database

In PSQL:

    CREATE DATABASE auth_db;
    CREATE TABLE animals(id SERIAL PRIMARY KEY,email varchar,password varchar);
    
    
## TODO
introduce Filters - to check for auth status before directing a user to a given route.

## Screen Shots
![Screen Shot 2019-05-05 at 09 28 51](https://user-images.githubusercontent.com/14147462/57189909-cbc58e00-6f1c-11e9-9561-6c48e831d078.png)
![Screen Shot 2019-05-05 at 09 29 22](https://user-images.githubusercontent.com/14147462/57189908-cbc58e00-6f1c-11e9-9e85-3761ec501004.png)
![Screen Shot 2019-05-05 at 09 29 29](https://user-images.githubusercontent.com/14147462/57189907-cb2cf780-6f1c-11e9-8fc6-d4c3d173c889.png)
![Screen Shot 2019-05-05 at 09 29 38](https://user-images.githubusercontent.com/14147462/57189906-cb2cf780-6f1c-11e9-91a1-f7a025375f39.png)




## License
[![MIT Licence](https://badges.frapsoft.com/os/mit/mit-125x28.png?v=103)](LICENSE)
