public class Vertex<T extends Comparable<T>, N extends Comparable<N>, D extends Comparable<D>> {
    T vertexInfo;
    int indeg, outdeg;
    Vertex<T,N,D> nextVertex;
    Edge<T,N,D> firstEdge;

    public Vertex(){
        vertexInfo=null;
        indeg=0;
        outdeg=0;
        nextVertex=null;
        firstEdge=null;
    }

    public Vertex(T vInfo, Vertex<T,N,D> next){
        vertexInfo=vInfo;
        indeg=0;
        outdeg=0;
        nextVertex=next;
        firstEdge=null;
    }
}
