class Edge implements Comparable<Edge>{
    private Vertex source;
    private Vertex dest;
    private int weight;
    Edge(Vertex source, Vertex dest, int weight){
        this.dest = dest;
        this.weight = weight;
        this.source = source;
    }

    Vertex getSource() {
        return source;
    }

    Vertex getDest(){
        return dest;
    }

    int getWeight(){
        return weight;
    }

    @Override
    public int compareTo(Edge e){
        return this.getWeight() - e.getWeight();
    }
}
