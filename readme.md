# DWP BPDTS Test
This project is created for DWP BPDTS test, the purpose of this API is to call the API at https://bpdts-test-app-v4.herokuapp.com/, and returns people who are listed as either living in London, or whose current coordinates are within 60 miles of London
## Running the API
The API is written as a SpringBoot MVC web api, to run it locally simply run the DwpBpdtsApplication from the ide of your choosing or run 
```bash
mvn spring-boot:start
```
## Deployment
The API is currently being deployed to a tomcat server at https://dwp.waleedrehman.co.uk, this is achieved by packaging the application as a war and uploading to Tomcat Web Application Manager portal manually.
To package the application simply run
```bash
mvn package
```
or 
```bash
mvn compile war:war
```
- https://maven.apache.org/plugins/maven-war-plugin/usage.html

Once you have created the war file simply upload the war to either the webapps folder in your tomcat installation or use the upload functionality in the tomcat web application manager portal.
## Optionals
I have coded the API in a way so that it can take be used for different cities and radius based on the parameter passed into the service call, if no parameters are being passed in the default values remain London and 60 for radius in miles however if we were to pass in Manchester and 40 for radius in miles the API would still return the users based out of Manchester or within 40 miles of Manchester.
## Changes I would do
Currently the API is calling another API which returns a list of cities within the radius and city name provided and then loops through these to fetch users based out of these cities which works however it could be a slow process and could take forever if requested with higher numbers of miles, to enhance performance I would try to look for a solution which could accomodate just the data set rather than having to query each city in uk to fetch the users.
The API is currently returning an array of multiple json responses got for each cities, according to our front-end our how we would consume this response it might be better to combine the arrays to one response using the help of user dto so each response can be associated to a data object which could then be listed in the response to be returned
