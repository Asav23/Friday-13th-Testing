import java.util.Scanner;
/*
This Lfriday13th file is the original file that was needed ton be tested, it contains numerous errors,and the testing code is testament to this.


 * Task-6: Friday13thCalculator
 * On the planet Htrae Friday the 13th is a lucky day. You are
 * going there on the next space ship and want to calculate how
 * many times it happens during a given year. Unfortunately they
 * change their calendar every year. Every year starts on a Sunday,  
 * but other than that, they change everything. They have released
 * a list of calendar specifications for the next few years. A
 * calendar specification consists of the total number of days in
 * the year, the number of months in the year, and the number of
 * days in each of the months.
 *
 * Your task is to figure out how many times there will be Friday
 * the 13th based on the calendar specifications.
 *
 * Program input should be:
 * - the total number of days in the year
 * - the number of months in the year
 * - an array of integers representing the number of days in each month
 *
 * The sum of integers in the array should equal the number of days in the year.
 */
// Class to represent a Day
// Class to represent a Day
class Day {
    private int dayNumber; // The day number in the month
    private int dayOfWeek; // The day of the week (0 = Sunday, 1 = Monday, ..., 6 = Saturday)
    // Constructor for Day
    public Day(int dayNumber, int dayOfWeek) {
        this.dayNumber = dayNumber;
        this.dayOfWeek = dayOfWeek;
    }
    // Getters
    public int getDayNumber() {
        return dayNumber;
    }
    public int getDayOfWeek() {
        return dayOfWeek;
    }
    // Override equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Check for reference equality
        if (obj == null || getClass() != obj.getClass()) return false; // Check for null and class type
        Day day = (Day) obj;
        return dayNumber == day.dayNumber && dayOfWeek == day.dayOfWeek; // Check for value equality 
    }
}
// Class to represent a Month
class Month {
    private int monthIndex; // Index of the month (0 = January, 1 = February, ...)
    private int daysInMonth; // Number of days in the month
    // Constructor for Month
    public Month(int monthIndex, int daysInMonth) {
        this.monthIndex = monthIndex;
        this.daysInMonth = daysInMonth;
    }
    // Getters
    public int getMonthIndex() {
        return monthIndex;
    }
    public int getDaysInMonth() {
        return daysInMonth;
    }
    // Override equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Check for reference equality
        if (obj == null || getClass() != obj.getClass()) return false; // Check for null and class type
        Month month = (Month) obj;
        return monthIndex == month.monthIndex && daysInMonth == month.daysInMonth; // Check for value equality
    }
}

class Calendar {
    private int totalDays;
    private int numberOfMonths;
    private Month[] months;
    // Constructor to initialize the calendar
    public Calendar(int totalDays, int numberOfMonths, int[] daysInMonths) {
        this.totalDays = totalDays;
        this.numberOfMonths = numberOfMonths;
        this.months = new Month[numberOfMonths];
        // Initialize months
        for (int i = 0; i < numberOfMonths; i++) {
            months[i] = new Month(i, daysInMonths[i]);
        } 
        validateInput(daysInMonths);
    }
    // Validate input for the calendar
    private void validateInput(int[] daysInMonths) {
        int sum = 0; 
        for (int days : daysInMonths) {
            sum += days;
        }
        if (sum != totalDays) {
            throw new IllegalArgumentException("Error: The sum of days in the months must equal the total days in the year.");
        }
        if (numberOfMonths <= 0) {
            throw new IllegalArgumentException("Error: The number of months must be greater than zero.");
        }
        if (totalDays <= 0) {
            throw new IllegalArgumentException("Error: The total number of days must be greater than zero.");
        }
    }
    // Method to calculate the number of Fridays that fall on the 13th
    public int countFridaysOn13th() {
        int friday13Count = 0;
        int dayOfWeek = 0; // Start at Sunday (0)
        for (Month month : months) {
            // Create a Day instance for the 13th of the current month
            Day day13 = new Day(13, dayOfWeek);
            // Check if the 13th day is a Friday
            if (day13.getDayOfWeek() == 5) { // 5 = Friday
                friday13Count++;
            }
            // Update dayOfWeek for the next month
            dayOfWeek = (dayOfWeek + month.getDaysInMonth()) % 7; // Move to the first day of the next month
        }
        return friday13Count;


       /* 
        public int countFridaysOn13th() { 
            int friday13Count = 0;
            int dayOfWeek = 0; // Start at Sunday (0)
    
            for (Month month : months) {
                if (month.getDaysInMonth() >= 13 && dayOfWeek == 0) { // Check if month has 13+ days and starts on Sunday
                    friday13Count++;
                }
                dayOfWeek = (dayOfWeek + month.getDaysInMonth()) % 7; // Move to the first day of the next month
            }
    
            return friday13Count;
        }
        */
















 
  
    }


    public int getStartDayOfMonth(int monthIndex) {
        int currentDayOfWeek = 0; // Start with Sunday for the first month (index 0)
        
        // Loop through all months up to the given month index
        for (int i = 0; i < monthIndex; i++) {
            // Update the day of the week by adding the number of days in the current month
            currentDayOfWeek = (currentDayOfWeek + months[i].getDaysInMonth()) % 7;
        }
        
        return currentDayOfWeek; // Return the calculated start day of the specified month
    }


}






    

public class LFriday13thCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Read the total number of days in the year
        System.out.print("Enter the total number of days in the year: ");
        int totalDays = scanner.nextInt();
        // Read the number of months in the year
        System.out.print("Enter the number of months in the year: ");
        int numberOfMonths = scanner.nextInt();
        // Read the number of days in each month
        int[] daysInMonths = new int[numberOfMonths];
        System.out.println("Enter the number of days in each month:");
        for (int i = 0; i < numberOfMonths; i++) {
            daysInMonths[i] = scanner.nextInt();
        }
        // Create a Calendar instance and calculate the number of Fridays on 13th
        try {
            Calendar calendar = new Calendar(totalDays, numberOfMonths, daysInMonths);
            int friday13Count = calendar.countFridaysOn13th();
            System.out.println("The number of Fridays that fall on the 13th is: " + friday13Count);
        } catch (IllegalArgumentException e) {
            // Handle validation errors
            System.out.println(e.getMessage());
        } catch (Exception e) {
            // Handle any other unexpected exceptions
            System.out.println("An unexpected error occurred: " + e. getMessage());
        } finally {
            scanner.close(); // Close the scanner
        }
    }
}
