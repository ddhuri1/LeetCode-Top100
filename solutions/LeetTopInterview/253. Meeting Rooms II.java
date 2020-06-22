class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        int rooms = 0;
        
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        
        for(int i = 0; i < intervals.length; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        int endPtr = 0, startPtr = 0;
        while(startPtr < start.length){
            if(start[startPtr] < end[endPtr]){
                rooms++;
            }else{
                endPtr++;
            }
            startPtr++;
        }
        
        return rooms;
        
    }
}