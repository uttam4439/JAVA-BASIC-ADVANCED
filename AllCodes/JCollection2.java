
import java.util.*;

public class JCollection2 {
    public static void main(String[] args){

        Queue<Integer> pq = new PriorityQueue<>(); 
        Queue<Integer> pqq = new PriorityQueue<>(Comparator.reverseOrder());
        PQueue(pq , pqq);

       ArrayDeque<Integer> gg = new ArrayDeque<>(); // Sliding Window Case
        ADQueue(gg);

        Set<Integer> kk = new HashSet<>();
        HSets(kk);
    }

    static void PQueue(Queue<Integer> pq , Queue<Integer> pqq){ 
        /*  Min Heap nd Max Heap internal implementation 
        so ordered get according that */
        pq.offer(10);
        pq.offer(21);
        pq.offer(11);
        pq.offer(31);
        pq.offer(19);
        pq.offer(7);

        pqq.offer(10);
        pqq.offer(21);
        pqq.offer(11);
        pqq.offer(31);
        pqq.offer(19);
        pqq.offer(7);

        pq.poll();
        System.out.println(pqq.peek());

        System.out.println(pq);
        System.out.println(pqq);
        System.out.println();
    }
    static void ADQueue(ArrayDeque<Integer> gg){ // Sliding Window Case for front and last 

        gg.offer(11);
        gg.offerFirst(12);
        gg.offerLast(17);
        gg.offer(12);
        gg.offer(11);
        gg.offer(16);
        gg.offer(19);

        System.out.println("ArrayDeque" + " " + gg);
        System.out.println("ArrayDeque" + " " + gg.peek());
        System.out.println("ArrayDeque" + " " + gg.pollLast());
        System.out.println("ArrayDeque" + " " + gg);
        System.out.println("ArrayDeque" + " " + gg.pollFirst());
        System.out.println("ArrayDeque" + " " + gg);
        System.out.println("ArrayDeque" + " " + gg.peekFirst());
        System.out.println("ArrayDeque" + " " + gg.peekLast());
        System.out.println();

    }

 static void HSets(Set<Integer> kk){
    kk.add(11);
    kk.add(21);
    kk.add(10);
    kk.add(8);
    kk.add(23);
    kk.add(11);

    System.out.println("HashSet" + " " + kk);

 }

}