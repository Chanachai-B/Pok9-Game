package gamecard;

public class Card {
    private String symbol;
    private String name;
    private boolean edgeCard;
    private int cardPoints;
    
    Card(String name, String symbol, boolean edge) {
        this.name = name;
        this.symbol = symbol;
        this.edgeCard = edge;
    }
    Card() {}
    
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEdgeCard() {
        return edgeCard;
    }

    public void setEdgeCard(boolean cardIsEdge) {
        this.edgeCard = cardIsEdge;
    }
    
    public int getCardPoints() {
        return cardPoints;
    }

    public void setCardPoints(int point) {
        this.cardPoints = point;
    }
    
}
