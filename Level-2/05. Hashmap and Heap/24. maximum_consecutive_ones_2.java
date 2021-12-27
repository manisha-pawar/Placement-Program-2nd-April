//https://leetcode.com/problems/max-consecutive-ones-iii/

class Solution {
    public int longestOnes(int[] nums, int k) {
        int cz = 0;
        int ans = 0;

        int i = -1;
        int j = -1;

        while(i <  nums.length - 1) {
            //aquire
            while(i < nums.length - 1 && cz <= k) {
                i++;

                if(nums[i] == 0) {
                    cz++;
                }
        
                if(cz <= k) {
                    int len = i - j;
                    ans = Math.max(len,ans);
                }
            }


            //release
            while(j < i) {
                j++;

                if(nums[j] == 0) {
                    cz--;
                    break;
                }
            }

        }

        return ans;

    }
}