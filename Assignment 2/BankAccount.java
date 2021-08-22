import java.util.ArrayList;

public class BankAccount {
    protected String name;
    protected String accountNumber;
    protected double balance;
    protected String dateOfOpening;

    protected ArrayList<String> transactions = new ArrayList<String>();

    BankAccount(String name, String accountNumber, String dateOfOpening){
        this.name = name;
        this.accountNumber = accountNumber;
        this.dateOfOpening = dateOfOpening;
    }

    public void checkBalance(){
        System.out.println("Mr/Miss " + name + " current balance in your account is " + balance + " PKR");
    }

    public double getBalance() {
        return balance;
    }

    public void makeWithdrawal(double amount, int day, int month, int year, int hour, int min){
        balance -= amount;
        transactions.add("----------------------- \n" + amount + " PKR was deposited to the account\n" + "Date of deposit: " + day + "/" + month + "/" + year + "\nTime of Deposit: " + hour + ":" + min);

    }

    public void printStatement(){
        checkBalance();
        System.out.println("Account Number: " + accountNumber);
        displayAllDeductions();
    }

    public void makeDeposit(double depositAmount, int day, int month, int year, int hour, int min){
        balance += depositAmount;
        transactions.add("----------------------- \n" + depositAmount + " PKR was deposited to the account\n" + "Date of deposit: " + day + "/" + month + "/" + year + "\nTime of Deposit: " + hour + ":" + min);
    }

    public void displayAllDeductions (){
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println(transactions.get(i));
        }
    }

    public void calculateZakat(){    }

    public void transferAmount(BankAccount accountTransferTo, BankAccount accountTransferFrom , double amountToTransfer, int day, int month, int year, int hour, int min){
        if (accountTransferTo instanceof CheckingAccount && accountTransferFrom instanceof CheckingAccount){
            CheckingAccount transferTo = (CheckingAccount) accountTransferTo;
            CheckingAccount transferFrom = (CheckingAccount) accountTransferFrom;

            if (transferFrom.getBalance() - amountToTransfer >= -50000) {
                transferFrom.makeWithdrawal(amountToTransfer, day, month, year, hour, min);
                transferTo.makeDeposit(amountToTransfer, day, month, year, hour, min);
            }
            else{
                System.out.println("Not Enough Balance to transfer");
            }
        }
        else if (accountTransferTo instanceof SavingAccount && accountTransferFrom instanceof CheckingAccount){
            SavingAccount transferTo = (SavingAccount) accountTransferTo;
            CheckingAccount transferFrom = (CheckingAccount) accountTransferFrom;

            if (transferFrom.getBalance() - amountToTransfer >= -50000) {
                transferFrom.makeWithdrawal(amountToTransfer, day, month, year, hour, min);
                transferTo.makeDeposit(amountToTransfer, day, month, year, hour, min);
            }
            else{
                System.out.println("Not Enough Balance to transfer");
            }
        }
        else if (accountTransferTo instanceof CheckingAccount && accountTransferFrom instanceof SavingAccount){
            CheckingAccount transferTo = (CheckingAccount) accountTransferTo;
            SavingAccount transferFrom = (SavingAccount) accountTransferFrom;

            if (transferFrom.getBalance() - amountToTransfer >= 0) {
                transferFrom.makeWithdrawal(amountToTransfer, day, month, year, hour, min);
                transferTo.makeDeposit(amountToTransfer, day, month, year, hour, min);
            }
            else{
                System.out.println("Not Enough Balance to transfer");
            }
        }
        else if (accountTransferTo instanceof SavingAccount && accountTransferFrom instanceof SavingAccount){
            SavingAccount transferTo = (SavingAccount) accountTransferTo;
            SavingAccount transferFrom = (SavingAccount) accountTransferFrom;

            if (transferFrom.getBalance() - amountToTransfer >= 0) {
                transferFrom.makeWithdrawal(amountToTransfer, day, month, year, hour, min);
                transferTo.makeDeposit(amountToTransfer, day, month, year, hour, min);
            }
            else{
                System.out.println("Not Enough Balance to transfer");
            }
        }
    }


}
