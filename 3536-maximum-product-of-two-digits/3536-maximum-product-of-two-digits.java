class Solution {
    public int maxProduct(int n) {
        String s = Integer.toString(n);
        char[] c = s.toCharArray();

        Arrays.sort(c);

        return (c[c.length - 1] - '0') * (c[c.length - 2] - '0');

    }
}