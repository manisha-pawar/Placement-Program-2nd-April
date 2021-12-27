class Solution {
    public int longestkSubstr(String s, int k) {
        int i = -1;
        int j = -1;
        
        HashMap<Character,Integer>map = new HashMap<>();
        
        int ans = -1;
        
        while(i < s.length() - 1) {
            //aquire
            while(i < s.length()-1) {
                i++;
                
                char ch = s.charAt(i);
                int nf = map.getOrDefault(ch,0) + 1;
                map.put(ch,nf);
                
                if(map.size() == k) {
                    //valid
                    int len = i - j;
                    ans = Math.max(len,ans);
                }
                else if(map.size() == k+1){
                    //invalid
                    break;
                }
            }
            
            
            //release
            while(j < i && map.size() == k+1) {
                j++;
                
                char ch = s.charAt(j);
                
                if(map.get(ch) == 1) {
                    map.remove(ch);
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