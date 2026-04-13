/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.loginandregistration;

/**
 *
 * @author Sfiso
 */
 import java.util.Scanner;
public class LoginAndRegistration {

    public static void main(String[] args) {
    
      Scanner input = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String FirstName = input.nextLine();
        System.out.print("Enter last name: ");
        String LastName = input.nextLine();
        // Registration
        boolean registered = false;
        int regSuccessCount = 0;
        String username = "", password = "", cellPhoneNumber = "";
        while (regSuccessCount < 3) {
            System.out.print("Enter username (must contain underscore and be up to 5 characters): ");
            username = input.nextLine();
            if (username.contains("_") && username.length() <= 5) {
                System.out.println("Username successfully captured.");
                regSuccessCount++;
            } else {
                System.out.println("Username is not correctly formatted. Try again.");
                regSuccessCount = 0; // reset count if any field is wrong
                continue;
            }
            System.out.print("Enter password (must have at least 8 characters, a capital letter, a number, and a special character): ");
            password = input.nextLine();
            if (password.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).{8,}$")) {
                System.out.println("Password successfully captured.");
                regSuccessCount++;
            } else {
                System.out.println("Password is not correctly formatted. Try again.");
                regSuccessCount = 0; // reset count if any field is wrong
                continue;
            }
            System.out.print("Enter cell phone number (must start with +27 and be 12 characters): ");
            cellPhoneNumber = input.nextLine();
            if (cellPhoneNumber.startsWith("+27") && cellPhoneNumber.length() == 12) {
                System.out.println("Cell phone number successfully captured.");
                regSuccessCount++;
            } else {
                System.out.println("Cell phone number is not correctly formatted. Try again.");
                regSuccessCount = 0; // reset count if any field is wrong
                continue;
            }
        }
        if (regSuccessCount == 3) {
            registered = true;
            System.out.println("Registration successful. Please login.");
        }
        // Login
        if (registered) {
            boolean loginSuccess = false;
            while (!loginSuccess) {
                int loginSuccessCount = 0;
                System.out.print("Enter username to login (must contain underscore and be up to 5 characters): ");
                String loginUsername = input.nextLine();
                if (loginUsername.equals(username) && loginUsername.length() <= 5) {
                    System.out.println("Username successfully captured.");
                    loginSuccessCount++;
                } else {
                    System.out.println("Username is not correctly formatted or doesn't match.");
                }
                System.out.print("Enter password to login (must have at least 8 characters, a capital letter, a number, and a special character): ");
                String loginPassword = input.nextLine();
                if (loginPassword.equals(password)) {
                    System.out.println("Password successfully captured.");
                    loginSuccessCount++;
                } else {
                    System.out.println("Password is not correctly formatted or doesn't match.");
                }
                System.out.print("Enter cell phone number to login (must start with +27 and be 12 characters): ");
                String loginCellPhoneNumber = input.nextLine();
                if (loginCellPhoneNumber.equals(cellPhoneNumber)) {
                    System.out.println("Cell phone number successfully captured.");
                    loginSuccessCount++;
                } else {
                    System.out.println("Cell phone number is not correctly formatted or doesn't match.");
                }
                if (loginSuccessCount == 3) {
                    loginSuccess = true;
                    System.out.println("Welcome " + FirstName + " " + LastName);
                } else {
                    System.out.println("Login failed. Try again.");
                }
            }
        }
  // reference 
  //Regrex

//https://stackoverflow.com/questions/42983829/what-do-i-do-if-i-want-to-check-for-a-special-character-in-java-using-char#:~:text=3%20Answers&text=The%20code%20in%20the%20if,(pointed%20out%20by%20@Wietlol)

//Retrieving input
//https://youtube.com/shorts/LX4w63sCQg0?si=fJdMVVuswSjW2uyX

//https://youtube.com/shorts/ieUDnfLTeb8?si=bSnlRV_u5D_Ocsys

//While 
//https://youtube.com/shorts/LfzL4BRAR2k?si=Tu_-qLGxJ3G0kkWn
//Another while
//https://youtu.be/ZjHJrmYknrk?si=8FmIVMLk6HxtJ--S

        input.close();
    }
}
    

