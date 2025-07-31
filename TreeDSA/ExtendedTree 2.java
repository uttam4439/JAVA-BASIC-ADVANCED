import java.util.*;
public class ExtendedTree{
    public static void main(String args[]){
        PreOrder gg = new PreOrder();
        
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6};
        // Build the tree using PreOrder class logic
        PreOrder.BTree.index = -1;
        PreOrder.Node root = PreOrder.BTree.buildTree(nodes);
        System.out.println("Is Tree Balanced ?" +" "+ BalancedBinaryTree(root));

    }

    public static boolean BalancedBinaryTree(PreOrder.Node root){
        return balance(root) != -1;
    }
    static int balance(PreOrder.Node root){
        if(root == null){
            return 0;
        }
        int lst = balance(root.left);
        if(lst == -1) return -1;
        int rst = balance(root.right);
        if(rst == -1) return -1;

        if(Math.abs(lst-rst) > 1) return -1;
        return Math.max(lst,rst) + 1;
    }
}