import java.util.*;
public class LLQueue{
    Node2 head;

    public static void main(String[] args){
        // LLExample queue = new LLExample();
        LLQueue gg = new LLQueue();

        gg.enqueue(12);
        gg.enqueue(14);

        gg.Display();

        int[] arr = {1,2,3,4,5};

        Stack<Integer> input = new Stack<>();
        Stack<Integer> output = new Stack<>();

        for(int i = 0; i<arr.length; i++){
            input.push(arr[i]);
        } 
        if(output.isEmpty()!= true){
            output.pop();
        }else{
            while(input.isEmpty() == false){
                
                output.push(input.pop());
            }
        }

        System.out.println(input);
        System.out.println(output);
    }

    public void enqueue(int data){
        Node2 newNode = new Node2(data);
        if (head == null){
            head = newNode;
            return;
        }
        Node2 current = head ;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }

    public void Display(){
        Node2 current = head;
        while(current != null){
            System.out.print(current.data +" "+ "->");
            current = current.next;
        }
        System.out.println("null");
    }

    class Node2{
        int data;
        Node2 next;

        Node2(int data){
            this.data = data;
            this.next = null;
        }
    }


}