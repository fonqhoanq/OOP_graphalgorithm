package FinalOOP.model.algorithms;

import FinalOOP.model.network.Edge;
import FinalOOP.model.network.Network;
import FinalOOP.model.network.Node;

import java.util.*;

public class ScaleFreeNW implements Algorithms {
    private Network network;
    private int totalNodes;
    private int startNode;
    private int startEdge;

    public ScaleFreeNW(Network network) {
        this.network = network;
    }

    public ScaleFreeNW(Network network, int totalNodes,int startNode, int startEdge) {
        this.network = network;
        this.totalNodes = totalNodes;
        this.startNode = startNode;
        this.startEdge = startEdge;
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public int getTotalNodes() {
        return totalNodes;
    }

    public void setTotalNodes(int totalNodes) {
        this.totalNodes = totalNodes;
    }

    public int getStartNode() {
        return startNode;
    }

    public void setStartNode(int startNode) {
        this.startNode = startNode;
    }

    public int getStartEdge() {
        return startEdge;
    }

    public void setStartEdge(int startEdge) {
        this.startEdge = startEdge;
    }

    @Override
    public void createEdge() {
//        for (int i = 0; i <3 ; i++) {
//            for (int j = 0; j <3 ; j++) {
//                this.network.addEdge(new Edge(this.getNetwork().findById(i),this.getNetwork().findById(j)));
//            }
//        }
        ArrayList<Integer> list = new ArrayList<>();
//        for (int i=0;i<startNode;i++){
//            for (int j=i;j<startNode;j++){
//
//            }
//        }
        this.network.addEdge(new Edge(this.getNetwork().findById(0),this.getNetwork().findById(1)));
        this.network.addEdge(new Edge(this.getNetwork().findById(0),this.getNetwork().findById(2)));
        list.add(0);list.add(0);list.add(1);list.add(2);

        for (int i =3;i<totalNodes;i++){
            this.network.addNode(new Node(i));
            int check = 1;
//            for (int j = i-1 ; j >= 0;j--){
//                Random random = new Random();
//                int prob = random.nextInt(list.size());
//                double prob_temp = (double) this.network.countEdgesofNode(this.network.findById(j))/(double)this.network.totalEdges();
//                System.out.println(prob + "-" + prob_temp);
//                if (prob < prob_temp){
//                    this.network.addEdge(new Edge(this.network.findById(i),this.network.findById(j)));
//                }
            do{
                int index;
                do{
                    Random random = new Random();
                    index = random.nextInt(list.size());
                }while (this.network.findEdgebyId(i,list.get(index)) != null || list.get(index) == i);
                System.out.println("node: "+i +"-value: "+ list.get(index) +"-index: " + index);
                this.network.addEdge(new Edge(this.network.findById(i),this.network.findById(list.get(index))));
                list.add(i);
                list.add(list.get(index));
                for (int j=0;j<list.size();j++){
                    System.out.print(list.get(j) +" - ");
                }
                System.out.println();
                System.out.println("check :" + check);
                check++;
            }while (check <= this.startEdge);
        }
    }

    @Override
    public void buildNetwork() {
        for (int i = 0; i <3 ; i++){
            this.network.addNode(new Node(i));
        }
        createEdge();
    }

}

