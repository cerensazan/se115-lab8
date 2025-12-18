public class Task {
    private String taskName;
    private int energyCost;

    public Task(String name, int cost) {
        taskName = name;
        energyCost = cost;
    }
    public String getTaskName() {return taskName;}
    public int getEnergyCost() {return energyCost;}

    public void describeTask() {
        System.out.println("Task: " + taskName + ", Energy cost: " + energyCost);
    }

}
