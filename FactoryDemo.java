import java.util.Scanner;

public class FactoryDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Robot r1 = new Robot("Alpha", 80, "Active");
        Robot r2 = new Robot("Beta", 50, "Active");

        System.out.println("Initial Robot Info:");
        r1.displayRobotInfo();
        r2.displayRobotInfo();

        System.out.print("Enter amount of battery to consume for Alpha: ");
        int consumeAmount = sc.nextInt();

        r1.consumeBattery(consumeAmount);

        System.out.println("Updated Robot Info:");
        r1.displayRobotInfo();
        r2.displayRobotInfo();

        System.out.print("Enter amount of battery to charge Beta: ");
        int chargeAmount = sc.nextInt();
        r2.chargeBattery(chargeAmount);

        System.out.println("Final Robot Info:");
        r1.displayRobotInfo();
        r2.displayRobotInfo();

        Task t1 = new Task("Welding", 30);
        Task t2 = new Task("Painting", 60);
        Task t3 = new Task("Assembly", 50);

        System.out.println("Tasks:");
        t1.describeTask();
        t2.describeTask();
        t3.describeTask();
        System.out.println();

        System.out.println("Robot performing tasks:");
        r1.performTask(t1); // enough battery
        r1.performTask(t2); // maybe not enough
        r2.performTask(t3);

        System.out.println("Robot Info After Tasks:");
        r1.displayRobotInfo();
        r2.displayRobotInfo();

        TaskBatch batch = new TaskBatch();
        batch.addTask(t1);
        batch.addTask(t2);
        batch.addTask(t3);

        System.out.println("Batch Info:");
        batch.printBatchInfo();

        System.out.println("Total energy cost of batch: " + batch.getTotalEnergyCost());



    }
}
