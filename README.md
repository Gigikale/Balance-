# Balanceè
## Project Overview
The Rewards Management API is a backend service designed to help customers retrieve their cashback balance and view transaction history. This project, built using Java Springboot, is part of the internship program at Balanceè.

## Features
- Retrieve customer's cashback balance.
- View cashback transaction history.

## Task Objective
The goal of this task is to develop a basic backend API with two key functionalities:
1. Provide an endpoint for customers to retrieve their current cashback balance.
2. Provide an endpoint for customers to view their cashback transaction history.

## API Endpoints
### 1. Get Rewards Balance
- Endpoint: /api/rewards/balance
- Method: GET
- Request Parameters:
    - customerId (query parameter or path variable)
- Response:
 json  {
  "customerId": "12345",
  "totalCashback": 200,
  "currentBalance": 150
}
### 2. Get Cashback History
- Endpoint: /api/rewards/history
- Method: GET
- Request Parameters:
    - customerId (query parameter or path variable)
- Response:
json [
  {
    "transactionId": "abc123",
    "transactionDate": "2024-01-01",
    "amountEarned": 50,
    "description": "Booking ID: XYZ"
  }
]

### Data Models
### Customer Rewards Data:
- Customer ID: Unique identifier.
- Total Cashback: Total cashback earned by the customer.
- Current Balance: Available cashback balance for cashout.

### Cashback History:
- Transaction ID: Unique identifier for each transaction.
- Transaction Date: Date when the cashback was earned.
- Amount Earned: Cashback amount for each transaction.
- Description: Brief description of the transaction.

## Technical Requirements
- Language: Java
- Framework: Springboot
- Database: PostgresSql

## Setup Instructions
Clone the Repository:

```sh
git clone https://github.com/Gigikale/balance-.git.
```

Navigate to the Project Directory:
```sh
cd Balance-
```
Build the Project:
```sh
./mvnw clean install
```
Run the Application:
```sh
./mvnw spring-boot:run
```

