class Solution {

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int i = 0, j = 0, size = s.length();
        int count = map.size();
        int mini = Integer.MAX_VALUE;
        String ans = "";

        while (j < size) {
            char ch1 = s.charAt(j);

            if (!map.containsKey(ch1)) {
                j++;
                continue;
            } else if (map.containsKey(ch1)) {
                map.put(ch1, map.get(ch1) - 1);

                if (map.get(ch1) == 0) {
                    count--;
                }
            }

            if (count == 0) {
                if (mini > j - i + 1) {
                    ans = s.substring(i, j + 1);
                    mini = j - i + 1;
                }

                while (count == 0) {
                    char ch2 = s.charAt(i);

                    if (!map.containsKey(ch2)) {
                        i++;
                    } else {
                        map.put(ch2, map.get(ch2) + 1);

                        if (map.get(ch2) > 0) {
                            count++;
                        }

                        i++;
                    }

                    if (count == 0) {
                        if (mini > j - i + 1) {
                            ans = s.substring(i, j + 1);
                            mini = j - i + 1;
                        }
                    }
                }
            }
            j++;
        }

        return ans;
    }
}
