package Stack;
import java.util.*;

public class ReverseStack {
    public static void pushAgain(Stack<Integer> s , int top){
        if(s.isEmpty()){
            s.push(top);
            return;
        }
        int curr = s.pop();
        pushAgain(s , top);
        s.push(curr);
    }
    public static void reverseStack(Stack<Integer> s ){
        if(s.isEmpty()){

            return;
        }

        int curr = s.pop();
        reverseStack(s);
        pushAgain(s , curr);

    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println(s);
        reverseStack(s );
        System.out.println(s);
    }
}
