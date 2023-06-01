import java.util.ArrayList;

public class RoutingGraph <T extends Comparable<T>, N extends Comparable<N>, D extends Comparable<D>>{
    Vertex<T,N,D> head = null;
    int size = 0;

    public int getSize(){
        return size;
    }

    public boolean hasVertex(T v){
        if (head==null)
            return false; 
        Vertex<T,N,D> temp = head;
        while (temp!=null){
            if (temp.vertexInfo.compareTo(v)==0)
                return true;
            temp = temp.nextVertex;
        }
        return false;
    }

    public boolean addVertex(T v){
        if (hasVertex(v)==false){
            Vertex<T,N,D> temp = head;
            Vertex<T,N,D> newVertex = new Vertex<>(v,null);
            if (head==null)
                head = newVertex;
            else {
                Vertex<T,N,D> previous = head;
                while (temp!=null){
                    previous=temp;
                    temp=temp.nextVertex;
                }
                previous.nextVertex=newVertex;
            }
            size++;
            return true;
        }
        else return false;
    }

    public T getVertex(int pos){
        if (pos>size-1 || pos<0)
            return null;
        Vertex<T,N,D> temp = head;
        for (int i=0; i<pos; i++)
            temp = temp.nextVertex;
        return temp.vertexInfo;
    }

    public boolean hasEdge(T source, T destination){
        if (head==null)
            return false;
        if (!hasVertex(source)||!hasVertex(destination))
            return false;
        Vertex<T,N,D> sourceVertex = head;
        while (sourceVertex!=null){
            if (sourceVertex.vertexInfo.compareTo(source)==0){
                Edge<T,N,D> currentEdge = sourceVertex.firstEdge;
                while (currentEdge!=null){
                    if (currentEdge.toVertex.vertexInfo.compareTo(destination)==0)
                        return true;
                    currentEdge = currentEdge.nextEdge;
                }
            }
            sourceVertex = sourceVertex.nextVertex;
        }
        return false;
    }

    public boolean addDirectedEdge(T source, T destination, N speed, D distance){
        if (head==null)
            return false;
        if (!hasVertex(source)||!hasVertex(destination))
            return false;
        Vertex<T,N,D> sourceVertex = head;
        while (sourceVertex!=null){
            if (sourceVertex.vertexInfo.compareTo(source)==0){
                Vertex<T,N,D> destinationVertex = head;
                while (destinationVertex!=null){
                    if (destinationVertex.vertexInfo.compareTo(destination)==0){
                        Edge<T,N,D> currentEdge = sourceVertex.firstEdge;
                        Edge<T,N,D> newEdge = new Edge<>(destinationVertex,speed,distance,currentEdge);
                        sourceVertex.firstEdge = newEdge;
                        sourceVertex.outdeg++;
                        destinationVertex.indeg++;
                        return true;
                    }
                    destinationVertex = destinationVertex.nextVertex;
                }
            }
            sourceVertex = sourceVertex.nextVertex;
        }
        return false;
    }

    public boolean addUndirectedEdge(T v1, T v2, N speed, D distance){
        return (addDirectedEdge(v1,v2,speed,distance) && addDirectedEdge(v2,v1,speed,distance));
    }

    public ArrayList<T> getNeighbours(T v){
        if (!hasVertex(v))
            return null;
        ArrayList<T> neighbours = new ArrayList<>();
        Vertex<T,N,D> temp = head;
        while (temp!=null){
            if (temp.vertexInfo.compareTo(v)==0){
                Edge<T,N,D> currentEdge = temp.firstEdge;
                while (currentEdge!=null){
                    neighbours.add(currentEdge.toVertex.vertexInfo);
                    currentEdge = currentEdge.nextEdge;
                }
            }
            temp = temp.nextVertex;
        }
        return neighbours;
    }

    public Edge<T,N,D> getEdge(T currentVertex, T nextVertex){
        Vertex<T,N,D> source = head;
        while (source!=null) {
            if (source.vertexInfo.compareTo(currentVertex) == 0) {
                Edge<T,N,D> currentEdge = source.firstEdge;
                while (currentEdge!=null) {
                    if (currentEdge.toVertex.vertexInfo.compareTo(nextVertex) == 0)
                        return currentEdge;
                    currentEdge = currentEdge.nextEdge;
                }
            }
            source = source.nextVertex;
        }
        return null;
    }

    public void printEdges() {
        Vertex<T,N,D> temp = head;
        while (temp != null) {
            System.out.print("# " + temp.vertexInfo + " : ");
            Edge<T,N,D> currentEdge = temp.firstEdge;
            while (currentEdge != null) {
                System.out.print("[" + temp.vertexInfo + "," + currentEdge.toVertex.vertexInfo + "(speed="+currentEdge.speed+" , distance="+currentEdge.distance+")] ");
                currentEdge = currentEdge.nextEdge;
            }
            System.out.println();
            temp = temp.nextVertex;
        }
    }


}
