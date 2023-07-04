package py2020;

public class Q2 {
    public static void main(String[] args){
        Q2GenericQueue<String> q = new Q2GenericQueue<String>(10);
        q.enqueue("Dom T");
        q.enqueue("Rafa N");
        q.enqueueMany("Roger F,Daniil M,Novak D,Alex Z,Stef T,Karen K");
        q.display();
        q.dequeue();
        q.enqueue("Matt B");
        q.enqueue("Kei N");
        q.display();
        q.dequeueAll();
        q.display();
        System.out.println("--------------------------------------------");
        
        Q2GenericQueue<Integer> q2 = new Q2GenericQueue<Integer>(10);
        q2.enqueue(10);
        q2.enqueue(20);
        q2.enqueueMany("30,40,50,60,70,80,90");
        q2.display();
        q2.changeOrder(5);
        q2.display();
    }
}
