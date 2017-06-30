import java.util.Scanner;

public class Player
{
    private static final int[] SHIP_LENGTHS = {2, 3, 3, 4, 5};
    private Grid playerGrid;
    private Grid opponentGrid;
    private static final int NUM_SHIPS = 5;
    public  Scanner reader;
    
    public Player(Scanner x, Grid compGrid){
  
    	reader = x; 
        playerGrid = new Grid();
        opponentGrid = compGrid;
    }
    
    public void printMyShips() {
    	
        playerGrid.printShips();
    }

    public void printOpponentGuesses() {
        playerGrid.printStatus();
        
    }
    
    public void printMyGuesses() {
        opponentGrid.printStatus();
    }
    
    public int recordOpponentGuess(int row, int col) {
        if(playerGrid.hasShip(row, col) == true){
            playerGrid.markHit(row, col);
            return 1;
        }
        else{
            playerGrid.markMiss(row, col);
            return 0;
        }
    }
    
    public int recordMyGuess(int row, int col){
    	if(opponentGrid.hasShip(row, col) == true){
            opponentGrid.markHit(row, col);
            return 1;
        }
        else{
            opponentGrid.markMiss(row, col);
            return 0;
        }
    }
    
    public boolean chooseShipLocation(Ship s, int row, int col, int direction){
        s.setLocation(row, col);
        s.setDirection(direction);
        return playerGrid.addShip(s);
        
    }
    
    public void askForShips() {
        int shipRow = 0;
        int shipCol = 0;
        int shipDirection = 0;

        for (int i = 0; i < NUM_SHIPS; i++) {
            
            System.out.println("Your current grid of ships.");
            printMyShips();
            System.out.println();

            System.out.println("Now you need to place a ship of length " + Player.SHIP_LENGTHS[i] + ".");
            System.out.print("Which row? (1-10) ");
            shipRow = reader.nextInt()-1;
            System.out.println("Which column? (1-10) ");
            shipCol = reader.nextInt()-1;
            System.out.println("Which direction? (0 aka horizontal or 1 aka verticle) ");
            shipDirection = reader.nextInt();
            Ship s = new Ship(SHIP_LENGTHS[i]);
            boolean check = chooseShipLocation(s, shipRow, shipCol, shipDirection);
            if(check == false){
            	System.out.println("Invalid location. Pick new location: ");
            	i--;
            }
            
            
        }
       
    }
}
