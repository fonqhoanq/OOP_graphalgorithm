package FinalOOP.model.algorithms;

import FinalOOP.model.network.Edge;
import FinalOOP.model.network.Network;
import FinalOOP.model.network.Node;

import java.util.Random;

public class RandomNW implements Algorithms {

    private Network network;
    private int totalNodes;
    private double probality;

    public RandomNW(Network network) {
        this.network = network;
    }

    public RandomNW(Network network, int totalNodes, double probality) {
        this.network = network;
        this.totalNodes = totalNodes;
        this.probality = probality;
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

    public double getProbality() {
        return probality;
    }

    public void setProbality(double probality) {
        this.probality = probality;
    }

    @Override
    public void createEdge() {
        if (this.probality == 0){
            System.out.println("connect's probality = 0");
            return;
        }
        for (int i=0;i<totalNodes;i++){
            for (int j=0;j<totalNodes;j++){
                if (this.probality == 1){
                    network.addEdge(new Edge(this.network.findById(i),this.network.findById(j)));
                }
                else if(this.probality >0 && this.probality < 1){
                    Random random = new Random();
                    if(random.nextDouble() < this.probality){
                        network.addEdge(new Edge(this.network.findById(i),this.network.findById(j)));
                    }
                }
            }
        }
    }

    @Override
    public void buildNetwork() {
        for (int i=0;i<totalNodes;i++){
            network.addNode(new Node(i));
        }
        createEdge();
        System.out.println("Build Success");
    }
}
