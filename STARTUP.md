# All About Me Startup Instructions
Welcome, and thank you for offering your help!

in order to begin contributing to All About Me, the following steps are required:

1. Make sure you have both the [Front](https://github.com/All-About-Me/All-About-Me-Angular-Front-End) and [Back](https://github.com/All-About-Me/All-About-Me-Back-End) end repositorys
2. Currently, the environment variables are set assuming that in the development environment angular front end will use port 4200 on localHost while the Spring Boot back end will use port 8080 on local host. 
3. If this is not the case, change the variables in the angular project in the .\src\environments\environment.ts file and in the Spring Boot project in the .\src\main\resources\application.yml. you will also have to change the values in the @CrossOrigins annotations in each controller class.
4. if you want to deploy the application, make sure to change the port numbers/IP address as needed in the .\src\environments\environment.prod.ts and the .\src\main\resources\application-prod.yml. You will also need to set the Endpoint, Username, and Password for the RDS instance you want to connect to the application
5. 
