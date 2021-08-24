package FinalOOP;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        Network network = new Network();
//        for (int i = 0; i < 5; i++) {
//            Node node = new Node(i);
//            network.addNode(node);
//        }
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                Edge edge = new Edge(network.findById(i), network.findById(j));
//                network.addEdge(edge);
//                System.out.println(i+"-"+j);
//                System.out.println(edge.getProbality());
//            }
//        }
//        network.removeEdge(new Edge(network.findById(0), network.findById(1)));
//        System.out.println(network.toString());

//        Network network = new Network();
//        RandomNW randomNW = new RandomNW(network, 6, 0);
//        randomNW.buildNetwork();
//        System.out.println(randomNW.getNetwork().toString());

//        Network network = new Network();
//        SmallWorldNW smallWorldNW = new SmallWorldNW(network, 6, 1, 2);
//        System.out.println(smallWorldNW.getNetwork().toString());
//        smallWorldNW.rewireEdge();
//        smallWorldNW.buildNetwork();
//        System.out.println(smallWorldNW.getNetwork().toString());

        Network network = new Network();
        ScaleFreeNW scaleFreeNW = new ScaleFreeNW(network,50);
        scaleFreeNW.buildNetwork();
        System.out.println(scaleFreeNW.getNetwork().toString());


    }
}
