import java.lang.reflect.Array;
import java.util.ArrayList;


/**
 * Created by Elber on 05-Aug-17.
 */
public class Dealer extends Person{
    ArrayList<Player> players = new ArrayList<>();
    Deck deck;
    public Dealer(ArrayList<Player> players, Deck deck){
        this.players = players;
        this.deck=deck;
    }
    @Override
    public void haveTurn(){

    }

    public void deal() {
        deck.shuffle();
        int i=0;
        while (i<2) {
            for (Player player : players) {
                dealCard(player);
            }
                dealCard(this);
                i++;
            }
        }

    public void dealCard(Person person){
        person.receive(deck.dealCard());
    }

    public void runTurns() {
        deal();
        for (Player player:players)
            player.haveTurn();
        haveTurn();
    }
}
