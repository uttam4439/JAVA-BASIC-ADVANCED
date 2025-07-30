class Node1{
    int data;
    Node1 next;
    Node1 prev;

    Node1(int data){
        this.data = data;
        this.next = null;
        this.prev = null; 
    }
}
public class DLLExample{
    Node1 head,tail;
//Push Front

public void pushFront(int data){
    Node1 newNode = new Node1(data);
    if(head == null){
        head = tail = newNode;
        return;
    }
    newNode.next = head;
    head.prev = newNode;
    head = newNode;
}
//Push Back
public void pushBack(int data){
    Node1 newNode = new Node1(data);
    if(head == null){
        head = tail = newNode;
        return;
    }
    newNode.prev = tail;
    tail.next = newNode;
    tail = newNode;
}

// Pop Front
public void popFront(){
    if(head == null){
        return;
    }
    Node1 temp = head;
    head = head.next;
    if(head != null){
        head.prev = null; // set new head prev.
    }
    temp.next = null;   // remove ref. of pev from old head
}

//Pop Back
public void popBack(){
    if(head == null){
        return;
    }
    if(tail == null){
        return;
    }
    Node1 temp = tail;
    tail = tail.prev;
    if(tail != null){
        tail.next = null;
    }
    temp.prev = null;
}

public void deleteTarget(int value){
    if(head == null){
        return;
    }
    if(head.data == value){
        head = head.next;
        if(head != null){
            head.prev = null;
        }
        return;
    }
    Node1 current = head;
    while(current.next != null){
        if(current.next.data == value){
            current.next = current.next.next;
            if(current.next != null){
                current.next.prev = current;
            }else{
                tail = current;
            }
            return;
        }
        current = current.next;
    }
}

public void display(){
    Node1 temp = head;
    System.out.print("head is ->" + " ");
    while(temp != null){
        System.out.print(temp.data + "->");
        temp = temp.next;
    }
    System.out.println("null");
}
public void displayReverse(){
    Node1 temp = tail;
    System.out.print("tail is ->");
    while (temp != null){
        System.out.print(temp.data+ "->");
        temp = temp.prev;
    }
    System.out.print("null");
}
public static void main(String args[]){

    DLLExample gg = new DLLExample();
    gg.pushFront(10);
    gg.pushFront(19);
    gg.pushFront(16);
    gg.pushFront(20);
    gg.pushFront(12);
    gg.pushBack(11);
    gg.pushBack(88);

    gg.popFront();
    gg.popBack();

    gg.deleteTarget(20);
    gg.display();
    gg.displayReverse();
    }
}
