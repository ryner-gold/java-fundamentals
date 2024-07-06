public class BankAccount {
    private final int accountNumber;
    private double balance;
    private String ownerName;

    // TODO: Implement default constructor
    // A default constructor is a constructor created by the compiler
    // if we do not define any constructor(s) for a class.
    // see main()

    // TODO: Call another constructor using this keyword
    public BankAccount() {
        this(1, 1, "RG");
    }

    // TODO: Implement parameterized constructor
    public BankAccount(int accountNumber, double balance, String ownerName) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.ownerName = ownerName;
    }

    // TODO: Implement getters and setters
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    // TODO: Implement deposit method

    public boolean deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposit amount " + amount + " to account " + this.accountNumber);
            return true;
        } else {
            System.out.println("Something went wrong.");
            return false;
        }
    }

    // TODO: Implement withdraw method

    public boolean withdraw(double withdrawAmount) {
        if (withdrawAmount > 0 && this.balance >= withdrawAmount) {
            this.balance -= withdrawAmount;
            System.out.println("Withdraw amount " + withdrawAmount + " from account " + this.accountNumber);
            return true;
        } else {
            System.out.println("Error in withdrawal");
            return false;
        }
    }


// TODO: Implement displayInfo method

    public void displayInfo() {
        System.out.println("Account number: " + this.accountNumber + " Owner: " + this.ownerName);
        System.out.printf("$%.2f\n", this.balance );
    }

    public static void main(String[] args) {
        BankAccount myBankAcc = new BankAccount(145142, 402.2443, "Ryner");

        System.out.println("Initial bank info:");
        myBankAcc.displayInfo();

        System.out.println("\nDepositing money:");
        if (myBankAcc.deposit(400)) {
            System.out.println("New balance is $" + String.format("%.2f", myBankAcc.getBalance()));
        }

        System.out.println("\nWithdrawing money:");
        if (myBankAcc.withdraw(300)) {
            System.out.println("New balance is $" + String.format("%.2f", myBankAcc.getBalance()));
        }

        System.out.println("\nFinal bank info:");
        myBankAcc.displayInfo();

    }

}
