import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
  
public class TestCalculator {

    // Test case to check if there's a Friday on the 13th in a month with exactly 13 days.
    @Test
    public void test13CalculatorOn1stMonth() {
        // Arrange
        int numberOfMonths = 1;
        int totalDays = 13;
        int[] daysInMonths = {13};

        // Create a Calendar instance with the above specifications
        Calendar calendar = new Calendar(totalDays, numberOfMonths, daysInMonths);

        // Act
        int fridayCount = calendar.countFridaysOn13th();

        // Assert
        assertEquals(1, fridayCount, "TEST FAILED, NO FRIDAY 13TH FOUND");
    }

    // Test case to check that no Friday the 13th exists in a month with only 1 day.
    @Test
    public void test13CalculatorOnonetMonth() {
        // Arrange
        int numberOfMonths = 1;
        int totalDays = 1;
        int[] daysInMonths = {1};

        // Create a Calendar instance with the above specifications
        Calendar calendar = new Calendar(totalDays, numberOfMonths, daysInMonths);

        // Act
        int fridayCount = calendar.countFridaysOn13th();

        // Assert
        assertEquals(0, fridayCount, "TEST FAILED, NO FRIDAY 13TH FOUND");
    }

    // Test case to check if there's exactly one Friday on the 13th in every month for a year.
    @Test
    public void testFriday13thEveryMonth() {
        // Arrange
        int numberOfMonths = 10;
        int totalDays = 210;
        int[] daysInMonths = {21,21,21,21,21,21,21,21,21,21};

        // Create a Calendar instance with the above specifications
        Calendar calendar = new Calendar(totalDays, numberOfMonths, daysInMonths);

        // Act
        int fridayCount = calendar.countFridaysOn13th();

        // Assert
        assertEquals(10, fridayCount, "TEST FAILED, NO FRIDAY 13TH FOUND");
    }

    // Test case to check the count of Friday the 13th for a normal year with 365 days.
    @Test
    public void testFriday13thNormalYear() {
        // Arrange
        int numberOfMonths = 12;
        int totalDays = 365;
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Act
        Calendar calendar = new Calendar(totalDays, numberOfMonths, daysInMonths);
        int fridayCount = calendar.countFridaysOn13th();

        // Assert
        assertEquals(2, fridayCount, "TEST FAILED, INCORRECT FRIDAY 13TH COUNT");
    }

    // Test case to check the count of Friday the 13th in a year where every month has 13 days.
    @Test
    public void testFriday13thAllMonthsHave13Days() {
        // Arrange
        int numberOfMonths = 12;
        int totalDays = 156;
        int[] daysInMonths = {13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13, 13};

        // Act
        Calendar calendar = new Calendar(totalDays, numberOfMonths, daysInMonths);
        int fridayCount = calendar.countFridaysOn13th();

        // Assert
        assertEquals(2, fridayCount, "TEST FAILED, INCORRECT FRIDAY 13TH COUNT");
    }

    // Test case to check the count of Friday the 13th in a short year with 90 days.
    @Test
    public void testFriday13thShortYear() {
        // Arrange
        int numberOfMonths = 3;
        int totalDays = 90;
        int[] daysInMonths = {30, 30, 30};

        // Act
        Calendar calendar = new Calendar(totalDays, numberOfMonths, daysInMonths);
        int fridayCount = calendar.countFridaysOn13th();

        // Assert
        assertEquals(1, fridayCount, "TEST FAILED, INCORRECT FRIDAY 13TH COUNT");
    }

    // Test case to check if there are no Fridays on the 13th when all months have less than 13 days.
    @Test
    public void testFriday13thNoMonthsOver13Days() {
        // Arrange
        int numberOfMonths = 4;
        int totalDays = 28;
        int[] daysInMonths = {7, 7, 7, 7};

        // Act
        Calendar calendar = new Calendar(totalDays, numberOfMonths, daysInMonths);
        int fridayCount = calendar.countFridaysOn13th();

        // Assert
        assertEquals(0, fridayCount, "TEST FAILED, INCORRECT FRIDAY 13TH COUNT");
    }

    // Test case to check the count of Friday the 13th with irregular month lengths.
    @Test
    public void testFriday13thYearWithIrregularMonths() {
        // Arrange
        int numberOfMonths = 5;
        int totalDays = 70;
        int[] daysInMonths = {10, 15, 20, 15, 10};

        // Act
        Calendar calendar = new Calendar(totalDays, numberOfMonths, daysInMonths);
        int fridayCount = calendar.countFridaysOn13th();

        // Assert
        assertEquals(0, fridayCount, "TEST FAILED, INCORRECT FRIDAY 13TH COUNT");
    }

    // Test case to check the behavior of the calendar with extreme values (1 billion days).
    @Test
    public void testExtremeValueCalendar() {
        // Arrange
        int numberOfMonths = 10;
        long totalDays = 1_000_000_000L; // 1 billion days
        int[] daysInMonths = new int[numberOfMonths];

        // Each month has 100 million days
        for (int i = 0; i < numberOfMonths; i++) {
            daysInMonths[i] = 100_000_000; // 100 million days in each month
        }

        // Act
        Calendar calendar = new Calendar((int) totalDays, numberOfMonths, daysInMonths);
        int fridayCount = calendar.countFridaysOn13th();

        // Assert
        // Since each month has 100 million days and the year starts on a Sunday,
        // The 13th day of each month will also be a Sunday (0 + 12 % 7 = 5 = Friday)
        assertEquals(0, fridayCount, "TEST FAILED: Expected 0 Friday the 13ths in a year with 10 months of 100 million days each.");
    }

    // Test case to check if an exception is thrown when there are no days in the calendar.
    @Test
    public void testZeroDaysInYear() {
        int numberOfMonths = 1;
        long totalDays = 0;
        int[] daysInMonths = { 0 }; // No days

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Calendar((int) totalDays, numberOfMonths, daysInMonths);
        }, "TEST FAILED: Expected IllegalArgumentException for zero total days.");
    }

    // Test case to check if an exception is thrown for negative total days.
    @Test
    public void testNegativeDays() {
        int numberOfMonths = 1;
        long totalDays = -1;
        int[] daysInMonths = { -1 }; // Invalid negative days

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Calendar((int) totalDays, numberOfMonths, daysInMonths);
        }, "TEST FAILED: Expected IllegalArgumentException for negative total days.");
    }

    
    // Test case to check if an exception is thrown when all months have zero days.
    @Test
    public void testAllMonthsWithZeroDays() {
        int numberOfMonths = 12;
        long totalDays = 0;
        int[] daysInMonths = new int[numberOfMonths];
        
        // Each month has 0 days
        for (int i = 0; i < numberOfMonths; i++) {
            daysInMonths[i] = 0;
        }

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Calendar((int) totalDays, numberOfMonths, daysInMonths);
        }, "TEST FAILED: Expected IllegalArgumentException for all months with zero days.");
    }

    // Test case to check if an exception is thrown when one month has more days than the total number of days in the calendar.
    @Test
    public void testOneMonthGreaterThanTotalDays() {
        int numberOfMonths = 1;
        long totalDays = 30; 
        int[] daysInMonths = { 31 }; // One month exceeds total days

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            new Calendar((int) totalDays, numberOfMonths, daysInMonths);
        }, "TEST FAILED: Expected IllegalArgumentException for one month having more days than total days.");
    }

     
    



}
