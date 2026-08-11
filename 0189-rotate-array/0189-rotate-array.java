class Solution {
    public void reverse(int[] nums , int i , int j){
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;


            i++;
            j--;

            
        }
    }
    public void rotate(int[] nums, int k) {
        int[] ans = new int[nums.length];

        int rot = k % nums.length;

        reverse(nums , 0 , nums.length-1);
        reverse(nums , 0 , rot-1);
        reverse(nums , rot , nums.length-1);

    }
}