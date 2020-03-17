import java.util.ArrayList;
import java.util.Collections;

class Graph {
    //private ArrayList<Vertex> vertices = new ArrayList<>();
    private ArrayList<Edge> allEdgeList = new ArrayList<>();
    private ArrayList<Edge> mstTree = new ArrayList<>();

    private int mstWeight = 0;
    Vertex createVertex(String name){
        return new Vertex(name);
        //vertices.add(v);
        //return v;
    }

    void addEdge(Vertex source, Vertex dest, int weight){
        source.addEdge(dest, weight);
    }

    void addEdge(Vertex source, Vertex dest, int weight, boolean isBidirectional){
        // if biDirectional is true, then both source and destination vertices will get an edge with same weight,
        // to add different weight, call addEdge(source, dest, weight) function (twice).
        if (isBidirectional) {
            addEdge(dest, source, weight);
        }
        addEdge(source, dest, weight);
    }


    void start(Vertex v){
        //traverse(v);
        stream(v);
        printMST(v);
    }

    private void stream(Vertex v){
        v.setVisited();
        addAdjToList(v);
        Edge minEdge = pickMinEdgeVertex();
        if(minEdge == null) {
            return;
        }
        //v.setMstEdge(minEdge);
        mstTree.add(minEdge);
        allEdgeList.remove(minEdge);

        stream(minEdge.getDest());
    }

    private Edge pickMinEdgeVertex(){
        /*make sure to check visited dest*/
        Collections.sort(allEdgeList);
        for(Edge e : allEdgeList){
            if(!e.getDest().isVisited()){
                return e;
            }
        }
        return null;
    }
    private void addAdjToList(Vertex v){
        ArrayList<Edge> neighbours = v.getEdges();
        for(Edge e : neighbours){
            if(!e.getDest().isVisited()){
                allEdgeList.add(e);
            }
        }
    }

    private void printMST(Vertex v){
        print("Source node is V(" + v.getName() + ")");
        print("Edge\tWeight");
        for(Edge edge: mstTree){
            print(edge.getSource().getName() + "--" + edge.getDest().getName() + "\t" + edge.getWeight());
            mstWeight = mstWeight + edge.getWeight();
        }
        print("Total weight of MST is " + mstWeight);
    }


    private void print(String msg){
        System.out.println(msg);
    }
}
