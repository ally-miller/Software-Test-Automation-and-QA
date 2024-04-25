import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/*
Author: Ally Miller
Date:4/13/2024
Description: TaskTest that tests creating a task object, if task id is too long, if task name is too long,
and if description is too long.
 */
class TaskTest {

    @Test
    void testCreatingTaskObject() {
        // Test creating a valid task object
        Task task = new Task("123", "TaskName", "TaskDescription");
        assertEquals("123", task.getID());
        assertEquals("TaskName",task.getName());
        assertEquals("TaskDescription", task.getDescription());
    }

    @Test
    void testErrorIfTaskIdIsTooLong() {
        // Test if an error occurs if the task ID is too long
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "TaskName", "TaskDescription");
        });

    }

    @Test
    void testErrorIfTaskNameIsTooLong() {
        // Test if an error occurs if the task name is too long
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("123", "TaskNameIsWayTooLongForThisExampleToHandleProperly", "TaskDescription");
        });

    }
    @Test
    void testErrorIfDescriptionIsTooLong() {
        // Test if an error occurs if the description is too long
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("123", "TaskName", "This description is way too long to be considered valid for this simple Task example.");
        });

    }
    @Test
    public void testTaskConstructorWithNullId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Task Name", "Task Description");
        });
    }

    @Test
    public void testTaskConstructorWithNullName() {
        assertThrows(IllegalArgumentException.class, () ->
                new Task("123", null, "Task Description"));
    }

    @Test
    public void testTaskConstructorWithNullDescription() {
        assertThrows(IllegalArgumentException.class, () ->
                new Task("123", "Task Name", null));
    }
    @Test
    public void testSetNameWithNull() {
        Task task = new Task("123", "Initial Name", "Description");
        assertThrows(IllegalArgumentException.class, () -> task.setName(null));
    }

    @Test
    public void testSetDescriptionWithNull() {
        Task task = new Task("123", "Name", "Initial Description");
        assertThrows(IllegalArgumentException.class, () -> task.setDescription(null));
    }
}


