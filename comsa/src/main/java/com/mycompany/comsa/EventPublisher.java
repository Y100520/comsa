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
import java.util.ArrayList;
import java.util.List;
public class EventPublisher {
    private List<Runnable> subscribers = new ArrayList<>(); // спис.    
    public void addSubscriber(Runnable subscriber) {
        subscribers.add(subscriber);
    }    
    public void removeSubscriber(Runnable subscriber) {
        subscribers.remove(subscriber);
    }    
    public void notifyEveryone() {
        // созд. копии
        List<Runnable> currentSubscribers = new ArrayList<>(subscribers);
        subscribers.clear();      
        // действие кажд. подпис.
        for (Runnable subscriber : currentSubscribers) {
            subscriber.run();
        }
    }    
    // кол-во
    public int getSubscriberCount() {
        return subscribers.size();
    }
}
