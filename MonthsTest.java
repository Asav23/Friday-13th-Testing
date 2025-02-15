import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MonthsTest {

    // Test for a normal month with 30 days
    @Test
    public void testNormalMonth() {
        int monthIndex = 0;
        int daysInMonth = 30;
        Month month = new Month(monthIndex, daysInMonth);
        assertEquals(30, month.getDaysInMonth());
    }

    // Test for zero days in a month (invalid case)
    @Test
    public void testZeroDaysInMonth() {
        int monthIndex = 1;
        int daysInMonth = 0;
        assertThrows(IllegalArgumentException.class, () -> new Month(monthIndex, daysInMonth));
    }

    // Test for negative days in a month (invalid case)
    @Test
    public void testNegativeDaysInMonth() {
        int monthIndex = 2;
        int daysInMonth = -10;
        assertThrows(IllegalArgumentException.class, () -> new Month(monthIndex, daysInMonth));
    }

    // Test for a valid month with a large index
    @Test
    public void testValidMonthLargeIndex() {
        int monthIndex = 1000;
        int daysInMonth = 28;
        Month month = new Month(monthIndex, daysInMonth);
        assertEquals(1000, month.getMonthIndex());
        assertEquals(28, month.getDaysInMonth());
    }

    // Test for a month with excessively large days
    @Test
    public void testExcessivelyLargeDaysInMonth() {
        int monthIndex = 7;
        int daysInMonth = 10_000;
        Month month = new Month(monthIndex, daysInMonth);
        assertEquals(10_000, month.getDaysInMonth());
    }

   
   

    // Test for the smallest valid month (1 day)
    @Test
    public void testSmallestValidMonth() {
        int monthIndex = 4;
        int daysInMonth = 1;
        Month month = new Month(monthIndex, daysInMonth);
        assertEquals(1, month.getDaysInMonth());
    }

     



    // Test for getters with normal values
    @Test
    public void testGettersNormalValues() {
        int monthIndex = 3;
        int daysInMonth = 30;
        Month month = new Month(monthIndex, daysInMonth);
        assertEquals(monthIndex, month.getMonthIndex());
        assertEquals(daysInMonth, month.getDaysInMonth());
    }

    // Test for getter methods with a typical month (February) 

    // Test for getters with invalid negative days
    @Test
    public void testGettersWithNegativeDays() {
        int monthIndex = 2;
        int daysInMonth = -5;
        assertThrows(IllegalArgumentException.class, () -> new Month(monthIndex, daysInMonth));
    }

    // Test for invalid negative month index
    @Test
    public void testNegativeMonthIndex() {
        int monthIndex = -1;
        int daysInMonth = 30;
        assertThrows(IllegalArgumentException.class, () -> new Month(monthIndex, daysInMonth));
    }

    // Test for getters with an extremely high month index
    @Test
    public void testHighMonthGetters() {
        int expectedMonthIndex = 100000000;
        int expectedDaysInMonth = 28;
        Month month = new Month(expectedMonthIndex, expectedDaysInMonth);
        assertEquals(expectedMonthIndex, month.getMonthIndex());
        assertEquals(expectedDaysInMonth, month.getDaysInMonth());
    }


    
    @Test
    public void testHighMonthDaysGetters() {
        int expectedMonthIndex = 0;
        int expectedDaysInMonth = 10000000;
        Month month = new Month(expectedMonthIndex, expectedDaysInMonth);
        assertEquals(expectedMonthIndex, month.getMonthIndex());
        assertEquals(expectedDaysInMonth, month.getDaysInMonth());
    }



}
