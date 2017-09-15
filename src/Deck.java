import java.util.ArrayList;

/**
 * Created by Elber on 05-Aug-17.
 */
public class Deck {
    private ArrayList<Card> cards = new ArrayList();
    String[] suits = {"Spades","Diamonds","Clubs","Hearts"};
    String[] names = {"Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King","Ace"};
    int[] scores = {2,3,4,5,6,7,8,9,10,10,10,10,11};
    public Deck(){
        for (String suit:suits) {
            for (String name : names) {
                    cards.add(new Card(suit, name));
            }
        }
    }

    public void shuffle() {
    }

    public Card dealCard() {
        Card selectedCard =  cards.get(cards.size()-1);
        cards.remove(selectedCard);
        return selectedCard;
    }
}
