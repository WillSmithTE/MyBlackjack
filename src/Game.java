import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Elber on 05-Aug-17.
 */
public class Game {
    int playerCount;
    private ArrayList<Person> everyone = new ArrayList<>();
    private ArrayList<Player> players = new ArrayList<>();
    private Boolean keepPlaying = true;
    private Scanner scanner = new Scanner(System.in);
    private Dealer dealer;
    public Game(){
        this.dealer = gameSetup();
    }
    public static void main(String[] args){
        new Game().play();

    }
    private void play(){
        while (keepPlaying){
            playRound();
        }
        System.out.println("Goodbye");
    }

    private void playRound() {
        for (Player player:players){
            player.placeBet();
        }
        dealer.runTurns();
        showLeaderboard();
        for (Person person:everyone){
            person.clearHand();
        }
        keepPlaying = playAgain();
        }

    private Boolean playAgain() {
        String response = null;
        while (response!="y"&&response!="n") {
            response = readPlayAgain();
            switch (response) {
                case "y":
                    return true;
                case "n":
                    return false;
                default:
                    System.out.println("Enter 'y' to keep playing or 'n' to stop now");
            }
        }
        return null;
    }

    private String readPlayAgain(){
        System.out.print("Play again? (y/n):");
        return scanner.nextLine().toLowerCase();
    }


    private void showLeaderboard() {
        ArrayList<Player> leaderboard = players;
        leaderboard.sort(Comparator.comparing(Player::getChips));
        Collections.reverse(leaderboard);
        for (Player player:leaderboard){
            System.out.println(leaderboard.indexOf(player)+1+". " + player);
    }

}

    private Dealer gameSetup(){
        Dealer dealer = new Dealer(new Deck());
        ArrayList<String> playerNames = readPlayers();
        for (String name:playerNames){
            Player player = new Player(name,dealer);
            players.add(player);
            everyone.add((Person) player);
        }
        dealer.assignPlayers(players);
        everyone.add(dealer);
        return dealer;
    }

    private ArrayList<String> readPlayers(){
        ArrayList<String> players= new ArrayList<>();

        System.out.print("How many players? ");
        int playerCount = scanner.nextInt();
        scanner.nextLine();
        for (int i=1;i<=playerCount;i++){
            System.out.print("Player "+i+"'s name: ");
            players.add(scanner.nextLine());
        }
        return players;
    }
}
