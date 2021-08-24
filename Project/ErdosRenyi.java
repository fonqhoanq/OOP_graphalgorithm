package Project;

import java.util.Scanner;

public class ErdosRenyi implements Algorithms {
//    Graph graph; = new Graph();
    
    private Graph graph;
    private int totalNodes;
    private float prob;

    public ErdosRenyi() {
        graph = new Graph();
    }

    public int getTotalNodes() {
        return totalNodes;
    }

    public void setTotalNodes(int totalNodes) {
        this.totalNodes = totalNodes;
    }

    public float getProb() {
        return prob;
    }

    public void setProb(float prob) {
        if (prob < 0.0 || prob > 1.0){
            System.out.println("invalid probality");
        }
        else{
            this.prob = prob;
        }
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    @Override
    public void addNode(){
        if (totalNodes < 1){
            System.out.println("totalNodes must be positive");
        }
        else{
            for (int i = 0; i < this.totalNodes; i++) {
                Node node = new Node(i,this.prob);
                this.graph.addVertex(node);
            }
        }
    }

    @Override
    public void createGraph(){
        for (int i = 0; i <graph.getVertexCount() ; i++) {
            Node start= graph.findByName(i);
            for (int j = 0; j < graph.getVertexCount() ; j++) {
                Node source = graph.findByName(j);
                if (i != j && !graph.hasEdge(start,source)){
                    graph.addEdge(start,source);
                }
            }
        }
    }
}
