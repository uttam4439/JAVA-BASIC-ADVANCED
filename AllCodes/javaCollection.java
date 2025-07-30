import java.util.*;

public class javaCollection{
    public static void main(String args[]){
        Stack<String> animal = new Stack<>();
        System.out.println("Stack Operation");
        Cstack(animal);

        List<Integer> gg = new LinkedList<>();
        System.out.println("ArrayList Operation");
        AList(gg);

        Queue<String> person = new LinkedList<>();
        System.out.println("Queue Operation");
        LLQueue(person);

        List<List<Integer>> nestedList = new ArrayList<>();
        System.out.println("Nested List Operation");
        nestedLL(nestedList);

    }

    public static void AList(List<Integer> gg){ // Dynamic Array
            gg.add(2);
            gg.add(40);
            gg.add(100);
            gg.add(11);
    
            System.out.println(gg.get(1));
    
            System.out.println(gg);
    
            for(int n : gg){
                System.out.println(n);
    
            }
    
            List<Integer> kk = new ArrayList<>();
    
            kk.add(11);
            gg.addAll(kk);
            System.out.println(gg);
    
            System.out.println(gg.contains(11));
    
            gg.set(3,111);
            System.out.println(gg);
    
            gg.remove(0);
            System.out.println(gg);
    
            gg.remove(Integer.valueOf(11));
            System.out.println(gg);
    
            gg.clear();
            System.out.println(gg);

        }

    public static void Cstack(Stack<String> animal){ // Last in First Out
        
        animal.push("Tiger");
        animal.push("Gadha");
        animal.push("Billa");
        animal.push("Kutta");

        // animal.pop();
        System.out.println(animal.peek());
        System.out.println(animal);
        System.out.println(animal.empty());

        System.out.println(animal.search("Gadha"));

        // if (position != -1) {
        //     System.out.println("Position of 'Gadha' from top: " + position);
        // } else {
        //     System.out.println("'Gadha' not found in stack");
        // }

        



    }

    public static void LLQueue(Queue<String> person){ //First in First Out
        person.offer("Asian");
        person.offer("Australian");
        person.offer("Chinese");
        person.offer("Indian");

        System.out.println(person);

        System.out.println(person.poll()); // Remove the head of the queue or return 'null' if it is empty
        person.remove(); //Remove the head of the queue or 'Throws Exception' if it is empty

        System.out.println(person.peek());  //show head or Also give null if empty queue
        System.out.println(person.element()); //show head or Throws Exception if empty queue
        System.out.println(person);
        System.out.println(person.isEmpty());
        System.out.println(person.size());
        System.err.println(person.contains("Indian"));

        
    }
    
    public static void nestedLL(List<List<Integer>> nestedList){
        List<Integer> table2 = new ArrayList<>();
        table2.add(2);
        table2.add(4);
        table2.add(6);

        List<Integer> table3 = new ArrayList<>();
        table3.add(3);
        table3.add(6);
        table3.add(9);

        List<Integer> table4 = new ArrayList<>();
        table4.add(4);
        table4.add(8);
        table4.add(12);

        nestedList.add(table2);
        nestedList.add(table3);
        nestedList.add(table4);

        nestedList.get(0).add(8);
        nestedList.get(1).add(12);

        nestedList.get(0).remove(2);

        System.out.println(nestedList);

        // for (List<Integer> innerList : nestedList) {
        //     for (int item : innerList) {
        //         System.out.print(item + " ");
        //     }
        //     System.out.println();
        // }

        for(int i=0; i<nestedList.size(); i++){
            for(int j=0; j<nestedList.get(i).size(); j++){
                System.out.print(nestedList.get(i).get(j) + " ");
            }
            System.out.println();
        }
        
    }

   
}

