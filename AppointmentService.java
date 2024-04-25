import java.util.HashMap;
/*
    Author: Ally Miller
    Date: 4/07/2024
    Description: Appointment Service class stores contacts in a map<ID, Appointment> and allows for adding, deleting,
    updating the Appointment.
 */
import java.util.Map;


public class AppointmentService
{
    //Map<Key, Value>
    //Map<String, Contact>
    private final Map<String, Appointment> appointments = new HashMap<>();

    public static Object appointmentID(String number) {
        return null;
    }

    //adds contact to contacts map
    public boolean addAppointment(Appointment contact)
    {
        if(appointments != null)
        {
            // add contact to contacts Map<Id, Contact>
            // if already in map, put returns the contact, which is != null so returns false
            // if not in map, put adds to Map and returns null, which null == null so returns true
            return appointments.put(contact.getID(), contact) == null;
        }
        // if contact is null, return false
        return false;
    }

    //deletes appointment from appointment map
    public void deleteAppointment(String appointmentID)
    {
        appointments.remove(appointmentID);
    }

    //updates appointment in appointment map
    public void updateAppointmentDate(String appointmentID, String date)
    {
        Appointment appointment= appointments.get(appointmentID);
        if(appointment != null)
        {
            appointment.setDate(date);
        }
    }
    public void updateAppointmentDescription(String appointmentID, String description)
    {
        Appointment appointment= appointments.get(appointmentID);
        if(appointment != null)
        {
            appointment.setDescription(description);
        }
    }
    public Appointment getAppointment(String appointmentID) {
        return appointments.get(appointmentID);
    }
}


