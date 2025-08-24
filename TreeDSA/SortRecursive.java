import java.util.*;
public class SortRecursive{
    public static void main(String[] args){

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5, 1, 0, 2, 4));
        sort(list);
        System.out.println("Sorted List: " + list);

        Stack<Integer> gg = new Stack<>();
        gg.addAll(list);
        System.out.println(gg);
        sortStack(gg);
        System.out.println("Sorted Stack" + gg);

        removeMiddle(gg);
        System.out.println(gg);
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

    public static void sortStack(Stack<Integer> gg){
        if(gg.size() <= 1){
            return;
        }
        // Top value ko remove kro;
        int last = gg.pop();
        //sort remaining
        sortStack(gg);
        //insert at correct position
        insertStack(gg, last);
    }
    static void insertStack(Stack<Integer> gg , int data){
        // Base condition: if empty OR top <= data → push data
        if(gg.isEmpty() || gg.peek() <= data){
            gg.push(data);
            return;
        }
        //otherwise remove top and recurse the fun
        int top = gg.pop();
        insertStack(gg, data);

        // Put the removed element back
        gg.push(top);
    }

    public static void removeMiddle(Stack<Integer> gg){
        if(gg.isEmpty()) return;

        int k = (gg.size() / 2) + 1;

        insertStack2(gg, k);
    }
    static void insertStack2(Stack<Integer> gg , int k){
        if(k == 1){
            gg.pop();
            return;
        }

        int top = gg.pop();
        insertStack2(gg, k-1);

        gg.push(top);
    }
    }