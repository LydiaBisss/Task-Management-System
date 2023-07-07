/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package easykanban;

import javax.swing.JOptionPane;

public class Task {
    
  private String username;
    private String password ;
    private String name;
    private String developer;
    private int duration;
    private String status;
    
    public boolean checkUserName() {
        //Dislaying the length of the required username and the need of a underscore
        
        //w3schools
        //https://www.w3schools.com/java/java_ref_string.asp
        //29-04-2023
        
        return (username.length() <= 5) || username.matches("^[a-zA-Z0-9_]{1,20}$");
    }

    public boolean checkPasswordComplexity() {
        //Dislaying the different vairables used to capture a password
        return password.matches ("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$");
    }

    public String registerUser() {
        if (!checkUserName()) {
            return "Username is incorrectly formatted.";
        } else if (!checkPasswordComplexity()) {
            return "Password does not meet the complexity requirements.";
        } else {
            // When regirstered successfully this message will display
            return "User registered successfully!!";
        }
    }

    public boolean loginUser(String Username, String Password) {
        
         //w3schools
        //https://www.w3schools.com/java/java_ref_string.asp
       //29-04-2023
        
        // Verifying if the entered username and password detail matches 
        return Username.equals(username) && Password.equals(password);
    }

    public String returnLoginStatus(boolean LoginSuccessful) {
        if (LoginSuccessful) {
            return "Login successful.";
        } else {
            return "Login failed.";
        }
    }

   
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    
    
    }
    
    private static String[] taskNames = new String[100];
    private static String[] developers = new String[100];
    private static String[] taskIDs = new String[100];
    private static int[] taskDurations = new int[100];
    private static String[] taskStatuses = new String[100];
    private static Task[] tasks = new Task[100];
    private String description;
    private String NAME;
    private String SURNAME;
    private String number;
    private static int taskCount = 0;

    public Task(String name, String description, int duration, String NAME) {
        this.name = name;
        this.description = description;
        this.NAME = NAME;
        this.SURNAME = SURNAME;
        this.duration = duration;
        this.number = number;
        this.status = status;
        this.developer = developer;
        
        taskNames[taskCount] = name;
        developers[taskCount] = developer;
        taskIDs[taskCount] = createTaskID();
        taskDurations[taskCount] = duration;
        taskStatuses[taskCount] = status;

        taskCount++;

   
    }

   public String createTaskID() {
    String namePrefix = name.substring(0, Math.min(name.length(), 2)).toUpperCase();
        String developerSuffix = developer.substring(Math.max(developer.length() - 3, 0)).toUpperCase();
        return namePrefix + ":" + developerSuffix + ":" + taskCount;
}

public String getStatus() {
    return status;
}

public String getId() {
        return taskIDs[taskCount - 1];
    }
public String[] getTaskIDs(){
    return taskIDs;
}

public String getName(){
    return name;
}

public String getDescription(){
    return description;
}

public void setDescription(String description){
    this.description = description;
}

public int getDuration(){
    return duration;
}


public String getDeveloper() {
        return developer;
    }

public String getNumber(){
    return number;
}

public void setNumber(String number){
    this.number = number;
}

public String getstatus(){
    return status;
}


public static void addTask() {       
    // Get the number of tasks to add
    int numberOfTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks to add:"));
    

    for (int i = 0; i < numberOfTasks; i++) {
      String name = JOptionPane.showInputDialog("Enter the task name:");
            String developer = JOptionPane.showInputDialog("Enter the name of the developer:");
            int duration = Integer.parseInt(JOptionPane.showInputDialog("Enter the duration (in hours) for the task:"));

            String status = JOptionPane.showInputDialog("Select the status:\n1. To Do\n2. Doing\n3. Done");

        String choice;
            switch (status) {
                case "1":
                    choice = "To Do";
                    break;
                case "2":
                    choice = "Doing";
                    break;
                case "3":
                    choice = "Done";
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option");
                    return;
            }

            Task task = new Task(name, developer, duration, choice);
            tasks[taskCount] = task;
        taskCount++;

        JOptionPane.showMessageDialog(null, "Task added successfully!");
        JOptionPane.showMessageDialog(null, "Task added:\n" + task.printTaskDetails());
        
             taskIDs[i] = task.getId();
            taskDurations[i] = task.getDuration();
            taskCount++;
    }
    
    JOptionPane.showMessageDialog(null, "Total hours: " + returnTotalHours(tasks));

        displayArray("Developer", developers, taskCount);
        displayArray("Task Names", taskNames, taskCount);
        displayArray("Task ID", taskIDs, taskCount);
        displayArray("Task Duration", taskDurations, taskCount);
        displayArray("Task Status", taskStatuses, taskCount);
}

