package Recursion;

public class FirstOccurence {
    public static int lastOccurence(int arr[] , int key , int i) {
        if(i == arr.length){  /*Go till end then check if we
                                   found it while returning or not*/
            return -1;
        }
        int isFound = lastOccurence(arr , key , i+1);
        if(isFound == -1 && arr[i] == key){
            return i;
        }
        return isFound;
    }
    public static int firstOccurence(int arr[] , int key , int i){
        if(i == arr.length){
            return -1;
        }
        if(arr[i] == key){
            return i;
        }
       return firstOccurence(arr ,key ,i+1);

    }

    public static void main(String[] args){
        int arr[] = { 2, 4,3 ,4 };
        //int res = firstOccurence(arr , 22 , 0);
        int res2 = lastOccurence(arr , 2 , 0);
        System.out.println(res2);
    }

}
