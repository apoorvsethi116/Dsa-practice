package DivideConquer;

public class InversionCount {
    //optimal approach
    public static int merge(int[] arr , int si , int mid , int ei){
        int[] temp = new int[ei - si + 1];
        //left part iterator
        int i = si;
        //right part iterator
        int j = mid + 1;
        //temp array iterator
        int k = 0;
        //inversion count
        int inv_count = 0;

        while(i <= mid && j <= ei){
            if(arr[i] <=  arr[j]){
                temp[k] = arr[i];
                i++ ;
            }else{
                inv_count += mid-i+1;
                temp[k] = arr[j];
                j++;
            }
            k++;


        }
        //leftover elements like
        // it could happen that size of left and right are not same

        //left
        while(i <= mid){
            temp[k++] = arr[i++];
        }
        //right
        while(j <= ei){
            temp[k++] = arr[j++];
        }

        //copy temp to original array
        for( k =0 , i=si; k< temp.length; k++ ,i++){
            arr[i] = temp[k];
        }
        return inv_count;
    }
    public static int optimalInversionCount(int[] arr , int si , int ei){
        if(si >= ei){
            return 0;
        }
        //divide
        int mid = si + (ei -si)/2;

        //left
        int linc = optimalInversionCount(arr , si , mid);
        //right
        int rinc = optimalInversionCount(arr , mid+1 , ei);
        //merge
        int inv_count = merge(arr , si , mid , ei);
        return linc + rinc + inv_count;
    }
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
        int res2 = optimalInversionCount(arr , 0 , arr.length-1);
        System.out.println("Brute force result: " + res);
        System.out.println("Opyimal approach result : " + res2);
    }
}
