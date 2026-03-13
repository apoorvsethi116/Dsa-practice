public class trappedRainwater {

        public static int trap(int[] height) {
            int n = height.length;
            int tw = 0;
            int leftMax[]= new int[n];
            leftMax[0] = height[0];
            int rightMax[]= new int[n];
            rightMax[n-1] = height[n-1];
            for (int i = 1; i < n; i++) {
                leftMax[i] = Math.max(height[i] ,leftMax[i-1]);

            }
            for (int j = n-2; j >=0; j--) {
                rightMax[j] = Math.max(height[j] , rightMax[j+1]);
            }
            for (int k = 0; k < n; k++) {
                int wl = Math.min(leftMax[k], rightMax[k]);
                tw +=  wl - height[k];


            }
            return tw;
        }

        public static void main(String args[]){
            int arr[] = {4 , 2 , 0 , 5 , 3 , 2};
            int res = trap(arr);
            System.out.println(res);
        }

    }


