class Solution {

    public String reverse(String str) {
        String st = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            st += str.charAt(i);
        }
        return st;
    }

    public String reverseWords(String s) {
        String ans = "";
        String temp1 = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch == ' ') {
                String temp = reverse(temp1);
                ans += temp + " ";
                temp = "";
                temp1 = "";
            } else {
                temp1 += ch;
            }
        }
        ans += reverse(temp1);
        return ans.replaceAll("\\s+", " ").trim();
    }
}
