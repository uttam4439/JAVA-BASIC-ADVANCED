import java.util.*;
import java.io.*;

public class DistictNumber{
    public static void main(String[] args) throws IOException{
        //byte to char stream and then reading char stream
        BufferedReader bb = new BufferedReader(new InputStreamReader(System.in));
        
        HashSet<Long> gg = new HashSet<>();

        int n = Integer.parseInt(bb.readLine());

        String[] input = bb.readLine().split(" ");

        for(int i=0; i<n; i++){
        gg.add(Long.parseLong(input[i]));
        }
        System.out.println(gg.size());
    }
}