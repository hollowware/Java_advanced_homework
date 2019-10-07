package JavaAdvanced_homework_CarRace_01;

public class Car {
	
	private String name;
	private int speed;
    private int maxSpeed;
    private int roadDriven;
    
    public Car(String name, int maxSpeed) {
		super();
		this.name = name;
		this.maxSpeed = maxSpeed;
		this.speed = 0;
		this.roadDriven = 0;
	}
    
    /**
     * Class Methods.
     * @param accelerationSpeed
     */
	public void carAccelerate (int accelerationSpeed) {
		if (accelerationSpeed == 0) {
			System.out.println("Car is broken, can't continue the race!");
		} else if (accelerationSpeed > maxSpeed) {
			System.out.println("Car engine overheated and exploaded!");
		} else {
        speed += accelerationSpeed;
		}
		
    }
	
    public void carBrake (int brakeSpeed) {
        speed -= brakeSpeed;
    }
    
    public void carDrive () {
       roadDriven += speed;
    }
    
    /**
     * Getters.
     * @return
     */
    public int getRoadDriven() {
		return roadDriven;
	}

	public String getName() {
		return name;
	}

	public int getSpeed() {
		return speed;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	/**
	 * To String method.
	 */
	@Override
    public String toString() {
        return "Car [name=" + name + ", maxSpeed=" + maxSpeed + ", speed=" + speed + ", roadDriven=" + roadDriven + "]";
    }
    
}
