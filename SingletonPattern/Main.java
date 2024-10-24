package SingletonPattern;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue queue = Queue.getInstance();

        while (true) {
            System.out.println("--- Centralized Queuing System ---");
            System.out.println("1. Add User to Queue");
            System.out.println("2. Accommodate First User");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt(); scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter last name: ");
                    String name = scanner.nextLine();
                    User user = new User(name, queue.getCurrentQueueNumber());
                    queue.addToQueue(user);
                    break;
                case 2:
                    User accommodatedUser = queue.accommodateFirstUser();
                    if (accommodatedUser != null) {
                        System.out.println("Accommodating: " + accommodatedUser);
                    }
                    break;
                case 3:
                    System.out.println("Exiting the system. Thank you!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
            queue.displayCurrentQueue();
            System.out.println("-----------------------------");
            System.out.println();
        }
    }
}