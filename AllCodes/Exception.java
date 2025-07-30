// package exceptionHandling;

public class Exception{
    public static void main(String args[]){

        int arr[] = new int[5];

        try{
        System.out.println(arr[5]);
        }catch(ArrayIndexOutOfBoundsException | ArithmeticException | NullPointerException e){
            System.out.println("Kuch to error aayega bro");
        }
        // Alternative and the best Way to handle The exception is  catch(Exception e) which is parent class of all exception class

        System.out.println("Chal Chal Solve kr");
    }
}