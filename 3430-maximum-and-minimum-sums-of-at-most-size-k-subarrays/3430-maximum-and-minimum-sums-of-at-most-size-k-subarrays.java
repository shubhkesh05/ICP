class Solution {
    public long minMaxSubarraySum(int[] nums, int k) {
        int[] pr1 = new int[nums.length], pr2 = new int[nums.length], nx1 = new int[nums.length], nx2 = new int[nums.length], st1 = new int[nums.length], st2 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pr1[i] = pr2[i] = -1;
            nx1[i] = nx2[i] = nums.length;
        }
        int ix1 = -1, ix2 = -1;
        for (int i = 0; i < nums.length; i++) {
            while (ix1 >= 0 && nums[st1[ix1]] <= nums[i]) {
                nx1[st1[ix1]] = i;
                ix1--;
            }
            ix1++;
            st1[ix1] = i;
            while (ix2 >= 0 && nums[st2[ix2]] >= nums[i]) {
                nx2[st2[ix2]] = i;
                ix2--;
            }
            ix2++;
            st2[ix2] = i;            
        }
        ix1 = -1;
        ix2 = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (ix1 >= 0 && nums[st1[ix1]] < nums[i]) {
                pr1[st1[ix1]] = i;
                ix1--;
            }
            ix1++;
            st1[ix1] = i;
            while (ix2 >= 0 && nums[st2[ix2]] > nums[i]) {
                pr2[st2[ix2]] = i;
                ix2--;
            }
            ix2++;
            st2[ix2] = i;            
        }
        long res = 0L;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i] * count(i - pr1[i], nx1[i] - i, k);
            res += nums[i] * count(i - pr2[i], nx2[i] - i, k);
        }
        return res;
    }

    static long count(long l, long r, long k) {
        l = Math.min(l, k);
        r = Math.min(r, k);
        long bound = Math.max(0, l + r - 1 - k);
        long invalid = bound * (bound + 1) / 2;
        return l * r - invalid;
    }
}