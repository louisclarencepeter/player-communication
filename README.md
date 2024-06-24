### `README.md`

This project demonstrates a simple communication between two player instances in Java. The players send and receive messages between each other until a specified stop condition is met.

## Project Structure

- **com.example.Player**: Class representing a player that can send and receive messages.
- **com.example.Message**: Class representing a message sent between players.
- **com.example.Main**: Main class to initialize the players and start the communication.
- **com.example.PlayerTest**: JUnit test class to test the functionality of the player communication.

## Requirements

- Java 8 (JDK 1.8)
- Maven

## Setup Instructions

### Install JDK 1.8

Ensure JDK 1.8 is installed on your system. You can download it from the Oracle website or use OpenJDK.

- **Oracle JDK 8**: [Oracle JDK 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
- **OpenJDK 8**: [OpenJDK 8](https://adoptopenjdk.net/releases.html)

### Install Maven

Ensure Maven is installed on your system. You can download it from the official website.

- **Maven**: [Maven Download](https://maven.apache.org/download.cgi)

## Build and Run the Project

1. **Clone the Repository**:
```sh
git clone <https://github.com/louisclarencepeter/player-communication>
cd player-communication
```

2. **Build the Project**:
Use Maven to build the project and package it into a JAR file.
```sh
mvn clean package
```

3. **Run the Application**:
You can run the application using the provided shell script. Make sure the script has execute permissions. If not, you can set it using `chmod +x run.sh`.
```sh
./run.sh
```

Alternatively, you can run the application directly using the following command:
```sh
java -cp target/player-communication-1.0-SNAPSHOT.jar com.example.Main
```

4. **Running Tests**:
To run the tests, use the Maven test command:
```sh
mvn test
```

## Project Details

### Player Class

The `Player` class is responsible for sending and receiving messages. Each player has a message counter to keep track of the number of messages sent and received. The players communicate using a blocking queue.

### Message Class

The `Message` class represents a message sent between players. It contains the message text and the sender information.

### Main Class

The `Main` class initializes the players and starts the communication. It creates two player instances, sets them as partners, and starts their respective threads. The communication continues until the stop condition is met.

### PlayerTest Class

The `PlayerTest` class contains a JUnit test to verify the functionality of the player communication. It ensures that messages are sent and received correctly between the players.

## Notes

- Ensure you have the correct version of JDK and Maven installed.
- The stop condition for the communication is set to 10 messages.

