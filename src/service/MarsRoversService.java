package service;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import main.MarsRover;
import models.Coordinates;
import models.Direction;
import models.Plateau;

@Path("/mars")
public class MarsRoversService {
	
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String exploreMarsRovers(@FormParam("plateauX") String plateauX,
                                    @FormParam("plateauY") String plateauY,
                                    @FormParam("positionX") String positionX,
                                    @FormParam("positionY") String positionY,
                                    @FormParam("direction") String direction,
                                    @FormParam("instructions") String instructions) {
    	MarsRover marsRover = new MarsRover(new Plateau(Integer.valueOf(plateauX),Integer.valueOf(plateauY)),
    										Direction.valueOf(direction),
    										new Coordinates(Integer.valueOf(positionX),Integer.valueOf(positionY)));;
		marsRover.run(instructions);
		System.out.println("HALA SERVICE");
		return marsRover.currentLocation() ;
    }

}
