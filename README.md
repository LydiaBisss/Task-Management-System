# Task Management System

A Java-based Task Management System that allows users to register and log in, create and manage tasks, search for tasks, generate reports, and track task status and duration.

## Features

### User Registration

* Username validation
* Password complexity validation
* Registration success and error messages
* Login authentication

The system checks usernames and passwords before allowing a user to register or log in.

### Task Management

Users can:

* Add multiple tasks
* Enter task names
* Assign tasks to developers
* Set task duration
* Set task status
* Generate task IDs
* Display task information

Task IDs are generated using the task name, developer name, and task count.

### Task Status

Tasks can have one of three statuses:

* To Do
* Doing
* Done

The system also provides a report showing tasks that have been completed.

### Search and Reports

The application supports:

* Searching for a task by task name
* Finding tasks assigned to a specific developer
* Displaying all tasks
* Displaying completed tasks
* Finding the developer and duration of the longest task
* Calculating total task hours
* Deleting a task

These features are implemented using Java arrays and methods for managing task information.

## Technologies Used

* Java
* Java Swing
* Object-Oriented Programming
* Arrays
* Methods
* Classes and Objects
* String handling
* Regular Expressions
* `JOptionPane`

The application uses `JOptionPane` to interact with the user through dialog boxes.

## Application Flow

```text
User
  ↓
Register
  ↓
Login
  ↓
Task Management
  ↓
Add Tasks
  ↓
Assign Developer
  ↓
Set Duration & Status
  ↓
Generate Task ID
  ↓
Search / Report / Delete
```

## Task Information

Each task stores information such as:

* Task name
* Developer
* Duration
* Status
* Task ID
* Description

The application stores task information using arrays and `Task` objects.

## Example Task ID

Task IDs are generated using:

```text
Task Name Prefix : Developer Suffix : Task Number
```

For example:

```text
DE:ITH:1
```

The ID is generated automatically when a task is created.

## Project Structure

```text
Task-Management-System/
│
├── Task.java
└── README.md
```

## What I Learned

This project helped develop experience with:

* Java programming
* Object-oriented programming
* Classes and objects
* Encapsulation
* Arrays
* Loops and conditional statements
* Methods
* String manipulation
* Regular expressions
* User input validation
* Basic task management logic
* Building a Java desktop application

## Future Improvements

Possible improvements include:

* Replace arrays with an ArrayList or database
* Add a graphical user interface
* Add stronger input validation
* Add task editing functionality
* Improve task deletion
* Add persistent data storage
* Add administrator and user roles
* Add automated tests
* Improve error handling

## Author

Lydia Bizuhen

This project was created as a Java programming project and is included as part of my software development portfolio.
