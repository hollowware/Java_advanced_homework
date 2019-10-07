package JavaAdvanced_homework_Arrays_03;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		
		int [] myArray = new int [10];
		for (int i = 0; i < myArray.length; i++) {
			myArray[i] = (int) (Math.random() * 100);
		}
		
		int [] tempArray = new int [myArray.length];
		int repeat = 0;
		
		System.out.println(Arrays.toString(myArray));
		System.out.println("******************************");
		
		while (repeat < myArray.length) {
			for (int i = 0; i < myArray.length; i++) {
				if (i == 0) {
					tempArray[i] = myArray[myArray.length - 1];
				} else {
					tempArray[i] = myArray[i - 1];
				}
			}
			for (int i = 0; i < tempArray.length; i++) {
				myArray[i] = tempArray[i];
			}
			repeat++;
			System.out.println(Arrays.toString(tempArray)); 
		}
		
	}
}
