import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Customer> customers = new ArrayList<Customer>();

        int options;

        do {
            System.out.println("1 -- Add Customer");
            System.out.println("2 -- Remove Customer");
            System.out.println("3 -- View All Customer");
            System.out.println("4 -- Log in to an Account");
            System.out.println("5 -- Deduct Zakat from all Saving accounts for this year");
            System.out.println("6 -- Start Next Year to deduct Zakat for this year");
            System.out.println("7 -- Start Next Month and reset Number of withdraws of all Accounts ");
            System.out.println("8 -- Add Interests to All Saving Accounts");
            System.out.println("9 -- Change Interest Rate");
            System.out.println("0 -- Exit");
            System.out.println();
            System.out.println("Select your option: ");
            options = input.nextInt();

            switch (options) {
                case 1: {
                    System.out.println("Enter Customer's Name: ");
                    String name = input.next();
                    System.out.println("Enter Customer's Address: ");
                    String address = input.next();
                    System.out.println("Enter Customer's Phone Number: ");
                    String number = input.next();
                    String accountNumber;
                    boolean accountExists = false;
                    do {
                        System.out.println("Enter Customer's Account Number");
                        accountNumber = input.next();
                        for (Customer customer : customers) {
                            if (customer.getAccountNumber().equals(accountNumber)) {
                                accountExists = true;
                                System.out.println("Account Number already exists");
                                break;
                            }
                        }
                    }while (accountExists);

                    Customer newCustomer = new Customer(name, address, number, accountNumber);
                    customers.add(newCustomer);
                    break;
                }
                case 2: {
                    System.out.println("Enter account number for the customer to remove: ");
                    String accountNumber = input.next();
                    boolean accountRemoved = false;

                    for (int i = 0; i < customers.size(); i++) {
                        if (customers.get(i).getAccountNumber().equals(accountNumber)){
                            customers.remove(i);
                            accountRemoved = true;
                            break;
                        }
                    }
                    if (!accountRemoved){
                        System.out.println("Could not find any Customer corresponding to that account number.");
                    }
                    break;
                }
                case 3: {
                    for (Customer customer : customers) {
                        customer.printAllDetails();
                    }
                    System.out.println("-------------------------------------");
                    break;
                }
                case 4: {
                    System.out.println("Enter account number for the customer to u want to log in to: ");
                    String accountNumber = input.next();
                    boolean accountFound = false;
                    int accountIndex = 0;

                    for (int i = 0; i < customers.size(); i++) {
                        if (customers.get(i).getAccountNumber().equals(accountNumber)){
                            accountIndex = i;
                            accountFound = true;
                            break;
                        }
                    }

                    if (!accountFound){
                        System.out.println("Could not find any Customer corresponding to that account number.");
                    }
                    else{
                        int choice = 0;

                        do {
                            System.out.println("1 -- Create an Account");
                            System.out.println("2 -- Delete an Account");
                            System.out.println("3 -- Check Balance");
                            System.out.println("4 -- Deposit Amount");
                            System.out.println("5 -- Withdraw Amount");
                            System.out.println("6 -- Transfer Amount to Another account");
                            System.out.println("7 -- Display All Deductions");
                            System.out.println("0 -- Exit");
                            System.out.println();
                            System.out.println("Select your option: ");
                            choice = input.nextInt();

                            switch (choice){
                                case 1: {
                                    System.out.println("Which type of account would u like to create? ");
                                    System.out.println("1 -- Checking Account");
                                    System.out.println("2 -- Saving Account");
                                    System.out.println();
                                    System.out.println("Select your choice: ");

                                    int option = input.nextInt();

                                    switch (option){
                                        case 1: {
                                            if (customers.get(accountIndex).getCheckingAccount() == null){
                                                System.out.println("Enter Day of Opening: ");
                                                int day = input.nextInt();
                                                System.out.println("Enter Month of Opening: ");
                                                int month = input.nextInt();
                                                System.out.println("Enter Year of Opening: ");
                                                int year = input.nextInt();

                                                String date = (day + "/" + month + "/" + year);

                                                CheckingAccount checkingAccount = new CheckingAccount(customers.get(accountIndex).getName(), customers.get(accountIndex).getAccountNumber(), date);

                                                customers.get(accountIndex).setCheckingAccount(checkingAccount);
                                            }
                                            else {
                                                System.out.println("Account Already Exists. Please delete it");
                                            }
                                            break;
                                        }
                                        case 2: {
                                            if (customers.get(accountIndex).getSavingAccount() == null) {
                                                System.out.println("Enter Day of Opening: ");
                                                int day = input.nextInt();
                                                System.out.println("Enter Month of Opening: ");
                                                int month = input.nextInt();
                                                System.out.println("Enter Year of Opening: ");
                                                int year = input.nextInt();

                                                String date = (day + "/" + month + "/" + year);

                                                SavingAccount savingAccount = new SavingAccount(customers.get(accountIndex).getName(), customers.get(accountIndex).getAccountNumber(), date);

                                                customers.get(accountIndex).setSavingAccount(savingAccount);
                                            }
                                            else {
                                                System.out.println("Account Already Exists. Please delete it");
                                            }
                                            break;
                                        }
                                        default: {
                                            System.out.println("Not a Given option");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                case 2: {
                                    System.out.println("Which account would u like to delete? ");
                                    System.out.println("1 -- Checking Account");
                                    System.out.println("2 -- Saving Account");
                                    System.out.println();
                                    System.out.println("Select your choice: ");

                                    int option = input.nextInt();

                                    switch (option){
                                        case 1: {
                                            if (customers.get(accountIndex).getCheckingAccount() != null){
                                                customers.get(accountIndex).setCheckingAccount(null);
                                            }
                                            else {
                                                System.out.println("Account does not Exist");
                                            }
                                            break;
                                        }
                                        case 2: {
                                            if (customers.get(accountIndex).getSavingAccount() != null) {
                                                customers.get(accountIndex).setSavingAccount(null);
                                            }
                                            else {
                                                System.out.println("Account does not Exist");
                                            }
                                            break;
                                        }
                                        default: {
                                            System.out.println("Not a Given option");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                case 3: {
                                    if (customers.get(accountIndex).getCheckingAccount() != null){
                                        CheckingAccount checkingAccount = customers.get(accountIndex).getCheckingAccount();
                                        checkingAccount.checkBalance();
                                    }
                                    if (customers.get(accountIndex).getSavingAccount() != null){
                                        SavingAccount savingAccount = customers.get(accountIndex).getSavingAccount();
                                        savingAccount.checkBalance();
                                    }
                                    if (customers.get(accountIndex).getCheckingAccount() == null && customers.get(accountIndex).getSavingAccount() == null){
                                        System.out.println("You dont have any accounts yet");
                                    }
                                break;
                                }
                                case 4: {
                                    System.out.println("Which account would u like to deposit money to? ");
                                    System.out.println("1 -- Checking Account");
                                    System.out.println("2 -- Saving Account");
                                    System.out.println();
                                    System.out.println("Select your choice: ");

                                    int option = input.nextInt();

                                    switch (option){
                                        case 1: {
                                            if (customers.get(accountIndex).getCheckingAccount() != null){
                                                CheckingAccount checkingAccount = customers.get(accountIndex).getCheckingAccount();
                                                System.out.println("Enter the amount you would like to deposit");
                                                double balance = input.nextDouble();

                                                System.out.println("Enter Day: ");
                                                int day = input.nextInt();
                                                System.out.println("Enter Month: ");
                                                int month = input.nextInt();
                                                System.out.println("Enter Year: ");
                                                int year = input.nextInt();
                                                System.out.println("Enter Hour: ");
                                                int hour = input.nextInt();
                                                System.out.println("Enter Min: ");
                                                int min = input.nextInt();

                                                checkingAccount.makeDeposit(balance, day, month, year, hour, min);
                                                customers.get(accountIndex).setCheckingAccount(checkingAccount);
                                            }
                                            else {
                                                System.out.println("Account does not Exist");
                                            }
                                            break;
                                        }
                                        case 2: {
                                            if (customers.get(accountIndex).getSavingAccount() != null){
                                                SavingAccount savingAccount = customers.get(accountIndex).getSavingAccount();
                                                System.out.println("Enter the amount you would like to deposit");
                                                double balance = input.nextDouble();

                                                System.out.println("Enter Day: ");
                                                int day = input.nextInt();
                                                System.out.println("Enter Month: ");
                                                int month = input.nextInt();
                                                System.out.println("Enter Year: ");
                                                int year = input.nextInt();
                                                System.out.println("Enter Hour: ");
                                                int hour = input.nextInt();
                                                System.out.println("Enter Min: ");
                                                int min = input.nextInt();

                                                savingAccount.makeDeposit(balance, day, month, year, hour, min);
                                                customers.get(accountIndex).setSavingAccount(savingAccount);
                                            }
                                            else {
                                                System.out.println("Account does not Exist");
                                            }
                                            break;
                                        }
                                        default: {
                                            System.out.println("Not a Given option");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                case 5: {
                                    System.out.println("Which account would u like to withdraw money from? ");
                                    System.out.println("1 -- Checking Account");
                                    System.out.println("2 -- Saving Account");
                                    System.out.println();
                                    System.out.println("Select your choice: ");

                                    int option = input.nextInt();

                                    switch (option){
                                        case 1: {
                                            if (customers.get(accountIndex).getCheckingAccount() != null){
                                                CheckingAccount checkingAccount = customers.get(accountIndex).getCheckingAccount();
                                                System.out.println("Enter the amount you would like to deposit");
                                                double balance = input.nextDouble();

                                                System.out.println("Enter Day: ");
                                                int day = input.nextInt();
                                                System.out.println("Enter Month: ");
                                                int month = input.nextInt();
                                                System.out.println("Enter Year: ");
                                                int year = input.nextInt();
                                                System.out.println("Enter Hour: ");
                                                int hour = input.nextInt();
                                                System.out.println("Enter Min: ");
                                                int min = input.nextInt();

                                                checkingAccount.makeWithdrawal(balance, day, month, year, hour, min);
                                                customers.get(accountIndex).setCheckingAccount(checkingAccount);
                                            }
                                            else {
                                                System.out.println("Account does not Exist");
                                            }
                                            break;
                                        }
                                        case 2: {
                                            if (customers.get(accountIndex).getSavingAccount() != null){
                                                SavingAccount savingAccount = customers.get(accountIndex).getSavingAccount();
                                                System.out.println("Enter the amount you would like to withdraw");
                                                double balance = input.nextDouble();

                                                System.out.println("Enter Day: ");
                                                int day = input.nextInt();
                                                System.out.println("Enter Month: ");
                                                int month = input.nextInt();
                                                System.out.println("Enter Year: ");
                                                int year = input.nextInt();
                                                System.out.println("Enter Hour: ");
                                                int hour = input.nextInt();
                                                System.out.println("Enter Min: ");
                                                int min = input.nextInt();

                                                savingAccount.makeWithdrawal(balance, day, month, year, hour, min);
                                                customers.get(accountIndex).setSavingAccount(savingAccount);
                                            }
                                            else {
                                                System.out.println("Account does not Exist");
                                            }
                                            break;
                                        }
                                        default: {
                                            System.out.println("Not a Given option");
                                            break;
                                        }
                                    }
                                    break;
                                }
                                case 6: {
                                    System.out.println("Enter account number for the customer u want to transfer the amount in: ");
                                    String transferAccountNumber = input.next();
                                    boolean transferAccountFound = false;
                                    int transferAccountIndex = 0;

                                    for (int i = 0; i < customers.size(); i++) {
                                        if (customers.get(i).getAccountNumber().equals(transferAccountNumber)){
                                            transferAccountIndex = i;
                                            transferAccountFound = true;
                                            break;
                                        }
                                    }

                                    if (transferAccountFound){
                                        System.out.println("Which account type would u like to transfer the money in?");
                                        System.out.println("1 -- Checking Account");
                                        System.out.println("2 -- Saving Account");
                                        System.out.println();
                                        System.out.println("Select your choice: ");

                                        int option = input.nextInt();

                                        switch (option){
                                            case 1: {
                                                if (customers.get(transferAccountIndex).getCheckingAccount() != null){
                                                    System.out.println("Which account would u like to transfer the money from? ");
                                                    System.out.println("1 -- Checking Account");
                                                    System.out.println("2 -- Saving Account");
                                                    System.out.println();
                                                    System.out.println("Select your choice: ");

                                                    int selection = input.nextInt();

                                                    switch (selection){
                                                        case 1: {
                                                            if (customers.get(accountIndex).getCheckingAccount() != null){

                                                                System.out.println("Enter the Amount you would like to send");
                                                                double amountToTransfer = input.nextDouble();

                                                                System.out.println("Enter Day: ");
                                                                int day = input.nextInt();
                                                                System.out.println("Enter Month: ");
                                                                int month = input.nextInt();
                                                                System.out.println("Enter Year: ");
                                                                int year = input.nextInt();
                                                                System.out.println("Enter Hour: ");
                                                                int hour = input.nextInt();
                                                                System.out.println("Enter Min: ");
                                                                int min = input.nextInt();

                                                                customers.get(accountIndex).getCheckingAccount().transferAmount(customers.get(transferAccountIndex).getCheckingAccount(), customers.get(accountIndex).getCheckingAccount(), amountToTransfer, day, month, year, hour, min);

                                                            }
                                                            else {
                                                                System.out.println("Account does not Exist");
                                                            }
                                                            break;
                                                        }
                                                        case 2: {
                                                            if (customers.get(accountIndex).getSavingAccount() != null) {

                                                                System.out.println("Enter the Amount you would like to send");
                                                                double amountToTransfer = input.nextDouble();

                                                                System.out.println("Enter Day: ");
                                                                int day = input.nextInt();
                                                                System.out.println("Enter Month: ");
                                                                int month = input.nextInt();
                                                                System.out.println("Enter Year: ");
                                                                int year = input.nextInt();
                                                                System.out.println("Enter Hour: ");
                                                                int hour = input.nextInt();
                                                                System.out.println("Enter Min: ");
                                                                int min = input.nextInt();

                                                                customers.get(accountIndex).getSavingAccount().transferAmount(customers.get(transferAccountIndex).getCheckingAccount(), customers.get(accountIndex).getCheckingAccount(), amountToTransfer, day, month, year, hour, min);

                                                            }
                                                            else {
                                                                System.out.println("Account does not Exist");
                                                            }
                                                            break;
                                                        }
                                                    }
                                                }
                                                else {
                                                    System.out.println("Account does not Exist");
                                                }
                                                break;
                                            }
                                            case 2: {
                                                if (customers.get(transferAccountIndex).getSavingAccount() != null){
                                                    System.out.println("Which account would u like to transfer the money from? ");
                                                    System.out.println("1 -- Checking Account");
                                                    System.out.println("2 -- Saving Account");
                                                    System.out.println();
                                                    System.out.println("Select your choice: ");

                                                    int selection = input.nextInt();

                                                    switch (selection){
                                                        case 1: {
                                                            if (customers.get(accountIndex).getCheckingAccount() != null){

                                                                System.out.println("Enter the Amount you would like to send");
                                                                double amountToTransfer = input.nextDouble();

                                                                System.out.println("Enter Day: ");
                                                                int day = input.nextInt();
                                                                System.out.println("Enter Month: ");
                                                                int month = input.nextInt();
                                                                System.out.println("Enter Year: ");
                                                                int year = input.nextInt();
                                                                System.out.println("Enter Hour: ");
                                                                int hour = input.nextInt();
                                                                System.out.println("Enter Min: ");
                                                                int min = input.nextInt();

                                                                customers.get(accountIndex).getCheckingAccount().transferAmount(customers.get(transferAccountIndex).getSavingAccount(), customers.get(accountIndex).getCheckingAccount(), amountToTransfer, day, month, year, hour, min);

                                                            }
                                                            else {
                                                                System.out.println("Account does not Exist");
                                                            }
                                                            break;
                                                        }
                                                        case 2: {
                                                            if (customers.get(accountIndex).getSavingAccount() != null) {

                                                                System.out.println("Enter the Amount you would like to send");
                                                                double amountToTransfer = input.nextDouble();

                                                                System.out.println("Enter Day: ");
                                                                int day = input.nextInt();
                                                                System.out.println("Enter Month: ");
                                                                int month = input.nextInt();
                                                                System.out.println("Enter Year: ");
                                                                int year = input.nextInt();
                                                                System.out.println("Enter Hour: ");
                                                                int hour = input.nextInt();
                                                                System.out.println("Enter Min: ");
                                                                int min = input.nextInt();

                                                                customers.get(accountIndex).getSavingAccount().transferAmount(customers.get(transferAccountIndex).getSavingAccount(), customers.get(accountIndex).getCheckingAccount(), amountToTransfer, day, month, year, hour, min);

                                                            }
                                                            else {
                                                                System.out.println("Account does not Exist");
                                                            }
                                                            break;
                                                        }
                                                        default: {
                                                            System.out.println("Not a Given option");
                                                            break;
                                                        }
                                                    }
                                                }
                                                else {
                                                    System.out.println("Account does not Exist");
                                                }
                                                break;
                                            }
                                            default: {
                                                System.out.println("Not a Given option");
                                                break;
                                            }
                                        }
                                    }
                                    else{
                                        System.out.println("No Customer with this account number exists");
                                    }
                                    break;
                                }
                                case 7: {
                                    if (customers.get(accountIndex).getCheckingAccount() != null){
                                        System.out.println("Your Checking Account Details: ");
                                        CheckingAccount checkingAccount = customers.get(accountIndex).getCheckingAccount();
                                        checkingAccount.displayAllDeductions();
                                    }
                                    if (customers.get(accountIndex).getSavingAccount() != null){
                                        System.out.println("Your Saving Account Details: ");
                                        SavingAccount savingAccount = customers.get(accountIndex).getSavingAccount();
                                        savingAccount.displayAllDeductions();
                                    }
                                    if (customers.get(accountIndex).getCheckingAccount() == null && customers.get(accountIndex).getSavingAccount() == null){
                                        System.out.println("You dont have any accounts yet");
                                    }
                                    System.out.println();
                                    break;
                                }
                                default: {
                                    System.out.println("This Option Does not exist");
                                    break;
                                }
                            }
                        }while (choice != 0);
                    }

                    break;
                }
                case 5: {
                    if (customers.size() !=0 ) {
                        for (Customer customer : customers) {
                            if (customer.getSavingAccount() != null) {
                                customer.getSavingAccount().calculateZakat();
                            }
                        }
                    }
                    else{
                        System.out.println("There are no accounts to deduct Zakat from");
                    }
                    break;
                }
                case 6: {
                    for (Customer customer : customers) {
                        customer.getSavingAccount().setZakatPaidThisYear(false);
                    }
                    break;
                }
                case 7: {
                    for (Customer customer : customers) {
                        customer.getCheckingAccount().setNumberOfWithdraws(0);
                    }
                    break;
                }
                case 8: {
                    for (int i = 0; i < customers.size(); i++) {
                        customers.get(i).getSavingAccount().calculateInterest();
                    }
                    break;
                }
                case 9: {
                    System.out.println("Enter new Interest rate: ");
                    SavingAccount.interestRate=input.nextDouble();
                }
                break;
            }

        }while (options != 0);
    }
}
