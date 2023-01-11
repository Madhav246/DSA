class Solution {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<String>();
        Set<String> set = new HashSet<>();

        int i = 0, j = 0;
        int size = s.length();
        int k = 10;
        String str = "";

        while (j < size) {
            char ch = s.charAt(j);

            str += ch;

            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                if (!set.isEmpty() && set.contains(str) && !ans.contains(str)) {
                    ans.add(str);
                }

                set.add(str);
                str = str.substring(1);
                i++;
                j++;
            }
        }

        return ans;
    }
}
