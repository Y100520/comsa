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
class SimpleDisplayStrategy implements DisplayStrategy {
    @Override
    public String format(User user) {
        return user.getName() + " | " + user.getEmail();
    }
    
    @Override
    public String toString() {
        return "Простой формат";
    }
}
