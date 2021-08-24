package Project;

import java.util.ArrayList;

public class Node{
    private int node;
    private float prob;
//    private ArrayList<Integer> connections;

    public Node(){

    }

    public Node(int node) {
        this.node = node;
    }

    public Node(int node, float prob) {
        this.node = node;
        this.prob = prob;
    }

    public int getNode() {
        return node;
    }

    public void setNode(int node) {
        this.node = node;
    }

    public float getProb() {
        return prob;
    }

    public void setProb(float prob) {
        this.prob = prob;
    }

//    public ArrayList<Integer> getConnections() {
//        return connections;
//    }
//
//    public void setConnections(ArrayList<Integer> connections) {
//        this.connections = connections;
//    }

    public String toString(){
        Integer i = this.node;
        return i.toString();
    }
}
