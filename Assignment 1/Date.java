public class Date {
    private int day;
    private int month;
    private int year;

    public Date (int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    static int daysDifference(Date issueDate, Date returnDate){
        int temp;
        int i = issueDate.getMonth();
        Date difference = issueDate;

        if (issueDate.getMonth() == returnDate.getMonth()){
            temp = returnDate.getDay() - issueDate.getDay();
        }
        else if (issueDate.getYear() == returnDate.getYear()){
            temp = (daysInMonth(issueDate) - issueDate.getDay()) + returnDate.getDay();
            while (difference.getMonth() + 1 != returnDate.getMonth()){
                i++;
                difference.setMonth(i);
                temp += daysInMonth(difference);

                if (issueDate.getMonth() < returnDate.getMonth()){
                    temp = -100;
                }
            }

            if (issueDate.getMonth() < returnDate.getMonth()){
                temp = -100;
            }
        }
        else{
            temp = (daysInMonth(issueDate) - issueDate.getDay()) + returnDate.getDay();

            while (difference.getMonth() != 12){
                i++;
                difference.setMonth(i);
                temp += daysInMonth(difference);
            }

            i = difference.getYear();

            while (difference.getYear() + 1 != returnDate.getYear()){
                i++;
                difference.setYear(i);
                temp += daysInYear(difference.getYear());
            }

            difference = new Date(1, 1, returnDate.getYear());
            while (difference.getMonth() + 1 != returnDate.getMonth()){
                if (issueDate.getYear() < returnDate.getYear()){
                    temp = -100;
                }
                i++;
                difference.setMonth(i);
                temp += daysInMonth(difference);
            }
        }

        return temp;
    }

    private static int daysInYear(int Year){
        int temp;

        if (Year % 4 == 0){
            if (Year % 100 == 0){
                if (Year % 400 == 0){
                    temp = 366;
                }
                else {
                    temp = 365;
                }
            }
            else {
                temp = 366;
            }
        }
        else{
            temp = 365;
        }

        return temp;
    }

    private static int daysInMonth(Date date){
        int temp = 0;
        switch (date.getMonth()){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                temp = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                temp = 30;
                break;
            case 2:

                if (leapYear(date.getYear())){
                    temp = 29;
                }
                else{
                    temp = 28;
                }
        }
        return temp;
    }

    static boolean leapYear(int Year){
        boolean temp = false;
        if (Year % 4 == 0){
            if (Year % 100 == 0){
                if (Year % 400 == 0){
                    temp = true;
                }
            }
            else {
                temp = true;
            }
        }

        return temp;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
