public class Ship
{
    public static final int UNSET = -1;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    int row;
    int col;
    int length;
    int direction;
    
    // Constructor. Create a ship and set the length.
    public Ship(int length){
        this.length = length;
        this.row = UNSET;
        this.col = UNSET;
        this.direction = UNSET;
        
    }

// Has the location been initialized
    public boolean isLocationSet(){
        if(row != UNSET && col != UNSET){
            return true;
        }
        else{
            return false;
        }
    }

// Has the direction been initialized
    public boolean isDirectionSet(){
        if(direction != UNSET){
            return true;
        }
        else{
            return false;
        }
    }

// Set the location of the ship 
    public void setLocation(int row, int col){
        this.row = row;
        this.col = col;
    }

// Set the direction of the ship
    public void setDirection(int direction){
        this.direction = direction;
    }

// Getter for the row value
    public int getRow(){
        return row;
    }

// Getter for the column value
    public int getCol(){
        return col;
    }

// Getter for the length of the ship
    public int getLength(){
        return length;
    }

// Getter for the direction
    public int getDirection(){
        return direction;
    }

// Helper method to get a string value from the direction
    private String directionToString(){
        String theDirect = "";
        if(direction == HORIZONTAL){
            theDirect = "horizontal";
        }
        else if(direction == VERTICAL){
            theDirect = "vertical";
        }
        else if(direction == UNSET){
            theDirect = "unset direction";
        }
        return theDirect;
        
    }

// Helper method to get a (row, col) string value from the location
    private String locationToString(){
        String theLocat = "(" + Integer.toString(row) + ", " + Integer.toString(col) + ")";
        if(isLocationSet() == false){
            theLocat = "(unset location)";
        }
        return theLocat;
    }

// toString value for this Ship
    public String toString(){
        return directionToString() + " ship of length " + Integer.toString(length) + " at " + locationToString(); 
    }

}
