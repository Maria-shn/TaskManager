# Task Manager Application

Welcome to the Task Manager application! This application helps you manage tasks, assign teammates, and keep track of your project progress. Here's a quick guide to get you started.

## Table of Contents

1. [Introduction](#introduction)
2. [Getting Started](#getting-started)
3. [Features](#features)
4. [Security Configuration](#security-configuration)
5. [Task Model](#task-model)
6. [Task Controller](#task-controller)
7. [Task Repository](#task-repository)
8. [Run the Application](#run-the-application)

## Introduction

The Task Manager application is built using Spring Boot and MongoDB to provide a simple and efficient way to manage tasks within a team. It incorporates Spring Security with OAuth2 authentication to ensure secure access to the dashboard.

## Getting Started

To run the application, make sure you have MongoDB installed and running. Update the MongoDB connection details in the `application.properties` file if necessary. Then, build and run the application using the provided `TaskManagerApplication` class.

## Features

- **View All Tasks:** Access a list of all tasks within the system.
- **View My Tasks:** Retrieve tasks assigned to you or tasks you've created.
- **Save Task:** Create and save new tasks with details such as name, description, and assigned teammates.
- **Delete Task:** Remove tasks, ensuring that only the creator can delete their tasks.

## Security Configuration

The application uses Spring Security for securing endpoints. The `SecurityConfiguration` class defines security configurations, allowing public access to the root ("/") and requiring authentication for other endpoints. OAuth2 login and form login are both enabled.

## Task Model

The `Task` class represents a task entity with fields such as id, creator, name, description, and teammates.

## Task Controller

The `TaskController` class defines RESTful endpoints for managing tasks. You can retrieve all tasks, view tasks assigned to you, save new tasks, and delete tasks.

## Task Repository

The `TaskRepository` interface extends `MongoRepository` to provide CRUD operations for the `Task` entity. Methods such as `findByCreator`, `findByTeammate1`, `findByTeammate2`, and `findByTeammate3` are defined for convenient task retrieval.

## Run the Application

Execute the `main` method in the `TaskManagerApplication` class to start the application. Access the dashboard at `http://localhost:8080/dashboard` and begin managing your tasks.

Feel free to explore and customize the application according to your team's needs. Happy task managing!
