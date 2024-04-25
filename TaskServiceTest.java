import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/*
Author: Ally Miller
Date: 4/13/2024
Description: TaskTest that tests adding a single task, adding multiple tests, adding tasks with duplicate ID,
adding and getting tasks back from service, updating tasks, and deleting tasks.
 */

class TaskServiceTest {
    private TaskService taskService;
    @BeforeEach
    void setUp() {
        taskService = new TaskService();
    }

    @Test
    void testAddingSingleTask() {
        assertTrue(taskService.addTask(new Task("1", "Task 1", "Description 1")));
    }

    @Test
    void testAddingMultipleTasks() {
        assertTrue(taskService.addTask(new Task("1", "Task 1", "Description 1")));
        assertTrue(taskService.addTask(new Task("2", "Task 2", "Description 2")));
    }
    @Test
    void testErrorWhenAddingTaskWithDuplicateID() {
        assertTrue(taskService.addTask(new Task("1", "Task 1", "Description 1")));
        assertFalse(taskService.addTask(new Task("1", "Task 1 Duplicate", "Description 1 Duplicate")));
    }
    @Test
    void testAddingAndGetTaskBackFromService() {
        Task task = new Task("1", "Task 1", "Description 1");
        taskService.addTask(task);
        assertEquals(task, taskService.getTask("1"));
    }
    @Test
    void testUpdatingTask() {
        Task task = new Task("1", "Task 1", "Description 1");
        taskService.addTask(task);
        taskService.updateTaskName("1", "Updated Task 1");
        taskService.updateTaskDescription("1", "Updated Description 1");
        Task updatedTask = taskService.getTask("1");
        assertEquals("Updated Task 1", updatedTask.getName());
        assertEquals("Updated Description 1", updatedTask.getDescription());


    }
    @Test
    void testDeletingTask() {
        taskService.addTask(new Task("1", "Task 1", "Description 1"));
        taskService.deleteTask("1");
        assertNull(taskService.getTask("1"));
    }
}