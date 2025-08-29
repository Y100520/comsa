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
class JsonDisplayStrategy implements DisplayStrategy {
    @Override
    public String format(User user) {
        return "{\"id\": \"" + user.getId() + "\", " +
               "\"name\": \"" + user.getName() + "\", " +
               "\"email\": \"" + user.getEmail() + "\", " +
               "\"userType\": \"" + user.getUserType() + "\"}";
    }
    
    @Override
    public String toString() {
        return "JSON формат";
    }
}
