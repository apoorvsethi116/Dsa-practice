class Solution {
    
   public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    int[] ans = new int[nums1.length];
    
    for (int i = 0; i < nums1.length; i++) {
        int nextGreater = -1; // Default to -1 if none found
        
        for (int j = 0; j < nums2.length; j++) {
            // Find the matching element in nums2
            if (nums1[i] == nums2[j]) {
                // Scan everything to the right of j
                for (int k = j + 1; k < nums2.length; k++) {
                    if (nums2[k] > nums2[j]) {
                        nextGreater = nums2[k];
                        break; // Found the *first* greater element, stop scanning
                    }
                }
                break; // Found the element in nums2, no need to keep looking
            }
        }
        ans[i] = nextGreater;
    }
    
    return ans;
}
}