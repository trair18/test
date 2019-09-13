### How to run?

#### Run mongodb server
1. Install docker and docker-compose on your computer
2. Open terminal in project directory where **docker-compose.yml** file placed
3. Run `docker-compose up`. After this command mongodb server will be started

*Alternative way: download and install mongodb server on your computer.*

#### Connect to mongodb from UI client - Robo3t, create shop db
1. Download Robo3t here [https://robomongo.org/download](https://robomongo.org/download).
2. Run robo3t and create new connection with `localhost:27017`
3. Create db with name `shop`

#### Run shop spring-boot application
1. Run main from ShopApplication class
2. Visit `http://localhost:8080/swagger-ui.html` in browser.