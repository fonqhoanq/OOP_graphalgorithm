package Project;

public class Main {
    public static void main(String[] args) {
        ErdosRenyi erdosRenyi = new ErdosRenyi();
        erdosRenyi.addNode();
        erdosRenyi.createGraph();
        erdosRenyi.getGraph().removeEdge(erdosRenyi.getGraph().findByName(1),erdosRenyi.getGraph().findByName(2));
        System.out.println(erdosRenyi.getGraph().toString());

    }
}
