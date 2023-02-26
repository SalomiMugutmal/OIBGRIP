import java.util.Scanner;
import java.util.Random;

//Game class
class Game{
	
	int systemInput;
	int userInput;
	int noOfGuesses=0;
	
	//Generating random number in default constructor
	Game(){
		Random random=new Random();
		this.systemInput=random.nextInt(100)+1;
	}
	
	//method to take user guesses
	public boolean takeUserInput() {
		if(noOfGuesses <10) {
			System.out.print("Guess the number :");
			this.userInput=GuessTheNumber.takeIntegerInput(100);
			noOfGuesses++;
			return false;
		}
		else {
			System.out.println("Number of attempts finished...Better luck next time..");
			return true;
			
		}
	}
	
	//method to check user guess status
	
	public boolean isCorrectGuess() {
		if(systemInput ==userInput) {
			System.out.println("Congratulations,you guess the number : "+systemInput+"in"+noOfGuesses +"guesses");
			switch(noOfGuesses) {
			case 1:
				System.out.println("Your score is 100");
				break;
			case 2:
				System.out.println("Your score is 90");
				break;
			case 3:
				System.out.println("Your score is 80");
				break;
			case 4:
				System.out.println("Your score is 70");
				break;
			case 5:
				System.out.println("Your score is 60");
				break;
			case 6:
				System.out.println("Your score is 50");
				break;
			case 7:
				System.out.println("Your score is 40");
				break;
			case 8:
				System.out.println("Your score is 30");
				break;
			case 9:
				System.out.println("Your score is 20");
				break;
			case 10:
				System.out.println("Your score is 10");
				break;
			}
			System.out.println();
			return true;
		}
		else if(noOfGuesses < 10 && userInput>systemInput) {
			if(userInput- systemInput>10) {
				System.out.println("Too High");
			}
			else {
				System.out.println("Little High");
			}
		}
		else if(noOfGuesses<10 && userInput<systemInput) {
			if(systemInput -userInput >10) {
				System.out.println("Too Low");
			}
			else {
				System.out.println("Little Low");
			}
		}
		return false;
	}
}
 //main class
public class GuessTheNumber {
 
	public static int takeIntegerInput(int limit) {
		int input=0;
		boolean flag =false;
		
		while(!flag) {
			try {
				Scanner sc=new Scanner(System.in);
				input=sc.nextInt();
				flag=true;
				
				if(flag && input >limit ||input <1) {
					System.out.println("Choose the number  between 1 to "+limit);
					flag=false;
					
				}
			}
			catch(Exception e) {
				System.out.println("Enter only integer value :");
				flag =false;
			}
		};
		return input;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		//input for start the game
		System.out.println("1.Start the game \n2.Exit");
		System.out.println("Enter your choice :");
		int choice =takeIntegerInput(2);
		int nextRound=1;
		int noOfRound=0;
		
		if(choice ==1) {
			//to check next round is there or not
			
			while(nextRound ==1) {
				//creating object of Game class
				Game game=new Game();
				boolean isMatched =false;
				boolean isLimitCross=false;
				System.out.println("\nRound "+ ++noOfRound + "status ...");
				
				//to check correct guess and limit cross
				while(!isMatched && !isLimitCross){
					isLimitCross =game.takeUserInput();
					isMatched =game.isCorrectGuess();
					
				}
				//input for next round
				System.out.println("1.Next Round \n2.Exit");
				System.out.println("Enter your choice : ");
				nextRound = takeIntegerInput(2);
				if(nextRound != 1) {
					System.exit(0);
				}
			}
		}
		else {
			System.exit(0);
		}


	}

}