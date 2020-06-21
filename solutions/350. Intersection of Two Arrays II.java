/* Slow
class Solution 
{
    public int[] intersect(int[] nums1, int[] nums2) 
    {
        List<Integer> temp = new ArrayList<Integer>();
        List<Integer> res = new ArrayList<Integer>();
        for(int i : nums1)
            temp.add(i);
        for(int j : nums2)
        {
            if(temp.contains(j))
            {
                res.add(j);
                temp.remove((Integer)j);
            }
        }
        int[] result = new int[res.size()];
        int count = 0;
        for(int k : res)
            result[count++] = k;
        return result;
    }
}*/

class Solution
{
    public int[] intersect(int[] nums1, int[] nums2) 
    {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> sec = new ArrayList<>();
        if(nums2.length > nums1.length) 
            return intersect(nums2, nums1);
        for(int i = 0; i < nums1.length; i++)
        {
            if(map.containsKey(nums1[i]))
                map.put(nums1[i], map.get(nums1[i])+1);
            else
                map.put(nums1[i], 1);
        }
        for(int i = 0; i < nums2.length; i++)
        {
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0)
            {
                sec.add(nums2[i]);
                map.put(nums2[i],map.get(nums2[i])-1);
            }
        }
        int  p = 0;
        int[] res = new int[sec.size()];
        
        for(int i : sec)
            res[p++] = i;
        return res;
    }
}


