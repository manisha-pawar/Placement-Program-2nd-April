//https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap < Character, Integer > map = new HashMap < > ();
        int olen = 0;

        int i = -1;
        int j = -1;

        while (i < s.length() - 1) {
            //aquire
            while (i < s.length() - 1) {
                i++;

                char ch = s.charAt(i);
                int of = map.getOrDefault(ch, 0);
                map.put(ch, of + 1);

                if (map.get(ch) > 1) {
                    break;
                } 
                else {
                    int len = i - j;
                    olen = Math.max(len, olen);
                }
            }

            //release
            while (j < i) {
                j++;

                char ch = s.charAt(j);

                if (map.get(ch) == 1) {
                    map.remove(ch);
                } 
                else {
                    int of = map.get(ch);
                    map.put(ch, of - 1);
                    break;
                }
            }
        }

        return olen;
    }
}