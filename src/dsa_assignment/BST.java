/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa_assignment;

/**
 *
 * @author Dinish
 */
public class BST {

    Node root;

    //Adding new node 
    public void addNode(int key, String b_name, String f_name, String s_name) {

        Node nodeToAdd = new Node(key, b_name, f_name, s_name);

        if (root == null) {
            root = nodeToAdd;
        } else {
            Node focusNode = root;
            Node parent;

            while (true) {
                parent = focusNode;
                if (key < focusNode.key) {

                    focusNode = focusNode.leftChild;

                    if (focusNode == null) {

                        parent.leftChild = nodeToAdd;
                        return;
                    }
                } else {
                    focusNode = focusNode.rightChild;

                    if (focusNode == null) {

                        parent.rightChild = nodeToAdd;
                        return;
                    }
                }
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("");
    }

}
