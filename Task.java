/*
    Author: Ally Miller
    Date: 4/13/2024
    Description: Task class creates Task objects using ID, name, description

 */
public class Task
{
    //variables
    //final so it is not updatable
    private final String id;
    //updatable
    private String name;
    private String description;


    //constructor
    public Task(String id, String name, String description)
    {
        //verify not null and not greater than 10 characters and confirms it is digit only
        if(id == null || id.length() > 10 || !id.matches("\\d+"))
        {
            throw new IllegalArgumentException("Invalid ID");
        }

        //set variables
        this.id = id;
        setName(name);
        setDescription(description);

    }

    //getters and setters
    //setters verify not null and valid length
    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.length() > 20)
        {
            throw new IllegalArgumentException("Invalid Name");
        }
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description == null || description.length() > 50)
        {
            throw new IllegalArgumentException("Invalid Description");
        }
        this.description = description;
    }

}
