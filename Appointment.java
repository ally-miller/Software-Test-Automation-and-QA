/*
    Author: Ally Miller
    Date: 4/07/2024
    Description: Appointment class creates Appointment objects using ID, date, description

 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Appointment {
    //variables
    //final so it is not updatable
    private final String id;
    //updatable
    private String date;
    private String description;


    //constructor
    public Appointment(String id, String date, String description) {
        //verify not null and not greater than 10 characters and confirms it is digit only
        if (id == null || id.length() > 10 || !id.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid ID");
        }

        //set variables
        this.id = id;
        setDate(date);
        setDescription(description);

    }

    //getters and setters
    //setters verify not null and valid length
    public String getID() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        if (date == null || date.length() > 20) {
            throw new IllegalArgumentException("Invalid Name");
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parsedDate = dateFormat.parse(date);
            if (parsedDate.before(new Date())) {
                throw new IllegalArgumentException("Date cannot be in the past");
            }
            this.date = date;
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid Date Format");
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid Description");
        }
        this.description = description;
    }
}

