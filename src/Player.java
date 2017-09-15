import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Elber on 05-Aug-17.
 */
public class Player extends Person{

    private int chips;
    private int bet;
    private Dealer dealer;
    private Boolean bust;

    public Player(String name,Dealer dealer){
        this.name = name;
        chips = 500;
        this.dealer=dealer;
    }
    @Override
    public void haveTurn(){
        readChoice();
    }
    public int getChips(){
        return chips;
    }
    @Override
    public String toString(){
        return name + ": " + chips + " chips.";
    }

    public void setBet(int bet) {
        this.bet=bet;
    }

    public void placeBet() {
        System.out.print(this + " How many chips would you like to bet? ");
        bet = new Scanner(System.in).nextInt();
    }

    @Override
    protected void stand(){
            System.out.println(name + " stands with " + getScore());
    }

    private void readChoice(){
        System.out.print(name + ": "+ getScore() + " " + hand + ". ");
        System.out.print("Hit, stand, double or split? ");
        String choice = new Scanner(System.in).nextLine();
        switch (choice.toLowerCase()){
            case "hit":hit();break;
            case "stand":stand();break;
            case "double":doub();break;
            case "split":split();break;
            default:help();
        }
    }

    private void doub() {
        bet *=2;
        dealer.dealCard(this);
        checkBust();
    }



    private void split() {
    }

    @Override
    protected void hit(){
        dealer.dealCard(this);
        checkBust();
    }


    protected void checkBust(){
        if (notBust()) {
            readChoice();
        }
        else System.out.println("You went bust with " + getScore()+ " "+hand);
    }

    private void help(){
        System.out.println("Hit: Take another card from the dealer.");
        System.out.println("Stand: Take no more cards.");
        System.out.println("Double down: Increase the initial bet by 100% and commit to stand after receiving exactly one more card.");
        System.out.println("Split: If the first two cards of your hand have the same value, you can split them into two hands, by placing a second bet equal to the first. The dealer separates the two cards and draws an additional card on each, placing one bet with each hand. The player then plays out the two separate hands in turn.");
        readChoice();
    }
    public void determinePayout(int dealersScore) {
        if ((dealersScore>=this.getScore()&&dealer.notBust())||!notBust()){
            chips-=bet;
        }
        else chips+=bet;
    }
}
