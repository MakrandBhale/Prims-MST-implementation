import java.util.ArrayList;

class Vertex {
    private String name;
    private ArrayList<Edge> edges = new ArrayList<>();
    private boolean isVisited = false;

    Vertex(String name){
        this.name = name;
    }

    String getName(){
        return name;
    }

    void addEdge(Vertex v, int weight){
        this.edges.add(new Edge(this, v, weight));
    }

    ArrayList<Edge> getEdges(){
        return edges;
    }

    boolean isVisited() {
        return isVisited;
    }

    void setVisited() {
        /*It can only be set to visited once and hence this setter method has no parameter.*/
        isVisited = true;
    }

}
