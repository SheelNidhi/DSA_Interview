package org.example;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRoomII {
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a,b) -> Integer.compare((a.start),(b.start)));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(intervals.get(0).end);
        for(int i = 1; i< intervals.size() ;i++){
            Interval currentMeeting = intervals.get(i);
            if(currentMeeting.start >= minHeap.peek()){
                minHeap.poll();
            }
            minHeap.add(currentMeeting.end);

        }
        return  minHeap.size();
    }

}
 class Interval {
     int start, end;
     Interval(int start, int end) {
         this.start = start;
          this.end = end;
      }
  }
