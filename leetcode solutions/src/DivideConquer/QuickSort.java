package DivideConquer;

public class QuickSort {
    public static void print(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

        public static void swap ( int[] arr, int i, int j ){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        public static int partition ( int[] arr, int first, int last){
            int pivot = arr[last];

            int i = first - 1;
            for (int j = first; j < last ; j++) {
                if (arr[j] < pivot) {
                    i++;
                    swap(arr, i, j);
                }
            }
            swap(arr, i + 1, last);
            return i + 1;
        }


        public static void quickSort ( int[] arr, int first, int last){
            if (first < last) {
                int pi = partition(arr, first, last);
                //left
                quickSort(arr, first, pi - 1);
                //right
                quickSort(arr, pi + 1, last);
            }
        }

        public static void main (String[]args){
            int[] arr = {4, 9, 1, 2, 7, 8};
            quickSort(arr , 0 , arr.length-1);
            print(arr);


    }
}
