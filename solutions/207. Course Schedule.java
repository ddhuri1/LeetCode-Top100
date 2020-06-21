class Solution 
{
    List<Integer>[] dependancy;
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {
        dependancy = new List[numCourses];
        for (int i = 0; i < numCourses; i++) 
            dependancy[i] = new ArrayList<Integer>();
        
        for (int[] rule : prerequisites) 
        {    
            if (this.isConnect(rule[1], rule[0])) 
                return false;
            dependancy[rule[0]].add(rule[1]);
        }
        
        return true;
    }

    private boolean isConnect(int u, int v) 
    {
        for (Integer node : dependancy[u]) 
            if (node == v || this.isConnect(node, v)) 
                return true;
        return false;
    }
}