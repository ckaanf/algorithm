class Solution {
    public int minIncrementForUnique(int[] nums) {
		Arrays.sort(nums);
		int cnt = 0;
		for(int i = 0; i < nums.length-1; i++) {
			while(nums[i] > nums[i+1]) {
				nums[i+1] = nums[i+1] + 1 ;
				cnt++;
			}
			if(nums[i] == nums[i+1]) {
				nums[i + 1] = nums[i + 1] + 1;
				cnt++;
			}
        }
        return cnt;
    }
}