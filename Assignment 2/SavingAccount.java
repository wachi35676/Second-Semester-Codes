public class SavingAccount extends BankAccount{
    static double interestRate = 8;
    boolean zakatPaidThisYear = false;

    SavingAccount (String name, String accountNumber, String dateOfOpening){
        super(name, accountNumber, dateOfOpening);
    }

    @Override
    public void makeWithdrawal(double amount, int day, int month, int year, int hour, int min) {
        if (balance - amount >= 0){
            System.out.println("Amount Withdrawen Successfully");
            System.out.println();
            balance -= amount;
            transactions.add("----------------------- \n" + amount + " PKR was withdrawn from the account\n" + "Date of withdrawal: " + day + "/" + month + "/" + year + "\nTime of withdrawal: " + hour + ":" + min);
        }
        else{
            System.out.println("Can not Withdraw not enough balance");
        }
    }

    @Override
    public void calculateZakat() {
        if (balance >= 20000 && !zakatPaidThisYear){
            balance -= balance * 2.5 / 100;
            zakatPaidThisYear = true;
            transactions.add("----------------------- \n" + balance * 2.5 / 100 + " PKR was withdrawn from the account for zakat\n");
        }
    }

    public void setZakatPaidThisYear(boolean zakatPaidThisYear) {
        this.zakatPaidThisYear = zakatPaidThisYear;
    }

    public void calculateInterest(){
        balance += (interestRate / 100) * balance;
        transactions.add("----------------------- \n" + (interestRate / 100) * balance + " PKR was deposited from interest\n");
    }
}
