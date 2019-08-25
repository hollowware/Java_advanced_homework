package JavaAdvanced_homework_CarRace_01;

import java.util.Arrays;

public class CarRace {
	public static void main(String[] args) {
		
		RandomSpeeds randomSpeeds = new RandomSpeeds();
		
		Car [] raceCars = {
				new Car("Audi", randomSpeeds.randomMaxSpeed()),
				new Car("BMW", randomSpeeds.randomMaxSpeed()),
				new Car("Volkswagen", randomSpeeds.randomMaxSpeed())
		};
		
		System.out.println(Arrays.toString(raceCars));
		
		System.out.println();
		
		for (int i = 0; i < raceCars.length; i++) {
			System.out.println("This race " + raceCars[i].getName() + " have max speed of - " + raceCars[i].getMaxSpeed() + " km/h!");
		}
		System.out.println();
		
		for (int i = 0; i < raceCars.length; i++) { 
			while (raceCars[i].getRoadDriven() < 2000) {
			raceCars[i].carAccelerate(randomSpeeds.randomAccelerateSpeed());
			raceCars[i].carDrive();
			System.out.println(raceCars[i].getName() + " accelerate - " + raceCars[i].getSpeed() + " km.");
			System.out.println("Distance covered - " + raceCars[i].getRoadDriven() + " km.");
			raceCars[i].carBrake(randomSpeeds.randomBreakSpeed());
			raceCars[i].carDrive();
			System.out.println(raceCars[i].getName() + " brake: " + raceCars[i].getSpeed() + " km.");
			System.out.println("Distance covered - " + raceCars[i].getRoadDriven() + " km.");
			System.out.println();
			if (raceCars[i].getRoadDriven() >=  2000) {
				System.out.println(Arrays.toString(raceCars));
			}
			} 
		}
		/*
		 * What is left:
		 * 1. Acceleration must stay always random and do not SUM every time. 
		 * 2. If the random car first reaches 2000km barrier loop stops executing and prints out Car array from first place to the last.
		 * 3. Write sorting method. 
		 */
		

	}
}	
