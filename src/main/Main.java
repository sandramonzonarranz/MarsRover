package main;

import models.Coordinates;
import models.Direction;
import models.Plateau;

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

}
