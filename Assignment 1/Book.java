public class Book {
    private String bookName;
    private String bookAuthor;
    private String textBody;
    private  int numberOfBooks;
    student [] studentIssued;
    Date [] issueRecords = new Date [0] ;

    Book(String bookName, String bookAuthor, int numberOfBooks){
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.numberOfBooks = numberOfBooks;
        textBody = "";
        studentIssued = new student[numberOfBooks];
        for (int i = 0; i < numberOfBooks; i++) {
            studentIssued[i] = new student();
        }
    }

    public void issueBook(String Name, String RollNumber, int Day , int Month, int Year){
        if (numberOfBooks != 0){
        studentIssued[numberOfBooks-1] = new student(Name, RollNumber, Day,Month,Year);
        numberOfBooks--;}
        else {
            System.out.println("The selected Book is not available right now");
        }

        Date [] temp = new Date[issueRecords.length+1];

        for (int i = 0; i < issueRecords.length; i++) {
            temp[i] = issueRecords[i];
        }

        temp[issueRecords.length] = new Date(Day,Month,Year);

        issueRecords = temp;

    }

    public int returnBook(String RollNumber, int Day, int Month, int Year){
        int temp = -1;
        student issueDate = new student();
        int fine = 0;

        for (int i = studentIssued.length-1 ; i >= 0; i--) {
            if (studentIssued[i].getRollNumber().equals(RollNumber)){
                temp = i;
                issueDate = studentIssued[i];
                studentIssued[0] = new student();
                break;
            }
        }
        if (temp != -1) {
            studentIssued[temp].setReturnDate(Day, Month, Year);
            fine = calculateFine(temp, issueDate);

            if (fine < 0){
                System.out.println("You Can't return a book before its Issue Date.");
            }
            else{
                for (int j = temp; j > 0; j--) {
                    studentIssued[j]=studentIssued[j-1];
                }
                numberOfBooks++;
            }
        }
        else {
            System.out.println("This roll number never issued this book");
        }
        return fine;
    }

    private int calculateFine(int i, student issueDate){
        int temp;

        temp = Date.daysDifference(issueDate.getIssueDate(),studentIssued[i].getReturnDate());

        if (temp > 7){
            temp -= 7;
            temp *= 500;
        }
        else if (temp > 0){
            temp = 0;
        }

        return temp;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public Date[] getIssueRecords() {
        return issueRecords;
    }

    public String getTextBody() {
        return textBody;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setTextBody(String textBody) {
        this.textBody = textBody;
    }

    public int getMonth(int i){
        return studentIssued[i].getMonth();
    }

    public int getYear(int i){
        return studentIssued[i].getYear();
    }
}
