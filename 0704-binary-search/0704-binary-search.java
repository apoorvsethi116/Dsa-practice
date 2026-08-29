class Solution {

    public int binary(int[] nums , int target , int start , int end){
        int mid = start + (end-start)/2;

        if(start > end){
            return -1;
        }

        if(target == nums[mid]){
            return mid;
        }

        if(target < nums[mid]){
            return binary(nums , target , start , mid-1);
        }else{
            return binary(nums , target , mid+1 , end);
        }


    }
    public int search(int[] nums, int target) {
        return binary(nums , target , 0 , nums.length-1);
    }
}