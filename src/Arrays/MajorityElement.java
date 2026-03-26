package Arrays;

public class MajorityElement {
    public static int majorityElement(int[] nums){
        int n = nums.length;
        int majority = nums[0];
        int count = 1;

        for(int i = 1; i < n; i++){
            if(nums[i] == majority){
                count++;
            }else{
                count--;
                if(count == 0){
                    majority = nums[i];
                    count = 1;
                }
            }
        }
        count = 0;
        for(int i = 0; i<n; i++){
            if(nums[i] == majority){
                count ++;
            }


        }

        if (count > n / 2) {
            return majority;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,1,2,2,2,2,2,1,1};
        System.out.println(majorityElement(arr));
    }
}
