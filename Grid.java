public class Grid
{
private Location[][] grid = new Location[NUM_ROWS][NUM_COLS];;

// Constants for number of rows and columns.
public static final int NUM_ROWS = 10;
public static final int NUM_COLS = 10;


    // Write your Grid class here
    public Grid(){
        for(int row = 0; row < NUM_ROWS; row++){
            for(int col = 0; col < NUM_COLS; col++) {
                grid[row][col] = new Location();
            }
        }
        
        
    }

// Mark a hit in this location by calling the markHit method
// on the Location object.  
    public void markHit(int row, int col){
        grid[row][col].markHit(); 
    
    }

// Mark a miss on this location.    
    public void markMiss(int row, int col){
        grid[row][col].markMiss(); 
    }

// Set the status of this location object.
    public void setStatus(int row, int col, int status){
        grid[row][col].setStatus(status);
    }

// Get the status of this location in the grid  
    public int getStatus(int row, int col){
        return grid[row][col].getStatus();
    }

// Return whether or not this Location has already been guessed.
    public boolean alreadyGuessed(int row, int col){
        return !grid[row][col].isUnguessed();
    }    

// Set whether or not there is a ship at this location to the val   
    public void setShip(int row, int col, boolean val){
        grid[row][col].setShip(val);
    }

// Return whether or not there is a ship here   
    public boolean hasShip(int row, int col){
        return grid[row][col].hasShip();
    }


// Get the Location object at this row and column position
    public Location get(int row, int col){
        return grid[row][col];
    }

// Return the number of rows in the Grid
    public int numRows(){
        return NUM_ROWS;
    }

// Return the number of columns in the grid
    public int numCols(){
        return NUM_COLS;
    }
    /**
 * This method can be called on your own grid. To add a ship
 * we will go to the ships location and mark a true value
 * in every location that the ship takes up.
 */
    public boolean addShip(Ship s){
    	int length = s.getLength();
        if(s.getDirection() == 0){
        if(length + s.getCol() > NUM_COLS){
        	return false;
        }
        	for(int i = 0; i < s.getLength(); i++){
            	if(grid[s.getRow()][s.getCol() + i].hasShip()){
            		return false;
            		}
            	}	
            for(int i = 0; i < s.getLength(); i++){
            grid[s.getRow()][s.getCol() + i].setShip(true);
            }
        }
        else if(s.getDirection() == 1){
        	if(length + s.getRow() > NUM_ROWS){
            	return false;
            }
        	for(int x = 0; x < s.getLength(); x++){
        		if(grid[s.getRow() + x][s.getCol()].hasShip()){
        			return false;
        		}
        	}
            for(int x = 0; x < s.getLength(); x++){
            grid[s.getRow() + x][s.getCol()].setShip(true);
            }
        }
        return true;
    }

    public void printStatus() {
        for (int c = 1; c <= NUM_COLS; c++) {
            if (c == NUM_COLS) {
                System.out.print(c);
            } 
            else if(c == 1){
                System.out.print(" " + c + " ");
            }
            else{
            	System.out.print(c + " ");
            }
            
        }
        System.out.print("\n");
        
        for (int i = 0; i < grid.length; i++) {
            int t = ('A' + i);
            char cur = (char) t;
            System.out.print(cur + " ");
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j].checkHit()) {
                    System.out.print("X ");
                } else if (grid[i][j].checkMiss()) {
                    System.out.print("O ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.print("\n");
        }
    }

    public void printShips(){
        for (int c = 1; c <= NUM_COLS; c++) {
            if (c == NUM_COLS) {
                System.out.print(c);
            }
            else if(c == 1){
            	System.out.print("  " + c + " ");
            }
            else {
                System.out.print(c + " ");
            }
        }
        
        System.out.print("\n");
        
        for (int i = 0; i < grid.length; i++) {
            int t = ('A' + i);
            char cur = (char) t;
            System.out.print(cur + " ");
            for (int j = 0; j < grid[0].length; j++) {
               if (grid[i][j].hasShip()) {
                   System.out.print("X ");
               } else {
                   System.out.print("- ");
               }
            }
            System.out.print("\n");
        }
    }
}
