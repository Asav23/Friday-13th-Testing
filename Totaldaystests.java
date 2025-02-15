import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class Totaldaystests {

    // Helper function to calculate the sum of days in months
    private int calculateSumOfDays(int[] daysInMonths) {
        int sum = 0;
        for (int days : daysInMonths) {
            sum += days;
        }
        return sum;
    }

    // ---- Before Constructor Tests ---- //

    @Test
    public void testInvalidTotalDaysBeforeConstructor() {
        // Test for invalid totalDays that don't match the sum of days in months.
        int totalDays = 30;
        int[] daysInMonths = {10, 10, 5}; // Total days mismatch, should be 25

        int sumOfDays = calculateSumOfDays(daysInMonths);
        
        if (totalDays != sumOfDays) {
            throw new IllegalArgumentException("Total days should match the sum of days in months.");
        }

        assertNotEquals(totalDays, sumOfDays, "Expected totalDays does not match the sum of days in months.");
    }

    @Test
    public void testZeroTotalDaysBeforeConstructor() {
        // Test for zero totalDays where sum of days in months is also zero.
        int totalDays = 0;
        int[] daysInMonths = {0, 0}; // Zero days match

        int sumOfDays = calculateSumOfDays(daysInMonths);

        if (totalDays != sumOfDays) {
            throw new IllegalArgumentException("Total days should match the sum of days in months.");
        }

        assertEquals(totalDays, sumOfDays, "Expected totalDays to match the sum of days in months.");
    }

    @Test
    public void testTotalDaysExceedingDaysInMonthsBeforeConstructor() {
        // Test for totalDays exceeding the sum of days in months. 
        int totalDays = 40;
        int[] daysInMonths = {15, 15}; // Total days = 30, exceeds totalDays

        int sumOfDays = calculateSumOfDays(daysInMonths);

        if (totalDays > sumOfDays) {
            throw new IllegalArgumentException("Total days should not exceed the sum of days in months.");
        }

        assertNotEquals(totalDays, sumOfDays, "Expected totalDays to exceed the sum of days in months.");
    }

    @Test
    public void testNegativeTotalDaysBeforeConstructor() {
        // Test for negative totalDays, should throw exception before constructor.
        int totalDays = -20 ;
        int[] daysInMonths = {10, 10}; // Negative totalDays is invalid

        assertThrows(IllegalArgumentException.class, () -> {
            if (totalDays < 0) {
                throw new IllegalArgumentException("Total days cannot be negative.");
            }
            new Calendar(totalDays, daysInMonths.length, daysInMonths);
        });
    }

    @Test
    public void testExtremeTotalDaysBeforeConstructor() {
        // Test for extremely large totalDays, should not throw exception before constructor.
        int totalDays = Integer.MAX_VALUE;
        int[] daysInMonths = {Integer.MAX_VALUE}; // Extreme totalDays

        int sumOfDays = calculateSumOfDays(daysInMonths);
        
        if (totalDays != sumOfDays) {
            throw new IllegalArgumentException("Total days should match the sum of days in months.");
        }

        assertEquals(totalDays, sumOfDays, "Expected totalDays does to match the sum of days in months.");
    }

    // ---- After Constructor Tests ---- //

    @Test
    public void testInvalidTotalDaysAfterConstructor() {
        // Test for constructor throwing exception when totalDays mismatches sum of days in months.
        int totalDays = 30;
        int numberOfMonths = 3;
        int[] daysInMonths = {10, 10, 5}; // Mismatch, should throw exception

        assertThrows(IllegalArgumentException.class, () -> new Calendar(totalDays, numberOfMonths, daysInMonths));
    }

    @Test
    public void testValidTotalDaysAfterConstructor() {
        // Test for valid totalDays matching the sum of days in months.
        int totalDays = 30;
        int numberOfMonths = 2;
        int[] daysInMonths = {15, 15}; // Valid total days

        assertDoesNotThrow(() -> new Calendar(totalDays, numberOfMonths, daysInMonths));
    }

    @Test
    public void testZeroTotalDaysAfterConstructor() {
        // Test for zero totalDays that should throw an exception.
        int totalDays = 0;
        int numberOfMonths = 2;
        int[] daysInMonths = {0, 0}; // Zero days in each month

        assertThrows(IllegalArgumentException.class, () -> new Calendar(totalDays, numberOfMonths, daysInMonths));
    }

    @Test
public void testEmptyMonthsArrayAfterConstructor() {
    // Test for empty daysInMonths array which should throw an ArrayIndexOutOfBoundsException.
    int totalDays = 30;
    int numberOfMonths = 2;
    int[] daysInMonths = {}; // Empty array, should throw ArrayIndexOutOfBoundsException

    // Expect ArrayIndexOutOfBoundsException to be thrown
    assertThrows(ArrayIndexOutOfBoundsException.class, () -> new Calendar(totalDays, numberOfMonths, daysInMonths));
}

    @Test
    public void testMinTotalDaysAfterConstructor() {
        // Test for minimum totalDays (1) that should pass with no exception.
        int totalDays = 1;
        int numberOfMonths = 1;
        int[] daysInMonths = {1}; // Valid minimum days

        assertDoesNotThrow(() -> new Calendar(totalDays, numberOfMonths, daysInMonths));
    }

    @Test
    public void testValidTotalDays31AfterConstructor() {
        // Test for valid totalDays of 31 that should pass with no exception.
        int totalDays = 31;
        int numberOfMonths = 1;
        int[] daysInMonths = {31}; // Valid totalDays

        assertDoesNotThrow(() -> new Calendar(totalDays, numberOfMonths, daysInMonths));
    }

    

    @Test
    public void testNegativeTotalDaysAfterConstructor() {
        // Test for negative totalDays, should throw exception during constructor.
        int totalDays = -20;
        int numberOfMonths = 2;
        int[] daysInMonths = {10, 10}; // Negative totalDays is invalid

        assertThrows(IllegalArgumentException.class, () -> new Calendar(totalDays, numberOfMonths, daysInMonths));
    }

    @Test
    public void testExtremeTotalDaysAfterConstructor() {
        // Test for extremely large totalDays, should pass without exception.
        int totalDays = Integer.MAX_VALUE;
        int numberOfMonths = 1;
        int[] daysInMonths = {Integer.MAX_VALUE}; // Extreme totalDays

        assertDoesNotThrow(() -> new Calendar(totalDays, numberOfMonths, daysInMonths));
    } 
}
