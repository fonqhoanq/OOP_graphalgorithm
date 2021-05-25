package FinalOOP;

import java.util.Random;

public class ScaleFreeNW implements Algorithms{
    private Network network;
    private int totalNodes;

    public ScaleFreeNW(Network network) {
        this.network = network;
    }

    public ScaleFreeNW(Network network, int totalNodes) {
        this.network = network;
        this.totalNodes = totalNodes;
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

    @Override
    public void createEdge() {
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j <3 ; j++) {
                this.network.addEdge(new Edge(this.getNetwork().findById(i),this.getNetwork().findById(j)));
            }
        }
        for (int i =3;i<totalNodes;i++){
            this.network.addNode(new Node(i));
            for (int j = i-1 ; j >= 0;j--){
                Random random = new Random();
                double prob = random.nextDouble();
                double prob_temp = (double) this.network.countEdgesofNode(this.network.findById(j))/(double)this.network.totalEdges();
                System.out.println(prob + "-" + prob_temp);
                if (prob < prob_temp){
                    this.network.addEdge(new Edge(this.network.findById(i),this.network.findById(j)));
                }
            }
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
