# RetailWebsiteApi

## Installation and running instructions

1. git clone 	https://github.com/smakara/RetailWebsiteApi.git 
2. cd into the project directory
3. install   dependancies and build jar  run the following command 
    mvnw install -Dmaven.test.skip=true
4. jar file is  generated in  target folder, cd into the target folder and run the following command
   java -jar "name of jar file".jar
   
Application will start running in tomcat on port 9900

# RetailWebsiteApi Documentation
you can access the swagger documentation on the following url
http://localhost:9900/swagger-ui.html#/


## sample post object when submitting customer bill 
localhost:9900/client/bill

{
	"clientId":1,
	"amount":900,
	"itemType":"grocery"
	
}

## sample response object after submitting customer bill 

{
  "clientData": {
    "amountsubmited": 900.0,
    "clientId": 1,
    "client": {
      "clientID": 1,
      "clientStatus": "employee",
      "clientName": "Thapelo Moyeni",
      "clientDateCreated": "2016-02-08"
    },
    "discount": 0.0,
    "bill": 900.0
  }
}

## Images/Screenshots 


<p align="center">
  <img src="https://github.com/smakara/RetailWebsiteApi/blob/25cb4380349f5f9043ba8b554c4a7b344e40b76b/screenshots/all%20clients.png" width="350" title="customer list">
      <img src="https://github.com/smakara/RetailWebsiteApi/blob/9ee6541a2fbc36aa010ff0d46c118e5ec495c6e5/screenshots/one%20customer.png" width="350" title="get one customer">
      <img src="https://github.com/smakara/RetailWebsiteApi/blob/master/screenshots/submit%20bill.png" width="350" title="submit bill">
      <img src="https://github.com/smakara/RetailWebsiteApi/blob/master/screenshots/swagger.png" width="350" title="swagger">
	 <img src="https://github.com/smakara/RetailWebsiteApi/blob/master/screenshots/jacoco coverage.png" width="350" title="swagger">
 
</p>


