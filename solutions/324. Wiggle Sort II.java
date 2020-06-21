class Solution 
{
    public void wiggleSort(int[] nums)
    {
        int n = nums.length;
        int[] nums2 = new int[n];
        for(int i = 0; i < n; i++)
            nums2[i] = nums[i];
        int mid = partition(nums2, 0, n - 1, n / 2);
        
        int[] ans = new int[n];
        for(int i = 0; i < n; i++)
            ans[i] = mid;

        int l = 1, r = (n % 2 == 0) ? (n - 2) : (n - 1);
        for(int i = 0; i < n; i++)
        {
            if(nums[i] < mid)
            {
                ans[r] = nums[i];
                r = r - 2;
            }
            else if(nums[i] > mid)
            {
                ans[l] = nums[i];
                l = l + 2;
            }
        }
        for(int i = 0; i < n; i++)
            nums[i] = ans[i];
    }
    
    private int partition(int[] nums, int start, int end, int rank)
    {
        int left = start;
        int right = end;
        int pivot = nums[start + (end - start) / 2];
        while(left <= right)
        {
            while(left <= right && nums[left] < pivot)
                left++;
            while(left <= right && nums[right] > pivot)
                right--;
            if(left <= right)
            {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        if(rank <= right) 
            return partition(nums, start, right, rank);
        else if(rank >= left) 
            return partition(nums, left, end, rank);
        else return nums[rank];
    }
}

