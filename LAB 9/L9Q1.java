/*Create a recursive function that accepts a String parameter, and substitute any of the
lowercase “a” (no applicable for uppercase "A") found with “i” char. Example:
substituteAI ("flabbergasted ") → "flibbergisted "
substituteAI ("Astronaut ") → " Astroniut" */
package LAB9;
import java.util.Scanner;
public class L9Q1 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = sc.nextLine();
        
        System.out.println("Replace a with i: " + replacement(str));
    }

    public static String replacement(String a){
         // Base Case
         if (a.isEmpty()) return "";

         //Recursion
        if(a.charAt(0)=='a'){
            return 'i' + replacement(a.substring(1));
        }
        else{
            return a.charAt(0) + replacement(a.substring(1));
        }
    }
}
