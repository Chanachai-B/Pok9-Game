package gamecard;

import java.util.ArrayList;
 
public class Player {
    private String playerName;
    private ArrayList<Card> cardInHand = new ArrayList<>();
    private int numberOfCardCanBeDraw;
    private String pointInHands;
    private boolean needToDraw = false;

    Player(){}
    
    Player(int name){
        this.playerName = "player " + name;
    }
    
    void drawCard(Card card){
        this.cardInHand.add(card);
    }
    
    public boolean isNeedToDraw() {
        return needToDraw;
    }

    public void setNeedToDraw(boolean needToDraw) {
        this.needToDraw = needToDraw;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String p) {
        this.playerName = p;
    }

    public int getNumberOfCardCanBeDraw() {
        return numberOfCardCanBeDraw;
    }

    public void setNumberOfCardCanBeDraw(int numberOfCardCanBeDraw) {
        this.numberOfCardCanBeDraw = numberOfCardCanBeDraw;
    }

    public ArrayList<Card> getCardInHand() {
        return cardInHand;
    }
    
    public void setCardInHand(Card c){
        this.cardInHand.add(c);
    }

    public String getPointInHands() {
        return pointInHands;
    }

    public void setPointInHands(String point) {
        this.pointInHands = point;
    }
    
}
