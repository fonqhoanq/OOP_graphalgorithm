package FinalOOP.model.network;

public class Node {
    private int id;

    public Node(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString(){
        Integer i = this.id;
        return i.toString();
    }
}
