# Car Rental App

The service provides an endpoint that will get a car booking data and validate if the license numbers are valid. 
There is a third party web service that gets a list of CSV license numbers and returns information about those
license numbers.

## Prerequisites

* [Java 11 Runtime](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
    
1. Run Springboot CarRentalApplication
2. EndPoints:
   1. /booking -> POST Endpoint. Receives a JSON object with Booking Information
      Example:

         {
         "id":10,
         "drivers": [
         {
         "id":100,
         "name":"Karla",
         "licenseNumber":1000000
         },
         {
         "id":101,
         "name":"Dario",
         "licenseNumber":10
         },
         {
         "id":100,
         "name":"Claudia",
         "licenseNumber":999
         }
         ]
         
         }
   2. /thirdparty/license/validate/ -> Receives a list of license numbers separated by commas.
      Example: http://localhost:8080/thirdparty/license/validate/10000,10,1010
   
