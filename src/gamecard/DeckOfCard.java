package gamecard;

import java.util.ArrayList;
import java.util.Random;

public class DeckOfCard{
    private ArrayList<Card> deck = new ArrayList<>();
    
    DeckOfCard(){
        String symbol[] = {"Club","Diamond","Heart","Spade"};
        String name[] = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        boolean edge;
        for(int type =0;type<4;type++){
            for(int point=0;point<13;point++){
                edge = point > 10? true:false;
                deck.add(new Card(name[point], symbol[type], edge));
            }
        }
    }
    
    void shuffle(){
        ArrayList<Card> positionCard = new ArrayList<>();
        int i = deck.size();
        while(i > 0){
            Random random = new Random(System.currentTimeMillis());
            int num = random.nextInt(i);
            positionCard.add(deck.get(num));
            deck.remove(num);
            i--;
        }
        deck.addAll(positionCard);
        }     

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }
}
