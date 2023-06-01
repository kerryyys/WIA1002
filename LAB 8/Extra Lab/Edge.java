public class Edge<T extends Comparable<T>, N extends Comparable<N>, D extends Comparable<D>>{
    Vertex<T,N,D> toVertex;
    N speed;
    D distance;
    Edge<T,N,D> nextEdge;

    public Edge(){
        toVertex=null;
        speed=null;
        distance=null;
        nextEdge=null;
    }

    public Edge(Vertex<T,N,D> destination, N speed, D distance, Edge<T,N,D> next){
        toVertex=destination;
        this.speed=speed;
        this.distance=distance;
        nextEdge=next;
    }
}
