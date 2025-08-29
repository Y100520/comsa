/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.comsa;

/**
 *
 * @author user
 */
import java.util.UUID;

public class User {
    private UUID id; 
    private String name;
    private String email; 
    private UserType userType; 
    private Runnable action;  

    public User(UUID id, String name, String email, UserType userType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.userType = userType;
    }   
    
    public UUID getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public UserType getUserType() { return userType; }

    public void setAction(Runnable action) {
        this.action = action;
    }

    public void removeAction() {
        this.action = null;
    }
   
    public void doAction() {
        if (action != null) {
            action.run(); 
            removeAction(); 
        }
    }
}