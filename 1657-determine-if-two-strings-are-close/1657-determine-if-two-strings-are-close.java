class Solution {

    public boolean closeStrings(String word1, String word2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        Set<Character> s1 = new HashSet<>();
        Set<Character> s2 = new HashSet<>();

        for (int i = 0; i < word1.length(); i++) {
            char ch = word1.charAt(i);
            freq1[ch - 'a']++;
            s1.add(ch);
        }

        for (int i = 0; i < word2.length(); i++) {
            char ch = word2.charAt(i);
            freq2[ch - 'a']++;
            s2.add(ch);
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        if (Arrays.equals(freq1, freq2) && s1.equals(s2)) {
            return true;
        }
        return false;
    }
}
