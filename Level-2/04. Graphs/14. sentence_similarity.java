//https://www.lintcode.com/problem/855/

public class Solution {
    /**
     * @param words1: 
     * @param words2: 
     * @param pairs: 
     * @return: Whether sentences are similary or not?
     */

    HashMap<String,String>parent;
    HashMap<String,Integer>rank;

    public boolean areSentencesSimilarTwo(List<String> words1, List<String> words2, List<List<String>> pairs) {
        if(words1.size() != words2.size()) {
            return false;
        }

        //initialise parent and rank
        parent = new HashMap<>();
        rank = new HashMap<>();

        for(int i=0; i < pairs.size();i++) {
            String s1 = pairs.get(i).get(0);
            String s2 = pairs.get(i).get(1);

            if(parent.containsKey(s1) == false) {
                parent.put(s1,s1);
                rank.put(s1,0);
            }

            if(parent.containsKey(s2) == false) {
                parent.put(s2,s2);
                rank.put(s2,0);
            }

        }


        //to perform DSU
        for(int i=0; i < pairs.size();i++) {
            String s1 = pairs.get(i).get(0);
            String s2 = pairs.get(i).get(1);

            String l1 = find(s1);
            String l2 = find(s2);

            if(l1.equals(l2) != true) {
                //merge
                if(rank.get(l1) < rank.get(l2)) {
                    parent.put(l1,l2);
                }
                else if(rank.get(l1) > rank.get(l2)) {
                    parent.put(l2,l1);
                }
                else {
                    parent.put(l1,l2);
                    rank.put(l2,rank.get(l2) + 1);
                }
            }
        }



        //check whether two sentences are similar or not
        for(int i=0; i < words1.size();i++) {
            String word1 = words1.get(i);
            String word2 = words2.get(i);

            if(word1.equals(word2) == true) {
                continue;
            }

            if(parent.containsKey(word1) != true || parent.containsKey(word2) != true ) {
                return false;
            }

            String p1 = find(word1);
            String p2 = find(word2);

            if(p1.equals(p2) == false) {
                return false;
            }
        }

        return true;


    }

    public String find(String x) {
        if(parent.get(x).equals(x) == true) {
            return x;
        }
        else {
            String ans = find(parent.get(x));
            parent.put(x,ans); //path compression
            return ans;
        }
    }
}