package ArrayList;
import java.util.*;
public class Q3Sum {
    public static ArrayList<ArrayList<Integer>> threesum(ArrayList<Integer> num, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Collections.sort(num);
        for (int i = 0; i < num.size() - 2; i++) {
            if (i > 0 && num.get(i).equals(num.get(i - 1))) {
                continue;
            }
            int j = i + 1;
            int k = num.size() - 1;

            int reqSum = target - num.get(i);

            while (j < k) {
                if (num.get(j) + num.get(k) == reqSum) {
                    ans.add(new ArrayList<>(Arrays.asList(num.get(i), num.get(j), num.get(k))));
                    j++;
                    k--;

                    while (j < k && num.get(j).equals(num.get(j - 1))) j++;
                    while (j < k && num.get(k).equals(num.get(k + 1))) k--;

                } else if (num.get(j) + num.get(k) < reqSum) {
                    j++;
                } else if (num.get(j) + num.get(k) > reqSum) {
                    k--;
                }
            }
        }
        return ans;
    }
        public static void main (String[]args){
            int target = 0;
            ArrayList<Integer> list = new ArrayList<>();
            list.add(-1);
            list.add(0);
            list.add(1);
            list.add(2);
            list.add(-1);
            list.add(-4);

            ArrayList<ArrayList<Integer>> res = threesum(list , target);
            System.out.println(res);
        }


}
