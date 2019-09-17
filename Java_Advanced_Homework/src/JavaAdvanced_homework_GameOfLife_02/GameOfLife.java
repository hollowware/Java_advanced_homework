package JavaAdvanced_homework_GameOfLife_02;

import java.util.ArrayList;
import java.util.Arrays;

public class GameOfLife {
	
	private static final String LIFE = "1";
	private static final String DEATH = ".";
	
	public static void main(String[] args) {
		
		String[][] grid = generateStartingPointGrid(10, 10); 
		int generation = 0;
		
		while(true) {
		System.out.println("Generation: " + (generation++));
		printGrid(grid); 
		System.out.println();
		
		String[][] superGrid = copyOfGrid(grid);    
		
		for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) { 
            	
                ArrayList<String> neighbours = new ArrayList<String>(); 
                
                // Find the neighbour cells of the current cell.
                // Modulus solve the edge problem. Out of bounds neighbour is the other side neighbour.
                neighbours.add(grid[Math.floorMod(i - 1, grid.length)][Math.floorMod(j - 1, grid[i].length)]);
                neighbours.add(grid[Math.floorMod(i - 1, grid.length)][j]);
                neighbours.add(grid[Math.floorMod(i - 1, grid.length)][Math.floorMod(j + 1, grid[i].length)]);
                neighbours.add(grid[i][Math.floorMod(j - 1, grid[i].length)]);
                neighbours.add(grid[i][Math.floorMod(j + 1, grid[i].length)]);
                neighbours.add(grid[Math.floorMod(i + 1, grid.length)][Math.floorMod(j - 1, grid[i].length)]);
                neighbours.add(grid[Math.floorMod(i + 1, grid.length)][j]);
                neighbours.add(grid[Math.floorMod(i + 1, grid.length)][Math.floorMod(j + 1, grid[i].length)]);
                
                int life_forms = 0;
                for (int k = 0; k < neighbours.size(); k++) { 
                    if (neighbours.get(k).compareTo(LIFE) == 0) 
                        life_forms += 1; 
                }
                
                if (grid[i][j].compareTo(DEATH) == 0) { 
                    if (life_forms == 3) { 
                        superGrid[i][j] = LIFE; 
                    }
                } else { 
                    if (life_forms < 2 || life_forms > 3) {
                        superGrid[i][j] = DEATH;
                    }
                }
            }
        }
		
		// Checking previous and next arrays, if equal - iteration stopped.
		if (Arrays.deepEquals(grid, superGrid)) {
			System.out.println("Second grid is the same as previous, iteration is finished");
			printGrid(superGrid);
         	break;
         } 
      
        grid = copyOfGrid(superGrid); 
        
		try {
            Thread.sleep(200);
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
        }
		}
        
	}
	
	/**
	 * Method that generates array with random LIFE points.
	 * @param height
	 * @param width
	 * @return
	 */
	private static String[][] generateStartingPointGrid(int height, int width) {
		String [][] array = new String [height][width];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (Math.random() < 0.25) {
                	array[i][j] = LIFE;
                }else {
                	array[i][j] = DEATH;
                }
            }
        }
        return array;
	}
	
	/**
	 * Prints existing grid. 
	 * @param matrix
	 */
	public static String[][] printGrid(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(" " + matrix[i][j] + " ");
            }

            System.out.println();
        }
        return matrix;
    }
	
	/**
	 * Copies grid.
	 * @param grid
	 * @return
	 */
	private static String[][] copyOfGrid(String[][] grid) {
		String[][] tempGrid = new String[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                tempGrid[i][j] = grid[i][j];
            }
        }
        return tempGrid;
    }
	
}	
