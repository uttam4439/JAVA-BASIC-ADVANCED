import java.util.*;
public class SortRecursive{
    public static void main(String[] args){

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5, 1, 0, 2, 4));
        sort(list);
        System.out.println("Sorted List: " + list);
    }

    public static void sort(ArrayList<Integer> list){
        if(list.size() <= 1) return; // base case

        //Remove last element.. because a single no. is sorted
        int last = list.remove(list.size()-1);
        //sort remaining arr
        sort(list);
        //insert last element in sorted arr
        insert(list,last);
    }

    static void insert (ArrayList<Integer> list , int value){
        if (list.size() == 0 || list.get(list.size() - 1) <= value) {
            list.add(value);
            return;
        }

        int temp = list.remove(list.size() - 1);
        insert(list, value);  // recursive call 
        list.add(temp);       // restore last element
    }
    }