CREATE TABLE UserDetails (
      id INT IDENTITY,
      firstName VARCHAR(50),
      lastName VARCHAR(50),
      userName VARCHAR(50),
      password VARCHAR(50),
	  phoneNumber VARCHAR(50),

	  PRIMARY KEY (id)
);
 
-------------Table 2: Route (To store Department information)---------------
 
CREATE TABLE Route(
 
      startPoint VARCHAR(50),
	  endPoint VARCHAR(50),
	  date VARCHAR(50),
	  time VARCHAR(50),
	  ownerName VARCHAR(50),
	  phoneNumber VARCHAR(50),
);