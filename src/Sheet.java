
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sheet {
    //prints //out the chosen cards user wanted
   
    private ArrayList<Card> cards = new ArrayList<>();
// scans in all of the cards from the file and puts them into an array called cards!
    public void scanCards(File file) throws FileNotFoundException {
        Scanner inFile1 = new Scanner(file);
        while (inFile1.hasNextLine()) { 
            String name = inFile1.nextLine().trim();
          
            if(name.isEmpty()){
                continue;
            }
          
            int[][] numbers = new int[5][5];

            for(int i=0; i<5; ++i){
                String[] commas = inFile1.nextLine().split(",");
                for(int j=0; j<5; ++j){
                    numbers[i][j]=Integer.parseInt(commas[j].trim());
                }
            }

            cards.add(new Card(name, numbers));
        }
        inFile1.close();
    }


    public ArrayList<Card> getCards(){
        return cards;
    }

//prints out all of the cards!
    public void printAll(){
		for(Card card: cards){
			System.out.println(card.getCardName());
			card.printCard();
			System.out.println();
		}
	}
// will print out player sheet
    public void printPlayerSheet(ArrayList<Card>chosenCards){
        for(Card card: chosenCards){
			System.out.println(card.getCardName());
			card.printCard();
			System.out.println();
		}
    }





    //scans through file and creates array of cards
   /*  public void scanCards(File file) throws FileNotFoundException{
        //Array List 
            ArrayList<Card> Database = new ArrayList<Card>();
            Scanner inFile1 = new Scanner(file);
            Card tempCard = null;
        //Scans the file and sets array list "Database" w/ records from file
                while (inFile1.hasNextLine()) { 
                     String line = inFile1.nextLine().trim();
    
                     if (line.isEmpty()){
                        continue;
                     }else if (line.startsWith("Card")){
                        if(tempCard != null){
                            Database.add(tempCard);
                        }
                        //tempCard = new card(line);
                     }
                    Database.add(new Card());
                    if (inFile1.hasNextLine())
                        inFile1.nextLine();
                }
                inFile1.close();
        } */






}
