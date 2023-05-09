package LAB7;

public class ComparableBook implements Comparable <ComparableBook> {

    private int ID;
    private String title;

    ComparableBook(int ID, String title){
        this.ID=ID;
        this.title=title;
    }
    public int getID(){
        return ID;
    }
    public String getTitle(){
        return title;
    }
    @Override
    public int compareTo(ComparableBook other){
        return Integer.compare(ID, other.ID);
    }
    @Override
    public String toString(){
        return "(" + ID + " , " + title + ")";
    }
}
