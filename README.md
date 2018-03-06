# News core

  **Simple backend service to serve news articles using spring boot**

## Deisgn

News core application developed using spring boot with mysql as backend database, it contains following end points for operations on news articles

#### NewsArticleController

Method	| Path	| Description	| User authenticated	| Available from UI
------------- | ------------------------- | ------------- |:-------------:|:----------------:|
GET	| /articles	| Get specified articles data (optional filters - published date range from & to) | × | ×
GET	| /articles/{articleId}	| Get article data for specified article id | × | ×
PUT	| /articles/{articleId}	| Updates article info | × | ×
POST	| /articles	| Creates a new article | × | ×
DELETE | /articles/{articleId} | Deletes specified article Id | × | ×

## How to run?

#### Before you start

#### Quick start installation using docker
- Install Docker.
- Export environment variables: 'MYSQL_HOST', 'MYSQL_PORT', 'MYSQL_USERNAME', 'MYSQL_PASSWORD'
- Run Mysql container first using following command
  `docker run -d  -p 3307:3306   --name demo-mysql     -e MYSQL_ROOT_PASSWORD=mysql123     -e MYSQL_DATABASE=news     -e MYSQL_USER=news_api_user     -e MYSQL_PASSWORD=mysql234     mysql:5.7`
- Once mysql container is running and healthy, start application container
`docker run -d     --name spring-boot-jpa-docker-webapp     --link demo-mysql:db     -p 8080:8080     -e MYSQL_HOST=db     -e MYSQL_PORT=3306     -e MYSQL_NAME=news     -e MYSQL_USER=root     -e MYSQL_PASSWORD=mysql123     menneni/news-core`

#### Important endpoints
- http://localhost:8080/info - application info
- http://localhost:8080/swagger-ui.html - swagger documenation

##### Required packges

If docker not installed, can run as a packaged application. Following packages required for building this project
- Apache Maven 3.3.9 (for build)
- Java 8
- Mysql 5.7 or above

#### build & run

After installing required packages as mentioned in the required packages section do

mvn spring-boot:run

By default application runs on 8080 port but can be customizable by editing `src/main/resources/application.yaml` file.

#### Sample usage

Create a new article by posting to http://localhost:8080/articles end point using CURL

`curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/hal+json' -d '{ \ 
 	"header": "Walmart launches a new home shopping site for furniture and home décor 2", \ 
 	"description": "Walmart launches a new home shopping site for furniture and home décor", \ 
 	"text": "Walmart launches a new home shopping site for furniture and home décor", \ 
 	"keywords": [{"keyword":"hyderabad"},{"keyword":"furniture"}], \ 
 	"authors": [{"name":"author1"}, {"name":"author2"}] \ 
 }' 'http://localhost:8082/articles'`
 
 Retrieve above artcile using following end point
 
 curl -X GET --header 'Accept: application/json' 'http://localhost:8080/articles/1'
 
 Retireve article between specific time period
 
 curl -X GET --header 'Accept: application/json' http://localhost:8080/articles?from=2018-02-05 20:26:20.0&to=2018-04-05 20:26:20.0


## Tests

## To do

unit test cases

docker compose to run application and mysql container together

elasticsearch to store news articles for effective retieval and text search
