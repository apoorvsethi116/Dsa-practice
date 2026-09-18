class Solution {
    public void duplicateZeros(int[] arr) {
        Queue<Integer> q = new LinkedList<>();
        for(int a : arr){
            if(a == 0){
                q.add(0);
                q.add(0);
            }else{
                q.add(a);
            }
        }
        int x = 0;

        while(!q.isEmpty() && x < arr.length ){
            arr[x] = q.remove();
            x++;
        }
    }
}