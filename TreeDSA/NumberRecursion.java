import java.util.*;
class NumberRecursion{
    
    public static void main(String[] args){

        int[] nums = {1,2,3};
        List<Integer> gg = new ArrayList<>();
        List<List<Integer>> kk = new ArrayList<>();
        
        subsetsWithoutDuplicate(nums, 0, gg,kk);
        System.out.println(kk);

        kk.sort((a,b)-> a.size() - b.size());
        System.out.println(kk);

        int[] arr = {1,2,2};
        List<Integer> ll = new ArrayList<>();
        List<List<Integer>> pp = new ArrayList<>();

        subsetsWithDuplicate(arr, 0, ll, pp);
        System.out.println(pp);

    }

    public static void subsetsWithoutDuplicate(int[] nums , int index , List<Integer> gg,List<List<Integer>> kk){
        if(index == nums.length){
            kk.add(new ArrayList<>(gg));
            return;
        }
        gg.add(nums[index]);
        subsetsWithoutDuplicate(nums, index+1, gg,kk);
        gg.remove(gg.size()-1);
        subsetsWithoutDuplicate(nums, index+1, gg,kk);
    }

    public static void subsetsWithDuplicate(int[] arr , int index , List<Integer> ll , List<List<Integer>> pp){
        pp.add(new ArrayList<>(ll));

        for(int i = index; i<arr.length; i++){
            if(i>index && arr[i] == arr[i-1]){
                continue;
            }

            ll.add(arr[i]);
            subsetsWithDuplicate(arr, i+1, ll, pp);
            ll.remove(ll.size()-1);
        }
    }
}