import java.util.Random;

public class Computer {

	    private static final int[] SHIP_LENGTHS = {2, 3, 3, 4, 5};
	    //private Grid computerGrid;
	    public Grid computerGrid;
	    private static final int NUM_SHIPS = 5;
	    
	    public Computer(){
	       
	        computerGrid = new Grid(); 
	    }
	    
	    public int recordOpponentGuess(int row, int col) {
	        if(computerGrid.hasShip(row, col) == true){
	            computerGrid.markHit(row, col);
	            return 1;
	        }
	        else{
	            computerGrid.markMiss(row, col);
	            return 0;
	        }
	    }
	    
	    public boolean chooseShipLocation(Ship s, int row, int col, int direction){
	        s.setLocation(row, col);
	        s.setDirection(direction);
	        return computerGrid.addShip(s);
	        
	    }
	    
	    
	    public int[] getCompGuess(){
	    	
	    	int shipRow = 0;
	    	int shipCol = 0;
	    	Random random = new Random();
	    	
	    	shipCol = random.nextInt(10);            
	        shipRow = random.nextInt(10);
	        if(computerGrid.alreadyGuessed(shipRow, shipCol)){
	        	return getCompGuess();
	        }
	        return new int [] {shipRow, shipCol};
	        
	    }
	    
	    
	    
	    public void askForShips() {
	        int shipRow = 0;
	        int shipCol = 0;
	        int shipDirection = 0;
	        Random random = new Random();

	        for (int i = 0; i < NUM_SHIPS; i++) {
	            
	            
	            shipRow = random.nextInt(10);
	            shipCol = random.nextInt(10);
	            shipDirection = random.nextInt(2);
	            Ship s = new Ship(SHIP_LENGTHS[i]);
	            boolean check = chooseShipLocation(s, shipRow, shipCol, shipDirection);
	            if(check == false){
	            	i--;
	            } 
	        }
	    }
	}
