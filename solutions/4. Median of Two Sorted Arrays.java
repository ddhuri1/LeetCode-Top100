class Solution 
{
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        int lenx = nums1.length;
        int leny = nums2.length;
        
        if(lenx > leny)
            return findMedianSortedArrays(nums2, nums1);
        
        int start = 0;
        int end = lenx;
        
        while(start <= end)
        {
            int partx = (start + end) / 2;
            int party = (lenx + leny +1) /2 - partx ;
            int maxLeftx = (partx == 0) ? -1: nums1[partx -1];
            int minRightx = (partx == lenx) ? Integer.MAX_VALUE: nums1[partx];
            int maxLefty = (party == 0) ? -1: nums2[party -1];
            int minRighty = (party == leny) ? Integer.MAX_VALUE: nums2[party];
            
            if(maxLeftx <= minRighty && maxLefty <= minRightx )
            {
                if((lenx + leny)%2 == 0)
                    return (double)(Math.max(maxLeftx , maxLefty) + Math.min(minRightx , minRighty))/2;
                else
                    return (double)Math.max(maxLeftx , maxLefty);
            }
            else if(maxLeftx > minRighty)
            {
                end = partx - 1;
            }
            else
            {
                start = partx + 1;
            }
        }
        throw new IllegalArgumentException();
    }
}