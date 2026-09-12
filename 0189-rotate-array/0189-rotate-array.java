class Solution {
    public void swap(int[] nums , int start , int end){
        int temp = nums[end];
        nums[end] = nums[start];
        nums[start] = temp;
    }
    public void reverse(int[] nums , int start , int end){
        
        while(start < end){
            swap(nums , start , end);
            start++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {
        if(k == 0){
            return;
        }
        k = k%nums.length;
        
        
        reverse(nums , 0 , nums.length-1);
        reverse(nums , 0 , k-1);
        reverse(nums , k , nums.length-1);
        
    }
}