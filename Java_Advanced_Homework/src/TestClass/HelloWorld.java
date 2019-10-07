package TestClass;

import java.util.Arrays;
import java.util.Scanner;

public class HelloWorld {
	public static void main (String[] args) {
		
		int [][] array = new int [10][10];
		for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
            	array[i][j] = 0;
            }
		}
		System.out.println(Arrays.deepToString(array));
		array[1][3] = 666;
		System.out.println(Arrays.deepToString(array));
//		int a = 3;
//	    int b = -2;
//	    System.out.println(Math.floorMod(a,b));
		
//		int [][] array = new int [5][10];
//		array[4][5] = 999;
//		array[0][9] = 666;
//		System.out.println(Arrays.deepToString(array));
		
//		System.out.println(Math.floorMod(0, 5)); 
//		System.out.println(Math.floorMod(1, 5)); 
//        System.out.println(Math.floorMod(2, 5));
//		System.out.println(Math.floorMod(3, 5)); 
//        System.out.println(Math.floorMod(4, 5)); 
//        System.out.println(Math.floorMod(5, 5)); 
//        System.out.println(Math.floorMod(6, 5)); 
//        System.out.println(Math.floorMod(7, 5)); 
//        System.out.println(Math.floorMod(8, 5));
//        System.out.println(Math.floorMod(9, 5)); 
//        System.out.println(Math.floorMod(10, 5));
		
//		for (int i = 0; i < 5; i++) {
//			System.out.println("Yo man. " + i);
//		}
//		
//		System.out.println("*****************");
//		
//		int i = 0;
//		while (i < 5) {
//			System.out.println("Yo man. " + i);
//			i++;
//		}
		
//		String input = "";
//		Scanner scan = new Scanner(System.in);
//		while (true) {
//			System.out.print("Quit the program: ");
//			input = scan.next().toLowerCase();
//			if (input.equals("pass")) 
//				continue;
//			
//			if (input.equals("quit")) 
//				break;
//				System.out.println(input);
//			
//		}
		
//		String [] fruits = {"Orange", "Banana", "Apple", "Pineapple"};
//		int [] numbers = {1, 2, 3, 4, 5, 8, 5, 13};
//		
//		for (int num : numbers) {
//			System.out.println(num);
//		}
		
//		for (int i = fruits.length - 1; i >= 0; i--) {
//			System.out.print(fruits[i] + ", ");
//		}
//		for (String fruit : fruits) {
//			System.out.print(fruit + " ");
//		}
		
//		do {
//			Scanner scan = new Scanner(System.in);
//			System.out.println("Quit the program: ");
//			input = scan.next();
//		} while (!input.equals("quit"));
	}
}
