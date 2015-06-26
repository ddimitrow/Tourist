# Tourist Application for Android

### What this application is used for?
Allow people to quick organize tourist groups, meet and travel together.

##Installation
Just run the .apk file

##Realization

###RestAPI
To open the code you need Visual Studio (pref. 2010 or 2013)
Contains 3 main classes and an interface.
DBConnect.cs is used to connect to the sql server.
IServiceAPI.cs contains declaration of functions that will be needed.
ServiceAPI.cs contains implementation of all querys that will be used from the Android app.

###Database
SQL Server
SQL Management studio is needed.
The current database is published in somee.com
Simple database with two tables.
User Details table (Profile) contains six columns in this order id, firstName, lastName, userName, password, phoneNumber
Route table also contains six columns: startPoint, endPoint, date, time, ownerName, phoneNumber

You can simple create this database by executing this query:

-------------Table 1: UserDetails (To store User Profile information)---------------
```
CREATE TABLE UserDetails (
      id INT IDENTITY,
      firstName VARCHAR(50),
      lastName VARCHAR(50),
      userName VARCHAR(50),
      password VARCHAR(50),
      phoneNumber VARCHAR(50),
      
      PRIMARY KEY(id)
);
 ```
-------------Table 2: Route (To store Route information)---------------
 ```
CREATE TABLE Route(
 
      startPoint VARCHAR(50),
      endPoint VARCHAR(50),
      date VARCHAR(50),
      time VARCHAR(50),
      ownerName VARCHAR(50),
      phoneNumber VARCHAR(50)
);
```


###Android Application

Application Name: “Tourist”
Project Name: TouristAPIClient
Package Name: com.mytouristapp.diyan.touristapiclient
Minimum Required SDK: API 18: Android 2.2 (Froyo)

Before we describe the app I want tо say that all requests to the database are async.
(AsyncTask enables proper and easy use of the UI thread. This class allows to perform background operations and publish results on the UI thread without having to manipulate threads and/or handlers).


Activity Name	      Layout Name
CreateRouteActivity	activity_create_route.xml
CreateUserActivity	activity_create_user.xml
DisplayRouteActivity	activity_display_routes.xml
LoginActivity	      activity_login.xml
MainActivity	      activity_main.xml
RouteActivity	      activity_route.xml
UserDetailsActivity	activity_user_details.xml

Also there are 4 other classes:
JSONParser, RestAPI, RouteTable and UserDetailsTable

####Activity Main
There is the information about the app, what it is used for. (A.K.A. About)
Also it contains 2 buttons (Registration and Login)
Login button sends you to Login activity
Sign up button sends you to Registration activity

####Login
Simple Login form
Used to check if users exist in the DB.
####Registration 
Simple Registration form
Used to create new users.
####Profile
Displays user profile and gives him an option to edit his profile.
NOTE: Edit profile is not implemented yet.
####Create Route
Add new route in the database
####Search Route
Searches for a route based on start point and date
####Display Route
Dispay all maches in list view.
NOTE: Not implemented yet: OnClickListener for the list view. On click it should display information about the route, weather, maybe map.

####JSONParser class

This class is used to parse JSONObjects.  The API always returns JSONObject type object as respond. So we need to convert those object into some other type to use it in our application. All the methods in JSONParser.java class get a JSONObject type of parameter. Those methods will convert the JSONObjects into some other object type where we can use those converted object in our application directly. Below methods are used to parse methods in my API.

Contains 3 public functions:
//Parses route details in ArrayList
 public ArrayList<RouteTable> parseRoute(JSONObject object); 
//Returns true if there is a record that matchs with "username" and "password"
 public boolean parseUserAuth(JSONObject object); 
//Parse user profile information 
 public UserDetailsTable parseUserDetails(JSONObject object)

####RouteTable class
RouteTable class is used to map the database objects into java objects.
####UserDetailsTable class
UserDetailsTable is used to map the database objects into java objects.

####RestAPI class
auto generated java file 
you can get it by typing the following url in the web broser:
```http://android-sql-client.somee.com/Handler.ashx?ANDROID 
```

####How to run the application
To use this application, application needs to access the API through the emulator or using real android device. To access the API, application needs to know the correct URL for the API. You need to provide the correct URL in RestAPI.java class. When you open the “RestAPI.java” class you will see an attribute called urlString with some value. This is the default value for “urlString” attribute in my “RestAPI.java”. This URL cannot accessible through the emulator or in a real device.  So you need to make this URL point to the restful API. (in this case the urlString is http://android-sql-client.somee.com/Handler.ashx?ANDROID 

If you host this restful API in your local host (In your PC) then you can’t access it using a real android device (In other words application will not work in a real device). To access the restful API through a real device you need to host this restful API in a public hosting space. Then application can access it through internet publicly similar to accessing a website.
