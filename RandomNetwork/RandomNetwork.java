package RandomNetwork;


public class RandomNetwork implements Algorithms {

    private Network network;
    private int totalNodes;
    private double prob;

    public RandomNetwork() {
    }

    public RandomNetwork(Network network){
        this.network = network;
    }

    public RandomNetwork(Network network, int totalNodes, double prob) {
        this.network = network;
        this.totalNodes = totalNodes;
        this.prob = prob;
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

    public double getProb() {
        return prob;
    }

    public void setProb(double prob) {
        this.prob = prob;
    }

    @Override
    public void createNode() {
        for (int i=0;i<totalNodes;i++){
            Node node = new Node(i,prob);
            network.addNode(node);
        }
    }

    @Override
    public void createEdge() {
        for (int i=0;i<totalNodes;i++){
            for (int j = 0; j < totalNodes; j++) {
//                System.out.println(i +"-"+j);
                Edge edge= new Edge(network.findById(i),network.findById(j));
                network.addEdge(edge);
            }
        }
    }
}
