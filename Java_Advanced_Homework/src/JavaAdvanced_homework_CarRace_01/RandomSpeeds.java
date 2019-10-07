package JavaAdvanced_homework_CarRace_01;

import java.util.Random;

public class RandomSpeeds {
	
	public Random random = new Random();
	
	public int randomMaxSpeed () {
		int low = 50;
		int high = 90;
		int ranMaxSpeed = random.nextInt(high-low) + low;
		return ranMaxSpeed;
	}
	
	public int randomAccelerateSpeed () {
		int low = 0;
		int high = 100;
		int ranAccelerateSpeed = random.nextInt(high-low) + low;
		return ranAccelerateSpeed;
	}
	
	public int randomBreakSpeed () {
		int low = 0;
		int high = 30;
		int ranBreakSpeed = random.nextInt(high-low) + low;
		return ranBreakSpeed;
	}
}
