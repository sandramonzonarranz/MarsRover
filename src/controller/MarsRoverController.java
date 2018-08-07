package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exceptions.MarsRoverNotValidParameterException;
import main.MarsRover;
import models.Coordinates;
import models.Direction;
import models.Plateau;

public class MarsRoverController extends HttpServlet {
	
	  private static final long serialVersionUID = 1L;
	  final String TAG_CLASS_NAME = this.getClass().getName();
	
	  /**
	   * Init of the class.
	   */
	  public void init() {
	    System.out.println(TAG_CLASS_NAME);
	  }
	  
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Integer plateauX = Integer.valueOf(request.getParameter("plateauX"));
		Integer plateauY = Integer.valueOf(request.getParameter("plateauY"));
        String direction = request.getParameter("direction").toUpperCase();
        Integer positionX = Integer.valueOf(request.getParameter("positionX"));
        Integer positionY = Integer.valueOf(request.getParameter("positionY"));
        String instructions = request.getParameter("instructions").toUpperCase();
        
        String exception = validateMarsRover(plateauX, plateauY, direction, positionX, positionY, instructions);
	
        response.setContentType("text/html");
        PrintWriter pw=response.getWriter();
        pw.write("<h3> Following mars data received: <h3>");
        pw.write("plateau X: " + plateauX + "<br>");
        pw.write("plateau Y: " + plateauY + "<br>");
        pw.write("direction: " + direction + "<br>");
        pw.write("position X : " + positionX + "<br>");
        pw.write("position Y: " + positionY + "<br>");
        pw.write("instructions: " + instructions + "<br>");
        
        if(exception.equals("")){
	    	MarsRover marsRover = new MarsRover(new Plateau(plateauX, plateauY),
					Direction.valueOf(direction),
					new Coordinates(positionX, positionY));;
			marsRover.run(instructions);
			pw.write("<h3> RESULT: " + marsRover.currentLocation() +" </h3>");
        }
        else {
        	pw.write("<h3> RESULT: WRONG PARAMETERS" +" </h3>");
        	try {
				throw new MarsRoverNotValidParameterException(exception);
			} catch (MarsRoverNotValidParameterException e) {
				e.printStackTrace();
			}
        }
        
        
      }

	private String validateMarsRover(Integer plateauX, Integer plateauY, String direction, Integer positionX,
									 Integer positionY, String instructions) {
		String exception = "";
		if (positionX < 0 || positionX > plateauX) {
			exception += " 0 <= POSITION X <= PLATEAU.";
		}
		if (positionY < 0 || positionY > plateauY) {
			exception += " 0 <= POSITION Y <= PLATEAU.";
		}
		if (plateauX < 0 ) {
			exception += " PLATEAU X >= 0.";
		}
		if (plateauY < 0 ) {
			exception += " PLATEAU Y >= 0.";
		}
		if (!direction.equals("N") && !direction.equals("E") && !direction.equals("S") && !direction.equals("W")) {
			exception += " DIRECTION VALE OF N-E-S-W.";
		}
		if (!instructions.matches("^[LMR]*")) {
			exception += " INSTRUCTIONS CHAIN OF L-R-M.";
		}
		return exception;
		
	}
}
