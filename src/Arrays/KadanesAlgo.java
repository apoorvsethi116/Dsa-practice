package Arrays;

public class KadanesAlgo {
    //accepts all negative array too
    public static int newKadane(int[] arr){
        int n = arr.length;
        int cs = arr[0];
        int ms = arr[0];

        for (int i = 1; i < n ; i++) {
            cs = Math.max(arr[i] , cs+arr[i]);

            ms = Math.max(cs , ms);
        }
        return ms;
    }

    //does not accept all negative array
    public static int kadane(int arr[]) {
        int n = arr.length;
        int cs = 0;
        int ms = Integer.MIN_VALUE;
         for (int i = 0; i<n ; i++){
             cs += arr[i];
             if(cs < 0){
                 cs = 0;
             }
             ms = Math.max(cs , ms);
         }
         return ms;
    }

    public static void main(String args[]) {
        int arr[] = {1 , -1 , 2 , -3 , 4};
        System.out.println(kadane(arr));
        int brr[] = {-1 , -1 , -2 , -3 , -4};
        System.out.println(newKadane(brr));
    }
}

