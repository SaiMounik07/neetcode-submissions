class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
       int res = 0;
        while(l <= r){
            int k = (l+r)/2;
            int t = 0;
            for(int i : piles){
                t+=Math.ceil((double) i/k);
            }
            if(t<=h){
                res = k;
                r = k-1;
            }else{
                l = k+1;
            }
        }
        return res;
    }
}
