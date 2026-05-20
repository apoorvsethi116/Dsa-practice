import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        // Step 1: Push the index of every person into the queue
        for (int i = 0; i < tickets.length; i++) {
            queue.add(i);
        }
        
        // Step 2: Simulate the line moving
        while (!queue.isEmpty()) {
            // Take the person at the front of the line
            int currentPerson = queue.poll();
            
            // They buy 1 ticket, which takes 1 second
            tickets[currentPerson]--;
            time++;
            
            // Check if this was person 'k' and they just bought their last ticket
            if (currentPerson == k && tickets[k] == 0) {
                return time;
            }
            
            // If they still need more tickets, they go to the back of the line
            if (tickets[currentPerson] > 0) {
                queue.add(currentPerson);
            }
        }
        
        return time;
    }
}