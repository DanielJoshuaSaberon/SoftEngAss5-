package SingletonPattern;

import java.util.*;
import java.text.*;

public class Queue {
    private static Queue instance;
    private int currentQueueNumber = 1;
    private final List<User> queueList = new ArrayList<>();
    private final List<Integer> accommodatedQueueList = new ArrayList<>();
    DecimalFormat df = new DecimalFormat("000");

    private Queue() {
    }

    public static Queue getInstance() {
        if (instance == null) {
            instance = new Queue();
        }
        return instance;
    }

    public int getCurrentQueueNumber() {
        return currentQueueNumber;
    }

    public void addToQueue(User user) {
        if (accommodatedQueueList.isEmpty()) {
            queueList.add(user);
            System.out.println(user.getUserName() + " received queue number: " + df.format(user.getQueueNumber()));
            currentQueueNumber++;
        } else {
            int reusedNumber = accommodatedQueueList.removeLast();
            user = new User(user.getUserName(), reusedNumber);
            queueList.add(user);
            System.out.println(user.getUserName() + " received queue number: " + df.format(reusedNumber));
        }
    }

    public User accommodateFirstUser() {
        if (!queueList.isEmpty()) {
            User accommodatedUser = queueList.removeFirst();
            accommodatedQueueList.add(accommodatedUser.getQueueNumber());
            return accommodatedUser;
        } else {
            System.out.println("No users in the queue to accommodate.");
            return null;
        }
    }

    public void displayCurrentQueue() {
        if (queueList.isEmpty()) {
            System.out.println("No users in the queue.");
        } else {
            System.out.println("-----------------------------");
            System.out.println("\t\tCurrent Queue");
            System.out.println();
            for (User user : queueList) {
                System.out.println(user);
            }
        }
    }
}