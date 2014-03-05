package dsa_assignment;

public class BinarySearchTree {

    Node root;
    BinarySearchTree tree;
    Node s;

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
     * @return
     */
    public boolean addNode(double key, String b_name, String f_name, String s_name) {

        Node nodeToAdd = new Node(key, b_name, f_name, s_name);
        //check whether the root is null
        if (root == null) {
            root = nodeToAdd;
        } else {
            if (searchByKey(key) == null) {
                Node tempNode = root;
                Node parent;
                while (true) {
                    parent = tempNode;
                    if (key < tempNode.key) {
                        tempNode = tempNode.leftChild;
                        if (tempNode == null) {
                            parent.leftChild = nodeToAdd;
                            return true;
                        }
                    } else {
                        tempNode = tempNode.rightChild;
                        if (tempNode == null) {
                            parent.rightChild = nodeToAdd;
                            return true;
                        }
                    }
                }
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * Using the key it will delete the Node from the Tree
     *
     * @param key ISBN will be the key
     * @return if turn then Node is remove from the tree, if false then there is
     * not Node with that Key
     */
    public boolean deleteByKey(double key) {
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

    /**
     *
     * @param bname
     * @return ture or false
     */
    public boolean deteleByBookName(String bname) {
        searchByBookName(bname);
        Node searchByBookName = this.s;
        if (searchByBookName != null) {
            return deleteByKey(searchByBookName.key);
        } else {
            return false;
        }
    }

    /**
     * When Deleting a Node have to replace the Node if there are child Node
     *
     * @param replacedNode Deleting Node
     * @return
     */
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

    public Node searchByKey(double key) {

        // Start at the top of the tree
        Node focusNode = root;
        // While we haven't found the Node
        // keep looking
        while (focusNode.key != key) {
            // If we should search to the left
            if (key < focusNode.key) {
                // Shift the focus Node to the left child
                focusNode = focusNode.leftChild;
            } else {
                // Shift the focus Node to the right child
                focusNode = focusNode.rightChild;
            }
            // The node wasn't found
            if (focusNode == null) {
                return null;
            }
        }
        return focusNode;
    }

    /**
     *
     * @param name
     * @return
     */
    public Node searchByBookName(String name) {
        Node search = search(this.root, name);
        return search;
    }

    /**
     *
     * @param focusNode
     * @param nm
     * @return NULL or Node object with data if the search is successful, either
     * wise it return NULL
     */
    private Node search(Node focusNode, String nm) {

        Node temp = null;
        if (focusNode != null) {
            if (nm.toLowerCase().matches(focusNode.b_name.toLowerCase())) {
                this.s = focusNode;
                return focusNode;
            }
            temp = search(focusNode.leftChild, nm);
            temp = search(focusNode.rightChild, nm);
        }
        return temp;
    }
}
