# Transaction API
__contact__: Abereham.wodajie@gmail.com

* This project is based on maven with spring boot version 1.46

## Prerequisite

* Maven
	* Check if you have maven installed: `mvn --version`
* IDE
	* Either IntelliJ or Eclipse

*clone or download
  * git clone https://github.com/Abrishges/transaction-api-service.git
  
#To run the project, Navigate to project directory, transaction-api-service  using terminal or cmd, and use the following cmd

  `mvn spring-boot:run`

# To test calls , use swagger page in your favourite browser 
* URL
    * http://localhost:8080/swagger-ui.html#/
    
* transaction urls, the last two are not fully implemented. 
     * http://localhost:8080/swagger-ui.html#/Transactions
     * http://localhost:8080/swagger-ui.html#!/Transactions/getAllTransactionsUsingPOST
     * http://localhost:8080/swagger-ui.html#!/Transactions/getMonthlyBudgetUsingPOST
     * http://localhost:8080/swagger-ui.html#!/Transactions/ignoreDonutsUsingPOST
     * http://localhost:8080/swagger-ui.html#!/Transactions/ignoreCCpaymentsUsingPOST
     * http://localhost:8080/swagger-ui.html#!/Transactions/getProjectedTransactionsForMonthUsingPOST
          

* using curl to extract information
    * getAllTransactions
    
 curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{
  "args": {
    "api-token": "AppTokenForInterview",
    "json-strict-mode": true,
    "json-verbose-response": true,
    "token": "5A927B8D34DAC597D0A1489C304E9BC9",
    "uid": 1110590645
  }
}' 'http://localhost:8080/capitalOne/transactions'

  * money the user spends and makes in each of the months
  
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{
  "args": {
    "api-token": "AppTokenForInterview",
    "json-strict-mode": true,
    "json-verbose-response": true,
    "token": "5A927B8D34DAC597D0A1489C304E9BC9",
    "uid": 1110590645
  }
}' 'http://localhost:8080/capitalOne/transactions/monthlyexpense'

 * getProjectedTransactionsForMonth
 
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{
  "args": {
    "api-token": "AppTokenForInterview",
    "json-strict-mode": true,
    "json-verbose-response": true,
    "token": "5A927B8D34DAC597D0A1489C304E9BC9",
    "uid": 1110590645
  },
  "month": 4,
  "year": 2017
}' 'http://localhost:8080/capitalOne/transactions/month/endpoint'