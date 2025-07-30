import java.util.Arrays;
class InsertInArray{
    public static void main(String args[]){

        int[] arr = {14,16,19,21,34};

        //insert at the end 
        int x = 12;
        int[] newArr = new int[arr.length+1];

        for(int i=0; i<arr.length; i++){
            newArr[i] = arr[i];
        }

        newArr[newArr.length - 1] = x;
        System.out.println(Arrays.toString(newArr));

        // insert at the certain index
        int index = 3;
        int[] newArr2 = new int[arr.length+1];
        for(int i=0; i<index; i++){
            newArr2[i] = arr[i];
        }
        newArr2[index] = x;
        for (int i = index; i < arr.length; i++) {
            newArr2[i + 1] = arr[i];
        }
        System.out.println(Arrays.toString(newArr2));
    }
}