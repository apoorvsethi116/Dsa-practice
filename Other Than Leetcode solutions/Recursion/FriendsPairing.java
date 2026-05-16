package Recursion;
//Given n friends, each one can remain single or can be paired
//up with some other friend.
//Each friend can be paired only once. Find out the total number
//of ways in which friends can remain single or can be paired up.
public class FriendsPairing {
    public static int friendsPairWays(int n){
        if(n == 1 || n == 2){
            return n;
        }
        // single
        int singal = friendsPairWays(n-1);

        //pair
        int pair = (n-1) * friendsPairWays(n-2);

        //total
        return singal + pair;
    }
    public static void main(String args[]){
        int n = 3;
        System.out.println(friendsPairWays(n));

    }

}
