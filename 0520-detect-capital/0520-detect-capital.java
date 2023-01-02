class Solution {

    public boolean detectCapitalUse(String word) {
        int count = 0;


        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                count++;
            }
        }

        if (count == 0 || count == word.length()) {
            return true;
        }

         return count == 1 && Character.isUpperCase(word.charAt(0));
    }
}
