class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int minFinishTime = Integer.MAX_VALUE;

        // Try every combination of Land Ride i and Water Ride j
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Case 1: Land ride first, then Water ride
                int landFinish = landStartTime[i] + landDuration[i];
                int totalFinish1 = Math.max(landFinish, waterStartTime[j]) + waterDuration[j];
                
                // Case 2: Water ride first, then Land ride
                int waterFinish = waterStartTime[j] + waterDuration[j];
                int totalFinish2 = Math.max(waterFinish, landStartTime[i]) + landDuration[i];
                
                // Keep track of the absolute minimum finish time found
                minFinishTime = Math.min(minFinishTime, Math.min(totalFinish1, totalFinish2));
            }
        }

        return minFinishTime;
    }
}
