//https://www.lintcode.com/problem/386/

public class Solution {
  
    public int lengthOfLongestSubstringKDistinct(String str, int k) {
        // write your code here
		//atmost k -> <= k
        HashMap<Character,Integer>map = new HashMap<>();

		int i = -1;
		int j = -1;

		int ans = 0; 

		while(i <  str.length()-1) {
			//aquire
			while(i < str.length() - 1 && map.size() <= k) {
				i++;

				char ch = str.charAt(i);
				int nf = map.getOrDefault(ch,0) + 1;
				map.put(ch,nf);

				if(map.size() <= k) {
					int len = i - j;
					ans = Math.max(ans,len);
				}
			}

			//release
			while(j < i) {
				j++;

				char ch = str.charAt(j);

				if(map.get(ch) == 1) {
					map.remove(ch);
					break;
				}
				else {
					int nf = map.get(ch) - 1;
					map.put(ch,nf);
				}
			}
		}

		return ans;
    }
}