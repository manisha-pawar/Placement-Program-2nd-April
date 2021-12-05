//https://leetcode.com/problems/rabbits-in-forest/

class Solution {
    public int numRabbits(int[] answers) {
        HashMap < Integer, Integer > map = new HashMap < > (); //ans vs how many rabbits

        for (int i = 0; i < answers.length; i++) {
            int of = map.getOrDefault(answers[i], 0);
            map.put(answers[i], of +1);
        }

        int ans = 0;

        for (int key: map.keySet()) {
            int gs = key + 1;
            int tr = map.get(key);
            ans += Math.ceil(tr * 1.0 / gs) * gs;
        }

        return ans;
    }
}