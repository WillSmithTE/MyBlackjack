import java.util.ArrayList;

/**
 * Created by Elber on 05-Aug-17.
 */
public class Player implements Person{
    private String name;
    private int chips;
    public Player(String name){
        this.name = name;
        chips = 500;
    }
    public void haveTurn(){

    }
    public int getChips(){
        return chips;
    }
    public void addChips(int chips){
        this.chips+=chips;
    }
    @Override
    public String toString(){
        return name + ": " + chips + " chips.";
    }
}
