class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int size = s.length();
        int i = 0, j = 0;
        int maxi = 0;

        while (j < size) {
            char ch1 = s.charAt(j);
            map.put(ch1, map.getOrDefault(ch1, 0) + 1);

            if (map.size() == j - i + 1) {
                maxi = Math.max(maxi, j - i + 1);
                j++;
            } 
            
            else if (map.size() < j - i + 1) {
                while (map.size() < j - i + 1) {
                    char ch2 = s.charAt(i);

                    map.put(ch2, map.get(ch2) - 1);

                    if (map.get(ch2) == 0) {
                        map.remove(ch2);
                    }

                    i++;
                }

                j++;
            }
        }

        return maxi;
    }
}
