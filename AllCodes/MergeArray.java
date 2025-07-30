import java.util.Arrays;
import java.util.List;

class MergeArray{
    public static void main(String args[]){

        int a[] = {1,2,3,4};
        int b[] = {5,6,23,7,8,9,11};

        // int c[] = new int[a.length + b.length];
        Integer c[] = new Integer[a.length + b.length];  
        //it is wrapper class for primitive data type int in Java. 
        // It allows you to use int values as objects.

        for(int i=0; i<=a.length-1; i++){
            c[i]=a[i];
        }
        for(int i=0; i<=b.length-1; i++){
            c[i+a.length] = b[i];
        }
        
        Arrays.sort(c);
        System.out.println(Arrays.toString(c));

        // convert int array to integer array
        // Integer[] gg = Arrays.stream(c).boxed().toArray(Integer[]::new);
        List <Integer> ll = Arrays.asList(c);
        System.out.println(ll);
    }
}
