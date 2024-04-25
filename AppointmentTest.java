import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;

/*
    Author: Ally Miller
    Date: 4/07/2024
    Description: Tests for Appointment.java

 */

public class AppointmentTest {
    @Test
    public void testCreatingAppointmentObject() {
        // Test creating a valid task object
        Appointment appointment = new Appointment("123", "2024-04-30", "AppointmentDescription");
        assertEquals("123", appointment.getID());
        assertEquals("2024-04-30", appointment.getDate());
        assertEquals("AppointmentDescription", appointment.getDescription());
    }

    @Test
    public void testErrorIfAppointmentIdIsTooLong() {
        // Test if an error occurs if the task ID is too long
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", "2024-04-30", "AppointmentDescription");
        });

    }

    @Test
    public void testErrorIfAppointmentDateIsTooLong() {
        // Test if an error occurs if the task name is too long
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123", "2024-04-07-5", "AppointmentDescription");
        });

    }

    @Test
    public void testErrorIfDescriptionIsTooLong() {
        // Test if an error occurs if the description is too long
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123", "2024-04-08", "This description is way too long to be considered valid for this simple Task example.");
        });

    }

    @Test
    public void testErrorDateisinthePast() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("123", "2024-04-01", "AppointmentDescription");
        });
    }

    @Test
    public void testNullID() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, "2024-04-30", "Test Description");
        });
    }

    @Test
    public void testNullDate() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", null, "Test Description");
        });
    }
    @Test
    public void testNullDescription() {
        assertThrows(IllegalArgumentException.class, () -> {
                new Appointment("1234567890", "2024-04-07", null);
    });
    }
}




