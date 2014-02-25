package dsa_assignment;

public class Node {
    int key;
    String b_name;
    String f_name;
    String s_name;
    Node leftChild;
    Node rightChild;

    public Node(int key, String b_name, String f_name, String s_name) {
        this.key = key;
        this.b_name = b_name;
        this.f_name = f_name;
        this.s_name = s_name;
    }

    @Override
    public String toString() {
        return "ISBN :" + key + "  Book :" + b_name + " by " + f_name + " " + s_name;
    }
}
