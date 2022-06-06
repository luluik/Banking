# Banking
Banking System with Java

## Project Structure
<img width="600" alt="截屏2022-06-06 下午9 23 04" src="https://user-images.githubusercontent.com/67938768/172169210-e6e120f5-5195-4d0a-8c3e-d04b1bd2a76f.png">

## Function Requirements

User can input A, B, C … G to choose an operation.

### A.Deposit
#### Input
Username, Currency(hkd, usd or cny), Account
#### Detail functions
1. Deposit a given amount of money into corresponding account according to username and currency.
2. "The user does not exist." will be returned when the account does not exist in the database. 
   （All oprations except Create also have this function）
3. "Currency does not exist." will be returned when the currency input is none of hkd, usd or cny.
   （Withdrawal and Transfer also have this function）
#### Output
<img width="700" alt="Deposit" src="https://user-images.githubusercontent.com/67938768/172192061-1b2828fb-356f-4e78-8281-fabbb86aea8b.png">

### B.Withdrawal
#### Input
Username, Currency(hkd, usd or cny), Account
#### Detail functions
1. Withdrawal a given amount of money from corresponding account according to username and currency.
2. A maximum of five withdrawal or transfer out operations can be done within five minutes. 
   Counts and Time Limits can be modified by changing the parameters “countLimit” and “timeLimit” in User.timeVerification() method.
3. When balance is insufficient, the withdrawal operation will fail. 
   The balance remains unchanged and no transaction records are left.
#### Output
1. Withdrawal Operations result will be shown in "D.Print Account" and "E.Print Transaction" Parts.
2. Frequent Withdrawal and Transfer Operations
<img width="600" alt="Withdrawal Frequent" src="https://user-images.githubusercontent.com/67938768/172192144-7a796a6b-cc83-4968-9023-1c2e2dca933e.png">

### C.Transfer
#### Input
Username1(Beneficiary's Name), Username2(Remitter's Name), Currency(hkd, usd or cny), Account
#### Detail functions
1. Transfer given amount of currency between two users' accounts.
2. A maximum of five withdrawal or transfer out operations can be done within five minutes. 
   Counts and Time Limits can be modified by changing the parameters “countLimit” and “timeLimit” in User.timeVerification() method.
3. When balance of tranfer-out account is insufficient, both of the transfer-out and transfer-in operations will fail. 
   The balance remains unchanged and no transaction records are left.
#### Output
1. Transfer Operations result will be shown in "D.Print Account" and "E.Print Transaction" Parts.
2. Frequent Withdrawal and Transfer Operations
<img width="600" alt="Transfer Frequent" src="https://user-images.githubusercontent.com/67938768/172192190-6d1e645f-fda8-452e-903a-11a91ca71d32.png">

### D.Print Account
#### Input
Username
#### Detail functions
1. Return all currencies' balance of given user's account.
#### Output
![Account](https://user-images.githubusercontent.com/67938768/172192392-33b388ff-5249-4b75-be6a-280b9d6509a2.jpg)

### E.Print Transaction
#### Input
Username
#### Detail functions
1. Return all transaction records of given user's account.
#### Output
Time shown in the figure indicates that the Transfer operation can only succeed after five minutes from the first Withdrawal operation, which means a maximum of five withdrawal or transfer out operations can be done within five minutes.
![Transaction Records](https://user-images.githubusercontent.com/67938768/172192335-6589eeec-0aff-43f5-8cea-86cb0db27da6.jpg)

### F.Create
#### Input
input: Username, HKD Account, USD Account, CNY Account
1. Initialize account information
#### Output
<img width="600" alt="Create" src="https://user-images.githubusercontent.com/67938768/172194968-c735f820-dc41-495b-b477-c0be49b5a8be.png">

### G.Quit

### OSL_FEE Account
#### Detail functions
1. Charge a handling fee when a withdrawal or a transfer operation occurs.
#### Output
![OSL_FEE](https://user-images.githubusercontent.com/67938768/172192373-38f24605-3a6c-4fee-a2a6-2c8021e171ef.jpg)
