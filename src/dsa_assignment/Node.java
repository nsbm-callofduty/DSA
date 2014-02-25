package dsa_assignment;


class Node {
    Node leftchild;
    Node rightchild;
    int key;
    String b_name;
    String f_name;
    String s_name;
    
    Node(int key1,String b1_name,String f1_name,String s1_name)
    {
        this.key = key1;
        this.b_name =b1_name;
        this.f_name= f1_name;
        this.s_name = s1_name;
        
        
    }
    
   
    
    public String toString(){
        return "ISBN :"+key+"Book :"+b_name+"by"+f_name+""+s_name; 
    }
}
