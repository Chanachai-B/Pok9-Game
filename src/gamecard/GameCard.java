package gamecard;

public class GameCard {

    public static void main(String[] args) throws InterruptedException {
        //Pok9 p = new Pok9();        //สร้างเกมไพ่ป๊อก ที่มีผู้เล่น 17 คน
        GamePok89 p = new GamePok89(10);       //สร้างเกมไพ่ป๊อก ที่มีผู้เล่น = จำนวนตัวเลขที่ใส่ในวงเล็บ
        p.setJaoIsPok9();           //ทำให้เจ้ามือได้ไพ่ป๊อก 9
        p.play();                   //เริ่มเล่นเกม
    }
}
