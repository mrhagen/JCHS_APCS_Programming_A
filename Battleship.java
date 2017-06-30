import java.io.IOException;
import java.util.Scanner;

public class Battleship {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.out.println("===============================");
		System.out.println("Welcome to Battleship.");
		System.out.println("===============================");
		System.out.println("First you need to choose the location of your ships" + "\n");
		
		
		Computer computer = new Computer();
		computer.askForShips();
		Scanner guesses = new Scanner(System.in);
		Player player1 = new Player(guesses, computer.computerGrid);
		player1.askForShips();
		
		

		System.out.println("Location of my ships");
		player1.printMyShips();
		System.out.println();
		
		
		
		System.out.println("Enemy has placed ships. " );
		int playerHits = 0;
		int computerHits = 0;
		int totalHits = 17;
		
		while(true){
			
            
			if(totalHits <= playerHits){
				System.out.println("YOU WIN!!");
				break;
			}
			if(computerHits >= totalHits){
				System.out.println("YOU LOSE!!");
				break;
			}
			
			
			System.out.println("\n" + "Player Turn to Guess:" + "\n");
			System.out.print("Which row? (1-10) ");
            int shipRow = player1.reader.nextInt()-1;
      
            System.out.println("Which column? (1-10) ");
            int shipCol = player1.reader.nextInt()-1;
         
            boolean check = true;
            if(shipRow > 10 || shipCol > 10 || shipRow < 0 || shipCol < 0){
            	check = false;
            	System.out.println("Invalid Guess. Guess again: ");
            }
            if(check){
            	playerHits += computer.recordOpponentGuess(shipRow, shipCol);
            	player1.recordMyGuess(shipRow, shipCol);
            	player1.printMyGuesses();
            	System.out.println("\1"
            			+ "1n" + "Computer's turn: ");
            	int[] compGuess = computer.getCompGuess();
            	computerHits += player1.recordOpponentGuess(compGuess[0], compGuess[1]);
            	player1.printOpponentGuesses();
            	//record Hit or miss for player
            	//ask comp for their guess
            	//call comp random guess
            	//check comp guess hit or miss
            }
            
		}
		
		player1.reader.close(); 
		

	}

}
