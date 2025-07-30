import java.util.*;

public class BinaryTree{
    public static void main(String[] args){

        
        System.out.println(CreateTree());
    }
    static Node CreateTree(){
        Scanner gg = new Scanner(System.in);
        Node root = null;
    
        System.out.println("Enter data : ");
        int data = gg.nextInt();

        if (data == -1)
        return null;
    
        root = new Node(data);
        System.out.println("Enter Data For Left :" + data);
        root.left = CreateTree();
    
        System.out.println("Enter Data For Right :" + data);
        root.right = CreateTree();
        
        return root;
        
    }
}


class Node{
    Node left ;     // My DataType  // It take property of again Node class
    Node right ;
    int data;

    public Node(int data){
        this.data = data;
    }
}

