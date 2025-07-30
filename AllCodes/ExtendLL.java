import java.util.Arrays;

import com.example.linkedlist.*;

public class ExtendLL{
    LLExample.Node head;   
    /* Node class should be public  , Node instance - public  , Node constructor - public , 
    head should be public to access in different file / Package;
    */  

    public static void main(String[] args){
        LLExample kk = new LLExample();

        kk.addStart(10);
        kk.addStart(11);
        kk.addStart(12);
        kk.addStart(13);
        kk.addStart(14);
        kk.addStart(15);
        kk.addStart(16);

        kk.Display();

        ExtendLL lg = new ExtendLL(); // Create an instance
        int len = lg.TwoHalf(kk.head); // Pass The head
        System.out.println(len);

        // LLExample.Node[] tll = ExtendLL.SplitTwo(kk.head);
        // ExtendLL.displayList(tll[0]); 
        // ExtendLL.displayList(tll[1]);
        
        // LLExample.Node[] gll = ExtendLL.SplitTwo2(kk.head);
        // ExtendLL.displayList(gll[0]);
        // ExtendLL.displayList(gll[1]);

        LLExample.Node pll = ExtendLL.swapTwoNodes(kk.head);
        System.out.println("Linked List after every 2 element swap");
        ExtendLL.displayList(swapTwoNodes(pll));

    }

    public int TwoHalf(LLExample.Node  head){
        LLExample.Node current = head;
        int length = 0;
        while(current != null){
            length++;
            current = current.next;
        }
        return length;
    }

    public static LLExample.Node[] SplitTwo(LLExample.Node head){ 
        // This will only work for Even no. of Nodes

        if(head == null || head.next == null){
            return new LLExample.Node[] {head,null};
        }
        LLExample.Node slow = head;
        LLExample.Node fast = head;
        LLExample.Node prev = null;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if(prev != null){
            prev.next = null;
        }
        LLExample.Node first = head;
        LLExample.Node second = slow;

        return new LLExample.Node[]{first,second};
    }

    public static LLExample.Node[] SplitTwo2(LLExample.Node head){ 
        // This will work for Both even and odd no. of Nodes

        LLExample.Node slow = head;
        LLExample.Node fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        LLExample.Node second = slow.next;
        slow.next = null;

        return new LLExample.Node[]{head,second};
    }
    public static LLExample.Node swapTwoNodes(LLExample.Node head){
            if (head == null || head.next == null) {
                return head; // Base case: if there are fewer than 2 nodes, return the head
            }
            LLExample.Node first = head;
            LLExample.Node second = head.next;
        
            // Recursively swap the rest of the list
            LLExample.Node swappedRest = swapTwoNodes(second.next);
        
            // Swap the current pair of nodes
            second.next = first;
            first.next = swappedRest;
        
            // Return the new head (second node becomes the new head of the swapped pair)
            return second;
        }


    
    public static void displayList(LLExample.Node node) {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }
    

    //Rotate List
   

    //sort list
    // public Node insertionSortList(Node head) {
    //     if (head == null) return null;
    
    //    Node dummy = new Node(0); // dummy node before sorted part
    //    Node current = head;
    
    //     while (current != null) {
    //         Node next = current.next;
    
    //         // Find the place to insert current in the sorted part
    //         Node prev = dummy;
    //         while (prev.next != null && prev.next.val < current.val) {
    //             prev = prev.next;
    //         }
    
    //         // Insert current between prev and prev.next
    //         current.next = prev.next;
    //         prev.next = current;
    
    //         current = next;
    //     }
    
    //     return dummy.next;
    }
