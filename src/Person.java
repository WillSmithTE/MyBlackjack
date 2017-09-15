import java.util.ArrayList;

/**
 * Created by Elber on 05-Aug-17.
 */
public abstract class Person {
    ArrayList<Card> hand = new ArrayList<>();
    protected String name;

    public abstract void haveTurn();

    public void receive(Card card){
        hand.add(card);
    }
    public int getScore(){
        int score =0;
        for (Card card:hand){
            score += card.getScore();
        }
        return score;
    }
    protected abstract void stand();

    protected abstract void hit();


    public boolean notBust() {
        return getScore()<=21;
    }

    public void clearHand() {
        hand.clear();
    }
}
