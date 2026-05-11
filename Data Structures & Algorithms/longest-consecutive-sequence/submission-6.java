class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        int lonn = 0;
        for(int num: set){
            int len = 1;
            if(!set.contains(num - 1)){
                while(set.contains(num+len)){
                    len++;
                }
                lonn = Math.max(lonn,len);
            }
        }
        return lonn;
    }
}
