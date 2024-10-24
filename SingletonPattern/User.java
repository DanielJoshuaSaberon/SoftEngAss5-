package SingletonPattern;

import java.text.*;

public class User {
    private String name;
    private int queueNumber;
    DecimalFormat df = new DecimalFormat("000");

    public User(String name, int queueNumber) {
        this.name = name;
        this.queueNumber = queueNumber;
    }

    public String getUserName() {
        return name;
    }

    public int getQueueNumber() {
        return queueNumber;
    }

    public String toString() {
        return "Queue Number: " + df.format(queueNumber)+ ", Name: " + name;
    }
}