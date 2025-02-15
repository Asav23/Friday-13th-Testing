import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class Daysinmonth {

    // Test case to verify the normal sum of days in given months
    @Test
    public void testNormalDaysInMonth() {
        int totalDays = 197;
        int[] daysInMonths = {21, 45, 31, 36, 64};

        int sumOfDays = 0;
        for (int days : daysInMonths) {
            sumOfDays += days;
        }

        assertEquals(totalDays, sumOfDays, "The sum of days in the months does not match the total days.");
        System.out.println("Test passed: Days match.");
    }

    // Test case to verify the minimum allowed days in a month (1 day in a month)
    @Test
    public void testMinDaysInMonthAllowed() {
        int totalDays = 1;
        int[] daysInMonths = {1};

        int sumOfDays = 0;
        for (int days : daysInMonths) {
            sumOfDays += days;
        }

        assertEquals(totalDays, sumOfDays, "Test failed: Sum should match the total days.");
        System.out.println("Test passed: Minimum amount of days is 1.");
    }

    // Test case to verify that negative days in a month throw an IllegalArgumentException
    @Test
    public void testNegativeDaysInMonth() {
        int[] daysInMonths = {56, 85, 18, 6, 9, -43, 18, 17, -19, 3}; // Contains negative values

        // Check for negative days and assert that an exception is thrown
        assertThrows(IllegalArgumentException.class, () -> {
            for (int days : daysInMonths) {
                if (days < 0) {
                    throw new IllegalArgumentException("Error: Days in months cannot contain negative values.");
                }
            }
        }, "Expected IllegalArgumentException due to negative days in months.");
    }

    // Test case to check if all months with zero days throw an IllegalArgumentException
    @Test
    public void testZeroDaysInAllMonths() {
        int[] daysInMonths = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; // All months have zero days

        // Expecting an exception for zero days in all months
        assertThrows(IllegalArgumentException.class, () -> {
            boolean allZeroDays = true;
            for (int days : daysInMonths) {
                if (days != 0) {
                    allZeroDays = false;
                    break;
                }
            }
            if (allZeroDays) {
                throw new IllegalArgumentException("Error: There should be at least one day in one month.");
            }
        }, "Expected IllegalArgumentException due to zero days in all months.");
    }

    // Test case to check the sum mismatch of days across months (invalid sum)
    @Test
    public void testDaysSumMismatch() {
        int totalDays = 197;
        int[] daysInMonths = {21, 45, 31, 36, 65};  // Sum is incorrect

        // Perform the sum and check inside the lambda
        assertThrows(IllegalArgumentException.class, () -> {
            int sumOfDays = 0;
            for (int days : daysInMonths) {
                sumOfDays += days;
            }
            if (sumOfDays != totalDays) {
                throw new IllegalArgumentException("The sum of days in the months does not match the total days.");
            }
        }, "Expected IllegalArgumentException due to sum mismatch.");
    }

    // Test case to check for extremely large numbers of days
    @Test
    public void testExtremeDaysInMonth() {
        int totalDays = 2_000_000_000;
        int[] daysInMonths = {400000000, 1_600_000_000};

        int sumOfDays = 0;
        for (int days : daysInMonths) {
            sumOfDays += days;
        }

        assertEquals(totalDays, sumOfDays, "Test failed: Incorrect total of days.");
    }

    // Test case to check the behavior when there is one zero-day month
   

    public void testOneZeroDayMonth() {
        int[] daysInMonths = {30, 0, 31, 28, 31, 31, 31};  // Invalid month with 0 days
    
        // Assert that an IllegalArgumentException is thrown for a month with 0 days
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> {
                for (int days : daysInMonths) {
                    if (days <= 0) {
                        throw new IllegalArgumentException("Invalid month with 0 or negative days.");
                    }
                }
            }
        );
    
        // Optionally check the exception message if specific feedback is needed
        assertEquals("Invalid month with 0 or negative days.", exception.getMessage());


        }



    // Test case to check for multiple months with zero days
    @Test
public void testMultipleZeroDayMonths() {
    int[] daysInMonths = {31, 0, 31, 0, 30, 0, 32};  // Multiple zero-day months

    // Assert that an IllegalArgumentException is thrown for multiple zero-day months
    IllegalArgumentException exception = assertThrows(
        IllegalArgumentException.class,
        () -> {
            for (int days : daysInMonths) {
                if (days <= 0) {
                    throw new IllegalArgumentException("Invalid month with 0 or negative days.");
                }
            }
        }
    );

    // Optionally check the exception message if specific feedback is needed
    assertEquals("Invalid month with 0 or negative days.", exception.getMessage());
}

    // Test case to check for all negative values in the daysInMonths array
    @Test
    public void testAllNegativeValues() {
        int totalDays = -124; // Negative total days

        assertThrows(IllegalArgumentException.class, () -> {
            if (totalDays < 0) {
                throw new IllegalArgumentException("Error: Total days cannot be negative.");
            }
        }, "Expected IllegalArgumentException for negative totalDays.");
    }

    // Test case to check handling of the maximum integer value for total days in a month
    @Test
    public void testMaxIntegerDaysInMonth() {
        int totalDays = Integer.MAX_VALUE;
        int[] daysInMonths = {Integer.MAX_VALUE};

        int sumOfDays = 0;
        for (int days : daysInMonths) {
            sumOfDays += days;
        }

        assertEquals(totalDays, sumOfDays, "Test failed: Handling maximum integer value for days in a month.");
    }

    // Test case to check that the sum of days doesn't exceed integer limits (max days)
    @Test
    public void testSumExceedsIntegerLimit() { 
        int totalDays = Integer.MAX_VALUE + 1; // Exceeding max integer value
        int[] daysInMonths = {Integer.MAX_VALUE, 1}; // Sum exceeds integer limit

         assertThrows(ArithmeticException.class, () -> {
            int sumOfDays = 0;
            for (int days : daysInMonths) {
                sumOfDays += days;
            }
            if (sumOfDays != totalDays) {
                throw new ArithmeticException("Sum exceeds integer limit.");
            }
        }, "Expected ArithmeticException for overflow.");
    }
}
