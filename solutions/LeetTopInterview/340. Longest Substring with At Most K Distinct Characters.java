class Solution 
{
  public int lengthOfLongestSubstringKDistinct(String s, int k)
  {
        int[] charFreq = new int[256];
        int distCharCount = 0;
        int substringMaxLen = 0;
        int l = 0, r = 0;
        char[] arr = s.toCharArray();
        while (r < arr.length) 
        {
            char cR = arr[r];
            charFreq[cR]++;
            if (charFreq[cR] == 1) 
                distCharCount++;
            if (distCharCount <= k) 
                substringMaxLen = Math.max(substringMaxLen, r-l+1);
            else 
            {
                while (distCharCount > k) 
                {
                    char cL = arr[l];
                    charFreq[cL]--;
                    if (charFreq[cL] == 0) 
                        distCharCount--;
                    l++;
                }
            }
            r++;
        }
        return substringMaxLen;
    }
}