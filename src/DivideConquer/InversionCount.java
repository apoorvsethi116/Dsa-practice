package DivideConquer;

public class InversionCount {

    //brute force approach
    public static int inversionCount(int[] arr){
        // inv_count is when arr[i] > arr[j]
        //for i<j ,
        int inv_count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if(arr[i] > arr[j]){
                    inv_count ++;
                }
            }
        }
        return inv_count;
    }
    public static void main(String[] args) {
        int[] arr = {2 ,4,1,3,5};
        int res = inversionCount(arr);
        System.out.println(res);
    }
}
