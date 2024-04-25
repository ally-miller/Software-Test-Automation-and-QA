import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*
    Author: Ally Miller
    Date: 4/07/2024
    Description: Tests for AppointmentServices.java

 */
class AppointmentServiceTest {
    private AppointmentService appointmentService;
    @BeforeEach
    void setUp() {
        appointmentService = new AppointmentService();
    }

    @Test
    void testAddingSingleTask() {
        assertTrue(appointmentService.addAppointment(new Appointment("1", "2024-04-30", "Description 1")));
    }

    @Test
    void testAddingMultipleTasks() {
        assertTrue(appointmentService.addAppointment(new Appointment("1", "2024-04-30", "Description 1")));
        assertTrue(appointmentService.addAppointment(new Appointment("2", "2024-04-29", "Description 2")));
    }
    @Test
    void testErrorWhenAddingTaskWithDuplicateID() {
        assertTrue(appointmentService.addAppointment(new Appointment("1", "2024-04-30", "Description 1")));
        assertFalse(appointmentService.addAppointment(new Appointment("1", "2024-04-30", "Description 1 Duplicate")));
    }
    @Test
    void testAddingAndGetTaskBackFromService() {
        Appointment appointment = new Appointment("1", "2024-04-30", "Description 1");
        appointmentService.addAppointment(appointment);
        assertEquals(appointment, appointmentService.getAppointment("1"));
    }
    @Test
    void testDeletingTask() {
        appointmentService.addAppointment(new Appointment("1", "2024-04-30", "Description 1"));
        appointmentService.deleteAppointment("1");
        assertNull(AppointmentService.appointmentID("1"));
    }

}