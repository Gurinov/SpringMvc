package gurinov;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class WorkWithDateTest {

    @Test
    public void isValidSeparatedSlash() {
        assertTrue(WorkWithDate.isValidDate("12/12/12"));
    }

    @Test
    public void isValidZeroAheadDay() {
        assertTrue(WorkWithDate.isValidDate("02/02/12"));
    }


    @Test
    public void isValidSeparatedDash() {
        assertTrue(WorkWithDate.isValidDate("12-12-2010"));
    }


    @Test
    public void isValidSingleDigitDay() {
        assertTrue(WorkWithDate.isValidDate("2-12-10"));
    }


    @Test
    public void isLeapYear() {
        assertTrue(WorkWithDate.isValidDate("29-2-2000"));
    }


    @Test
    public void isNotLeapYear() {
        assertFalse(WorkWithDate.isValidDate("29-2-99"));
    }


    @Test
    public void isNonexistentDate() {
        assertFalse(WorkWithDate.isValidDate("0-0-0"));
    }


    @Test
    public void isInvalidMonth() {
        assertFalse(WorkWithDate.isValidDate("10-13-2000"));
    }


    @Test
    public void isInvalidDay() {
        assertFalse(WorkWithDate.isValidDate("32-10-2000"));
    }


    @Test
    public void isInvalidYear() {
        assertFalse(WorkWithDate.isValidDate("10-10-9999"));
    }

    @Test
    public void calculateAge() {
        int different = 8;
        String date = LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + (LocalDate.now().getYear() - different);
        assertEquals(different + "", WorkWithDate.calculateAge(date));
        assertEquals("Error in date", WorkWithDate.calculateAge("32/32/32"));
    }

    @Test
    public void calculateDaysBeforeBirthday() {
        String date = LocalDate.now().getDayOfMonth() + "/" + LocalDate.now().getMonthValue() + "/" + LocalDate.now().getYear();
        assertEquals("Error in date", WorkWithDate.calculateDaysBeforeBirthday(date));
        assertEquals("Error in date", WorkWithDate.calculateDaysBeforeBirthday("32/32/32"));
    }
}