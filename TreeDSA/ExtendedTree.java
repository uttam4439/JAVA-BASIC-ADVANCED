import java.lang.reflect.Array;
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
        System.out.println("Tree in PreOrder" + preOrder(root));
        System.out.println("Tree in LevelOrder");
        level(root);    
        
/* Ah! Now I understand your exact confusion. You’re asking why can’t I do this?:

System.out.println("Tree in LevelOrder: " + level(root));
And the reason is — because level(root) is a void method, it does not return anything.

🔴 Why it Fails:
In Java, when you do:

System.out.println("Tree in LevelOrder: " + level(root));
the expression inside println expects both sides of + to be values that can be converted to Strings.

But since level(root) is void, it has no return value to concatenate with "Tree in LevelOrder: ". */

    }
    public static void level(PreOrder.Node root){
        Queue<PreOrder.Node> gg = new LinkedList<>();
        gg.offer(root);
        
        while(!gg.isEmpty()){
            PreOrder.Node kk = gg.poll();
            System.out.print(kk.data + "->");

            if(kk.left != null){
                gg.offer(kk.left);
            }
            if(kk.right != null){
                gg.offer(kk.right);
            }
        }
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

    static ArrayList<Integer> preOrder(PreOrder.Node root){
        ArrayList<Integer> gg  = new ArrayList<>();

        orderpre(root,gg);
        return gg;
    }
    private static void orderpre(PreOrder.Node root , ArrayList<Integer> gg){
        if(root == null){
            return;
        }
        gg.add(root.data);
        orderpre(root.left , gg);
        orderpre(root.right, gg);

    }
}

    // static boolean OddEven(PreOrder.Node root){
    //     if(root == null){
    //         return true;
    //     }
    //     Queue<PreOrder.Node> gg = new LinkedList<>();
    //     gg.add(root);

    //     int level = 0;
        
    // }

