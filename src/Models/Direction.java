package Models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
public enum Direction {


    N(0,1),
    E(1,0),
    S(0,-1),
    W(-1,0);
	
	@Getter @Setter
    private int x;
	
	@Getter @Setter
    private int y;
    
    public Direction turnRight(){
    	switch(this){
	    	case N:
	    		return E;
	    	case E:
	    		return S;
	    	case S:
	    		return W;
	    	case W:
	    		return N;
    	}
    	return null;
    };
    
    public Direction turnLeft(){
    	switch(this){
	    	case N:
	    		return W;
	    	case W:
	    		return S;
	    	case S:
	    		return E;
	    	case E:
	    		return N;
    	}
    	return null;
    };
    

}