public boolean checkTaskDescription(String description1) {
    // Check if the task description is within the specified limit
    return description.length() <= 50;
}
public static void showReport() {
        StringBuilder report = new StringBuilder("Task Report:\n");

        for (int i = 0; i < taskCount; i++) {
            Task task = tasks[i];
            report.append("Task Name: ").append(task.getName())
                    .append("\nDeveloper: ").append(task.getDeveloper())
                    .append("\nDuration: ").append(task.getDuration())
                    .append("\nStatus: ").append(task.getStatus())
                    .append("\n\n");
        }

        JOptionPane.showMessageDialog(null, report.toString());
    }
public static void displayTasksWithStatusDone() {
        StringBuilder report = new StringBuilder("Tasks with Status 'Done':\n");

        for (int i = 0; i < taskCount; i++) {
            if (tasks[i].status.equalsIgnoreCase("Done")) {
                report.append("Name: ").append(tasks[i].name)
                        .append("\nDeveloper: ").append(tasks[i].developer)
                        .append("\nDuration: ").append(tasks[i].duration)
                        .append("\n\n");
            }
        }

        JOptionPane.showMessageDialog(null, report.toString());
    }

    public static String displayDeveloperAndDurationForLongestDurationTask(Task[] tasks) {
        int longestDuration = 0;
        String developer = "";
        for (Task task : tasks) {
            if (task.getDuration() > longestDuration) {
                longestDuration = task.getDuration();
                developer = task.getDeveloper();
            }
        }
        return "Developer: " + developer + ", Duration: " + longestDuration;
    }

    public static String searchTaskByTaskName(Task[] tasks, String taskName) {
        for (Task task : tasks) {
            if (task.getName().equals(taskName)) {
                return "Task Name: " + task.getName() + ", Developer: " + task.getDeveloper() + ", Status: " + task.getStatus();
            }
        }
        return "Task not found.";
    }

    public static String searchTasksByDeveloper(Task[] tasks, String developer) {
        StringBuilder result = new StringBuilder("Tasks assigned to " + developer + ":\n");
        boolean found = false;
        for (Task task : tasks) {
            if (task.getDeveloper().equals(developer)) {
                result.append("Task Name: ").append(task.getName()).append(", Status: ").append(task.getStatus()).append("\n");
                found = true;
            }
        }
        if (!found) {
            result.append("No tasks found for ").append(developer).append(".");
        }
        return result.toString();
    }

    public static String deleteTaskFromArray(Task[] tasks, String taskName) {
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i].getName().equals(taskName)) {
                tasks[i] = null;
                return "Entry '" + taskName + "' successfully deleted.";
            }
        }
        return "Task not found.";
    }
   private static void displayArray(String arrayName, String[] array, int count) {
    StringBuilder builder = new StringBuilder(arrayName + ":\n");
    for (int i = 0; i < count; i++) {
        builder.append(array[i]).append("\n");
    }
    JOptionPane.showMessageDialog(null, builder.toString());
}

private static void displayArray(String arrayName, int[] array, int count) {
    StringBuilder builder = new StringBuilder(arrayName + ":\n");
    for (int i = 0; i < count; i++) {
        builder.append(array[i]).append("\n");
    }
    JOptionPane.showMessageDialog(null, builder.toString());
}
public static int returnTotalHours(Task[] tasks) {
    int totalHours = 0;
    if (tasks.length > 2) {
        for (Task task : tasks) {
            totalHours += task.duration;
        }
    } else {
        for (int i = 0; i < tasks.length; i++) {
            totalHours += tasks[i].duration;
        }
    }
    return totalHours;
}

public String printTaskDetails() {
    return "Name: " + name + "\nDeveloper: " + developer + "\nDuration: " + duration + "\nChoice: " + status;
}
}
