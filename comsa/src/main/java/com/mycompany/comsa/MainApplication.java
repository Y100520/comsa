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
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
public class MainApplication extends JFrame {
    private List<User> users = new ArrayList<>(); 
    private EventPublisher publisher = new EventPublisher(); 
    private JTextArea textArea;   
    public MainApplication() {
        setupWindow(); 
        createComponents(); 
    }    
    private void setupWindow() {
        setTitle("Управление пользователями");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // окно по центру
    }   
    private void createComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout()); // гл. понель     
        JPanel buttonPanel = new JPanel();
        JButton createButton = new JButton("Создать пользователей");
        JButton showButton = new JButton("Показать PREMIUM"); // кнопки панели 
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);        
        buttonPanel.add(createButton);
        buttonPanel.add(showButton);        
        mainPanel.add(buttonPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);        
        add(mainPanel);        
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createUsers();
            }
        });       
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPremiumUsers();
            }
        });
    }   
    private void createUsers() {
        users.clear();
        textArea.setText("");
        publisher = new EventPublisher();       
        for (int i = 0; i < 5; i++) {
            User user = UserFactory.createUser();
            users.add(user);           
            System.out.println("Создан: " + user.getName() + " (" + user.getUserType() + ")");           
            if (user.getUserType() == UserType.PREMIUM) {
                user.setAction(() -> {
                    textArea.append(user.toString() + "\n");
                });                
                publisher.addSubscriber(user::doAction);
            }
        }       
        int premiumCount = 0;
        for (User user : users) {
            if (user.getUserType() == UserType.PREMIUM) {
                premiumCount++;
            }
        }       
        JOptionPane.showMessageDialog(this, 
            "Создано 5 пользователей!\n" +
            "Обычных: " + (5 - premiumCount) + "\n" +
            "PREMIUM: " + premiumCount);
    }   
    private void showPremiumUsers() {
        if (users.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Сначала создайте пользователей!");
            return;
        }
        textArea.setText("PREMIUM пользователи:\n");
        textArea.append("=====================\n");       
        publisher.notifyEveryone();        
        if (textArea.getText().equals("PREMIUM пользователи:\n=====================\n")) {
            textArea.append("PREMIUM пользователей не найдено\n");
        }
    }   
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainApplication app = new MainApplication();
                app.setVisible(true); // Делаем окно видимым
            }
        });
    }
}
