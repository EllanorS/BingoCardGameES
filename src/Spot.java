public class Spot {
    private int number;
    private boolean dotted;

    public Spot(int number){
        this.number = number;
        this.dotted = false;

    }

    public int getNumber(){
        return number;
    }

    public boolean getDotted(){
        return dotted;
    }
// allows user to dot spots on board
    public void dot(){
        dotted = true;
    }






}
