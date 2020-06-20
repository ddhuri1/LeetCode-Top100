class Solution {
    public int reverse(int x) {
         int res = 0;
        for(;(x != 0) && (Math.abs(res) <= Integer.MAX_VALUE / 10);x /= 10) res = (res * 10) + x % 10;
        return x == 0 ? res : 0;
	
    }
}