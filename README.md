# A2ZStore-SpringBoot

## PPT Link
  Click [here](https://docs.google.com/presentation/d/1qKgxO4dinN5CTBM2Ejkt0AtyMZT2xax2CEKnsZBjgGA/) to see PPT of the project.


## Setup Procedure
  ### 1. Database Creation (MySQL)
  ` CREATE DATABASE a2zstore; `
  
  ### 2. Open src/main/resources/application.properties
  Change datasource username and password in this file:
  
  ` spring.datasource.username={username} `  
  ` spring.datasource.password={password} ` 
  
  Change PayPal credentials:  
  ` paypal.client.id={paypal id} `  
  ` paypal.client.secret={paypal secret} `  
  
  Change Twilio credentials:  
  ` twilio.acc.sid={twilio sid} `  
  ` twilio.acc.token={twilio token} `  
  ` twilio.acc.phno={twilio ph.no} `  
  
  ### 3. Open src/main/resources/gmail-creds.properties
  Change Gmail Credentials:  
  ` email={Gmail Id} `  
  ` password={Gmail Password} `
  
  ### 4. pom.xml
  (Do below step, only if created new spring starter project and copied source folder alone to your project)  
  Copy the dependencies of pom.xml 
  
  ### 5. Run the application 
  Run the application in STS (Spring Tool Suite) IDE as a Spring Boot App
  
  ### 6. Open App in Browser
  Open ` localhost:8080/ ` in browser
  
  ### 7.Default Credentials & Products
  The application have two types of users:  
  
  #### Admin:
  ` Email: admin@a2z.app `  
  ` Password: admin@a2z `  

  #### Customer:
  ` Email: testuser@a2z.app `  
  ` Password: testuser@a2z `

  Some products will be added by default into the database from the ` products.csv ` file in ` src/main/resources/ ` folder.
  
  You can disable these by commenting ` MyCommandLineRunner ` class in ` src/main/java/com/SpringA2ZStoreApplication ` file
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

