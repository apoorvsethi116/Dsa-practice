class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] nsr = new int[heights.length];
        int[] nsl = new int[heights.length];
        int maxArea = 0;
        //next smaller right
        Stack<Integer> s = new Stack<>();
        for(int i =  heights.length-1; i >= 0; i--){
            int curr = heights[i];
            while(!s.isEmpty() && heights[s.peek()] >= curr){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i] = heights.length;
            }else{  
                nsr[i] = s.peek();
            }

            s.push(i);
        }
        //next smaller left 
        s = new Stack<>();
        for(int i = 0; i < heights.length; i++){
            int curr = heights[i];
            while(!s.isEmpty() && heights[s.peek()] >= curr){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i] = -1;
            }else{  
                nsl[i] = s.peek();
            }

            s.push(i);
        }

        for(int i = 0; i < heights.length; i++){
            int length = heights[i];
            int breadth = nsr[i] - nsl[i] - 1;
            int currArea = length * breadth;
            maxArea = Math.max(currArea , maxArea);
        }

        return maxArea;

    }
}