class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findComb(0,target,ans,nums,new ArrayList<>());
        return ans;
    }
    public void findComb(int index,int target,List<List<Integer>> ans,int[] nums,List<Integer> ds){
        if(index == nums.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(nums[index] <= target){
            ds.add(nums[index]);
            findComb(index,target - nums[index],ans,nums,ds);
            ds.remove(ds.size()-1);
        }
        findComb(index+1,target,ans,nums,ds);
    }
}
