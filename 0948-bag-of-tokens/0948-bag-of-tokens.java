class Solution {

    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int i = 0, j = tokens.length - 1;
        int res = 0;
        int points = 0;

        while (i <= j) {
            if (tokens[i] <= power) {
                power -= tokens[i++];
                res = Math.max(res, ++points);
            } 
            
            else if (points > 0) {
                power += tokens[j--];
                points--;
            } 
            
            else {
                break;
            }
        }

        return res;
    }
}
