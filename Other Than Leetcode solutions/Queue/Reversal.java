package Queue;

import java.util.*;

public class Reversal {
    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();


        for(int i = 1; i <= 10; i++) {
            q.add(i);
        }
        System.out.println("before");
        System.out.println(q);
        while(!q.isEmpty()){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }

        System.out.println("after");
        System.out.println(q);
    }
}
