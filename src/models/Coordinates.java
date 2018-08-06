package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Coordinates {

	@Getter @Setter
    private int x;
	
	@Getter @Setter
    private int y;

    public Coordinates moveCoordinates(final int moveX, final int moveY) {
        return new Coordinates(this.x + moveX, this.y + moveY);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(x);
        res.append(" ");
        res.append(y);
        return res.toString();
    }

    public boolean isIn(final Coordinates coordinates) {
        return xIsInside(coordinates.x) && yIsInside(coordinates.y);
    }

    public boolean isOut(final Coordinates coordinates) {
        return xIsOut(coordinates.x) && yIsOut(coordinates.y);
    }

    private boolean xIsInside(final int x) {
        return x <= this.x;
    }

    private boolean yIsInside(final int y) {
        return y <= this.y;
    }
    
    private boolean xIsOut(final int x) {
        return x >= this.x;
    }

    private boolean yIsOut(final int x) {
        return y >= this.y;
    }

}
