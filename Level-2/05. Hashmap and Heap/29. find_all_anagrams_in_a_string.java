//https://leetcode.com/problems/find-all-anagrams-in-a-string/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>ans = new ArrayList<>();
        
        if(p.length() > s.length()) {
            return ans;
        }
        
        HashMap<Character,Integer>pm = new HashMap<>(); //freq map of pattern
        
        //freq map of p
        for(int i=0; i < p.length();i++) {
            char ch = p.charAt(i);
            int nf = pm.getOrDefault(ch,0) + 1;
            pm.put(ch,nf);
        }
        
        HashMap<Character,Integer>wm = new HashMap<>(); //freq map of window
        
        //freq map of first window in s
        int i = 0;
        int j = 0;
        
        for(i=0; i < p.length();i++) {
            char ch = s.charAt(i);
            int nf = wm.getOrDefault(ch,0) + 1;
            wm.put(ch,nf);
        }
        
        
        
        for(; i < s.length();i++,j++) {
            if(areMapsEqual(wm,pm) == true) {
                ans.add(j);
            }
            
            //aquire ith char
            char chi = s.charAt(i);
            int nfi = wm.getOrDefault(chi,0) + 1;
            wm.put(chi,nfi);
            
            //release jth char
            char chj = s.charAt(j);
            
            if(wm.get(chj) == 1) {
                wm.remove(chj);
            }
            else {
                int nfj = wm.get(chj) - 1;
                wm.put(chj,nfj);
            }
        }
        
        
        
        if(areMapsEqual(wm,pm) == true) {
            ans.add(j);
        }
        
        return ans;
        
    }
    
    public static boolean areMapsEqual(HashMap<Character,Integer>fm1,HashMap<Character,Integer>fm2) {
        if(fm1.size() != fm2.size()) {
            return false;
        }
        
        for(char ch : fm1.keySet()) {
            int f1 = fm1.get(ch);
            int f2 = fm2.getOrDefault(ch,0);
            
            if(f1 != f2) {
                return false;
            }
        }
        
        return true;
        
    }
}