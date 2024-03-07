import java.util.Random;

//TO DO: import all libraries that you use here

public class Wild {
	static final int MAXT = 5,//maximum number of simulation time steps
                MAXX=4, //maximum number of cells on the x-axis
                MAXY=4; //maximum number of cells on the y-axis
		Animal[][] wilderness;
		Random random;
//TO DO: write your code here; create as many classes, interfaces, etc. that you see fit	

		    public Wild() {
		        this.wilderness = new Animal[MAXX][MAXY];
		    }
	
		    	 public void Grid(int rows, int cols) {
		    	        wilderness = new Animal[rows][cols];
		    	        random = new Random();
		    	        populate();
		    	    }

		    	    private void populate() {
		    	    	 
		    	        for (int i = 0; i < wilderness.length; i++) {
		    	            for (int j = 0; j < wilderness[i].length; j++) {
		    	            	int randomNumber = random.nextInt(3);
		    	            	 if (randomNumber == 0) {
		 		    	            addAnimal(new Deer(),i,j);
		 		    	        } else if (randomNumber == 1) {
		 		    	        	 addAnimal(new Wolf(),i,j);
		 		    	        }
		 		    	        else {
		 		    	        	addAnimal(null,i,j);
		 		    	        }
		    	            }
		    	        }
		    	    }

		    	    public void addAnimal(Animal x,int row, int col) {
		    	        wilderness[row][col] = x;
		    	        // If randomNumber == 2, the cell will be left empty
		    	    }
		    
		    public void move() {
		    	for(int i = 0; i<wilderness.length;i++) {
		    		for(int j = 0; j<wilderness[i].length;j++) {
		    			if(wilderness[i][j]==null) 
		    				continue;
		    			int move = wilderness[i][j].getMove();
		    			int xy = (int)(Math.random()*2);
		    			int y=0;
		    			int x=0;
		    			
		    			if(xy==0) {
		    				if(j+move>MAXY-1)
		    					y = -1;
		    				else if(j+move<0)
		    					y =1;
		    				else 
		    					y =move;
		    		}
		    		else {
		    			if(i+move>MAXX-1)
		    				x =-1;
		    			else if(i+move<0)
		    				x=1;
		    			else 
		    				x= move;
		    		}
		    		if((wilderness[i][j] instanceof Deer && wilderness[i+x][j+y] instanceof Wolf) || (wilderness[i][j] instanceof Wolf && wilderness[i+x][j+y] instanceof Deer)) {
		    			wilderness[i][j]= null;
		    			wilderness[i+x][j+y] = new Wolf();
		    		}
		    		else if(wilderness[i][j] instanceof Deer && wilderness[i+x][j+y] == null) {
		    			wilderness[i][j] = null;
		    			wilderness[i+x][j+y] = new Deer();
		    		}else if(wilderness[i][j] instanceof Wolf && wilderness[i+x][j+y]==null) {
		    			wilderness[i][j]=null;
		    			wilderness[i+x][j+y] = new Wolf();
		    		}
		    			
		    				
		    		}
		    	}
		    }
		    
		    public String toString() {
		    	for(int i = 0; i<wilderness.length;i++) {
		    		for(int j = 0; j<wilderness[i].length;j++) {
		    			if(wilderness[i][j]==null) {
		    				System.out.print("-  ");
		    			}
		    			else {
		    				System.out.print(wilderness[i][j].getType()+"  ");
		    			}
		    			
		    		}
		    		System.out.println();
		    	}
		    	return "";
		    }
		   
	public static void main(String[] args) {
		        Wild simulation = new Wild();
		        simulation.Grid(MAXX,MAXY);
		        
		        for(int i = 0; i<MAXT;i++) {
		        	simulation.move();
		        	System.out.println("Stage "+(i+1));
		        	System.out.println(simulation.toString());
		        }
	}

	
}
