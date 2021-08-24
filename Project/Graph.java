package Project;

import java.util.*;

public class Graph {
//    private Map<Node, List<Node>> graph = new HashMap<>();

//    public Map<Node, List<Node>> getGraph() {
//        return graph;
//    }
//
//    public void setGraph(Map<Node, List<Node>> graph) {
//        this.graph = graph;
//    }
    private Map<Node, List<Node>> graph;

    public Graph() {
        graph = new HashMap<>();
    }

    public Map<Node, List<Node>> getGraph() {
        return graph;
    }

    public void setGraph(Map<Node, List<Node>> graph) {
        this.graph = graph;
    }

    public void addVertex(Node node){
        graph.put(node,new LinkedList<Node>());
    }

    public void addEdge(Node start, Node destination){
        if (!graph.containsKey(start) || !graph.containsKey(destination)){
            System.out.println("Not existed!!");
        }
        else{
            if (destination.getProb() == 1){
                graph.get(start).add(destination);
                graph.get(destination).add(start);
            }
            else if (destination.getProb() >0 ){
                Random rand = new Random();
                float prob = rand.nextFloat();
                if(prob < destination.getProb()){
                    graph.get(start).add(destination);
                    graph.get(destination).add(start);
                    System.out.println("Add");
                }
                else{
                    System.out.println("Not add");
                }
            }
            else if (destination.getProb() == 0){
                System.out.println("destination's probality = 0");
            }
        }
    }

    public void removeEdge(Node start , Node destination){
        if (!graph.containsKey(start) || !graph.containsKey(destination)){
            System.out.println("Not existed!!");
        }
        else if(start == destination){
            System.out.println("Duplicated");
        }
        else{
            if (graph.get(start).remove(destination)){
//                graph.get(start).remove(destination);
                graph.get(destination).remove(start);
                System.out.println("Removed");
            }
            else{
                System.out.println("Not remove");
            }
        }
    }

    public int getVertexCount()
    {
//        System.out.println("The graph has "
//                + graph.keySet().size()
//                + " vertex");
//        System.out.println("Nodes: " +graph.keySet());
        return graph.keySet().size();
    }

    public int getEdgesCount(){
        int count = 0;
        for (Node v : graph.keySet()) {
            count += graph.get(v).size();
        }
        count = count / 2;
//        System.out.println("The graph has "
//                + count
//                + " edges.");
        return count;
    }

    public boolean hasVertex(Node s)
    {
        if (graph.containsKey(s)) {
//            System.out.println("The graph contains "
//                    + s + " as a vertex.");
            return true;
        }
        else {
//            System.out.println("The graph does not contain "
//                    + s + " as a vertex.");
            return false;
        }
    }

    public boolean hasEdge(Node s, Node d)
    {
        if (graph.get(s).contains(d)) {
//            System.out.println("The graph has an edge between "
//                    + s + " and " + d + ".");
            return true;
        }
        else {
//            System.out.println("The graph has no edge between "
//                    + s + " and " + d + ".");
            return false;
        }
    }

    public Node findByName(int i){
//        Node node = new Node();
        for (Node node: graph.keySet()) {
            if (node.getNode() == i){
                return node;
            }
        }
        return null;
    }

    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        for (Node v : graph.keySet()) {

            builder.append(v.toString() + ": ");
            for (Node w : graph.get(v)) {
                builder.append(w.toString() + " ");
            }
            builder.append("\n");
        }
        return (builder.toString());
    }
}