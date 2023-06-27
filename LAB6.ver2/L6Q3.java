package queue;

import java.util.*;

public class L6Q3 {

    public static void main(String[] args) {
        Colour game = new Colour();
        String player1 = "";
        String player2 = "";
        Queue<String> player11 = new LinkedList<>();
        Queue<String> player22 = new LinkedList<>();
        int score1 = 0;
        int score2 = 0;
        int count = 0;
        
        while(count <5){ //must not same
            do{
            player1 = (Colour.getCard());
            player2 = (Colour.getCard());
            }while(player11.contains(player1) && player22.contains(player2));
            
            if(Colour.getNumber(player1) > Colour.getNumber(player2)){
                score1++;
            }else if(Colour.getNumber(player1) < Colour.getNumber(player2)){
                score2++;
            }else{
                if(Colour.getColour(player1) > Colour.getColour(player2)){
                    score1++;
                }
                else{
                    score2++;
                }
            }
                
                player11.offer(player1);
                player22.offer(player2);
                
                count++;
        }
        
        System.out.println("Player 1 Card");
        while(!player11.isEmpty()){
        System.out.print(player11.poll() + " --> ");
        }
        
        System.out.println("\nPlayer 2 Card");
        while(!player22.isEmpty()){
        System.out.print(player22.poll() + " --> ");
        }
        
        System.out.println("\nPlayer 1 Score: "+ score1);
        System.out.println("Player 2 Score: " + score2);
        if(score1 > score2){
            System.out.println("Player 1 WIN!");
        }else{
            System.out.println("Player 2 WIN!");
        }
    }

    public static class Colour {

        static LinkedList<String> colour = new LinkedList<>();
        static LinkedList<String> number = new LinkedList<>();
        static Random rand = new Random();
       

        public Colour() {
            colour.add("Blue");
            colour.add("Green");
            colour.add("Red");
            colour.add("Yellow");
            
            number.add("One");
            number.add("Two");
            number.add("Three");
            number.add("Four");
            number.add("Five");
            number.add("Six");
            number.add("Seven");
            number.add("Eight");
            number.add("Nine");
            
        }

        public static int getColour(String cardColour) {
            String[] colour = cardColour.split(" ");
            switch(colour[1]){
                case "Blue":
                    return 4;
                    
                case "Green":
                    return 3;
                    
                case "Red":
                    return 2;
                    
                case "Yellow":
                    return 1;    
            }
            return 0;
        }
        
        public static int getNumber(String cardNumber){
            String[] number = cardNumber.split(" ");
            switch(number[0]){
                case "One":
                    return 1;
                    
                case "Two":
                    return 2;
                    
                case "Three":
                    return 3;
                    
                case "Four":
                    return 4;
                    
                case "Five":
                    return 5;
                    
                case "Six":
                    return 6;
                    
                case "Seven":
                    return 7;
                    
                case "Eight":
                    return 8;
                    
               case "Nine":
                    return 9;
            }
            return 0;
        }
        
        public static String getCard(){
            return number.get(rand.nextInt(9)) + " " + colour.get(rand.nextInt(4));
        }

    }
}
