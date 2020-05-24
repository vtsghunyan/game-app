# game-app
Game application where players communicate via sending and receiving messages each other

How to run
----------
This is a simple maven application, needs to import build with maven, 
create jar file and run it from script file:

From application root directory create jar file with maven command:
- mvn package
Then run command:
- java -jar target/game-app-1.0-SNAPSHOT.jar

Also, possible to run from script file:

For Windows run:
- start.cmd

For Linux system run:
- ./start.sh

Notes
-----
- Application creates 2 players: Initiator and Responder.
- Initiator starts sending messages and responder received and replies to them