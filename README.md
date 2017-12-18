# Hair Salon

## About

- This project is aimed at demonstrating the spark implementation of sql database one-to many in java framework `spark`.

## Hair Salon:
* Allows to one to register a stylist and assign them clients.

## Included tests
### Stylist Class tests.
- Class instantiation.
- Class' ability to dynamically assign Ids to its new objects.
- Class' ability to keep track of all of it's instantiated objects.
- Class' self emptying of the instantiation array.`keeps track of all instances of a class object`.
- Class' ability to find a specific object instance based on it's id.

### Client Class tests.

- Class instantiation test.
- Class' ability to return the assigned stylists' name.
- Class' ability to keep track of all of it's instantiated objects.
- Class' self emptying off-of-the instantiation array list.
- Class dynamic Id assignment during object instantiation.

### Task-Category connection.
- Instantiate a stylist with an empty array list to hold a list of clients.
- Stylist class test for it's ability to add a client instance in it's array list


## Contributors

- [Vinge1718](https://github.com/Vinge1718)

## Built with
- [Java](http://www.oracle.com/technetwork/java/index.html)
    * [Spark framework](http://sparkjava.com/)

## Setup
- Clone or downlad repo from [Here](https://github.com/Vinge1718/hair_salon)
- Download latest version of `java` and `gradle`.
- from the parent directory, run `$ gradle build` then `gradle run`.
- Launch the program from your local server `http://localhost:4567` in your browser.
- you can access the fully functioning app [here](https://github.com/Vinge1718/hair_salon).

## Database set-up
Assumming you have  - [Java](http://www.oracle.com/technetwork/java/index.html) installed.
                    - [PostgreSQL](link-here)
                    - [Git](link)
                    - [Gradle](link)
* In the cloned parent directory Connect to psql and run:
    - CREATE DATABASE hair_salon;
* Leave the `psql` line and run the following command in the terminal (not psql):
    - psql hair_salon < hair_salon.psql
* Connect to psql again and connect to your new database `\c hair_salon`.
    - run \dt to view your tables
    


## Known Problems
- ...


## Licensing
All the work included has been dedicated to the public domain by waiving all of my rights to the work, under
copyright law, including all related and neighboring rights, to the extent allowed by law.
You can copy, modify, distribute and perform the work, even for commercial
purposes, all without asking permission.
