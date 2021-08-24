package RandomNetwork;

public class Main {
    public static void main(String[] args) {
//        Network network = new Network();
//        for (int i=0;i<5;i++){
//            Node node = new Node(i, 1);
//            network.addNode(node);
//        }
//        for (int i=0;i<5;i++){
//            for (int j = 0; j < 5; j++) {
//                System.out.println(i +"-"+j);
//                Edge edge= new Edge(network.findById(i),network.findById(j));
//                network.addEdge(edge);
//            }
//        }
//        System.out.println(network.countEdges());
//        network.removeEdge(new Edge(new Node(0),new Node(1)));
//        System.out.println(network.countEdges());
//        System.out.println(network.toString());\

        //RandomNetwork
//        Network network = new Network();
//        RandomNetwork randomNetwork = new RandomNetwork(network);
//        randomNetwork.setTotalNodes(5);
//        randomNetwork.setProb(0.5);
//        randomNetwork.createNode();
//        randomNetwork.createEdge();
//        System.out.println(randomNetwork.getNetwork().toString());

        //SmallWorldNetwork
        Network network1 = new Network();
        SmallWorldNetwork smallWorldNetwork = new SmallWorldNetwork(network1);
        smallWorldNetwork.setTotalNodes(5);
        smallWorldNetwork.setNeighborNodes(1);
        smallWorldNetwork.createNode();
        smallWorldNetwork.createEdge();
        System.out.println(smallWorldNetwork.getNetwork().toString());
        smallWorldNetwork.setProbRewire(0.5);
        smallWorldNetwork.rewireEdge();
        System.out.println(smallWorldNetwork.getNetwork().toString());
    }
}
