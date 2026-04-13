/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginandregistration;

/**
 *
 * @author Sfiso
 */
public class Login {
    // Method to check username format
    public boolean checkUsername(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Method to check password complexity
    public boolean checkPasswordComplexity(String password) {
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).{8,}$";
        return password.matches(regex);
    }

    // Method to check cell phone number format
    public boolean checkCellPhoneNumber(String cellPhoneNumber) {
        return cellPhoneNumber.startsWith("+27") && cellPhoneNumber.length() == 12;
    }

    // Method for user registration
    public String registerUser(String username, String password, String cellPhoneNumber) {
        if (!checkUsername(username)) {
            return "Username is incorrectly formatted.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password does not meet complexity requirements.";
        }
        if (!checkCellPhoneNumber(cellPhoneNumber)) {
            return "Cell phone number is not correctly formatted.";
        }
        return "The two above conditions have been met, and the user has been registered successfully.";
    }

    // Method for user login
    public boolean loginUser(String username, String password, String cellPhoneNumber, String storedUsername, String storedPassword, String storedCellPhoneNumber) {
        return username.equals(storedUsername) && password.equals(storedPassword) && cellPhoneNumber.equals(storedCellPhoneNumber);
    }

    // Method to return login status
    public String returnLoginStatus(boolean loginSuccess) {
        if (loginSuccess) {
            return "Login successful.";
        } else {
            return "Login failed.";
        }
    }
    
}
