package gamecard;

import java.util.ArrayList;

public class GroupOfPlayers {
    private ArrayList<Player> players = new ArrayList<>();

    GroupOfPlayers() {}
    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayersName(int num) {
        for(int i=1;i<=num;i++)
            this.players.add(new Player(i));
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}
