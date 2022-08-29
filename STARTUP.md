# All About Me Startup Instructions
Welcome, and thank you for offering your help!
this guide assumes that you have already setup: Angular 14 CLI, NPM 8, JDK 1.8 (or newer), the H2 console, and your preferred IDEs for Typescript and Java

in order to begin contributing to All About Me, the following steps are required:

1. Make sure you have both the [Front](https://github.com/All-About-Me/All-About-Me-Angular-Front-End) and [Back](https://github.com/All-About-Me/All-About-Me-Back-End) end repositorys cloned locally.
2. Currently, the environment variables are set assuming that in the development environment angular front end will use port 4200 on localHost while the Spring Boot back end will use port 8080 on local host. 
3. If this is not the case, change the variables in the angular project in the .\src\environments\environment.ts file and in the Spring Boot project in the .\src\main\resources\application.yml. you will also have to change the values in the @CrossOrigins annotations in each controller class.
4. if you want to deploy the application in production mode, make sure to change the port numbers/IP address as needed in the .\src\environments\environment.prod.ts and the .\src\main\resources\application-prod.yml. 
5. If you want to connect you project to an AWS RDS instance, you will also need to set the Endpoint, Database Name, Username, and Password for the RDS instance you want to connect to the application into your system environment variables to match the naming pattern in the application-prod.yml.
6. By default, the project will connect to a local H2 database when run in development mode and will connect to an RDS instance based on the system variables mentioned in step 5. to cheange this behavior, change the values in the application.yml and the application-prod.yml
7. Install the Angular project by navigating to the root directory for the Angular Front End and entering the command `npm install`
8. 
