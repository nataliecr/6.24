import java.util.Scanner;

public class ShowCurrentTime {
  public static void main(String[] args) {
    // Obtain the total milliseconds since midnight, Jan 1, 1970
    long totalMilliseconds = System.currentTimeMillis();
 
    // Obtain the total seconds since midnight, Jan 1, 1970
    long totalSeconds = totalMilliseconds / 1000;
 
    // Compute the current second in the minute in the hour
    long currentSecond = totalSeconds % 60;
 
    // Obtain the total minutes
    long totalMinutes = totalSeconds / 60;
 
    // Compute the current minute in the hour
    long currentMinute = totalMinutes % 60;
 
    // Obtain the total hours
    long totalHours = totalMinutes / 60;
 
    // Compute the current hour
    long currentHour = totalHours % 24;
    
    System.out.println("Current date and time is " + printDate(totalHours) + 
            " " + currentHour + ":" + currentMinute + ":" 
            + currentSecond + " GMT");
  } // main
  
  public static String printDate(long totalHours){
    long days = totalHours / 24;
    int year = 1970, temp = 0, temp2 = 0, month;
    
    while (days > 0){
        if(isLeapYear(year)){
          temp = 366;
          days = days - 366;
        } // if leap year
        if(isLeapYear(year) == false){
          temp = 365;
          days = days - 365;
        } // if not leap year
        year++;
    } // while days > 0
    days += temp;
    year--;
    
    for (month = 1; month <= 12; month++) {
     temp2 = getNumberOfDaysInMonth(year, month);
     days -= temp2;
 
     if (days < 0)
      break;
    }
 
    days += temp2;
    
    return month + "/" + days + "/" + year;
  } // print date
  
  /** Get the number of days in a month */
  static int getNumberOfDaysInMonth(int year, int month) {
    if (month == 1 || month == 3 || month == 5 || month == 7 ||
      month == 8 || month == 10 || month == 12)
      return 31;

    if (month == 4 || month == 6 || month == 9 || month == 11)
      return 30;

    if (month == 2) return isLeapYear(year) ? 29 : 28;

    return 0; // If month is incorrect
  }

  /** Determine if it is a leap year */
  static boolean isLeapYear(int year) {
    return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
  }
}