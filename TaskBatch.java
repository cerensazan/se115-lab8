public class TaskBatch {
    private Task[] tasks;
    private int taskCount;

    public TaskBatch() {
        tasks = new Task[5]; // max batch size
        taskCount = 0;
    }

    public void addTask(Task t) {
        if (taskCount < 5) {
            tasks[taskCount] = t;
            taskCount++;
            System.out.println("Task " + t.getTaskName() + " added to batch.");
        } else {
            System.out.println("Cannot add more tasks. Batch full!");
        }
    }

    public int getTotalEnergyCost() {
        if (taskCount == 0) {
            System.out.println("No tasks in batch!");
            return 0;
        }
        int total = 0;
        for (int i = 0; i < taskCount; i++) {
            total += tasks[i].getEnergyCost();
        }
        return total;
    }

    public Task[] getTasks() {
        if (taskCount == 0) {
            System.out.println("No tasks in batch!");
            return new Task[0];
        }
        Task[] currentTasks = new Task[taskCount];
        for (int i = 0; i < taskCount; i++) {
            currentTasks[i] = tasks[i];
        }
        return currentTasks;
    }

    public void printBatchInfo() {
        if (taskCount == 0) {
            System.out.println("No tasks in batch!");
        } else {
            System.out.println("Tasks in batch:");
            for (int i = 0; i < taskCount; i++) {
                System.out.println("- " + tasks[i].getTaskName() + ", Energy cost: " + tasks[i].getEnergyCost());
            }
        }
    }
}
