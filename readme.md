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

