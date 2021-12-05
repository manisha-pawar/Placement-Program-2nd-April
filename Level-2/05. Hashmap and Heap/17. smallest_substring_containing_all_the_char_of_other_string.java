//https://leetcode.com/problems/minimum-window-substring/

class Solution {
    public String minWindow(String s, String t) {
        
        if(t.length() > s.length()) {
            return "";    
        }
        
        HashMap<Character,Integer>t_map = new HashMap<>(); 
        
        for(int i=0; i < t.length();i++) {
            char ch = t.charAt(i);
            int of = t_map.getOrDefault(ch,0);
            t_map.put(ch,of + 1);
        }
        
        int mc = 0;
        HashMap<Character,Integer>map = new HashMap<>();
        int olen = Integer.MAX_VALUE;
        int si = 0;
        int ei = -1;
        
        int i = -1,j = -1;
        
        while(i < s.length() - 1) {
            //aquire
            while(i < s.length()-1  && mc < t.length()) {
                i++;
                
                //aquire ith character
                char ch = s.charAt(i);
                int of = map.getOrDefault(ch,0);
                map.put(ch,of + 1);
                
                //impact of aquired character on match count
                if(map.getOrDefault(ch,0) <= t_map.getOrDefault(ch,0)) {
                    mc++;
                }
            }
            
            //release
            while(j < i && mc == t.length()) {
                int len = i - j;
                
                if(len < olen) {
                    olen = len;
                    si = j + 1;
                    ei = i;
                }
                
                j++;
                
                //release jth character
                char ch = s.charAt(j);
                if(map.get(ch) == 1) {
                    map.remove(ch);
                }
                else {
                    int of = map.get(ch);
                    map.put(ch,of - 1);
                }
                
                //impact of released character on match count
                if(map.getOrDefault(ch,0) < t_map.getOrDefault(ch,0)) {
                    mc--;
                }
                
            }
        }
        
       
        return s.substring(si,ei+1);
        
    }
}