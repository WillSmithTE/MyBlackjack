import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Elber on 05-Aug-17.
 */
public class Player extends Person{
    private String name;
    private int chips;
    private int bet;
    public Player(String name){
        this.name = name;
        chips = 500;
    }
    @Override
    public void haveTurn(){
        System.out.println(name + "'s turn: "+ hand + " - Current score = "+getScore());
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

    public void placeBet() {
        System.out.print(this + " How many chips would you like to bet? ");
        bet = new Scanner(System.in).nextInt();
    }
}
