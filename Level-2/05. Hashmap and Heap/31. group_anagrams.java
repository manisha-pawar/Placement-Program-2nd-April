//https://leetcode.com/problems/group-anagrams/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>>map = new HashMap<>();
        
        for(String str : strs) {
            String key = getKey(str);
            
            if(map.containsKey(key) == true) {
                ArrayList<String>list = map.get(key);
                list.add(str);
            }
            else {
                ArrayList<String>list = new ArrayList<>();
                list.add(str);
                map.put(key,list);
            }
        }
        
        List<List<String>>ans = new ArrayList<>();
    
        for(String key : map.keySet()) {
            ans.add(map.get(key));
        }

        return ans;
    }
    
    public static String getKey(String str) {
        int[]arr = new int[26];
        
        for(int i=0; i < str.length();i++) {
            char ch = str.charAt(i);
            
            arr[ch - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder("");
        
        for(int i=0; i < 26;i++) {
            int f = arr[i];
            
            if(f == 0) {
                continue;
            }
            
            char ch = (char)(i + 'a');
            
            sb.append(ch  + "" + f);
        }
        
        return sb.toString();
    }
        
}
