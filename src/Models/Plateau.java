package Models;

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
        topCoordinates = topCoordinates.newInstance(x, y);
    }

    public boolean hasWithinBounds(final Coordinates coordinates) {
        return bottomCoordinates.isOut(coordinates) && topCoordinates.isInside(coordinates);
    }

}

