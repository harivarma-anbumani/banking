# Banking-Assignment
Assignment on Banking-transfer

Deliverables
------------

A copy of the source code can be clone from the below github repository,

https://github.com/harivarma-anbumani/banking.git


Instructions on how to build/execute it:
  Build the code:	mvn clean install
  </br>
  Execue the code: java -jar target\banking-0.0.1-SNAPSHOT

Time Spent on below tasks:

| Tasks	| Hours |
| ----- | ----- |
| Requirement analysis | 0.1 |
| Workspace setup	| 0.3 |
| Coding	| 1.25 |
| Github commit	| 0.1 |
| Readme file	| 0.25 |


| Number# | Technology Used | 
| ----- | ----- |
| 1 |	Java 11 |
| 2 |	Spring boot |
| 3 |	Spring REST |
| 4 |	Spring JPA |
| 5 |	H2 embedded database |
| 6 |	lombok |
| 7 |	swagger |
| 8 |	Embedded Tomcat |

 
**Output:** 

Swagger is integrated to the code, hence swagger helps us to test the different scenarios. 

Swagger url: http://localhost:8080/swagger-ui/index.html

**Customer controller:**

`
1. curl -X GET "http://localhost:8080/api/customer/1" -H "accept: application/json"
    Output: {   "id": 1, "name": "Mark", "balance": 1000 }

2. curl -X POST "http://localhost:8080/api/customer" -H "accept: application/json" -H "Content-Type: application/json" -d "{ \"id\": 10, \"name\": \"Marry\", \"balance\": 1001}"

3. curl -X DELETE "http://localhost:8080/api/customer/1" -H "accept: application/json"

4. curl -X GET "http://localhost:8080/api/customers" -H "accept: application/json"
[
  {
    "id": 2,
    "name": "Rob",
    "balance": 1500
  },
  {
    "id": 3,
    "name": "Jim",
    "balance": 2100
  },
  {
    "id": 4,
    "name": "William",
    "balance": 3500
  },
  {
    "id": 10,
    "name": "Marry",
    "balance": 1001
  }
]

**Beneficiary Controller**
1. GET curl -X GET "http://localhost:8080/api/beneficiaries" -H "accept: application/json"
[
  {
    "id": 1,
    "name": "Phil"
  },
  {
    "id": 2,
    "name": "Tim"
  },
  {
    "id": 3,
    "name": "Scott"
  },
  {
    "id": 4,
    "name": "John"
  }
]

2. curl -X POST "http://localhost:8080/api/beneficiary" -H "accept: application/json" -H "Content-Type: application/json" -d "{ \"id\": 10, \"name\": \"Marry\"}"
3. curl -X DELETE "http://localhost:8080/api/beneficiary/10" -H "accept: application/json"
4. curl -X GET "http://localhost:8080/api/beneficiary/1" -H "accept: application/json"
{
  "id": 1,
  "name": "Phil"
}

**Transfer Controller**

##### Transfer - test 

curl -X POST "http://localhost:8080/api/transfer" -H "accept: application/json" -H "Content-Type: application/json" -d "{ \"amount\": 100, \"beneficiary_id\": 2, \"customer_id\": 2, \"id\": 20}"

Input:
{
  "amount": 100,
  "beneficiary_id": 2,
  "customer_id": 2,
  "id": 20
}

Output:
Respose 201 Created
