import java.util.Random;

public class Wolf extends Animal{
	static int count;
	static char type;
	static int xaxis;
	static int yaxis;
	
	public Wolf() {
		this.type = 'W';
		count++;
	}
	 
	
	public static int getXaxis() {
		return xaxis;
	}


	public static void setXaxis(int xaxis) {
		Wolf.xaxis = xaxis;
	}


	public static int getYaxis() {
		return yaxis;
	}


	public static void setYaxis(int yaxis) {
		Wolf.yaxis = yaxis;
	}
	
	public char getType() {
        return type; // Type for Deer
    }
}
