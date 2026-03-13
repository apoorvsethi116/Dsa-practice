public class maxSubArray {
    public static int maxSubArray(int[] arr){
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            //System.out.print(arr[i] + " ");
            for(int j = i; j < arr.length; j++){
                int currentSum = 0;
                for(int k =i; k <= j; k++){
                    
                    currentSum += arr[k];
                    if(currentSum > maxSum){
                        maxSum = currentSum;
                    }
                }


            }

        }return maxSum;
    }
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        int arr[] = {0,1,2 ,-1};
        int ans = maxSubArray(arr);
        System.out.println(ans);
    }
}
