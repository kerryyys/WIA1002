public class Data<T extends Comparable<T>> implements Comparable<Data<T>>{
    private String user;
    private T data;
    private int date;

    Data(String user, T data, int date){
        this.user=user;
        this.data=data;
        this.date=date;
    }
    public int compareTo(T other){
        if(data.compareTo(other)>0){
            return 1;
        }
        else{
            return -1;
        }
    }
    /*
    public int compareTo(T other){return data.compareTo(other);}
     */
    public int compareTo(Data<T> o) {
        return date - o.date;
    }
    public void setData(T data){
        this.data=data;
    }
    public String getUser(){
        return user;
    }
    public T getData(){
        return data;
    }
    public int getDate(){
        return date;
    }

}
