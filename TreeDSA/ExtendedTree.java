import java.util.*;

public class ExtendedTree {
    public static void main(String args[]) {

        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6 };
        // Build the tree using PreOrder class logic
        PreOrder.BTree.index = -1;
        PreOrder.Node root = PreOrder.BTree.buildTree(nodes);
        System.out.println("Is Tree Balanced ?" + " " + BalancedBinaryTree(root));

        System.out.println("Tree in Inorder" + inOrder(root));
        System.out.println("Tree in PreOrder" + preOrder(root));
        System.out.println("Is this odd Even tree" + "->" + OddEven(root));

        System.out.println("Has Path Sum" + "->" + hasPathSum(root, 7));

        // right view
        System.out.println("Right view Of a Tree" + ExtendedTree.rightView(root));

        // isCousins
        int x = 3, y = 4;
        System.out.println("Values are Cousins" + "->" + ExtendedTree.isCousins(root, x, y));

        /*
         * Ye tree ko puring kr de raha so tree utni hi bachi aage ke trave utne hi tree
         * pr ho gya
         */
        System.out.println("After Puring The tree is" + "->" + treePuring(root));

        System.out.println("Tree in LevelOrder");
        System.out.println(level2(root));

        System.out.println("Tree in LevelOrder");
        level(root);
        System.out.println();

