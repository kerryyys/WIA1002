package py2020;

public class Q3 {
    public static void main(String[] args){
        Q3LL myLL = new Q3LL();
        
        myLL.createNode("Loard of The Ring",500);
        myLL.createNode("Tale of the Body Theif",1);
        myLL.createNode("Mumnoch the Devil",100);
        myLL.createNode("Heart of a Samurai",10);
        myLL.display();
        myLL.addAfter("Mumnoch the Devil","While Crane",10);
        myLL.addAfter("While Crane","Menories of a Geisha",90);
        myLL.removeNode("Harry Potter");
        myLL.removeNode("Heart of a Samurai");
        myLL.display();
    }
}
