Based on the information you provided, here is a sample `README.md` for your project:

---

# Real-Time Event Ticketing System CLI

## Overview

The **Real-Time Event Ticketing System CLI** is a command-line application designed to simulate a ticketing system where vendors release tickets, and customers purchase them at specified rates. It uses multithreading to handle concurrent operations and ensures thread-safe interactions with a shared ticket pool. The system also allows configuration settings to be saved and loaded for future use.

This project combines **React.js** for the frontend and **Spring Boot** for the backend, providing a dynamic and robust solution for event ticketing management.

## Features

- **Multithreading**: Simultaneous ticket release by vendors and ticket retrieval by customers.
- **Ticket Pool Management**: A synchronized pool ensures thread-safe ticket release and retrieval.
- **User Configuration**: Users can load or manually configure ticket system parameters such as maximum capacity, total tickets, release rate, and retrieval rate.
- **Logging**: System events are logged to a text file for monitoring.
- **Configuration Management**: Configuration settings can be saved to and loaded from a JSON file.

## Technologies Used

- **Frontend**: React.js
- **Backend**: Spring Boot
- **Java**: For core system logic (TicketingSystem.java, TicketPool.java, Vendor.java, Customer.java, Configuration.java, Logger.java)
- **JSON**: For saving and loading configurations
- **Gson Library**: For JSON serialization and deserialization
- **Multithreading**: For concurrent ticket release and retrieval
- **Logging**: Thread-safe event logging to a text file

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/sehandiluka/20230110_W2052921.git
   ```

2. Navigate to the project directory:
   ```bash
   cd 20230110_W2052921
   ```

### Backend (Spring Boot)

1. Navigate to the backend directory:
   ```bash
   cd backend
   ```

2. Install dependencies and build the project:
   ```bash
   mvn clean install
   ```

3. Run the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```

### Frontend (React.js)

1. Navigate to the frontend directory:
   ```bash
   cd frontend
   ```

2. Install the necessary dependencies:
   ```bash
   npm install
   ```

3. Start the React application:
   ```bash
   npm start
   ```

## Usage

1. Launch the application and interact with the system through the command-line interface.
2. The system will prompt you to either load a saved configuration or enter values manually (e.g., maximum capacity, total tickets, release rate, retrieval rate).
3. Vendors and customers will simultaneously interact with the ticket pool based on the configured rates.
4. You can stop the system anytime by entering the "q" command.

## Configuration

- **Maximum Capacity**: The total number of tickets that can be in the pool at any given time.
- **Total Tickets**: The total number of tickets that will be available to release.
- **Ticket Release Rate**: The rate at which the vendor releases tickets into the pool.
- **Ticket Retrieval Rate**: The rate at which customers purchase tickets from the pool.

## Logging

The system logs events such as ticket releases, purchases, and other actions to `log.txt`. This file is created automatically and updated with each event.

## Contributing

Contributions are welcome! Feel free to fork the repository, create a branch, and submit a pull request with your changes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

For inquiries, please reach out to:
- Email: [sehandiluka@gmail.com]
- GitHub: [https://github.com/sehandiluka](https://github.com/sehandiluka)

---

Let me know if you'd like to make any adjustments or add specific sections!
