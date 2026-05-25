/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginandregistration;

/**
 *
 * @author Sfiso
 */
    

public class message {
    String id, recipient, content, hash;

    // This is a constructor. It MUST NOT have a return type.
    public message(String i, String r, String c, String h) {
        this.id = i; 
        this.recipient = r; 
        this.content = c; 
        this.hash = h;
    }
    
    // If you add other methods here, they MUST have a return type.
    public String getId() {
        return this.id; // Correct: 'String' is the return type
    }
}