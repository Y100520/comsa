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
class DetailedDisplayStrategy implements DisplayStrategy {
    @Override
    public String format(User user) {
        return "[ID: " + user.getId() + "] " + user.getName() + 
               " (" + user.getEmail() + ") | Status: " + user.getUserType();
    }
    
    @Override
    public String toString() {
        return "Детальный формат";
    }
}