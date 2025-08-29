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
interface DisplayStrategy {
    String format(User user);
    String toString(); // для отображения в комбобоксе
}
