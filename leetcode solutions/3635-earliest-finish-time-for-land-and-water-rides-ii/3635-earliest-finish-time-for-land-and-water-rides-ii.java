class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        // Evaluate both possibilities and return the absolute minimum
        long landThenWater = evaluateOrder(landStartTime, landDuration, waterStartTime, waterDuration);
        long waterThenLand = evaluateOrder(waterStartTime, waterDuration, landStartTime, landDuration);
        
        return (int) Math.min(landThenWater, waterThenLand);
    }

    private long evaluateOrder(int[] start1, int[] duration1, int[] start2, int[] duration2) {
        // Step 1: Find the earliest possible time to finish ANY ride of the first type
        int minFirstFinish = Integer.MAX_VALUE;
        for (int i = 0; i < start1.length; i++) {
            minFirstFinish = Math.min(minFirstFinish, start1[i] + duration1[i]);
        }

        // Step 2: From that optimal milestone, see which second ride completes the earliest
        long bestTotalFinish = Long.MAX_VALUE;
        for (int j = 0; j < duration2.length; j++) {
            // You can board the second ride either right after the first finishes,
            // or when the second ride actually opens—whichever is later.
            long secondStart = Math.max((long) minFirstFinish, (long) start2[j]);
            long totalFinish = secondStart + duration2[j];
            
            bestTotalFinish = Math.min(bestTotalFinish, totalFinish);
        }

        return bestTotalFinish;
    }
}