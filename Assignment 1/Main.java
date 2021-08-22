import java.util.Scanner;

public class Main {

    static String password = "123";

    static public void main(String [] Args) {
        String choice = "0";
        int option = -1;
        Scanner input = new Scanner(System.in);

        Book[] books = new Book[3];
        books[0] = new Book("The Ultimate Guide to Programming", "David", 10);
        books[1] = new Book("Java for dummies", "Ali", 5);
        books[2] = new Book("How to Make your on AI Assistant", "Majid",3);

        while (!choice.equals("<")){
            printMainMenu();
            choice = input.next();

            switch (choice) {
                case "#":
                    if (!passwordVerified()){
                        System.out.println("Incorrect password. Exiting to Main Menu");
                        break;
                    }

                    option = -1;

                    while  (option != 0){

                        printAdminMenu();

                        option = input.nextInt();
                        input.nextLine();

                        switch (option) {

                            case 1:
                                books = addBook(books);
                                break;
                            case 2:
                                editBook(books);
                                break;
                            case 3:
                                books = deleteBook(books);
                                break;
                            case 4:
                                issueBook(books);
                                break;
                            case 5:
                                returnBook(books);
                                break;
                            case 6:
                                viewBooks(books);
                                break;
                            case 7:
                                viewRecords(books);
                                break;
                            case 8:
                                password = changePassword();
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Invalid Input");
                        }
                    }

                    break;
                case "$":

                    option = -1;

                    while  (option != 0) {

                        printStudentMenu();

                        option = input.nextInt();
                        input.nextLine();

                        switch (option){
                            case 1:
                                searchBook(books);
                                break;
                            case 2:
                                issueBook(books);
                                break;
                            case 3:
                                readBook(books);
                                break;
                            case 4:
                                returnBook(books);
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Invalid Input");

                        }
                    }

                    break;
                case "<":

                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    static void printMainMenu(){
        System.out.println("# -- Access Admin Mode");
        System.out.println("$ -- Access Student Mode");
        System.out.println("< -- Exit Program");
        System.out.println();
        System.out.println("Enter Your Choice: ");
    }

    static void printAdminMenu(){
        System.out.println("1 -- Add a Book");
        System.out.println("2 -- Modify a Book's Details");
        System.out.println("3 -- Delete a Book");
        System.out.println("4 -- Issue a Book");
        System.out.println("5 -- Return a Book");
        System.out.println("6 -- View All Available Books");
        System.out.println("7 -- View all issue records for a month");
        System.out.println("8 -- Change the Password");
        System.out.println("0 -- Go Back to Main Menu");
        System.out.println();
        System.out.println("Enter Your Choice: ");
    }

    static void printStudentMenu(){
        System.out.println("1 -- Search for a Book");
        System.out.println("2 -- Borrow a particular Book");
        System.out.println("3 -- Read a Book");
        System.out.println("4 -- Return a borrowed Book");
        System.out.println("0 -- Go Back to Main Menu");
        System.out.println();
        System.out.println("Enter Your Choice: ");
    }

    static boolean passwordVerified(){
        boolean temp = false;
        String pin;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the Admin PIN: ");
        pin = input.next();

        if (pin.equals(password)){
            temp = true;
        }

        return temp;
    }

    static Book [] addBook(Book [] books){
        Scanner input = new Scanner(System.in);

        int newBookLength = books.length + 1;
        Book[] newBook = new Book[newBookLength];

        for (int i = 0; i < books.length; i++) {
            newBook[i] = books[i];
        }

        System.out.println("Enter New Book Name: ");
        String name = input.nextLine();

        System.out.println("Enter Authors Name: ");
        String aName = input.nextLine();

        System.out.println("Enter Number Of Books: ");
        int number = input.nextInt();

        newBook[newBookLength - 1] = new Book(name, aName, number);

        return newBook;
    }

    static void editBook(Book [] book){
        Scanner input = new Scanner(System.in);
        int temp = -1;
        int choice = -1;
        String name;

        while (choice != 0) {

            while(temp < 1 || temp > book.length+1 ) {
                System.out.println("Which Book you would like to edit: ");

                viewBooks(book);

                System.out.println("Enter Your Choice: ");
                temp = input.nextInt();
            }
            System.out.println("Which Attribute would you like to add?");
            System.out.println();
            System.out.println("1 -- Book Title");
            System.out.println("2 -- Authors Name");
            System.out.println("3 -- New Text Body");
            System.out.println("0 -- Exit to Previous menu");

            System.out.println("Selected Book Details");

            choice = input.nextInt();

            temp--;

            switch (choice) {
                case 1:
                    System.out.println("Enter New Book Name: ");
                    name = input.next();
                    book[temp].setBookName(name);
                    break;
                case 2:
                    System.out.println("Enter Authors Name: ");
                    String aName = input.next();
                    book[temp].setBookAuthor(aName);
                    break;
                case 3:
                    System.out.println("Enter Text for the Book: ");
                    String text = input.next();
                    book[temp].setTextBody(text);
                case 0:
                    break;
                default:
                    System.out.println("Invalid Choice");

            }
        }
    }

    static Book [] deleteBook (Book [] book){
        Scanner input = new Scanner(System.in);
        int temp = -1;
        int newBookLength = book.length-1;
        Book [] newBooks = new Book[newBookLength];

        while(temp < 0 || temp > book.length+1 ) {

            System.out.println("After Deleting a Book all its issue records will also be removed");
            System.out.println("If you would like to go back Enter 0");
            System.out.println("Which Book you would like to delete: ");

            viewBooks(book);
            System.out.println("0 -- Exit");

            System.out.println("Enter Your Choice: ");
            temp = input.nextInt();
        }

        if (temp != 0) {
            temp--;

            int x = 0;

            for (int i = 0; i < book.length; i++) {
                if (i != temp) {
                    newBooks[x] = book[i];
                    x++;
                }
            }
            return newBooks;
        }
        else{
            return book;
        }

    }

    static void issueBook (Book [] book){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter The Name of the Student: ");
        String name = input.next();

        System.out.println("Enter roll Number of student");
        String rollNumber = input.next();

        int temp = 0;
        int day, month, year;

        do {
            System.out.println("Enter Today's Day: ");
            day = input.nextInt();

            if(day < 1 || day > 31){
                System.out.println("Invalid Input");
            }

        }while (day < 1 || day > 31);

        do {
            System.out.println("Enter Today's Month");
            month = input.nextInt();

            if((month == 2 && day > 29)||(month > 12 || month < 1)){
                System.out.println("Invalid Input");
            }

        }while ((month == 2 && day > 29)||(month > 12 || month < 1));

        do {
            System.out.println("Enter Today's Year");
            year = input.nextInt();

            if(!Date.leapYear(year) && month == 2 && day == 29){
                System.out.println("Invalid Input");
            }

        }while (!Date.leapYear(year) && month == 2 && day == 29);

        while(temp < 1 || temp > book.length+1 ) {
            System.out.println("Which Book you would like to issue: ");

            viewBooks(book);

            System.out.println("Enter Your Choice: ");
            temp = input.nextInt();

        }

        temp--;
        book[temp].issueBook(name,rollNumber,day,month,year);

    }

    static void returnBook(Book[] book){
        Scanner input = new Scanner(System.in);
        int temp = 0;
        int fine;

        while(temp < 1 || temp > book.length+1 ) {
            System.out.println("Which Book you would like to return: ");

            viewBooks(book);

            System.out.println("Enter Your Choice: ");
            temp = input.nextInt();

        }
        temp--;

        System.out.println("Enter the roll number of student");
        String rollNumber = input.next();
        int day, month, year;

        do {
            System.out.println("Enter Today's Day: ");
            day = input.nextInt();

            if(day < 1 || day > 31){
                System.out.println("Invalid Input");
            }

        }while (day < 1 || day > 31);

        do {
            System.out.println("Enter Today's Month");
            month = input.nextInt();

            if((month == 2 && day > 29)||(month > 12 || month < 1)){
                System.out.println("Invalid Input");
            }

        }while ((month == 2 && day > 29)||(month > 12 || month < 1));

        do {
            System.out.println("Enter Today's Year");
            year = input.nextInt();

            if(!Date.leapYear(year) && month == 2 && day == 29){
                System.out.println("Invalid Input");
            }

        }while (!Date.leapYear(year) && month == 2 && day == 29);

        fine = book[temp].returnBook(rollNumber,day,month,year);

        if ( fine > 0){
            System.out.println("You returned the book after 7 days");
            System.out.println("Your fine will be: " + fine);
        }
        else if (fine == 0){
            System.out.println("Book Returned");
        }
    }

    static void viewBooks(Book [] book){

        System.out.println();

        System.out.println("List of All Book: ");

        for (int i = 0; i < book.length; i++) {
            System.out.println(i + 1 + " -- " + book[i].getBookName() + " -- Author: " + book[i].getBookAuthor() + " -- Available number of Books: " + book[i].getNumberOfBooks());
        }

        System.out.println();
    }

    static void viewRecords(Book [] books){
        Scanner input = new Scanner(System.in);
        Date [] temp;
        int month;

        System.out.println("Enter Year: ");
        int year = input.nextInt();

        do {
            System.out.println("Enter Month: ");
            month = input.nextInt();
        }while (month > 12 || month < 1);
        System.out.println("Books issued this month were:");

        for (int i = 0 ; i < books.length ; i++) {
            temp = books[i].getIssueRecords();
            for (int j = 0 ; j < temp.length ; j++) {
                if (temp[j].getMonth() == month && temp[j].getYear() == year) {
                    System.out.println(books[i].getBookName() + " issued on " + temp[j].getDay());
                }
            }
        }
    }

    static String changePassword(){
        Scanner input = new Scanner(System.in);

        String temp;
        System.out.println("Enter New Password: ");
        temp = input.next();

        return temp;
    }

    static void searchBook(Book[] books){
        Scanner input = new Scanner(System.in);
        String choice;
        boolean bookFound = false;

        while(!bookFound){
            System.out.println("Enter the name of the book(enter 0 to exit): ");
            choice = input.nextLine();

            if (choice.equals("0")){
                break;
            }

            for (int i = 0; i < books.length; i++) {
                if (books[i].getBookName().equals(choice) ){
                    System.out.println("Your book was found at index " + i);
                    bookFound = true;
                    break;
                }
            }

            if (!bookFound){
                System.out.println("The book name you searched is not available in the library");
            }

        }



    }

    static void readBook(Book [] books) {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        viewBooks(books);
        System.out.println("Enter the Book Number you would like to read: ");


        while (choice < 1 || choice > books.length) {
            choice = input.nextInt();
        }


        if (books[choice - 1].getTextBody().equals("")) {
            System.out.println("No text is available for this book kindly ask admin to edit the book to add it");
        }
        else {
            System.out.println("The text written for this book is: ");
            System.out.println(books[choice - 1].getTextBody());
        }
    }
}
