package dsa_assignment;

public class Node {
    double key;
    String b_name;
    String f_name;
    String s_name;
    Node leftChild;
    Node rightChild;

    public Node(double key, String b_name, String f_name, String s_name) {
        this.key = key;
        this.b_name = b_name;
        this.f_name = f_name;
        this.s_name = s_name;
    }

    @Override
    public String toString() {
        String k = String.valueOf(key);
        k =k.substring(0, 14);
        return "ISBN :" + k+ "  Book :" + b_name + " by " + f_name + " " + s_name;
    }
}
