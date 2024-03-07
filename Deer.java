
public class Deer extends Animal{
	static int count;
	static char type;
	static int xaxis;
	static int yaxis;
	
	public Deer() {
		this.type = 'D';
		count++;
	}
	 
	
	public static int getXaxis() {
		return xaxis;
	}


	public static void setXaxis(int xaxis) {
		Deer.xaxis = xaxis;
	}


	public static int getYaxis() {
		return yaxis;
	}


	public static void setYaxis(int yaxis) {
		Deer.yaxis = yaxis;
	}
	
	public char getType() {
        return type; // Type for Deer
    }
}
