package Project;

import java.awt.*;

public class Watts implements Algorithms{
    int totalNodes;
    int nearestConnected;
    float probRewire;
    private Graph graph;

    public Watts() {
        graph = new Graph();
    }

    public int getTotalNodes() {
        return totalNodes;
    }

    public void setTotalNodes(int totalNodes) {
        if (totalNodes <3 ){
            System.out.println("Total Nodes must be at least 3");
        }
        else{
            this.totalNodes = totalNodes;
        }
    }

    public float getProbRewire() {
        return probRewire;
    }

    public void setProbRewire(float probRewire) {
        if (probRewire > 0.0 || probRewire < 1.0)
        {
            System.out.println("Invalid ProbalityRewire");
        }
        else{
            this.probRewire = probRewire;
        }
    }

    public int getNearestConnected() {
        return nearestConnected;
    }

    public void setNearestConnected(int nearestConnected) {
        if (nearestConnected%2 != 0){
            System.out.println("nearestConnected must be even");
        }
        else if (nearestConnected < 1){
            System.out.println("nearestConnected must be positive");
        }
        else if (nearestConnected > totalNodes-2 + (totalNodes%2))
        {
            System.out.println("Invalid nearestConnecteed");
        }
        else{
            this.nearestConnected = nearestConnected;
        }
    }


    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }



    @Override
    public void addNode() {
        if (totalNodes < 1){
            System.out.println("totalNodes must be positive");
        }
        else{
            for (int i = 0; i < this.totalNodes; i++) {
                Node node = new Node(i,1);
                this.graph.addVertex(node);
            }
        }
    }

    @Override
    public void createGraph() {

    }
}
