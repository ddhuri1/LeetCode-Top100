class Solution 
{
    public int longestSubstring(String s, int k) {        
        if(k<2)
            return s.length();
        return dfs(s,0,s.length(),k);
    }
    public int dfs(String s, int l, int r, int k){
        int ans=0;
        if(r-l<k)
            return 0;        
        int arr[]=new int[26];        
        for(int i=l;i<r;i++)            
            arr[s.charAt(i)-'a']++;
        boolean f=true;
        for(int i=0;i<26;i++)            
            f&=(arr[i]==0||arr[i]>=k);
        if(f) return r-l;
        int st=0;
        for(int i=l;i<r;i++){
            if(arr[s.charAt(i)-'a']<k){
                ans=Math.max(ans,dfs(s,st,i,k));
                st=i+1;
            }
        }
        ans=Math.max(ans,dfs(s,st,r,k));
        return ans;
    }
}