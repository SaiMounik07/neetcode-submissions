class Solution {
    public int findDuplicate(int[] nums) {
        int f = 0,s = 0;
        while(true){
            s = nums[s];
            f = nums[nums[f]];
            if(s == f) break;
        }
        int s1 = 0;
        while(true){
            s = nums[s];
            s1 = nums[s1];
            if(s == s1) return s;
        }

    }
}
