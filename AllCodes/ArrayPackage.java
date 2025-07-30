import java.util.Arrays;
import java.util.List;
public class ArrayPackage{
    public static void main(String[] args) {
        int[] arr = {1, 2, 21,32,123, 4, 5,11};
        int[] arr2 = {1, 2, 21,32,123, 4, 5,11};

        //Creating And Filling Array

        Arrays.fill(arr,10);
        System.out.println(Arrays.toString(arr));

        Arrays.setAll(arr, i -> i+arr[i]);  
        System.out.println(Arrays.toString(arr));

        int[] newArr = Arrays.copyOf(arr, 8);
        newArr[6] = 100;
        System.out.println(Arrays.toString(newArr));
        System.out.println(newArr.length);

        int[] newArr2 = Arrays.copyOfRange(newArr, 2, 7);
        System.out.println(Arrays.toString(newArr2));
        System.out.println(newArr2.length);


        // Sorting and seaching

        Arrays.sort(arr);
        int index = Arrays.binarySearch(arr, 32);
        System.out.println(index);

        // Converting Array to List

        Integer[] newArr3 = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        List<Integer> gg = Arrays.asList(newArr3);
        System.out.println(gg);

        // Stream Arrays
        int minValue = Arrays.stream(arr2).min().getAsInt();
        System.out.println(minValue);

        
    }
}