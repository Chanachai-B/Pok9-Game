//**********GamePok89 ส่วนที่ 1/4
package gamecard;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class GamePok89 {
    GroupOfPlayers player = new GroupOfPlayers();
    DeckOfCard card = new DeckOfCard();
    int roundsPlayed;
    ArrayList<String> pointList = new ArrayList<>();
    
    GamePok89(){
        this.player.setPlayersName(17);
        setPoint();
        printStar();
        for(int i=0; i<17; i++)
            this.player.getPlayers().get(i).setNeedToDraw(true);
        System.out.println("17 players have participated in Pok 9 game.");
        printStar();
        roundsPlayed = 1;
    }
    
    GamePok89(int num){
        setPoint();
        if(num >= 2 && num <=17){
            this.player.setPlayersName(num);
            printStar();
            for(int i=0; i<num; i++)
                this.player.getPlayers().get(i).setNeedToDraw(true);
            System.out.println(num+" players have participated in Pok 9 game.");
            printStar();
            roundsPlayed = 1;
        }
        else 
            roundsPlayed = 0;
    }
    
    void play() throws InterruptedException{
        if(roundsPlayed == 1){
            System.out.println("The game started with 52 cards.");
            this.card.shuffle();
            dealOutCards();
        }
        else
            System.out.println("Pok 9 game supports 2 - 17 players only.");
    }
    
    void dealOutCards() throws InterruptedException{
        int num,r,list;
        roundsPlayed = 1;
        System.out.println("1st round play");
        printStar();
        
        //แจกไพ่ให้ผู้เล่น
        for (num = 1;num < this.player.getPlayers().size();num++){
            for(r=0;r<2;r++){
                int i = this.card.getDeck().size() - 1;
                this.player.getPlayers().get(num).setCardInHand(this.card.getDeck().get(i));
                this.card.getDeck().remove(i);
            }
            TimeUnit.MILLISECONDS.sleep(500);
            this.player.getPlayers().get(num).setPointInHands(calculatePoints (this.player.getPlayers().get(num).getCardInHand()));
            list = this.pointList.indexOf(this.player.getPlayers().get(num).getPointInHands());
            this.player.getPlayers().get(num).setNeedToDraw(needToDraw(this.player.getPlayers().get(num).getPointInHands().charAt(0)));
            System.out.println("\n"+this.player.getPlayers().get(num).getPlayerName()+" gets 2 cards. Cards in the deck of "+this.card.getDeck().size()+" cards remain.");
            if(list < 4){
                System.out.println("*****"+this.player.getPlayers().get(num).getPlayerName()+" is "+this.player.getPlayers().get(num).getPointInHands()+"*****");
                this.player.getPlayers().get(num).setNumberOfCardCanBeDraw(0);
            }
            else
                this.player.getPlayers().get(num).setNumberOfCardCanBeDraw(1);
        }
        //**********GamePok89 ส่วนที่ 2/4
        //แจกไพ่ให้เจ้ามือ
        for(r=0;r<2;r++){
            if(this.player.getPlayers().get(0).isNeedToDraw() == false) continue;
            int i = this.card.getDeck().size() - 1;
            this.player.getPlayers().get(0).setCardInHand(this.card.getDeck().get(i));
            this.card.getDeck().remove(i);
        }
        TimeUnit.MILLISECONDS.sleep(500);
        this.player.getPlayers().get(0).setPointInHands(calculatePoints (this.player.getPlayers().get(0).getCardInHand()));
        list = this.pointList.indexOf(this.player.getPlayers().get(0).getPointInHands());
        this.player.getPlayers().get(0).setNeedToDraw(needToDraw(this.player.getPlayers().get(0).getPointInHands().charAt(0)));
        System.out.println("\n"+this.player.getPlayers().get(0).getPlayerName()+" gets 2 cards. Cards in the deck of "+this.card.getDeck().size()+" cards remain.");
        if(list < 4){
            System.out.println("*****"+this.player.getPlayers().get(0).getPlayerName()+" is "+this.player.getPlayers().get(0).getPointInHands()+"*****");
            this.player.getPlayers().get(0).setNumberOfCardCanBeDraw(0);
            this.roundsPlayed = 0;
            printStar();
        }
        else{
            this.roundsPlayed = 2;
            this.player.getPlayers().get(0).setNumberOfCardCanBeDraw(1);
        }
        
        
        //กรณีที่มีการเล่นรอบที่ 2 (แจกไพ่ใบที่ 3)
        if(roundsPlayed == 2 && this.player.getPlayers().size() > 0){
        System.out.println("\n2nd round play");
        printStar();
        
        //แจกไพ่ให้ผู้เล่น
        for(num = 1;num < this.player.getPlayers().size();num++){
            if(this.player.getPlayers().get(num).isNeedToDraw() == true ){
                int i = this.card.getDeck().size() - 1;
                this.player.getPlayers().get(num).setCardInHand(this.card.getDeck().get(i));
                this.card.getDeck().remove(i);
                this.player.getPlayers().get(num).setPointInHands(calculatePoints (this.player.getPlayers().get(num).getCardInHand()));
                System.out.println("\n"+this.player.getPlayers().get(num).getPlayerName()+" draws 1 more card. Cards in the deck of "+this.card.getDeck().size()+" cards remain.");
            }
            else if(this.player.getPlayers().get(num).getNumberOfCardCanBeDraw() == 0) {
            } 
            else
                System.out.println("\n"+this.player.getPlayers().get(num).getPlayerName()+" pass");
            TimeUnit.SECONDS.sleep(1);
        }
        
        //แจกไพ่ให้เจ้ามือ
        if(this.player.getPlayers().get(0).isNeedToDraw() == true && this.player.getPlayers().get(0).getNumberOfCardCanBeDraw() == 1){
            int i = this.card.getDeck().size() - 1;
            this.player.getPlayers().get(0).setCardInHand(this.card.getDeck().get(i));
            this.card.getDeck().remove(i);
            this.player.getPlayers().get(0).setPointInHands(calculatePoints (this.player.getPlayers().get(0).getCardInHand()));
            System.out.println("\n"+this.player.getPlayers().get(0).getPlayerName()+" draws 1 more card. Cards in the deck of "+this.card.getDeck().size()+" cards remain.");
        }
        else
            System.out.println("\n"+this.player.getPlayers().get(0).getPlayerName()+" pass");
        printStar();
        }
        System.out.println("\nGame is end.\n");
        playerRanking();
    }
     //**********GamePok89 ส่วนที่ 3/4
    String calculatePoints(ArrayList<Card> card) {
        int point = 0;
        boolean sameName = card.get(0).getName().equals(card.get(1).getName());
        boolean sameSymbol = card.get(0).getSymbol().equals(card.get(1).getSymbol());
        boolean sameEdge = card.get(0).isEdgeCard() & card.get(1).isEdgeCard();
        String characteristicsPoints = null;
        for(int i = 0; i < card.size(); i++){
            point += card.get(i).getCardPoints();
        }
        
        if(card.size() == 3){
            sameName = card.get(0).getName().equals(card.get(1).getName().equals((card.get(2).getName())));
            sameSymbol = card.get(0).getSymbol().equals(card.get(1).getSymbol().equals(card.get(2).getSymbol()));
            sameEdge = card.get(0).isEdgeCard() & card.get(1).isEdgeCard() & card.get(2).isEdgeCard();
        }
            
        if(point%10 > 7 && card.size() == 2 &&  (sameName == true || sameSymbol == true))
            characteristicsPoints = "Pok".concat(Integer.toString(point%10))+" Double";
        
        else if(point%10 > 7 && card.size() == 2)
            characteristicsPoints = "Pok".concat(Integer.toString(point%10))+" Single";
        
        else if(card.size() == 3 && sameName == true && (point%10 == 0 || point%10 == 3))
            characteristicsPoints = card.get(0).getName()+" Triple";
        
        else if(card.size() == 3 && sameEdge == true)
            characteristicsPoints = "Edge Triple";
        
        else if(card.size() == 3 && point%10 != 0 && (sameName == true || sameSymbol == true))
            characteristicsPoints = Integer.toString(point%10)+" Triple";
        
        else if(card.size() == 2 && point%10 > 0 && point%10 < 8 && (sameName == true || sameSymbol == true))
            characteristicsPoints = Integer.toString(point%10)+" Double";
        
        else if(point%10 > 0)
            characteristicsPoints = Integer.toString(point%10)+" Single";
        
        else if(point%10 == 0)
            characteristicsPoints = "Zero";
        return characteristicsPoints;
    }
    
    void showCard() throws InterruptedException{
        for(int i = 0; i < this.player.getPlayers().size(); i++){
            TimeUnit.MILLISECONDS.sleep(250);
            System.out.print(this.player.getPlayers().get(i).getPlayerName()+" : ");
            System.out.print(this.player.getPlayers().get(i).getPointInHands()+" : ");
            for(int j = 0; j < this.player.getPlayers().get(i).getCardInHand().size() ; j++)
                System.out.print(this.player.getPlayers().get(i).getCardInHand().get(j).getName()+" "+this.player.getPlayers().get(i).getCardInHand().get(j).getSymbol()+" ");
            System.out.print("\n-----------------------------------------------\n");
            System.out.println();
        }
    }
    
    void playerRanking() throws InterruptedException{       //ใช้วิธีการ bubble sort ในการเรียงข้อมูล
        System.out.println("Players ranking!!!");
        printStar();
        int n = this.player.getPlayers().size();
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++){
                int i1 =this.pointList.indexOf(this.player.getPlayers().get(j).getPointInHands());
                int i2 =this.pointList.indexOf(this.player.getPlayers().get(j+1).getPointInHands());
                if (i1 > i2) {
                    // swap player[j] and player[j+1]
                    Player t = this.player.getPlayers().get(j);
                    this.player.getPlayers().remove(j);
                    this.player.getPlayers().add(j,this.player.getPlayers().get(j));
                    this.player.getPlayers().remove(j+1);
                    this.player.getPlayers().add(j+1,t);
                }
            }
        showCard();
    }
