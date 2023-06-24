package LinkedList;
/*Create a StarList Game. Each player will take turns to roll a dice. The first players that reach more than 20 stars in the lists win the game. */
import java.util.Random;
public class StarList {
    static LinkedList<String> player1 = new LinkedList<>();
    static LinkedList<String> player2 = new LinkedList<>();
    static Random rand = new Random();
    static int size1 = 0;
    static int size2 = 0;
    public static void main(String [] args){
        System.out.println("Player 2 start first");
        while(size1<20 && size2<20){
            player2 = starDice2(player2);
            System.out.print("Player 2: ");
            for(int i=0;i<size2;i++){
            System.out.print(player2.get(i));
            }
            player1 = starDice1(player1);
            System.out.print("\nPlayer 1: ");
            for(int i=0;i<size1;i++){
            System.out.print(player1.get(i));
            }
            System.out.println();
        }
        if(size1>20){
            System.out.println("Player 1 win the game");
        }else if(size2 >20){
            System.out.println("Player 2 win the game");
        }
    }

    public static LinkedList<String> starDice1(LinkedList<String> list1){
        int star = rand.nextInt(7);
        size1+=star;
        
        for(int i=0;i<star;i++){
        list1.addLast("* --> ");
        }
        return list1;
    }

    public static LinkedList<String> starDice2(LinkedList<String> list2){
        int star = rand.nextInt(7);
        size2+=star;
        
        for(int i=0;i<star;i++){
        list2.addLast("* --> ");
        }
        return list2;
    }
}
