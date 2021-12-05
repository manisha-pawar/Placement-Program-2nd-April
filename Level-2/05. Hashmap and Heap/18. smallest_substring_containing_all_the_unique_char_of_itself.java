//https://practice.geeksforgeeks.org/problems/smallest-distant-window3132/1

class Solution {
    public String findSubString( String str) {
        // Your code goes here
        
        HashSet<Character>hs = new HashSet<>();
        
        for(int i=0; i < str.length();i++) {
            hs.add(str.charAt(i));
        }
        
        HashMap<Character,Integer>map = new HashMap<>();
        int i = -1;
        int j = -1;
        
        int olen = Integer.MAX_VALUE;
        int si = 0;
        int ei = -1;
        
        while(i <  str.length()-1) {
            //aquire
            while(i <  str.length() - 1 && map.size() < hs.size()) {
                i++;
                
                char ch = str.charAt(i);
                int of = map.getOrDefault(ch,0);
                map.put(ch,of + 1);
            }
            
            //release
            while(j < i && map.size() == hs.size()) {
                int len = i - j;
                
                if(len < olen) {
                    olen = len;
                    si = j + 1;
                    ei = i;
                }
                
                j++;
                
                char ch = str.charAt(j);
                
                if(map.get(ch) == 1) {
                    map.remove(ch);
                }
                else {
                    int of = map.get(ch);
                    map.put(ch,of - 1);
                }
                
            }
        }
        
        return str.substring(si,ei + 1);
    }
}