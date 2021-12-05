//https://practice.geeksforgeeks.org/problems/longest-subarray-with-sum-divisible-by-k1259/1

class Solution {
    int longSubarrWthSumDivByK(int a[], int n, int k) {
        // Complete the function
        HashMap < Integer, Integer > map = new HashMap < > (); //ps % k vs first occ
        int ps = 0;
        int olen = 0;
        map.put(0, -1);

        for (int i = 0; i < n; i++) {
            ps += a[i];
            int rem = ps % k;

            if (rem < 0) {
                rem += k;
            }

            if (map.containsKey(rem) == false) {
                map.put(rem, i);
            } 
            else {
                int len = i - map.get(rem);
                if (len > olen) {
                    olen = len;
                }
            }
        }

        return olen;

    }

}