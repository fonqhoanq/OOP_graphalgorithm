package RandomNetwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Network {
    private List<Node> nodeList;
    private List<List<Edge>> edgesList;

    public Network() {
        this.nodeList = new ArrayList<>();
        this.edgesList = new ArrayList<>();
    }

    public Network(List<Node> nodeList, List<List<Edge>> edgesList) {
        this.nodeList = nodeList;
        this.edgesList = edgesList;
    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }

    public List<List<Edge>> getEdgesList() {
        return edgesList;
    }

    public void setEdgesList(List<List<Edge>> edgesList) {
        this.edgesList = edgesList;
    }


    public void addNode(Node node) {
        if (node == null) return;
        this.nodeList.add(node);
        this.edgesList.add(new ArrayList<>());
    }

    //    Node: 1-List<Edge>,2,3,4,5
    public boolean hasEdge(Edge edge) {
        for (Edge edge1 : this.edgesList.get(edge.getStart().getId())) {
            if (edge1.getDestination().getId() == edge.getDestination().getId()) {
                return true;
            }
        }
        return false;
    }

    public void addEdge(Edge edge) {
        if (edge.getStart().getId() < 0 || edge.getStart().getId() >= this.edgesList.size()
                || edge.getDestination().getId() < 0 || edge.getDestination().getId() >= this.edgesList.size()) {
            System.out.println("error1");
            return;
        }
        if (edge.getDestination().getId() == edge.getStart().getId()) {
            System.out.println("error2");
            return;
        }
        if (this.hasEdge(edge)) {
            System.out.println("existed edge!!");
            return;
        }
        if (edge.getDestination().getProb() == 1) {
//            System.out.println("1");
            this.edgesList.get(edge.getStart().getId()).add(edge);
            this.edgesList.get(edge.getDestination().getId()).add(new Edge(edge.getDestination(), edge.getStart()));
            System.out.println("add1");
//            for (Edge edge1 : this.edgesList.get(edge.getStart().getId())) {
//                System.out.println(edge1.getStart().getId() + "//" + edge1.getDestination().getId());
//            }
        } else if (edge.getDestination().getProb() > 0 && edge.getDestination().getProb() < 1) {
            Random random = new Random();
            double prob = random.nextDouble();
            if (prob >= edge.getDestination().getProb()) {
                this.edgesList.get(edge.getStart().getId()).add(edge);
                this.edgesList.get(edge.getDestination().getId()).add(new Edge(edge.getDestination(), edge.getStart()));
                System.out.println("Add");
            } else {
                System.out.println("Not add");
            }
        } else if (edge.getDestination().getProb() == 0) {
            System.out.println(edge.getStart().getId() + "---" + edge.getDestination().getId());
            System.out.println("destination's probality = 0");
        }
    }

    public Node findById(int i) {
        for (Node node : nodeList) {
            if (node.getId() == i) {
                return node;
            }
        }
        System.out.println("Node not existed!!");
        return null;
    }

    public void removeEdge(Edge edge) {
        int check = 0;
        for (Edge edge1 : this.edgesList.get(edge.getStart().getId())) {
            if (edge1.getDestination().getId() == edge.getDestination().getId()) {
                this.edgesList.get(edge.getStart().getId()).remove(edge1);

                break;
            }
        }
        for (Edge edge2 : this.edgesList.get(edge.getDestination().getId())) {
            if (edge2.getDestination().getId() == edge.getStart().getId()) {
                this.edgesList.get(edge.getDestination().getId()).remove(edge2);
                System.out.println("remove success!!");
                check =1 ;
                break;
            }
        }
        if (check == 0 ){
            System.out.println("Remove failed");
        }
    }

    public int countNodes() {
        return this.nodeList.size();
    }

    public int countEdges() {
        int count = 0;
        for (Node node : nodeList) {
            count += this.edgesList.get(node.getId()).size();
        }
        return count / 2;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Node node : this.nodeList) {
            stringBuilder.append(node.toString()).append(":");
            for (Edge edge : edgesList.get(node.getId())) {
                stringBuilder.append(edge.getDestination().toString()).append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

}
