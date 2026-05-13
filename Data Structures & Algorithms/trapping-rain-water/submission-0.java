class Solution {
    public int trap(int[] height) {
        int l = 0,r = height.length - 1,lm = Integer.MIN_VALUE,rm=Integer.MIN_VALUE,ans = 0;
        while(l < r){
            lm = Math.max(lm,height[l]);
            rm = Math.max(rm,height[r]);
            ans+=(height[l] < height[r]) ? lm - height[l++]: rm - height[r--];
        }
        return ans;
    }
}
