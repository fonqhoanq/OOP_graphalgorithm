package RandomNetwork;

import java.util.Random;

public class SmallWorldNetwork implements Algorithms{
    private Network network;
    private int totalNodes;
    private double probRewire;
    private int neighborNodes;

    public SmallWorldNetwork(Network network) {
        this.network = network;
    }

    public SmallWorldNetwork(Network network, int totalNodes, double probRewire,int neighborNodes) {
        this.network = network;
        this.totalNodes = totalNodes;
        this.probRewire = probRewire;
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

    public double getProbRewire() {
        return probRewire;
    }

    public void setProbRewire(double probRewire) {
        this.probRewire = probRewire;
    }

    public int getNeighborNodes() {
        return neighborNodes;
    }

    public void setNeighborNodes(int neighborNodes) {
        this.neighborNodes = neighborNodes;
    }

    @Override
    public void createNode() {
        for (int i=0;i<totalNodes;i++){
            Node node = new Node(i,1.0);
            network.addNode(node);
        }
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
//                System.out.println(i +"-"+index);
                network.addEdge(new Edge(network.findById(i),network.findById(index)));
            }
        }
    }

    public void rewireEdge(){
        for (int i=0;i<totalNodes;i++){
            if (this.network.getEdgesList().get(i).size() > 0){
                for (Edge edge: this.network.getEdgesList().get(i)) {
                    Random random = new Random();
                    double prob = random.nextDouble();
                    if (prob < probRewire){
                        network.removeEdge(edge);
                        Random rnd = new Random();
                        int num = rnd.nextInt(totalNodes+1);
                        System.out.println(num);
//                        network.addEdge(new Edge(new Node(edge.getStart().getId())));
                    }
                }
            }
        }
    }

}
