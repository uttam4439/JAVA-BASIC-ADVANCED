import java.util.*;
class TreeAdvanced{
    
    public static class SumNodes{
        int data ;
        SumNodes left;
        SumNodes right;

        public SumNodes(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class TreeBuilder{
        static int index = -1;
        public static SumNodes buildroot(int[] nodes){
            index++;

            if(index >= nodes.length || nodes[index] == -1){
                return null;
            }

            SumNodes root = new SumNodes(nodes[index]);
            root.left = buildroot(nodes);
            root.right = buildroot(nodes);
            return root;
        }

    }
    
    public static void allPath(SumNodes root , int sum , List<Integer> path , List<List<Integer>> gg){
        if(root == null) return;

        path.add(root.data);

        // This gives when sum is for root to leaf
        if(root.left == null && root.right == null && sum == root.data){
            gg.add(new ArrayList<>(path));
        }
        // This give when sum is root to any node ->
        // if(root.data == sum){
        //     gg.add(new ArrayList<>(path));
        // }

        allPath(root.left ,sum-root.data , path,gg);
        allPath(root.right ,sum-root.data , path,gg);

        path.remove(path.size()-1);
    }

    public static void CountSum(SumNodes root , int sum){
        
    }

    public static void main(String[] args){
        int[] nodes = {
            5, 4, 11, 7, -1, -1, 2, -1, -1, -1,
            8, 13, -1, -1, 4, 5, -1, -1, 1, -1, -1
        };
        
        SumNodes root = TreeBuilder.buildroot(nodes);

        List<Integer> path = new ArrayList<>();
        List<List<Integer>> gg  = new ArrayList<>();
        
        allPath(root, 22, path, gg);
        System.out.println("All paths that sum to 22:");
        System.out.println(gg);
    }


}

