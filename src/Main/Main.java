package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Models.Coordinates;
import Models.Direction;
import Models.Plateau;

public class Main {

	private static Plateau plateau;
	
	public static void main(String[] args) {
		readPlateau();
		readMarsRover();		
	}

	private static void readPlateau(){
		plateau = new Plateau(5,5);
	}
	
	private static void readMarsRover(){
		Coordinates startingPosition = new Coordinates(1,2);
		MarsRover mr = new MarsRover(plateau, Direction.N, startingPosition);;
		mr.run("LMLMLMLMM");
		System.out.println(mr.currentLocation());
		
		startingPosition = new Coordinates(3,3);
		mr = new MarsRover(plateau, Direction.E, startingPosition);
		mr.run("MMRMMRMRRM");
		System.out.println(mr.currentLocation());
	}

	private static void readInput() {
		 BufferedReader br = null;
		 try {
	        br = new BufferedReader(new InputStreamReader(System.in));
	        while (true) {
	            System.out.print("Enter input : ");
                String input = br.readLine();
                if ("q".equals(input)) {
                    System.exit(0);
                }
	        }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	

}
