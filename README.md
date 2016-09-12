# Seed

A basic skeleton that you should be able to jump into. Setup Sucks.

* This seed uses a Finagle/Finatra Twitter server to serve JSON. `https://twitter.github.io/finagle/`
* It is backed by a rails managed Postgres DB.
* Slick 3.1 is being used to interact with the DB from the server.

##Setup

1. Go to the db folder and complete the set up in the db manager
2. Make sure you have SBT and Scala installed. This seed was built at scala 2.11.7 but can be changed in build.sbt.
3. run `sbt compile` to get all the dependencies.
4. run `sbt run` to start the server up on localhost:8080

There are 2 test endpoints. 1 will select usernames from the db ("/") the other will insert a sample into the db("/ins")
Those should hopefully provide the context on how you would go about extending the functionality here

That should be everything.