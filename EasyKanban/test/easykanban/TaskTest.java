/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package easykanban;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author fereh
 */
public class TaskTest {
    
    private Task[] tasks;
    
    @BeforeEach
   public void setUp() {
    tasks = new Task[4];
    tasks[0] = new Task("Task 1", "Description 1", 5, "Mike Smith");
    tasks[1] = new Task("Task 2", "Description 2", 8, "Edward Harrington");
    tasks[2] = new Task("Task 3", "Description 3", 7, "Samantha Paulson");
    tasks[3] = new Task("Task 4", "Description 4", 11, "Glenda Oberholzer");
   }

    @org.junit.jupiter.api.Test
    public void testDeveloperArrayPopulated() {
        String[] expectedDevelopers = {"Mike Smith", "Edward Harrington", "Samantha Paulson", "Glenda Oberholzer"};
        String[] actualDevelopers = new String[tasks.length];

        for (int i = 0; i < tasks.length; i++) {
            actualDevelopers[i] = tasks[i].getDeveloper();
        }

        Assertions.assertArrayEquals(expectedDevelopers, actualDevelopers);
    }

    @org.junit.jupiter.api.Test
    public void testDisplayDeveloperAndDurationForLongestDurationTask() {
        String expectedOutput = "Developer: Glenda Oberholzer, Duration: 11";
        String actualOutput = Task.displayDeveloperAndDurationForLongestDurationTask(tasks);

        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @org.junit.jupiter.api.Test
    public void testSearchTaskByTaskName() {
        String taskName = "Create Login";
        String expectedOutput = "Task Name: Create Login, Developer: Mike Smith, Status: To Do";
        String actualOutput = Task.searchTaskByTaskName(tasks, taskName);

        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @org.junit.jupiter.api.Test
    public void testSearchTasksByDeveloper() {
        String developer = "Samantha Paulson";
        String expectedOutput = "Tasks assigned to Samantha Paulson:\n" +
                "Task Name: Task 3, Status: Doing\n";
        String actualOutput = Task.searchTasksByDeveloper(tasks, developer);

        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @org.junit.jupiter.api.Test
    public void testDeleteTaskFromArray() {
        String taskName = "Create Reports";
        String expectedOutput = "Entry 'Create Reports' successfully deleted";
        String actualOutput = Task.deleteTaskFromArray(tasks, taskName);

        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @org.junit.jupiter.api.Test
   public void testshowReport() {
        String expectedOutput = "Task Report:\n" +
                "Task Name: Task 1, Developer: Mike Smith, Duration: 5, Status: To Do\n" +
                "Task Name: Task 2, Developer: Edward Harrington, Duration: 8, Status: Doing\n" +
                "Task Name: Task 3, Developer: Samantha Paulson, Duration: 7, Status: Doing\n" +
                "Task Name: Task 4, Developer: Glenda Oberholzer, Duration: 11, Status: Done\n";
        String actualOutput = Task.showReport(tasks);
        
        Assertions.assertEquals(expectedOutput, actualOutput);
    }
}

    
   

    

   
