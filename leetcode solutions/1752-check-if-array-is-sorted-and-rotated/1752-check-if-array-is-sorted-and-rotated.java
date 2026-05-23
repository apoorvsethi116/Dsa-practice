class Solution {
    public boolean check(int[] nums) {
       int dip = 0;
        for(int i = 0; i < nums.length-1; i++){
            
            if(nums[i] > nums[i+1]){
                dip++;
            }
        }
        if (nums[nums.length - 1] > nums[0]) {
            dip++;
        }
      if(dip > 1){
        return false;
      }
      return true;
    }
}