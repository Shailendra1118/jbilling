### This is SpringBoot based web application that serves REST base APIs for clients.
Business case taken - Electronic stores and Smartphones as products.

### Technology used -
 - Build -> Gradle
 - DB -> H2 
(DB is in memory and can be accessed using browser on http://localhost:8082)
 

### Primarity used Spring modules 
 - Spring Rest
 - Spring Repository
 - Spring Cache (EHCache)
 - Spring scheduling (AsyncTask) etc.



### How to run -
Using Gradlew build. It build fat jar in location %PROJECT_DIR%\jbilling\build\libs\jbilling-0.1.0.jar
(If running with IDE just start as plain java application.)

```sh
$ cd %PROJECT_DIR%\jbilling\build\libs\
$ java -jar jbilling-0.1.0.jar
```




### Todos

 - Write MORE Tests
 - Add Night Mode



