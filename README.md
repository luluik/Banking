# Banking
Banking System with Java

## Project Structure
<img width="622" alt="截屏2022-06-06 下午9 23 04" src="https://user-images.githubusercontent.com/67938768/172169210-e6e120f5-5195-4d0a-8c3e-d04b1bd2a76f.png">

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

### D.Print Account
#### Input
Username
#### Detail functions
1. Return all currencies' balance of given user's account.
#### Output

### E.Print Transaction
#### Input
Username
#### Detail functions
1. Return all transaction records of given user's account.
#### Output

### F.Create
#### Input
input: Username, HKD Account, USD Account, CNY Account
1. Initialize account information
#### Output

### G.Quit

### OSL_FEE Account
#### Detail functions
1. Charge a handling fee when a withdrawal or a transfer operation occurs.

#### Output
