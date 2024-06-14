class Solution {
    public int minIncrementForUnique(int[] nums) {
		Arrays.sort(nums);
		int cnt = nums[0];
		int result = 0;
		for(int i= 1 ;i<nums.length ;i++){
			cnt++;
			if(cnt <= nums[i]){
				cnt = nums[i];
			}else{
				result += cnt - nums[i];
			}
		}
		
        return result;
    }
}