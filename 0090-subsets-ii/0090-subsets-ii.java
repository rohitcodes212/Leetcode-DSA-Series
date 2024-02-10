class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0 || nums == null){
            return result;
        }
        Arrays.sort(nums);
        backtrack(result,nums,new ArrayList<>(),0);
        return result;
    }
    private void backtrack(List<List<Integer>> result,int[] nums,List<Integer> current,int start){
        result.add(new ArrayList<>(current));
        for(int i = start;i<nums.length;i++){
            if(i>start && nums[i] == nums[i-1]){continue;}
            current.add(nums[i]);
            backtrack(result,nums,current,i+1);
            current.remove(current.size() - 1);
        }
    }
} 