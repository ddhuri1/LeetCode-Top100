class Solution 
{
    public int[] findOrder(int numCourses, int[][] prerequisites) 
    {
        List<List<Integer>> courses = new ArrayList<>();
        for(int i = 0; i < numCourses; i++)
            courses.add(new ArrayList<>());
        for(int i = 0; i < prerequisites.length; i++)
            courses.get(prerequisites[i][0]).add(prerequisites[i][1]);
        
        int[] visited = new int[numCourses];
        List<Integer> res = new ArrayList<>();
        
        for(int i = 0; i < numCourses;i++)
            if(dfs(i, courses, visited, res))
                return new int[0];

        int[] output = new int[res.size()];
        for(int i = 0; i < res.size();i++)
            output[i] = res.get(i);
        return output;
    }
    
    public boolean dfs(int course, List<List<Integer>> courses, int[] visited, List<Integer> res)
    {
        if(visited[course] == 1) return true;
        if(visited[course] == 2) return false;
        visited[course] = 1;
        
        for(int next : courses.get(course))
            if(dfs(next, courses, visited, res))
                return true;

        visited[course] = 2;
        res.add(course);
        return false;
    }
}