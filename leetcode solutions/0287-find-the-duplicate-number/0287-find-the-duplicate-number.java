class Solution {
    public int findDuplicate(int[] nums) {
        // Phase 1: Find the intersection point of the fast and slow pointers
        int tortoise = nums[0];
        int hare = nums[0];
        
        do {
            tortoise = nums[tortoise];       // Moves 1 step
            hare = nums[nums[hare]];         // Moves 2 steps
        } while (tortoise != hare);
        
        // Phase 2: Find the entrance to the cycle (the duplicate number)
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];       // Moves 1 step
            hare = nums[hare];               // Moves 1 step
        }
        
        return hare;
    }
}