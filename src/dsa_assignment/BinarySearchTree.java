package BinaryTree;

 
public class BinarySearchTree {
         
        Node root;
                
        public void addNode(int key, String b_name, String f_name, String s_name){
            
            Node nodeToAdd = new Node(key, b_name, f_name, s_name);
            
            if (root == null){
                root = nodeToAdd;
            }
            else {
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
            }
            else { 
                    focusNode = focusNode.rightChild;
                    
                    if (focusNode == null) {
                        
                        parent.rightChild = nodeToAdd;
                        return; 
                    }
                }
             }
          }
        }
            
          
        public static void main(String[]args){
        
        BinarySearchTree theTree = new BinarySearchTree();
        theTree.addNode(50, "Thinking In Java", "Bruce", "Eckel");
        theTree.addNode(52, "The elements of Java style", "Scott", "Ambler");
        theTree.addNode(52, "Effective Java", "Joshua", "Bloch");
        theTree.addNode(52, "Head First design patterns", "Eric", "Freeman");
        theTree.addNode(52, "PHP and MySQL Web Development", "Luke", "Welling");
        theTree.addNode(52, "PHP 4 Bible", "Tim", "Converse");
        theTree.addNode(52, "PHP 4: A Beginner's Guide", "Bill", "McCarty");
        theTree.addNode(52, "PHP Functions Essential Reference", "Torben", "Wilson");
        theTree.addNode(52, "Programming PHP ", "Rasmus", "Lerdorf");
        theTree.addNode(52, "PHP Functions Essential Reference", "Torben", "Wilson");
        theTree.addNode(52, "PHP Object-Oriented Solutions ", "David", "Powers");
        theTree.addNode(52, "Head First PHP & MySQL", "Michael", "Morrison");
        theTree.addNode(52, "Head First Java, 2nd Edition ", "Kathy", "Sierra");
        theTree.addNode(52, "Java: How to Program, 8th Edition", "P.J.", "Deitel");
        theTree.addNode(52, "The Java Programming Language, 4th Edition ", "Ken ", "Arnold");
        theTree.addNode(52, "Securing PHP Web Applications ", "Tricia", "Ballad");
        theTree.addNode(52, "Java Concurrency in Practice", "Brian  ", "Goetz");
        theTree.addNode(52, "Java Generics and Collections ", "Philip  ", "Wadler");
        theTree.addNode(52, "Java In A Nutshell, 5th Edition ", "David  ", "Flanagan");
        theTree.addNode(52, "Java", "Dinish ", "De Silva");
        
        
        
    }

}
