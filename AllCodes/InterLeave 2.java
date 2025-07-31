import java.util.*;
public class InterLeave{  // split the queue pick one from 1st half and the one from 2nd half ....
    public static void main(String args[]){

        Queue<Integer> pq = new LinkedList<>();
        for(int i = 1; i<=6; i++){
            pq.add(i);
        }
        System.out.println(pq);
        leave(pq);
        System.out.println(pq);
    }

    public static void leave(Queue<Integer> pq){
        int n = pq.size();
        Queue<Integer> first = new LinkedList<>();
        if (n % 2 != 0) {
            System.out.println("Queue size must be even to interleave.");
            return;
        }

        for(int i = 0; i<n/2; i++){
            first.add(pq.poll());
        }
        // System.out.print(first);
        
        while(!first.isEmpty()){
            pq.add(first.poll());
            pq.add(pq.poll());
        }
    }
}