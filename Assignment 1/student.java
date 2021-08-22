public class student {
    private String name;
    private String rollNumber;

    private Date issueDate;
    private Date returnDate;

    public student(){
        name = "";
        rollNumber = "";
        setIssueDate(0,0,0);
        setReturnDate(0,0,0);
    }

    public student(String name, String rollNumber, int Day, int Month, int Year){
        this.name = name;
        this.rollNumber = rollNumber;
        setIssueDate(Day, Month, Year);
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setIssueDate(int Day, int Month, int Year) {
        issueDate = new Date(Day, Month, Year);
    }

    public void setReturnDate(int Day, int Month, int Year) {
        returnDate = new Date(Day, Month, Year);
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public int getMonth(){
        return issueDate.getMonth();
    }

    public int getYear(){
        return issueDate.getYear();
    }

    public int getDay(){
        return issueDate.getDay();
    }

    public Date getReturnDate() {
        return returnDate;
    }
}
