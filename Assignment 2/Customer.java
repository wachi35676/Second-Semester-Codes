public class Customer {
    private String name;
    private String address;
    private String number;
    private String accountNumber;

    private CheckingAccount checkingAccount;
    private SavingAccount savingAccount;

    Customer(String name, String address, String number, String accountNumber){
        this.name = name;
        this.address = address;
        this.number = number;
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printAllDetails(){
        System.out.println("-------------------------------------");
        System.out.println("Name: " +name);
        System.out.println("Address: " + address);
        System.out.println("Phone Number: " + number);
        System.out.println("Account Number: " + accountNumber);
    }

    public SavingAccount getSavingAccount() {
        return savingAccount;
    }

    public CheckingAccount getCheckingAccount() {
        return checkingAccount;
    }

    public void setSavingAccount(SavingAccount savingAccount) {
        this.savingAccount = savingAccount;
    }

    public String getName() {
        return name;
    }

    public void setCheckingAccount(CheckingAccount checkingAccount) {
        this.checkingAccount = checkingAccount;
    }
}
