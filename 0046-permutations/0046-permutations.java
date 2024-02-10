class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return result;
        }

        permutations(nums,new ArrayList<>(),result);
        return result;
    }
    private void permutations(int[] nums,List<Integer> current,List<List<Integer>> result){
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
        }

        for(int i=0;i<nums.length;i++){
            if(current.contains(nums[i])){
                continue;
            }
            current.add(nums[i]);
            permutations(nums,current,result);
            current.remove(current.size() - 1);
        }
    }

}