//**********GamePok89 ส่วนที่ 4/4
    void setPoint() {
        int i,j;
        String symbol[] = {"Pok9","Pok8","King","Queen","Jack","Edge","9","8","7","6","5","4","3","2","1","Zero"};
        String type[] = {"Triple","Double","Single"};
        for(i=0;i<2;i++){
            for(j=1;j<3;j++)
                this.pointList.add(symbol[i].concat(" "+type[j]));
        }
        for(i=2;i<6;i++){
                this.pointList.add(symbol[i].concat(" "+type[0]));
        }
        for(i=6;i<15;i++){
            for(j=0;j<3;j++){
                this.pointList.add(symbol[i].concat(" "+type[j]));
                this.pointList.remove("9 Double");
                this.pointList.remove("8 Double");
            }
        }
        this.pointList.add(symbol[15]);
        for(int k = 0; k < this.card.getDeck().size(); k++)
            this.card.getDeck().get(k).setCardPoints(cardPoint(this.card.getDeck().get(k).getName()));
    }
    
    int cardPoint(String name){
        int pointCard;
        switch(name){
            case "A" : pointCard = 1;  break;
            case "J" : pointCard = 10; break;
            case "Q" : pointCard = 10; break;
            case "K" : pointCard = 10; break;
            default : pointCard = Integer.parseInt(name);
        }
        return pointCard;
    }
    
    boolean needToDraw(char point){
        boolean isNeed = false;
        switch(point){
            case 'K' : 
            case 'Q' : 
            case 'J' : 
            case 'Z' : 
            case '3' :
            case '2' :
            case '1' : isNeed = true;
    }
        return (isNeed);
    }
    
    void printStar(){
        System.out.println("*****************************************************");
    }
    
    void setJaoIsPok9(){
        this.card.shuffle();
        if(!this.player.getPlayers().isEmpty()){
            this.player.getPlayers().get(0).setCardInHand(this.card.getDeck().get(51));
            this.card.getDeck().remove(51);
            int i = 9 - this.player.getPlayers().get(0).getCardInHand().get(0).getCardPoints();
            int cardPok = 0;
            int n = this.card.getDeck().size() -1;
            if(i == -1 || i == 9){
                while(cardPok != 9){
                    cardPok = this.card.getDeck().get(n).getCardPoints();
                    n--;
                }
            }
            else{
                while(cardPok != i){
                    cardPok = this.card.getDeck().get(n).getCardPoints();
                    n--;
                } 
            }
            if(n != this.card.getDeck().size() -1)
                n ++;
            this.player.getPlayers().get(0).getCardInHand().add(this.card.getDeck().get(n));
            this.card.getDeck().remove(n);
            this.player.getPlayers().get(0).setNeedToDraw(false);
        }
    }
}