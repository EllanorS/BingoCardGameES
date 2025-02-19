import java.util.ArrayList;

public class Card {
    
	private String cardName;
	private Spot[][] spots;

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	
	// initialize 2D array that holds columns and rows of the BINGO numbers
	public Card(String cardName, int[][] numbers){
		this.cardName = cardName;
		this.spots = new Spot[5][5];

		for(int row= 0; row<5; ++row){
			for(int column= 0; column<5; ++column){
				spots[row][column] = new Spot(numbers[row][column]);
			}
		}
		//check off the free space!
		spots[2][2].dot();
	}
	
	//Dots the correct spot on the card if its there!
	public void dotSheet(int number){
		for(Spot[] row : spots){
			for(Spot spot : row){
				if(spot.getNumber()==number){
					spot.dot();
					return;
				}
			}
		}
	}
// Checks for BINGOs using checkRows, check Columns, and checkDiagonals
	public boolean checkBingo(ArrayList<Integer> calledNumbers){
		return (checkRows(calledNumbers) || checkColumns(calledNumbers) || checkDiagonals(calledNumbers));
	}
	//Checks for horizontal BINGOs
	public boolean checkRows(ArrayList<Integer> calledNumbers){
		for(int row=0; row<5; ++row){
			boolean allDotted = true;
			for(int column=0; column<5; ++column){
				if(!spots[row][column].getDotted()|| !calledNumbers.contains(spots[row][column].getNumber())){
					allDotted = false;
					break;
				}
			}
			if (allDotted){
				return true;
			} 
		}
		return false;
	}
//checks for vertical BINGOS
	public boolean checkColumns(ArrayList<Integer> calledNumbers){
		for(int column=0; column<5; ++column){
			boolean allDotted = true;
			for(int row=0; row<5; ++row){
				if(!spots[row][column].getDotted() || !calledNumbers.contains(spots[row][column].getNumber())){
					allDotted = false;
					break;
				}
			}
			if (allDotted){
				return true;
			} 
		}
		return false;
	}
// checks for diagonal BINGOs
	public boolean checkDiagonals(ArrayList<Integer> calledNumbers){
		boolean diagonalLR = true;
		boolean diagonalRL = true;
		for(int i=0; i<5; ++i){
			if(spots[i][i].getDotted() && calledNumbers.contains(spots[i][i].getNumber())){
				diagonalLR=true;
			}
			if(spots[i][4-i].getDotted() && calledNumbers.contains(spots[i][4-i].getNumber())){
				diagonalRL=true;
			}
		}
		return (diagonalLR || diagonalRL);
	}

	//Prints out card in Box-like formatting
	public void printCard(){
		String[] bingoLetters = {"B","I","N","G","O"};
		
		System.out.print("    ");
		for(int i=0; i<5; ++i){
			System.out.print(" "+bingoLetters[i]+"   ");
		}System.out.println();
		System.out.println("---------------------------");

		for(int i=0; i<5; ++i){
			System.out.print(bingoLetters[i] + " |");

			for(int j=0; j<5; ++j){
				String marker = spots[i][j].getDotted() ? "XX" : Integer.toString(spots[i][j].getNumber());
				System.out.print(" "+ marker + " |");
			}

			System.out.println();
			System.out.println("---------------------------");
		}

		

		
	}

	

	
}
