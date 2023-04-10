/** (MEGA_TEAM_ASSIGNMENT.)

Problem: Design a java program that will simulate a simple bank account management system. The system should allow users to make transactions such as depositing and withdrawing money, checking their balance and printing their transaction history.

Solution:

UML Diagram: 

```
+---------------------------------+
|          Bank Account           |
+---------------------------------+
| - owner : String                |
| - balance : double              |
| - transactions : ArrayList      |
+---------------------------------+
| + BankAccount(owner : String)   |
| + deposit(amount : double)      |
| + withdraw(amount : double)     |
| + checkBalance() : double       |
| + printTransactions() : String  |
+---------------------------------+

**/

/**
Java Code:

NOTE:
```interface Account is public, should be declared in a file named Account.java

```class InsufficientFundsException is public, should be declared in a file named InsufficientFundsException.java

```class Main is public, should be declared in a file named Main.java

//WE  MAKE THE CODE APPEAR IN A SINGLE FILE HERE, SO IT MAY HAVE RUNNING ISSUE ON PHONE Jvdroid Compiler. BECAUSE WE NEED TO RUN IT ON COMPUTER AND CREATE THE DIFFERENT INTERFACE FILES!
**/

interface Account {
    void deposit(double amount);

    void withdraw(double amount) throws InsufficientFundsException;

    double checkBalance();

    String printTransactions();
}

class BankAccount implements Account {

    private String owner;
    private double balance;
    private ArrayList<String> transactions = new ArrayList<>();

    public BankAccount(String owner) {
        this.owner = owner;
        balance = 0;
        transactions.add("Account created");
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposit: " + amount);
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (balance < amount) {
            throw new InsufficientFundsException();
        } else {
            balance -= amount;
            transactions.add("Withdrawal: " + amount);
        }
    }

    public double checkBalance() {
        transactions.add("Check balance: " + balance);
        return balance;
    }

    public String printTransactions() {
        String transactionHistory = "";
        for (String transaction : transactions) {
            transactionHistory += transaction + "\n";
        }
        return transactionHistory;
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException() {
        super("Insufficient funds in account");
    }
}

class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("John");
        account.deposit(1000);
        System.out.println("Balance: $" + account.checkBalance());
        try {
            account.withdraw(500);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Balance: $" + account.checkBalance());
        System.out.println(account.printTransactions());
    }
}


/**
```

Error Handling: The `withdraw` method throws an `InsufficientFundsException` if the account balance is not enough to cover the withdrawal amount.

Interfaces: The `Account` interface provides a contract for classes that implement bank account processing functionality.

UML: The UML diagram provides a graphical representation of the Bank Account class, showing its properties and methods.

**/