package FinalOOP.model.algorithms;

import FinalOOP.model.network.Edge;
import FinalOOP.model.network.Network;
import FinalOOP.model.network.Node;

import java.util.Random;

public class SmallWorldNW implements Algorithms {
    private Network network;
    private int totalNodes;
    private double rewireProbality;
    private int neighborNodes;

    public SmallWorldNW(Network network) {
        this.network = network;
    }

    public SmallWorldNW(Network network, int totalNodes, double rewireProbality, int neighborNodes) {
        this.network = network;
        this.totalNodes = totalNodes;
        this.rewireProbality = rewireProbality;
        this.neighborNodes = neighborNodes;
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

    public double getRewireProbality() {
        return rewireProbality;
    }

    public void setRewireProbality(double rewireProbality) {
        this.rewireProbality = rewireProbality;
    }

    public int getNeighborNodes() {
        return neighborNodes;
    }

    public void setNeighborNodes(int neighborNodes) {
        this.neighborNodes = neighborNodes;
    }

    @Override
    public void createEdge() {
        for (int i=0;i<totalNodes;i++){
            for (int j = 0-this.neighborNodes;j<this.neighborNodes+1;j++){
                int index = i+j;
                if (index < 0){
                    index = totalNodes + index;
                }
                else if (index >= totalNodes){
                    index = index - totalNodes;
                }
                System.out.println(i+"-"+index);
                this.network.addEdge(new Edge(network.findById(i),network.findById(index),0.0));
            }
        }
    }

    @Override
    public void buildNetwork() {
        for (int i=0;i<totalNodes;i++){
            network.addNode(new Node(i));
        }
        createEdge();
//        rewireEdge();
    }

    public void rewireEdge(){
        for(int i=0;i<totalNodes;i++){
            for (int j=i+1;j<(this.neighborNodes + i +1);j++) {
//                System.out.println("kiki: " + i +"---" + num);
//                System.out.println("kaka: " + num +"---" + (this.neighborNodes + i +1));
                int num = j;
                if (num >= totalNodes){
                    num = num - totalNodes;
                }
                Random random = new Random();
                double prob = random.nextDouble();
                if (rewireProbality == 1&& this.network.findEdgebyId(i,num).getProbality() != 1){
                    System.out.println("old: "+i+"-"+num);
                    this.network.removeEdge(this.network.findEdgebyId(i,num));
                    System.out.println("11111");
                    int index;
                    do{
                        index = random.nextInt(totalNodes);
                    }while(index == i || index == num || this.network.findEdgebyId(i,index) != null );
                    this.network.addEdge(new Edge(new Node(i),new Node(index),1.0));
                    System.out.println("new: "+i+"-"+index);
                }
                else if (prob < this.rewireProbality && this.network.findEdgebyId(i,num).getProbality() != 1){
                    System.out.println("old: "+i+"-"+num);
                    this.network.removeEdge(this.network.findEdgebyId(i,num));
                    int index;
                    do{
                        index = random.nextInt(totalNodes);
                    }while(index == i || index == num || this.network.findEdgebyId(i,index) != null );
                    this.network.addEdge(new Edge(new Node(i),new Node(index),1.0));
                    System.out.println("new: "+i+"-"+index);
                }
            }
        }
    }
}
