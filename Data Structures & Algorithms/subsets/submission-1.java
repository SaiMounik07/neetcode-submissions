class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int num : nums){
            int s = res.size();
            for(int i=0 ;i<s;i++){
                List<Integer> list = new ArrayList<>(res.get(i));
                list.add(num);
                res.add(list);

            }
        }return res;
    }
}
