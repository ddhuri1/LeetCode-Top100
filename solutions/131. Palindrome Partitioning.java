class Solution 
{
    List<List<String>> resultLst;
    ArrayList<String> currLst;
    public List<List<String>> partition(String s) 
    {
        resultLst = new ArrayList<List<String>>();
        currLst = new ArrayList<String>();
        char[] arr = s.toCharArray();
        backTrack(arr,0);
        return resultLst;
    }
    
    public void backTrack(char[] arr, int l)
    {
        if(l >= arr.length)
        {
            List<String> res = new ArrayList<>(currLst);
            resultLst.add(res);
        }
        for(int i = l; i < arr.length; i++)
        {
            if(isPalindrome(arr, l, i))
            {
                if(l == i)
                    currLst.add(Character.toString(arr[i]));
                else 
                    currLst.add(new String(arr, l, i + 1 - l));
                backTrack(arr,i+1);
                currLst.remove(currLst.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(char[] arr, int l, int r)
    {
        if(l==r) return true;
        while(l<r)
        {
            if(arr[l] != arr[r]) 
                return false;
            l++;
            r--;
        }
        return true;
    }
}