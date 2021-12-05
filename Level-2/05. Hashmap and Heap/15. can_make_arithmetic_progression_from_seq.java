class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int min = Integer.MAX_VALUE;
        int smin = Integer.MAX_VALUE;

        HashSet < Integer > hs = new HashSet < > ();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                smin = min;
                min = arr[i];
            } 
            else if (arr[i] < smin) {
                smin = arr[i];
            }
            hs.add(arr[i]);
        }


        int cd = smin - min;

        if (cd == 0 && hs.size() > 1) {
            return false;
        }


        for (int i = 0; i < arr.length; i++) {
            int term = i * cd + min;

            if (hs.contains(term) == false) {
                return false;
            }
        }

        return true;
    }
}