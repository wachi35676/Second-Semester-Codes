public class CheckingAccount extends BankAccount{

    private int numberOfWithdraws = 0;

    CheckingAccount (String name, String accountNumber, String dateOfOpening){
        super(name, accountNumber, dateOfOpening);
    }

    @Override
    public void makeWithdrawal(double amount, int day, int month, int year, int hour, int min) {
        if (balance - amount >= -50000){
            if (numberOfWithdraws >= 2 && balance - (amount+10) >= -50000){
                System.out.println("Amount Withdrawen Successfully");
                System.out.println();
                balance -= amount;
                transactions.add("----------------------- \n" + amount + " PKR was withdrawn from the account\n" + "Date of withdrawal: " + day + "/" + month + "/" + year + "\nTime of withdrawal: " + hour + ":" + min + "\nTax Charged: " + 10);
            }
            else if (numberOfWithdraws < 2){
                System.out.println("Amount Withdrawen Successfully");
                System.out.println();
                balance -= amount;
                transactions.add("----------------------- \n" + amount + " PKR was withdrawn from the account\n" + "Date of withdrawal: " + day + "/" + month + "/" + year + "\nTime of withdrawal: " + hour + ":" + min);
                numberOfWithdraws++;
            }
        }
        else{
            System.out.println("Can not Withdraw not enough balance");
        }
    }

    public void setNumberOfWithdraws(int numberOfWithdraws) {
        this.numberOfWithdraws = numberOfWithdraws;
    }
}
