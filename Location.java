public class Location
{
public static final int UNGUESSED = 0;
public static final int HIT = 1;
public static final int MISSED = 2;
private boolean ship;
private int shipStat;

    //Implement the Location class here
    // Location constructor. 
    public Location(){
        this.ship = false;
        this.shipStat = UNGUESSED;
        
    }

// Was this Location a hit?
    public boolean checkHit(){
        if(shipStat == HIT){
            return true;
        }
        
        return false;
    }

// Was this location a miss?
    public boolean checkMiss(){
        if(shipStat == MISSED){
            return true;
        }
        
        return false;
    }

// Was this location unguessed?
    public boolean isUnguessed(){
        if(shipStat == UNGUESSED){
            return true;
        }
        
        return false;
        
    }

// Mark this location a hit.
    public void markHit(){
        shipStat = HIT;
    }

// Mark this location a miss.
    public void markMiss(){
        shipStat = MISSED;
    }

// Return whether or not this location has a ship.
    public boolean hasShip(){
        return ship;
    }

// Set the value of whether this location has a ship.
    public void setShip(boolean val){
        ship = val;
        
    }

// Set the status of this Location.
    public void setStatus(int status){
        shipStat = status;
    }

// Get the status of this Location.
    public int getStatus(){
        return shipStat;
        
    }
}
