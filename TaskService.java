import java.util.HashMap;
/*
    Author: Ally Miller
    Date:4/13/2024
    Description: Task Service class stores contacts in a map<ID, Task> and allows for adding, deleting,
    updating the task.
 */
import java.util.Map;

public class TaskService
{
    //Map<Key, Value>
    //Map<String, Contact>
    private final Map<String, Task> tasks = new HashMap<>();

    //adds contact to contacts map
    public boolean addTask(Task contact)
    {
        if(tasks != null)
        {
            // add contact to contacts Map<Id, Contact>
            // if already in map, put returns the contact, which is != null so returns false
            // if not in map, put adds to Map and returns null, which null == null so returns true
            return tasks.put(contact.getID(), contact) == null;
        }
        // if contact is null, return false
        return false;
    }

    //deletes contact from contacts map
    public void deleteTask(String taskID)
    {
        tasks.remove(taskID);
    }

    //updates contact in contacts map
    public void updateTaskName(String taskID, String name)
    {
        Task task= tasks.get(taskID);
        if(task != null)
        {
            task.setName(name);
        }
    }
    public void updateTaskDescription(String taskID, String description)
    {
        Task task= tasks.get(taskID);
        if(task != null)
        {
            task.setDescription(description);
        }
    }
    public Task getTask(String taskID) {
        return tasks.get(taskID);
    }
}


