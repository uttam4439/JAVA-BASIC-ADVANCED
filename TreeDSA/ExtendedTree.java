import java.util.*;
public class ExtendedTree{
    public static void main(String args[]){
        PreOrder gg = new PreOrder();
        
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6};
        // Build the tree using PreOrder class logic
        PreOrder.BTree.index = -1;
        PreOrder.Node root = PreOrder.BTree.buildTree(nodes);
        System.out.println("Is Tree Balanced ?" +" "+ BalancedBinaryTree(root));

        System.out.println("Tree in Inorder" + inOrder(root));

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

    // How to save inorder , postorder , preorder
    static ArrayList<Integer> inOrder(PreOrder.Node root){
        ArrayList<Integer> gg = new ArrayList<>();

        orderin(root,gg);
        return gg;
    }

    private static void orderin(PreOrder.Node root , ArrayList<Integer> gg){
        if(root == null){
            return;
        }
        orderin(root.left , gg);
        gg.add(root.data);
        orderin(root.right, gg);
    }
}