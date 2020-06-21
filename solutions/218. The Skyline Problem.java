class Solution
{
    public List<List<Integer>> getSkyline(int[][] buildings) 
    {
        List<List<Integer>> res = new ArrayList();
        if (buildings.length == 0) return res;

        PriorityQueue<int[]> pq = new PriorityQueue(buildings.length, new Comparator<int[]>() 
        {
            public int compare(int[] o1, int[] o2) 
            {
                return o2[2] == o1[2] ? o1[0] - o2[0] : o2[2] - o1[2];
            }
        });

        int[] pre = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        for (int[] building : buildings) 
        {
            while (!pq.isEmpty() && building[0] > pre[1]) 
            {
                int[] cur = pq.poll();
                if (cur[1] <= pre[1])
                    continue;
                res.add(Arrays.asList(pre[1], cur[2]));
                pre = cur;
            }

            if (pre[2] < building[2]) 
            {
                if (pre[0] == building[0])
                    res.remove(res.size() - 1);
                res.add(Arrays.asList(building[0], building[2]));
                if (pre[1] > building[1])
                    pq.offer(pre);
                pre = building;
            } 
            else if (pre[2] == building[2])
                pre[1] = Math.max(pre[1], building[1]);
            else if (pre[1] < building[1]) 
                pq.offer(building);
        }

        while (!pq.isEmpty())
        {
            int[] cur = pq.poll();
            if (cur[1] <= pre[1])
                continue;
            res.add(Arrays.asList(pre[1], cur[2]));
            pre = cur;
        }

        if (pre[2] > 0) 
            res.add(Arrays.asList(pre[1], 0));
        
        return res;
    }
}