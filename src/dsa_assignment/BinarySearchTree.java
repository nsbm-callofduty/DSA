package dsa_assignment;

public class BinarySearchTree {

    Node root;

    /**
     * This method is used to add new node in to the tree.If the tree have No
     * data then then first input is consider as the root of the tree.Then
     * according to the Key value Node will be place in LEFT or RIGHT side under
     * parent Node
     *
     * @param key Thirteen digits numbers and it is also the ISBN
     * @param b_name Name of the Book
     * @param f_name Author's First name
     * @param s_name Author's Surname
     */
    public void addNode(double key, String b_name, String f_name, String s_name) {

        Node nodeToAdd = new Node(key, b_name, f_name, s_name);

        if (root == null) {
            root = nodeToAdd;
        } else {

            Node tempNode = root;
            Node parent;

            while (true) {
                parent = tempNode;
                if (key < tempNode.key) {

                    tempNode = tempNode.leftChild;

                    if (tempNode == null) {

                        parent.leftChild = nodeToAdd;
                        return;
                    }
                } else {
                    tempNode = tempNode.rightChild;

                    if (tempNode == null) {

                        parent.rightChild = nodeToAdd;
                        return;
                    }
                }
            }
        }
    }

    public boolean deleteByKey(int key) {
        // Start at the top of the tree
        Node focusNode = root;
        Node parent = root;
        // When searching for a Node this will
        // tell us whether to search to the
        // right or left
        boolean isItALeftChild = true;
        // While we haven't found the Node
        // keep looking
        while (focusNode.key != key) {
            parent = focusNode;
            // If we should search to the left
            if (key < focusNode.key) {
                isItALeftChild = true;
                // Shift the focus Node to the left child
                focusNode = focusNode.leftChild;
            } else {
                // Greater than focus node so go to the right
                isItALeftChild = false;
                // Shift the focus Node to the right child
                focusNode = focusNode.rightChild;
            }
            // The node wasn't found
            if (focusNode == null) {
                return false;
            }
        }

        // If Node doesn't have children delete it
        if (focusNode.leftChild == null && focusNode.rightChild == null) {
            // If root delete it
            if (focusNode == root) {
                root = null;
            } // If it was marked as a left child
            // of the parent delete it in its parent
            else if (isItALeftChild) {
                parent.leftChild = null;
            } // Vice versa for the right child
            else {
                parent.rightChild = null;
            }
        } // If no right child
        else if (focusNode.rightChild == null) {

            if (focusNode == root) {
                root = focusNode.leftChild;
            } // If focus Node was on the left of parent
            // move the focus Nodes left child up to the
            // parent node
            else if (isItALeftChild) {
                parent.leftChild = focusNode.leftChild;
            } // Vice versa for the right child
            else {
                parent.rightChild = focusNode.leftChild;
            }

        } // If no left child
        else if (focusNode.leftChild == null) {
            if (focusNode == root) {
                root = focusNode.rightChild;
            } // If focus Node was on the left of parent
            // move the focus Nodes right child up to the
            // parent node
            else if (isItALeftChild) {
                parent.leftChild = focusNode.rightChild;
            } // Vice versa for the left child
            else {
                parent.rightChild = focusNode.rightChild;
            }

        } // Two children so I need to find the deleted nodes
        // replacement
        else {
            Node replacement = getReplacementNode(focusNode);
            // If the focusNode is root replace root
            // with the replacement
            if (focusNode == root) {
                root = replacement;
            } // If the deleted node was a left child
            // make the replacement the left child
            else if (isItALeftChild) {
                parent.leftChild = replacement;
            } // Vice versa if it was a right child
            else {
                parent.rightChild = replacement;
            }
            replacement.leftChild = focusNode.leftChild;
        }
        return true;
    }
    
    public Node getReplacementNode(Node replacedNode) {

        Node replacementParent = replacedNode;
        Node replacement = replacedNode;
        Node tempNode = replacedNode.rightChild;
        // While there are no more left children
        while (tempNode != null) {
            replacementParent = replacement;
            replacement = tempNode;
            tempNode = tempNode.leftChild;
        }
        // If the replacement isn't the right child
        // move the replacement into the parents
        // leftChild slot and move the replaced nodes
        // right child into the replacements rightChild
        if (replacement != replacedNode.rightChild) {
            replacementParent.leftChild = replacement.rightChild;
            replacement.rightChild = replacedNode.rightChild;
        }
        return replacement;
    }

    public static void main(String[] args) {

        BinarySearchTree theTree = new BinarySearchTree();
        theTree.addNode(6786001191251d, "Thinking In Java", "Bruce", "Eckel");
        theTree.addNode(3786001191062d, "The elements of Java style", "Scott", "Ambler");
        theTree.addNode(3786001184075d, "Effective Java", "Joshua", "Bloch");
        theTree.addNode(9786001183990d, "Head First design patterns", "Eric", "Freeman");
        theTree.addNode(8785945583905d, "PHP and MySQL Web Development", "Luke", "Welling");
        theTree.addNode(8727089728320d, "PHP 4 Bible", "Tim", "Converse");
        theTree.addNode(1727089655864d, "PHP 4: A Beginner's Guide", "Bill", "McCarty");
        theTree.addNode(2786325955707d, "PHP Functions Essential Reference", "Torben", "Wilson");
        theTree.addNode(1786703422290d, "Programming PHP ", "Rasmus", "Lerdorf");
        theTree.addNode(1130588189933d, "PHP Functions Essential Reference", "Torben", "Wilson");
        theTree.addNode(2115514789655d, "PHP Object-Oriented Solutions ", "David", "Powers");
        theTree.addNode(7561993138507d, "Head First PHP & MySQL", "Michael", "Morrison");
        theTree.addNode(1222180496829d, "Head First Java, 2nd Edition ", "Kathy", "Sierra");
        theTree.addNode(4993355853224d, "Java: How to Program, 8th Edition", "P.J.", "Deitel");
        theTree.addNode(9052083632623d, "The Java Programming Language, 4th Edition ", "Ken ", "Arnold");
        theTree.addNode(5600296084786d, "Securing PHP Web Applications ", "Tricia", "Ballad");
        theTree.addNode(8448938360606d, "Java Concurrency in Practice", "Brian  ", "Goetz");
        theTree.addNode(3472479731436d, "Java Generics and Collections ", "Philip  ", "Wadler");
        theTree.addNode(7124428189487d, "Java In A Nutshell, 5th Edition ", "David  ", "Flanagan");
        theTree.addNode(1001001001001d, "Java", "Dinish ", "De Silva");

    }

}
