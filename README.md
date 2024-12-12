Based on the details you provided, here is a `README.md` template for your Real-Time Event Ticketing System CLI project:

---

# Real-Time Event Ticketing System CLI

## Description
The Real-Time Event Ticketing System CLI is a multithreaded Java application that simulates the release and retrieval of tickets in real-time. It allows users to interact with the system via the command line, configuring ticket parameters, managing a ticket pool, and monitoring ticket release and purchase activities.

The system consists of several classes working together:
- **TicketingSystem.java**: Manages user input, validation, and multithreading for vendors and customers.
- **TicketPool.java**: Handles the shared pool of tickets with thread-safe operations.
- **Vendor.java**: Releases tickets into the pool at a specified rate.
- **Customer.java**: Retrieves tickets from the pool at a specified rate.
- **Configuration.java**: Saves and loads system configurations using JSON.
- **Logger.java**: Logs system events and activities to a file.

## Features
- Multithreaded ticket release and retrieval by vendors and customers.
- Input validation to ensure correct configuration settings.
- Ability to save and load system configurations.
- Timestamped logging of system events.
- Graceful termination of system via command input.

## Installation

1. Clone the repository to your local machine:
   ```bash
   git clone https://github.com/sehandiluka/20230110_W2052921.git
   ```

2. Navigate to the project directory:
   ```bash
   cd 20230110_W2052921
   ```

3. Compile the Java files:
   ```bash
   javac *.java
   ```

4. Run the TicketingSystem:
   ```bash
   java TicketingSystem
   ```

## Usage
Once the system is running, you can:
- **Configure the system**: Either load a saved configuration or enter values for maximum capacity, total tickets, release rate, and retrieval rate.
- **Run vendors and customers**: The system will simulate the release and retrieval of tickets by vendors and customers.
- **Stop the system**: Type `q` to gracefully terminate the application.

### Example Command Input
```text
Enter maximum ticket capacity: 100
Enter total tickets: 1000
Enter ticket release rate (tickets per second): 5
Enter customer retrieval rate (tickets per second): 3
```

## Classes Overview
### `TicketingSystem.java`
- Manages user input and system configuration.
- Includes input validation and multithreading management for vendor and customer operations.

### `TicketPool.java`
- A thread-safe class for managing the ticket pool with synchronized methods for adding and removing tickets.

### `Vendor.java`
- Releases tickets into the pool at a specified rate using multithreading.

### `Customer.java`
- Purchases tickets from the pool at a specified rate using multithreading.

### `Configuration.java`
- Saves and loads system configurations to/from a JSON file.

### `Logger.java`
- Logs system events and messages to a log file (`log.txt`).

## Technologies Used
- **Java**: Main programming language for the application.
- **Gson**: Library used for JSON serialization and deserialization.
- **Multithreading**: Used for concurrent operations by vendors and customers.
- **File Handling**: For saving and loading configurations and logging events.

## Contributing
1. Fork the repository.
2. Create a new branch for your feature.
3. Commit your changes.
4. Push the branch to your fork.
5. Open a pull request to contribute your changes.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

Feel free to adjust the content as needed based on any additional features or instructions!
