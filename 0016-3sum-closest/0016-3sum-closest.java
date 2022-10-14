class Solution {

    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int close = Integer.MAX_VALUE;
        int first = 0, second = 0, third = 0;
        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                int low = i + 1;
                int high = n - 1;
                int aim = target - nums[i];

                while (low < high) {
                    int sum = nums[low] + nums[high];

                    if (sum == aim) {
                        first = nums[i];
                        second = nums[low];
                        third = nums[high];
                        return first + second + third;
                    } 
                    
                    else if (sum < aim) {
                        if (aim - sum < close) {
                            first = nums[i];
                            second = nums[low];
                            third = nums[high];
                            close = aim - sum;
                        }
                        low++;
                    } 
                    
                    else {
                        if (sum - aim < close) {
                            first = nums[i];
                            second = nums[low];
                            third = nums[high];
                            close = sum - aim;
                        }
                        high--;
                    }
                }
            }
        }

        return first + second + third;
    }
}
