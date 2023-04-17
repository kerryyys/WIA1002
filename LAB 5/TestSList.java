public class TestSList {
    public static void main(String[] args) {
        SList<String> list= new SList<>();

        //Append the following values individually: “Linked list, is, easy.”
        list.appendEnd("Linked");
        list.appendEnd("list");
        list.appendEnd(",");
        list.appendEnd("is");
        list.appendEnd("easy");
        list.appendEnd(".");

        //Display these values.
        list.display();

        //Remove the word “Linked list” and display the removed value.
        list.removeInitial();
        list.removeInitial();
        list.removeInitial();
        list.display();

        //Check if ‘difficult’ is in the list.
        System.out.println("Contain difficult?\n"+ (list.contain("difficult")?"yes":"no"));
        

        //Clear the list.
        list.clear();
        list.display();
    }
}
