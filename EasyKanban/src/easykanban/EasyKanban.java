/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package easykanban;

import javax.swing.JOptionPane;

/**
 *
 * @author fereh
 */
public class EasyKanban {

    
    public static void main(String[] args) {
          
        String Username = JOptionPane.showInputDialog("Please enter a username that is no more than 5 characters long with an underscore");
            
        if (Username.length() <= 5 || Username.matches("^[a-zA-Z0-9_]{1,20}$")) {
            JOptionPane.showMessageDialog(null, "Username successfully captured");
        } else {
            JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length");
            return;
        }
        //Dislaying the different vairables used to capture a password
        String Password = JOptionPane.showInputDialog("Enter a password that has 8 characters long (capital letter\n "
                + " Contains a number, "
                + "Contains a special character): ");
        
//mkyong
//from https://mkyong.com/regular-expressions/how-to-validate-password-with-regular-expression/#:~:text=Password%20must%20contain%20at%20least%20one%20special%20character%20like%20!,a%20maximum%20of%2020%20characters.
//22-04-2023

        if (Password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$")) {
            
            //Ch&&sec@ke99!
            JOptionPane.showMessageDialog(null, "Password successfully captured");
           
        } else {
            JOptionPane.showMessageDialog(null, "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
            
            return;
    
    }
        // initialize isAuthenticated variable to true
        boolean isAuthenticated = true;
        String name = JOptionPane.showInputDialog("Please enter your name: ");
        String lastname = JOptionPane.showInputDialog("Please enter your last name: ");
        
        //Switch statement is used to check if the entered username and password are correct
        
//W3schools
//from https://www.w3schools.com/java/java_switch.asp
//24-04-2023
        
switch (Username) {
    case "username1":
        if (Password.equals("password1")) {
            isAuthenticated = true;
            //if isAuthenticated is true username and password are correct
        }
        break;
    case "username2":
        if (Password.equals("password2")) {
            isAuthenticated = true;
        }
        
        break;
    default:
        //if isAuthenticated is false username and password are correct
        if (isAuthenticated) {
    JOptionPane.showMessageDialog(null, "Welcome " +name + " " +lastname+" it is great to see you again.");
} else {
    JOptionPane.showMessageDialog(null, "Username or password incorrect, please try again”");
        return;
         
        }
    

      // Display welcome message
        JOptionPane.showMessageDialog(null, "Welcome to the EasyKanban App!");

        int choice = 0;
        while (choice != 3) {
            // Display menu and get user's choice
            String input = JOptionPane.showInputDialog("Menu:\n1. Add Task\n2. Show Report\n3. Quit\nEnter your choice:");

            // Validate user's choice
            while (!input.matches("[1-3]")) {
                JOptionPane.showMessageDialog(null, "Please enter a valid choice (1-3).");
                input = JOptionPane.showInputDialog("Menu:\n1. Add Task\n2. Show Report\n3. Quit\nEnter your choice:");
            }

            // Convert user's choice to integer
            choice = Integer.parseInt(input);

            // Perform action based on user's choice
            switch (choice) {
                case 1:
                    // Add Task
                    Task.addTask();
                    break;

                case 2:
                    // Show Report
                    Task.showReport();
                    break;

                case 3:
                    // Quit
                    JOptionPane.showMessageDialog(null, "Thank you for using the EasyKanban App!");
                    break;

                default:
                    // Invalid choice
                    JOptionPane.showMessageDialog(null, "Please enter a valid choice (1-3).");
                    break;
            }
        }
    }
}
}