class Solution {
    public void swap(int a , int b , int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public void moveZeroes(int[] nums) {
        int i = 0;
        for(int j = 0; j<nums.length; j++){
            if(nums[j] != 0){
                swap(i ,j ,nums);
                i++;
            }
            
        }
    }
}