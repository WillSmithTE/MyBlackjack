/**
 * Created by Elber on 05-Aug-17.
 */
public class Card {
    private String suit;
    private String name;
    private int score;
    public Card(String suit,String name){
        this.suit=suit;
        this.name=name;
        this.score = findScore(name);
    }

    private int findScore(String name) {
        switch (name){
            case "Two": return 2;
            case "Three": return 3;
            case "Four": return 4;
            case "Five": return 5;
            case "Six": return 6;
            case "Seven": return 7;
            case "Eight": return 8;
            case "Nine": return 9;
            case "Ten": return 10;
            case "Jack": return 10;
            case "Queen": return 10;
            case "King": return 10;
            case "Ace": return 11;
        }
        return 0;
    }

    @Override
    public String toString(){
        return name + " of " + suit + " (" + score + ")";
    }

    public int getScore() {
        return score;
    }
}
