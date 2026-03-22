package DivideConquer;

public class MergeSort {
    public static void print(int[] arr){
        for(int j : arr) {
            System.out.print(j + " ");
        }
    }
    public static void merge(int[] arr , int si , int mid , int ei){
        int[] temp = new int[ei - si + 1];
        //left part iterator
        int i = si;
        //right part iterator
        int j = mid + 1;
        //temp array iterator
        int k = 0;
        while(i <= mid && j <= ei){
            if(arr[i] <  arr[j]){
                temp[k] = arr[i];
                i++ ;  k++;
            }else{
                temp[k] = arr[j];
                j++; k++;
            }


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
    }
    public static void mergeSort(int[] arr , int si , int ei){
        if(si >= ei){
            return;
        }
        //divide
        int mid = si + (ei -si)/2;
        int n = arr.length;
        //left
        mergeSort(arr , si , mid);
        //right
        mergeSort(arr , mid+1 , ei);
        //merge
        merge(arr , si , mid , ei);

    }
    public static void main(String[] args) {
        int[] arr = {4 , 9, 1 ,2 ,7 ,8};
        mergeSort(arr , 0 , arr.length-1);
        print(arr);
    }
}
