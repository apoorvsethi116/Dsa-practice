package Arrays;

public class sortingAlgos {

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void selection(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minPos = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[minPos] > arr[j]) {
                    minPos = j;
                }
            }

            swap(arr, minPos, i);
        }
    }

    public static void bubbleSort(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }
    public static void insertionSort(int arr[]){
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int prev = i-1;
            while(prev >=0 && arr[prev] > curr){
                arr[prev +1] = arr[prev];
                prev--;
            }
            arr[prev + 1 ] = curr;
        }
    }
    public static void countingSort(int arr[]) {
        int max = arr[0];

        // Step 1: Find max
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Step 2: Create count array
        int count[] = new int[max + 1];

        // Step 3: Store frequencies
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        // Step 4: Reconstruct sorted array
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[index] = i;
                index++;
                count[i]--;
            }
        }
    }

    public static void main(String args[]) {
        int arr[] = {3, 5, 9 ,7, 66, 2, 1};
        Integer brr[] = {3, 5, 9 ,7, 66, 2, 1};//an object now

        //insertionSort(arr);
        //bubbleSort(arr);
        //Arrays.sort(arr , 1 , 6);
        //Arrays.sort(brr,Collections.reverseOrder());//works on objects not primitive dat types
        //countingSort(arr);
        printArr(arr);
    }
}