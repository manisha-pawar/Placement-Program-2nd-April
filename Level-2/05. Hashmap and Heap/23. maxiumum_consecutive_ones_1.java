//https://www.lintcode.com/problem/883/

public class Solution {
   
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int cz = 0;
        int ans = 0;

        int i = -1;
        int j = -1;

        while(i <  nums.length - 1) {
            //aquire
            while(i < nums.length - 1 && cz <= 1) {
                i++;

                if(nums[i] == 0) {
                    cz++;
                }
        
                if(cz <= 1) {
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