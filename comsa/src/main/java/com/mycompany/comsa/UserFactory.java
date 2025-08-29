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
import java.util.Random;
public class UserFactory {
    private static Random random = new Random();    
    // Списки cлуч. дан.
    private static String[] names = {"Иван Иванов", "Мария Петрова", "Алексей Сидоров", "Екатерина Кузнецова", "Дмитрий Смирнов"};
    private static String[] domains = {"gmail.com", "mail.ru", "yandex.ru"};    
    // созд. польз.
    public static User createUser() {
        UUID id = UUID.randomUUID();
        String name = names[random.nextInt(names.length)];
        String email = name.toLowerCase().replace(" ", ".") + "@" + domains[random.nextInt(domains.length)];       
        // случ выбор. польз.
        UserType userType;
        if (random.nextBoolean()) {
            userType = UserType.PREMIUM;
        } else {
            userType = UserType.REGULAR;
        }     
        return new User(id, name, email, userType);
    }
}
