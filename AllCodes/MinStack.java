import java.util.*;
public class MinStack{
    Node head;

    public static void main(String[] args){
        MinStack kk = new MinStack();

        kk.Push(11);
        kk.Push(14);
        kk.Push(12);
        kk.Push(14);
        kk.Push(11);

        kk.Pop();
        System.out.println(kk.Palindrome());

        kk.Peek();
        kk.Display();

    }
    public void Push(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;

    }

    public void Pop(){
        if(head == null){
            return;
        }
        head = head.next;
    }

    public void Peek(){
        if(head == null){
            return;
        }
        System.out.println(head.data + " is a head");
    }

    public boolean Palindrome(){
        if(head == null || head.next == null){
            return true;
        }
        Node current = head;
        ArrayList<Integer> kk = new ArrayList<>();
        while(current != null){
            kk.add(current.data);
            current = current.next;
        }

        int left = 0;
        int right = kk.size() - 1;
        while(left < right){
            if(!kk.get(left).equals(kk.get(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public void Display(){
        Node current = head;
        while(current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println();
    }

    class Node{
        int data;
        Node next;
        

        Node(int data){
            this.data = data;
            this.next = null;
            
        }
    }
}