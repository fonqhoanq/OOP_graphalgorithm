package RandomNetwork;

public class Edge{
    private Node start;
    private Node destination;

    public Edge(Node start, Node destination) {
        this.start = start;
        this.destination = destination;
    }

    public Node getStart() {
        return start;
    }

    public void setStart(Node start) {
        this.start = start;
    }

    public Node getDestination() {
        return destination;
    }

    public void setDestination(Node destination) {
        this.destination = destination;
    }

}
