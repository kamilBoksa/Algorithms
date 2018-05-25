import java.util.ArrayList;
import java.util.List;

public class TinkerTailor {
    private Integer syllablesAmount;
    private List<Integer> players;
    private Integer winner;

    TinkerTailor(Integer syllablesAmount, List<Integer> players) {
        this.syllablesAmount = syllablesAmount;
        this.players = players;
    }

    public List<Integer> findTheWinner() {
        List<Integer> excluded = new ArrayList<>();
        int index = 0;

        while(players.size() > 1) {
            index = ((index + syllablesAmount - 1) % players.size());
            excluded.add(players.get(index));
            players.remove(index);
        }
        winner = players.get(0);
        excluded.add(winner);

        return excluded;
    }

    public Integer getWinner() {
        return winner;
    }
}
