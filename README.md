# libmgmtapi
Simple Library Management api created using spring boot REST


API BASE URL : http://localhost:8080/libmgmt

Library To get All Libraries | GET : /libraries

To Get Library books | GET : /libraries/{libId} Example : http://localhost:8080/libmgmt/libraries/8

Books To get All books | GET : /books To get book | GET : /books/{bookId} To create a new book | POST : /books To update a book | PUT : /books/{bookId} To Delete a book | DELETE : /books/{bookId}


------
Validators skeleton added to the service to validate the book, Factory would suit to get the validator based on criteria. but if criteria grows then facotry would not be an good option. in this case collect all validator related to the model and execute would be best option.
