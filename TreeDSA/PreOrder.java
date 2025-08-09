import java.util.*;
public class PreOrder{

    public static class Node{
        public int data;
        public Node left;
        public Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static class BTree{
        static int index = -1;
        public static Node buildTree(int[] nodes) {
            index++;
            if(index >= nodes.length || nodes[index] == -1){
                return null;
            }
            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
        
    }

    static void PreorderT(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        PreorderT(root.left);
        PreorderT(root.right);
    }

    static void InorderT(Node root){  
        if(root == null){
            return;
        }
        InorderT(root.left);
        System.out.print(root.data + " ");
        InorderT(root.right);
    }

    static void PostorderT(Node root){
        if(root == null){
            return;
        }
        PostorderT(root.left);
        PostorderT(root.right);
        System.out.print(root.data + " ");
    }

    static void LevelOrder(Node root){
        Queue<Node> gg = new LinkedList<>();
        gg.add(root);
        gg.add(null);

        while(!gg.isEmpty()){
            Node currNode = gg.remove();
            if(currNode == null){ // null means next Line pr ja rahe
                System.out.println();
                if(gg.isEmpty()){   // Last Node k baad bhi null ho to break 
                    break;
                }else{
                    gg.add(null);
                }
            }else{ // agar currNode null nahi thi to data print krwaiye
                System.out.print(currNode.data + " ");
                if(currNode.left != null){
                    gg.add(currNode.left);
                }
                if(currNode.right != null){
                    gg.add(currNode.right);
                }
            } 
        }
    }
    
    static boolean isBST(Node root){
        return  BST(root,Integer.MAX_VALUE, Integer.MAX_VALUE);
    }
    static boolean BST(Node root, int min , int max ){
        if(root == null){
            return false;
        }
        else if(root.data <= min || root.data >= max){
            return false;
        }
        return BST(root.left,min,root.data) && BST(root.right,root.data,max);
         
    }

    public static boolean isSymmetric(Node root){   // Check in Mirror like problem
        return (root == null || isSymmetricCheck(root.left ,root.right));
    }
    private static boolean isSymmetricCheck(Node left, Node right){
        if(left == null || right == null){
            return left == right;
        }
        if(left.data != right.data){
            return false;
        }
        return isSymmetricCheck(left.left, right.right) && isSymmetricCheck(left.right, right.left);
    }

    public static int countNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftSubNodes = countNodes(root.left);
        int rightSubNodes = countNodes(root.right);

        return leftSubNodes + rightSubNodes + 1;
    }

    public static int sumOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftsum = sumOfNodes(root.left);
        int rightsum = sumOfNodes(root.right);

        return leftsum + rightsum + root.data;
    }

    public static int heightOfTree(Node root){
        if(root == null){
            return 0;
        }
        int leftheight = heightOfTree(root.left);
        int rightheight = heightOfTree(root.right);

        int maxheight = Math.max(leftheight,rightheight) + 1;

        return maxheight;
    }

    public static int diameterOfTree(Node root){
        if(root == null){
            return 0;
        }
        int left = diameterOfTree(root.left);
        int right = diameterOfTree(root.right);
        int diam = heightOfTree(root.left) + heightOfTree(root.right) + 1;

        return Math.max(diam , Math.max(left,right));
    }

    static class TreeInfo{
        int height;
        int diam;

        TreeInfo(int height , int diam){
            this.height = height;
            this.diam = diam;
        }
    }
        public static TreeInfo diameter(Node root){
            if(root == null){
                return new TreeInfo(0, 0);
            }
            TreeInfo left = diameter(root.left); // height of left 
            TreeInfo right = diameter(root.right); // height of right

            // Calculate the height of the current node
            int high = Math.max(left.height , right.height) + 1;
            
            //diameter of the left and right subtrees
            int ldiam = left.diam;
            int rdiam = right.diam;
            //diameter passing through the current node
            int maindiam = (left.height + right.height) + 1;

            int resultdiam = Math.max(Math.max(rdiam, ldiam) , maindiam);

            TreeInfo myInfo = new TreeInfo(high, resultdiam);
            return myInfo;
        }

    public static Node MaximumBinaryTree(int nums[]){  
/*  root is max for every iteration and 
leftsubtree is left part of max element index and same for right. */
        if(nums.length == 0){
            return null;
        }
        return build(nums,0,nums.length-1);
    }
        private static Node build(int nums[],int start, int end){
            if(start > end){
                return null;
            }
            int idx = start;
            for(int i = start; i<= end; i++){
                if(nums[i] > nums[idx]){
                    idx = i;
                }
            }
            Node root = new Node(nums[idx]);

            root.left = build(nums, start, idx-1);
            root.right = build(nums, idx+1, end);
            return root;
        }

    public static void main(String[] args){
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6};
        Node root = BTree.buildTree(nodes);
        System.out.print("\nPre-Order Traversal" + " ");
        PreorderT(root);
        System.out.print("\nIN-Order Traversal" + " ");
        InorderT(root);
        System.out.print("\nPost-Order Traversal" + " ");
        PostorderT(root);
        System.out.println("\nIs Tree Symmetric? " + isSymmetric(root));
        System.out.println(isBST(root));
        System.out.print("\nLevel-Order Traversal" + " ");
        LevelOrder(root);

        System.out.println("\nTotal Nodes in Tree " + PreOrder.countNodes(root));
        System.out.println("\nSum of Nodes in Tree " + PreOrder.sumOfNodes(root));
        System.out.println("\nHeight of Tree " + PreOrder.heightOfTree(root));

        int[] nums = {3,2,1,6,0,5};
        Node maxRoot = PreOrder.MaximumBinaryTree(nums); 
        System.out.print("\nLevel-Order Traversal of Max. Binary Tree" + " ");
        LevelOrder(maxRoot);
          // output [6,3,5,null,2,0,null,null,1]
        
          System.out.println("O(n^2) approach for calculating diameter of tree" + PreOrder.diameterOfTree(root));
        
          System.out.println("O(n) approach for calculating diameter of tree"+PreOrder.diameter(maxRoot).diam);
    }
    
}