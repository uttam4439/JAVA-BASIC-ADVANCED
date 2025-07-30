import java.util.*;
public class TopKFrequent{
    public static void main(String[] args){

        int[] arr = {1,2,2,4,4,4,4,4,7,3,3,3,3};
        int k = 3; // kitne frequent element chahiye wo puch rahe

        System.out.println(Arrays.toString(TopKFrequent.Element(arr, k)));
    }

    static int[] Element(int[] arr , int k){
        HashMap<Integer ,Integer> freq = new HashMap<>();

        for(int fr : arr){
            freq.put(fr,freq.getOrDefault(fr,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> combo = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());
        //fequency k basis pr min heap m daal rahe; small comes first;

        for(Map.Entry<Integer,Integer> entry : freq.entrySet()){
            combo.offer(entry);
            if(combo.size() > k){
                combo.poll();  
                // sare data dalo acc. to PQ or agar size se jyada ho to pahlle wale nikal do
            }
        }
        int[] result = new int[k]; 
        int i = 0;
        while(!combo.isEmpty()){
            result[i++] = combo.poll().getKey();  
            // naye wale array m daal rahe map se nikal kr 
        }
        return result;
    }


}