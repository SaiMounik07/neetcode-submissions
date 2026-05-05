class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i = 0; i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        List<Integer>[] b = new List[nums.length+1];
        for(int ke: map.keySet()){
            int v = map.get(ke);
            if(b[v] == null){
                b[v] = new ArrayList<>();
            }
            b[v].add(ke);
        }
        int[] ans = new int[k];
        int index = 0;
        for(int  i = b.length-1;i>=0 && index<k;i--){
            if(b[i]!=null){
                for(int j : b[i]){
                    ans[index++] = j;
                    if(index == k) break;
                }
            }
        }
        return ans;
    }
}
