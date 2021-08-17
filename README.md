# hospitalManagement
 **About:**  
 This is a web application that is designed to mimic the functionality of a hospital andministration management system. This application was created using Spring Boot and connects to a MySql database. Users are allowed access to certain endpoints based on their role and the authorizations that are allowed for each role. Users with the role of Admin have access to everything, while users with the role of medical staff will have access to patient information. The last type of role availabe is that of staff who will only be allowed to look up information about the current employees in the hospital or information regarding the various departments. Only Admins are able to add in new employees or fire them.  
 
 **Requirements:**  
 Java 11  
 Spring Boot 2.5.3  
 MySQL Database  
 Hibernate 5  
 
 **Spring Dependencis:**  
 Spring Boot Actuator  
 Spring Boot Web    
 Spring Boot Data JPA  
 Spring Security  
 Thymeleaf  
 MySql Connector  
 
 **Database Schema:**   
 
 ![image](https://user-images.githubusercontent.com/43048860/129783613-5079d0a0-1be9-4181-9083-87294d10b8a5.png)  
 
 Note: The LoginDetails table has a column named password, which stores an encrypted password.
 
 Employee Trigger: This trigger will automatically create a new row in the loginDetails table every time a new employee is added and will populate that with a temporary role of staff.  
 CREATE DEFINER=`root`@`localhost` TRIGGER `employee_AFTER_INSERT` AFTER INSERT ON `employee` FOR EACH ROW BEGIN
INSERT INTO logindetails (employeeId, userName, password, role) values (NEW.employeeId, null, null, "staff");
END  

PatientDetails Trigger: This will will automatically create a new entry in the patientCare and previousVisits tables every time a new patient has been registered with the hospital.  
CREATE DEFINER=`root`@`localhost` TRIGGER `patientdetails_AFTER_INSERT` AFTER INSERT ON `patientdetails` FOR EACH ROW BEGIN
INSERT INTO patientcare (patiendId, reason, doctorId) values (NEW.patiendId, null, null);
INSERT INTO previousvisits (patientId, reasonForVisits) values (NEW.patiendId, '');
END  

PatientCare Trigger: This trigger will automiatically update the previousVisits table every time there has been an update in the patientCare table for the reason as to why they were in the hospital.  
CREATE DEFINER=`root`@`localhost` TRIGGER `patientcare_BEFORE_UPDATE` BEFORE UPDATE ON `patientcare` FOR EACH ROW BEGIN
UPDATE previousvisits, patientcare SET previousvisits.reasonForVisits=CONCAT(reasonForVisits,' ', patientcare.reason) WHERE patientcare.reason IS NOT null and patientcare.patiendId = previousvisits.patientId;
END  

**Connecting To Database:**  
In order to connect the Spring Boot Application to the MySQL Database you first need to install the MySQL Connector and Spring Data JPA dependencies to your project. After doing so fill in the following information in the application.properties file located in the src/main/resources.  
![image](https://user-images.githubusercontent.com/43048860/129784902-d76fce5a-a212-4a83-9067-c35ab7fb51f5.png)  

Replace the username, password, and Url information with your MySQL Login information and the name of the database you're trying to connect to. The naming specifications mentioned in the picture above will result in you being able to map your entity fields to the properly specified columns without having to worry about using the wrong naming convention. By default Hibernate will create a new column in your database with a snakecase naming convention if you try to use camel case naming convention. The above naming specifications will ensure that this does not happen.  

**Adding First Employee:**  
In order to add your first employee it is important to have already created an employee with a role of Admin in your database so that you can login. This application will encrypt an employee's password when they attempt to login, so it is important to store the encrypted password in the database to check for login credentials. To create the first employee manually enter in the employee details into the database. When it is time to enter the password for the employee go the the PasswordGenerator file located in the com.example.hospitalManagement.security package located in src/main/java. Run the file as a Java Application after entering in a password, the file should generate an encrypted password for you to enter into the database. This is only for the first employee as all other employees will not have to do this step. The Spring application will encrypt the password and automatically store it in the database for you.  

**Running The Application:**  
The first thing you need to do to run the application is to make sure that the MySQL database you are connected to is running. Next run the Spring Application as a Spring Boot App. From here to your browser of choice and proceed to the server port your application is running on. The very first screen you should see is the login screen, which will prompt you to enter in the login information.  
![image](https://user-images.githubusercontent.com/43048860/129787530-ad29611d-6707-4386-9b0a-169368ff2822.png)  

Enter in the login information and if it recognizes the login information then you will have successfully logged in and can preceed to any authorized activities such as looking up current employees.  
![image](https://user-images.githubusercontent.com/43048860/129787706-9adbf3a0-9cf5-4600-a11a-f40401a2ae0a.png)  

If the login information is not recognized then you will not be able to login and may proceed to try again.  
![image](https://user-images.githubusercontent.com/43048860/129787804-d8263bea-62c1-4b3b-bf44-60c42f07eb35.png)  







