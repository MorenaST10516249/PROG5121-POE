/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.loginandregistration;

/**
 *
 * @author Sfiso
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
 import java.util.Scanner;


    


public class LoginAndRegistration {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first name: ");
        String firstName = input.nextLine();
        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

        String[] credentials = register(input);
        if (login(input, credentials)) {
            System.out.println("Welcome " + firstName + " " + lastName);
            processMessaging(input);
        }
        input.close();
    }

    public static String[] register(Scanner input) {
        String username, password, phone;
        while (true) {
            System.out.print("Enter username (underscore, max 5 chars): ");
            username = input.nextLine();
            System.out.print("Enter password (8+ chars, Cap, Num, Special): ");
            password = input.nextLine();
            System.out.print("Enter phone (+27, 12 chars): ");
            phone = input.nextLine();

            if (username.contains("_") && username.length() <= 5 &&
                password.matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).{8,}$") &&
                phone.startsWith("+27") && phone.length() == 12) {
                System.out.println("Registration successful.");
                return new String[]{username, password, phone};
            }
            System.out.println("Invalid format. Restarting registration...");
        }
    }

    public static boolean login(Scanner input, String[] creds) {
        while (true) {
            System.out.print("Enter username: ");
            String u = input.nextLine();
            System.out.print("Enter password: ");
            String p = input.nextLine();
            System.out.print("Enter phone: ");
            String ph = input.nextLine();

            if (u.equals(creds[0]) && p.equals(creds[1]) && ph.equals(creds[2])) return true;
            System.out.println("Login failed. Try again.");
        }
    }

    public static void processMessaging(Scanner input) {
        System.out.print("How many messages? ");
        int num = Integer.parseInt(input.nextLine());
        List<message> messages = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            System.out.print("Enter message (max 250): ");
            String content = input.nextLine();
            if (content.length() > 250) { i--; continue; }

            System.out.print("Enter recipient (include +): ");
            String recipient = input.nextLine();
            if (!recipient.contains("+")) { i--; continue; }

            String id = String.valueOf(new Random().nextInt(900000) + 100000);
            String hash = id.substring(0, 4) + content.length() + i;

            System.out.println("ID: " + id + " | Hash: " + hash);
            System.out.println("1) Send | 2) Discard | 3) Store");
            
            String opt = input.nextLine();
            if (opt.equals("1")) System.out.println("Sent.");
            else if (opt.equals("2")) System.out.println("Press 0 to delete.");
            
            messages.add(new message(id, recipient, content, hash));
        }
    }
}