        /*
         * Ah! Now I understand your exact confusion. You’re asking why can’t I do
         * this?:
         * 
         * System.out.println("Tree in LevelOrder: " + level(root));
         * And the reason is — because level(root) is a void method, it does not return
         * anything.
         * 
         * 🔴 Why it Fails:
         * In Java, when you do:
         * 
         * System.out.println("Tree in LevelOrder: " + level(root));
         * the expression inside println expects both sides of + to be values that can
         * be converted to Strings.
         * 
         * But since level(root) is void, it has no return value to concatenate with
         * "Tree in LevelOrder: ".
         */

    }

    public static void level(PreOrder.Node root) {
        if (root == null)
            return;
        Queue<PreOrder.Node> gg = new LinkedList<>();
        gg.offer(root);

        while (!gg.isEmpty()) {
            PreOrder.Node kk = gg.poll();
            System.out.print(kk.data + "->");

            if (kk.left != null) {
                gg.offer(kk.left);
            }
            if (kk.right != null) {
                gg.offer(kk.right);
            }
        }
    }

    public static List<Integer> level2(PreOrder.Node root) {
        List<Integer> ll = new ArrayList<>();
        if (root == null)
            return ll;

        Queue<PreOrder.Node> gg = new LinkedList<>();
        gg.offer(root);

        while (!gg.isEmpty()) {
            int size = gg.size();

            for (int i = 0; i < size; i++) {
                PreOrder.Node kk = gg.poll();

                ll.add(kk.data);

                if (kk.left != null) {
                    gg.offer(kk.left);
                }
                if (kk.right != null) {
                    gg.offer(kk.right);
                }
            }
        }
        return ll;
    }

    public static boolean BalancedBinaryTree(PreOrder.Node root) {
        return balance(root) != -1;
    }

    static int balance(PreOrder.Node root) {
        if (root == null) {
            return 0;
        }
        int lst = balance(root.left);
        if (lst == -1)
            return -1;
        int rst = balance(root.right);
        if (rst == -1)
            return -1;

        if (Math.abs(lst - rst) > 1)
            return -1;
        return Math.max(lst, rst) + 1;
    }

    // How to save inorder , postorder , preorder
    static ArrayList<Integer> inOrder(PreOrder.Node root) {
        ArrayList<Integer> gg = new ArrayList<>();

        orderin(root, gg);
        return gg;
    }

    private static void orderin(PreOrder.Node root, ArrayList<Integer> gg) {
        if (root == null) {
            return;
        }
        orderin(root.left, gg);
        gg.add(root.data);
        orderin(root.right, gg);
    }

    static ArrayList<Integer> preOrder(PreOrder.Node root) {
        ArrayList<Integer> gg = new ArrayList<>();

        orderpre(root, gg);
        return gg;
    }

    private static void orderpre(PreOrder.Node root, ArrayList<Integer> gg) {
        if (root == null) {
            return;
        }
        gg.add(root.data);
        orderpre(root.left, gg);
        orderpre(root.right, gg);

    }

    static boolean OddEven(PreOrder.Node root) {
        if (root == null) {
            return true;
        }
        Queue<PreOrder.Node> gg = new LinkedList<>();
        gg.add(root);
        int level = 0;

        while (!gg.isEmpty()) {
            int size = gg.size();
            int prevVal = (level % 2 == 0) ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            for (int i = 0; i < size; i++) {
                PreOrder.Node kk = gg.poll();
                int curr = kk.data;

                if (level % 2 == 0) {
                    if (curr % 2 == 0 || prevVal >= curr)
                        return false;
                } else {
                    if (curr % 2 != 0 || prevVal <= curr)
                        return false;
                }
                prevVal = curr;
                if (kk.left != null)
                    gg.offer(kk.left);
                if (kk.right != null)
                    gg.offer(kk.right);
            }
            level++;
        }
        return true;
    }

    public static boolean hasPathSum(PreOrder.Node root, int targetSum) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null) {
            return root.data == targetSum;
        }

        int remainingSum = targetSum - root.data;

        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
    }

    public static PreOrder.Node treePuring(PreOrder.Node root) {
        // sub tree which only contains 0 with decendant

        if (root == null)
            return null;

        root.left = treePuring(root.left);
        root.right = treePuring(root.right);

        if (root.data == 0 && root.left == null || root.right == null) {
            return null;
        }
        return root;
    }

    public static boolean isSubtree(PreOrder.Node root, PreOrder.Node subtree) {
        if (subtree == null)
            return true;
        if (root == null)
            return false;

        if (root.data == subtree.data) {
            if (isSame(root, subtree)) {
                return true;
            }
        }
        return isSubtree(root.left, subtree) || isSubtree(root.right, subtree);
    }

    private static boolean isSame(PreOrder.Node root, PreOrder.Node subtree) {
        if (root == null && subtree == null)
            return true;

        // Base Cond. -> koi ek null raha to subtree nhi hoga
        if (root == null || subtree == null)
            return false;

        if (root.data == subtree.data) {
            return (isSame(root.left, subtree.left) && isSame(root.right, subtree.right));
        }
        return false;
    }

    public static boolean isCousins(PreOrder.Node root, int x, int y) {
        if (root == null)
            return false;

        Queue<PreOrder.Node> gg = new LinkedList<>();
        gg.offer(root);

        while (!gg.isEmpty()) {
            int size = gg.size();
            boolean foundx = false;
            boolean foundy = false;

            for (int i = 0; i < size; i++) {
                PreOrder.Node curr = gg.poll();

                if (curr.left != null && curr.right != null) {
                    if ((curr.left.data == x && curr.right.data == y)
                            || (curr.left.data == y && curr.right.data == x)) {
                        return false;
                    }
                }
                if (curr.left != null) {
                    gg.offer(curr.left);
                    if (curr.left.data == x)
                        foundx = true;
                    if (curr.left.data == y)
                        foundy = true;
                }
                if (curr.right != null) {
                    gg.offer(curr.right);
                    if (curr.right.data == x)
                        foundx = true;
                    if (curr.right.data == y)
                        foundy = true;
                }
            }
            if (foundx && foundy)
                return true;
            if (foundx || foundy)
                return false;
        }
        return false;
    }

    public static List<Integer> rightView(PreOrder.Node root) {
        List<Integer>  gg = new ArrayList<>();
        if(root == null) return gg;

        Queue<PreOrder.Node> kk = new LinkedList<>();
        kk.offer(root);

        while(!kk.isEmpty()){
            int size = kk.size();
            PreOrder.Node lastnode = null; 

            for(int i =0; i<size; i++){
                PreOrder.Node curr = kk.poll();

                lastnode = curr;

                if(curr.left != null) kk.offer(curr.left);
                if(curr.right != null) kk.offer(curr.right);
            }
            gg.add(lastnode.data);
        } 
        return gg;
    }
}
