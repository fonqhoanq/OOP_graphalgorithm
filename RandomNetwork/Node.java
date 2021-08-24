package RandomNetwork;

public class Node {
    private int id;
    private double prob;

    public Node() {
    }

    public Node(int id) {
        this.id = id;
    }

    public Node(int id, double prob) {
        this.id = id;
        this.prob = prob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getProb() {
        return prob;
    }

    public void setProb(double prob) {
        this.prob = prob;
    }

    public String toString(){
        Integer i = this.id;
        return i.toString();
    }
}
