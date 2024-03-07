import java.util.Random;

public abstract class Animal extends Wild{
    public int getMove() {
    	int move = (int) (Math.random()*2);
    	if(move==0) {
    		move = -1;
    	}
    return move;
    }

	abstract char getType() ;
	
	
}
