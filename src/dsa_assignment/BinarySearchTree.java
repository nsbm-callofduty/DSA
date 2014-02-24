package dsa_assignment;

 
public class BinarySearchTree {
         
        Node root;
        String name= null;
        int e = 0;
        
        public void add(int data){
            
            Node nodeToAdd = new Node(data);
            
            if (root == null)
                root = nodeToAdd;
            
            traverseAddAddNode(root,nodeToAdd);
                                
        }
        
        private void traverseAddAddNode(Node node,Node nodeToAdd){
            
            if (nodeToAdd.data < node.data){
                
                if (node.leftchild == null){
                    
                    node.leftchild = nodeToAdd;
                }
                else{
                    
                    traverseAddAddNode(node.leftchild,nodeToAdd);
                }
                if (node.rightchild == null){
                    
                    node.rightchild = nodeToAdd;
                }
                else{
                    
                    traverseAddAddNode(node.rightchild,nodeToAdd);
                }
            }
        }
         public static void main(String[]args){
        
            BinarySearchTree tree = new BinarySearchTree();
        
            tree.add(50);
            tree.add(40);
            tree.add(45);
            tree.add(55);
            tree.add(60);
            tree.add(53);
            System.out.println("hi");
        
        
        
    }

}
