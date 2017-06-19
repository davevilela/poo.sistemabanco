package util;

/**
 * Created by daviv on 19/06/2017.
 */
public class Date {

    private int day;
    private int month;
    private int year;

    public Date(){}

    public Date(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
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

    public void setDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String getDateFormatted(){
        String date = this.year + "-" + this.month + "-" + this.day;
        return date;
    }
}
