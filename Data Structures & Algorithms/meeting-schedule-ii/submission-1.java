/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return 0;
        }
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{intervals.get(0).start,intervals.get(0).end});
        int min=1;
        for(int i=1;i<intervals.size();i++){
            int[] top=pq.poll();
            int end=top[1];
            if(end<=intervals.get(i).start){
                pq.offer(new int[]{top[0],Math.max(end,intervals.get(i).end)});

            }
            else{
                min+=1;
                pq.offer(top);
                pq.offer(new int[]{intervals.get(i).start,intervals.get(i).end});
                
            }
        }
        return min;
    }
}
