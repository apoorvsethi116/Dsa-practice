package Recursion;

public class AllOccurence {
    public static void findAllOccur(int[] arr , int key , int i){

        if(i == arr.length){
            return;
        }

        //kaam
        if(arr[i] == key){
            System.out.print(i + " ");
            //findAllOccur(arr , key , i+1);
        }
         findAllOccur(arr, key, i + 1);
    }


    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 5, 6, 2, 7, 2 , 2};
        findAllOccur(arr , 2 , 0);

    }
}
