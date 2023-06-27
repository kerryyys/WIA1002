package queue;

import java.util.*;
import java.io.*;

public class L6Q2 {
    public static void main(String[] args) {
        read();
    }

    public static void read() {
        try (BufferedReader reader = new BufferedReader(new FileReader("gile.txt"))) {
//can use HashMap direct add in all
            Queue<String> P03 = new LinkedList<>();
            Queue<String> P02 = new LinkedList<>();
            Queue<String> P06 = new LinkedList<>();
            Queue<String> P04 = new LinkedList<>();
            Queue<String> queue = new LinkedList<>();

            String line = "";

            line = reader.readLine();
            String[] type = line.split(" ");
            int count = 0;
            for (int i = 0; i < type.length; i = i + 2) {
                if (type[i].charAt(0) == ('P') && !queue.contains(type[i])) {
                    queue.offer(type[i]);
                }
                switch(type[i]){
                    case "P03":
                        P03.offer(type[i+1]);
                        break;

                      case "P02":
                        P02.offer(type[i+1]);
                        break;
                        
                        case "P04":
                        P04.offer(type[i+1]);
                        break;

                        case "P06":
                        P06.offer(type[i+1]);
                        break;
                }
            }

            System.out.println("Product Code in Queue: ");
            while (!queue.isEmpty()) {
                System.out.print(queue.poll() + " --> ");
            }

            System.out.println("\nProduct P03 : ");
            while (!P03.isEmpty()) {
                System.out.print(P03.poll() + " --> ");
            }

            System.out.println("\nProduct P02 : ");
            while (!P02.isEmpty()) {
                System.out.print(P02.poll() + " --> ");
            }

            System.out.println("\nProduct P04 : ");
            while (!P04.isEmpty()) {
                System.out.print(P04.poll() + " --> ");
            }

            System.out.println("\nProduct P06 : ");
            while (!P06.isEmpty()) {
                System.out.print(P06.poll() + " --> ");
            }
        }

        catch (

        IOException e) {
            System.out.println("File not exist");
        }
    }
}
