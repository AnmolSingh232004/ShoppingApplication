This is a project made for HyperSrot Techonlogies pvt.ltd

This project uses PostgresSQL as database, spring framework with dependencies like spring web , jpa and postgresSQL
You need PostgresSQL to run this application

This is an application representing a shopping app where user can order products, look at products,
avail discounts, look at their placed orders, keep track of products and pay for products(Mock)

It has 6 REST methods including 4 get and 2 post

Testing for the same is done and recorded in Microsoft Word 
DOWNLOAD LINK : https://docs.google.com/document/d/1zWR324kAbiWrjEo3lmKRjpqcqsAdMT0b/edit?usp=sharing&ouid=117259944129101235274&rtpof=true&sd=true

To run the app using executable go to "target/ShoppingApp-0.0.1-SNAPSHOT" and double click on it

This will run the app in background and you can browse to
http://localhost:8080/api/v1/shopping/"Your request url"

Here you can enter in any api which is present in the Shopping Controller which are :

/inventory
/fetchCoupons
/{userId}/orders
/{userId}/orders/{orderId}
/{userId}/order
/{userId}/{orderId}/pay

Entity RelationShip and ClassDiagram Download Link
https://drive.google.com/drive/folders/1-31NXirhhNxA7caFCKD1VqvJWO4WPt6V?usp=sharing

