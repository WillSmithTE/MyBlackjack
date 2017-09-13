import java.util.ArrayList;

/**
 * Created by Elber on 05-Aug-17.
 */
public interface Person {
    ArrayList<Card> hand = new ArrayList<>();

    void haveTurn();

    default void receive(Card card){
        hand.add(card);
    }
    default int getScore(){
        int score =0;
        for (Card card:hand){
            
        }
    }
}
