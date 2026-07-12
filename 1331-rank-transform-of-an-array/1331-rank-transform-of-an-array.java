class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] ans = new int[arr.length];
        int[] temp = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }

        Arrays.sort(temp);

        int rank = 1;
        HashMap<Integer, Integer> h = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!h.containsKey(temp[i])) {
                h.put(temp[i], rank);
                rank++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            ans[i] = h.get(arr[i]);
        }

        return ans;

    }
}