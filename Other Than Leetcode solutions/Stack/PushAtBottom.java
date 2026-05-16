package Stack;
import java.util.*;

public class PushAtBottom {
    public static void arrange(Stack<Integer> s , int k){
        if(s.isEmpty()){
            s.push(k);
            return;
        }
        int top = s.pop();

        arrange(s , k);

        s.push(top);
    }
    public static void main(String[] args) {
        int k = 4;

        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        arrange(s , k);

        System.out.println(s);
    }
}
