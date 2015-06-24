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
Before we describe the app I want tо say that all requests to the database are async.
(AsyncTask enables proper and easy use of the UI thread. This class allows to perform background operations and publish results on the UI thread without having to manipulate threads and/or handlers).

There are 7 activities: Main Activity, Login, Registration, Profile, Create Route, Search for Route, Display Route

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


 
