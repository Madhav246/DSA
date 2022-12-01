class Solution {

    public boolean halvesAreAlike(String s) {
        int len = s.length();

        String s1 = "";
        String s2 = "";

        for (int i = 0; i < len / 2; i++) {
            s1 += s.charAt(i);
        }

        for (int i = len / 2; i < len; i++) {
            s2 += s.charAt(i);
        }

        int v1 = 0;
        int v2 = 0;

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                v1++;
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                v2++;
            }
        }

        return v1 == v2;
    }
}
