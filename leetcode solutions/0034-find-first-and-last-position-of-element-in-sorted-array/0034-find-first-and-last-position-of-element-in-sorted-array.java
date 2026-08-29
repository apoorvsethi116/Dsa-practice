class Solution {

    public int findL(int[] nums , int target , int start , int end){
        int ans = -1;
        while(start <= end){
            int mid = start + (end - start)/2;

            if(target == nums[mid]){
                ans = mid;
                end = mid-1;
            }else if(target > nums[mid]){
                start = mid+1;

            }else{
                end = mid-1;
            }
        }

        return ans;
    }

    public int findR(int[] nums , int target , int start , int end){

        int ans = -1;
        while(start <= end){
            int mid = start + (end - start)/2;

            if(target == nums[mid]){
                ans = mid;
                start = mid+1;
            }else if(target > nums[mid]){
                start = mid+1;

            }else{
                end = mid-1;
            }
        }

        return ans;
        
    }


    public int[] searchRange(int[] nums, int target) {
        int first = findL(nums , target , 0 , nums.length-1);
        int second = findR(nums , target , 0 , nums.length-1);

        return new int[]{first , second};
    }
}