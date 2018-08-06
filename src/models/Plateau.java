package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Plateau {

	@Getter @Setter
    private Coordinates topCoordinates = new Coordinates(0, 0);
	
	@Getter @Setter
    private Coordinates bottomCoordinates = new Coordinates(0, 0);

    public Plateau(final int x, final int y) {
        topCoordinates = topCoordinates.moveCoordinates(x, y);
    }

    public boolean isIn(final Coordinates coordinates) {
        return bottomCoordinates.isOut(coordinates) && topCoordinates.isIn(coordinates);
    }

}

