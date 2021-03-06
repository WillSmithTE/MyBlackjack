import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


/**
 * Created by Elber on 05-Aug-17.
 */
public class Dealer extends Person {
    ArrayList<Player> players = new ArrayList<>();
    Deck deck;

    public Dealer(Deck deck) {
        this.deck = deck;
        this.name = "dealer";
    }

    @Override
    public void haveTurn() {
        while (getScore() < 17) {
            System.out.println(name + ": " + getScore() + " " + hand + ".");
            waitSecond();
            hit();
        }
        if (notBust()) stand();
        else System.out.println("Dealer went bust with " + getScore() + " " + hand);
        waitSecond();
        payout();
    }

    private void payout() {
        for (Player player : players) {
            waitSecond();
            player.determinePayout(getScore());
            player.setBet(0);
        }
    }

    public void deal(ArrayList<Player> players) {
        deck.shuffle();
        int i = 0;
        while (i < 2) {
            for (Player player : players) {
                dealCard(player);
            }
            dealCard(this);
            i++;
        }
    }

    public void dealCard(Person person) {
        person.receive(deck.dealCard());
    }

    public void runTurns() {
        deal(players);
        showFirstCard(hand);
        for (Player player : players)
            player.haveTurn();
        haveTurn();
    }

    private void showFirstCard(ArrayList<Card> hand) {
        System.out.println("Dealer has " + hand.get(0));
    }

    @Override
    protected void hit() {
        dealCard(this);
    }

    @Override
    protected void stand() {
        System.out.println(name + " stands with " + getScore() + " " + hand);
    }

    public void assignPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    private void waitSecond() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
