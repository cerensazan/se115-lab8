public class Robot {
    private String modelName;
    private int batteryLevel;
    private String status;

    public Robot(String modelName, int batteryLevel, String status){
        this.modelName = modelName;
        this.batteryLevel = batteryLevel;
        this.status = status;
    }

    public void setModelName(String modelName){ this.modelName = modelName; }
    public void setStatus(String status){ this.status = status; }
    public void setBatteryLevel(int batteryLevel){ this.batteryLevel = batteryLevel; }
    public String getModelName(){ return modelName; }
    public String getStatus(){ return status; }
    public int getBatteryLevel(){ return batteryLevel; }

    public void displayRobotInfo(){
        System.out.println("Robot Model: " + modelName);
        System.out.println("Battery Level: " + batteryLevel);
        System.out.println("Status: " + status);
    }

    public boolean isBatteryEnough(int requiredAmount) {
        return batteryLevel >= requiredAmount;
    }

    public void consumeBattery(int amount) {
        if (isBatteryEnough(amount)) {
            batteryLevel -= amount;
            System.out.println(modelName + " consumed " + amount + " battery.");
        } else {
            System.out.println(modelName + " does not have enough battery!");
        }
    }

    public void chargeBattery(int amount) {
        batteryLevel += amount;
        if (batteryLevel >= 100) {
            batteryLevel = 100;
            status = "Active";
        } else {
            status = "Charging";
        }
        System.out.println(modelName + " charged " + amount + ". Current battery: " + batteryLevel + ", Status: " + status);
    }

    public void performTask(Task t) {
        System.out.println(modelName + " attempting task: " + t.getTaskName());

        if (status.equals("Charging")) {
            System.out.println("Cannot perform task. Robot is charging.");
        } else if (isBatteryEnough(t.getEnergyCost())) {
            consumeBattery(t.getEnergyCost());
            System.out.println(modelName + " completed the task: " + t.getTaskName());
        } else {
            System.out.println("Not enough battery to perform task: " + t.getTaskName());
        }
    }
}
