import java.util.*;

public class Interleave {
    public static void main(String[] args) {

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> firstHalf = new LinkedList<>();

        for(int i = 1; i <= 10; i++) {
            q1.add(i);
        }

        int half = q1.size() / 2;

        // store first half
        for(int i = 0; i < half; i++) {
            firstHalf.add(q1.remove());
        }

        // interleave
        while(!firstHalf.isEmpty()) {
            q1.add(firstHalf.remove());
            q1.add(q1.remove());
        }

        System.out.println(q1);
    }
}