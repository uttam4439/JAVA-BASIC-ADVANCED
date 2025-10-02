package com.example.linkedlist;

public class LLExample { // Singly Linked List
    public Node head;

    public static void main(String[] args){
        LLExample gg = new LLExample();

        int[] arr = {2,4,6,8,9};
        gg.head = gg.CreateLL(arr);
        gg.Display();
        gg.addEnd(10);
        gg.addEnd(20);

        gg.addStart(14);
        gg.addStart(11);
        gg.addStart(12);
        gg.addStart(11);
        gg.addStart(13);
        gg.addStart(19);
        gg.addStart(11);
        gg.addStart(14);

        gg.delLastSec();

        gg.deleteEnd();

        gg.getIndex(14);
        gg.deleteAtIndex(2);

        gg.deleteDuplicate(11);

        gg.deleteTarget(12);
        
        gg.deleteStart();
        gg.deleteStart();
        gg.Display();
        gg.head = gg.MoveLastToFirst(gg.head);
        gg.head = gg.DeleteMiddle(gg.head);
        gg.Display();

    }
    
    //Add Element from start
    public void addStart(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return ;
        }
        
        newNode.next = head;
        head = newNode;

    }
    // Append a data at the end 
    public void addEnd(int data){       
        Node newNode = new Node(data);
            if(head == null){
                head=newNode ;
                return;
            }
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
    }

    // delete form Start
    public void deleteStart(){
        if(head != null){
            head = head.next;
        }
    }

    // delete from end
    public void deleteEnd(){
        if(head == null && head.next == null){
            head = null;
            return;
        }
        Node current = head;
        while(current.next.next != null){
            current = current.next;
        }
        current.next = null;
    }
    // Delete Last Second
    public void delLastSec(){
	    if(head == null || head.next == null) return;
	    
	    Node current = head;
	    while(current.next.next.next != null){
	        current = current.next;
	    }
	    current.next = current.next.next;
	}

    // delete a node by its value
    public void deleteTarget(int value){
        if(head == null){
            return;
        }
        if(head.data == value){
            head = head.next;
            return;
        }
        Node current = head;
        while(current.next != null){
            if(current.next.data == value){
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
    
    public void deleteDuplicate(int data){
        if(head == null){
            return;
        }if(head.data == data){
            head = head.next;
        }
        Node current = head;
        while(current.next != null){
            if(current.next.data == data){
            current.next = current.next.next;
        }else{
        current = current.next;
    }
}
    }

    public void deleteAtIndex(int index){
        if(head == null || index < 0){
            return;
        }
        if(index == 0){
            head = head.next;
            return;
        }
        Node current = head;
        int count = 0;
        while(current != null && current.next != null && count < index-1){
            current = current.next;
            count++;
        }
        current.next = current.next.next;
    }

    public int getIndex(int data){
        Node current = head;
        int index = 0;
        while(current.next != null){
            if(current.data == data){
                System.out.println(index);
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public void Display(){
        Node current = head;
        while(current != null){
            System.out.print(current.data +" "+ "->");
            current = current.next;
        }
        System.out.println("null");

    }
    public Node CreateLL(int[] arr){ // arr se Linked list
        if(arr.length == 0){
            return null;
        }
        Node head = new Node(arr[0]);
        Node current = head;

        for(int i = 1; i<arr.length; i++){
            current.next =  new Node(arr[i]);
            current = current.next;
        }
        return head;
    }

    public Node MoveLastToFirst(Node head){
        Node secondLast = null;
        Node last = head;
        
        while(last.next != null){
            secondLast = last;
            last = last.next;
        }
        secondLast.next = null;
        last.next = head;
        head = last;
        return head;
    }
    public Node DeleteMiddle(Node head){   // Two Pointer Approach  jab fast last pr hoga slow middle pr hoga 
        if(head == null || head.next == null){
            return null;
        }
        Node slow = head;
        Node fast = head;
        Node prev = null;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = slow.next;
        return head;
    }

    public static class Node{
        public int data;
        public Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    
}