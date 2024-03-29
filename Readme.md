This project uses PostgresSQL as database, spring framework with dependencies like spring web , jpa and postgres driver
You need PostgresSQL to run this application

This is an application representing a shopping app where user can order products, look at products,
avail discounts, look at their placed orders, keep track of products and pay for products(Mock)

It has 6 REST methods including 4 get and 2 post

Testing for the same is done and a visula representation is present in the link below 
DOWNLOAD LINK : https://docs.google.com/document/d/1zWR324kAbiWrjEo3lmKRjpqcqsAdMT0b/edit?usp=sharing&ouid=117259944129101235274&rtpof=true&sd=true

**You need postgresSQL installed to run this application properly**
To run the app using executable go to "target/ShoppingApp-0.0.1-SNAPSHOT" and double click on it
https://drive.google.com/file/d/1HydG02ae55Ss9U7oc93zf8sM6ex2oBRS/view?usp=sharing Download Link

This will run the app in background and you can browse to
http://localhost:8080/api/v1/shopping/"Your request url"

Here you can enter in any api which is present in the Shopping Controller which are :

/inventory
/fetchCoupons
/{userId}/orders
/{userId}/orders/{orderId}
/{userId}/order
/{userId}/{orderId}/pay

You will have to use some sort of web api tester to use all functions of the application such as Postman

Entity Relationship and Class Diagrams Download Link
https://drive.google.com/drive/folders/1-31NXirhhNxA7caFCKD1VqvJWO4WPt6V?usp=sharing

