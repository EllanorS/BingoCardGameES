import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        //Game plays out here
        //Scans in Bingo cards and sets stuff up
        Scanner sc = new Scanner(System.in);
        Sheet bigSheet = new Sheet();
        Sheet playerSheet = new Sheet();
        File bingoCards = new File("BingoCards.txt");
        System.out.println("Scanning File");

        bigSheet.scanCards(bingoCards);

        System.out.println("Hello! Welcome to Bingo :) ");
        bigSheet.printAll();
        
        System.out.println("How many cards would you like to play? (1-4)");
        int numCards = sc.nextInt();
        sc.nextLine();
// makes sheet for player!
        ArrayList<Card> chosenCards = new ArrayList<>();
        for(int i=0; i<numCards; ++i){
            System.out.println("Which card? Please enter name: ");
            String cardName = sc.nextLine();
            for(Card card : bigSheet.getCards()){
                if(card.getCardName().equals(cardName)){
                    chosenCards.add(card);
                    break;
                }
            }
        }
// setting up stuff for called spots!
        Random rand = new Random();
        ArrayList<Integer> calledSpots = new ArrayList<>();
        boolean iGotBINGO = false;
        
        //calls out BINGO numbers
        while(!iGotBINGO){
            String call;
            int calledNum;
            do{
                char letter = "BINGO".charAt(rand.nextInt(5));
                calledNum = switch(letter){
                    case 'B' -> rand.nextInt(15)+1;
                    case 'I' -> rand.nextInt(15)+16;
                    case 'N' -> rand.nextInt(15)+31;
                    case 'G' -> rand.nextInt(15)+46;
                    case 'O' -> rand.nextInt(15)+61;
                    default -> 200;
                };
                call = Character.toString(letter) + calledNum;
            } while (calledSpots.contains(calledNum));

            calledSpots.add(calledNum);

            playerSheet.printPlayerSheet(chosenCards);

            System.out.println("Called: "+call);
            System.out.println("Need to mark something?");

            // if the user does, then let them enter in location to mark.
            //Put in location with Scanner
            //Repeat until the user would like to call BINGO (repetitive ask)
            //If yes, checkBingo
            //Tell them if they won or lost!


          /*   for(Card card : chosenCards){
                card.dotSheet(calledNum);
                card.printCard();
                if(card.checkBingo(calledSpots)){
                    System.out.println("You got BINGO!");
                    iGotBINGO = true;
                    break;
                }
            }
        } */
        sc.close();

    }
}
