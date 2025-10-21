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

        int[] array = {1,2,3};
        List<List<Integer>> res = new ArrayList<>();

        allCombinations(array, 0, res);

        System.out.println(res);

        int[] array1 = {1,2,2};
        List<List<Integer>> res1 = new ArrayList<>();

        allCombinationsDuplicate(array1, 0, res1);

        System.out.println(res1);

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

    public static void allCombinations(int[] array , int index , List<List<Integer>> res){
        if(index == array.length){
            List<Integer> temp = new ArrayList<>();
            for (int num : array){
            temp.add(num);
            }
            res.add(temp);
            return;
        }

        for(int i = index; i<array.length; i++){

            swap(array ,index, i);
            allCombinations(array, index+1, res);
            swap(array ,index, i);
        }
    }

    public static void swap(int array[] ,int i , int j){
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

    public static void allCombinationsDuplicate(int[] array1 , int index , List<List<Integer>> res1){
        if(index == array1.length){
            List<Integer> temp = new ArrayList<>();
            for (int num : array1){
            temp.add(num);
            }
            res1.add(temp);
            return;
        }
        HashSet<Integer> used = new HashSet<>();
        for(int i = index; i<array1.length; i++){
            if(used.contains(array1[i])){
                continue;
            }else{
                used.add(array1[i]);
            }
            swap1(array1 ,index, i);
            allCombinationsDuplicate(array1, index+1, res1);
            swap1(array1 ,index, i);
        }
    }
    public static void swap1(int array1[] ,int i , int j){
        int temp = array1[i];
        array1[i] = array1[j];
        array1[j] = temp;
    }
}