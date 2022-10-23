class Solution {

    public boolean haveConflict(String[] event1, String[] event2) {
        int[] e1 = new int[2];
        int[] e2 = new int[2];

        e1 = getTime(event1);
        e2 = getTime(event2);

        if (e1[1] < e2[0] || e2[1] < e1[0]) {
            return false;
        }

        return true;
    }

    public int[] getTime(String arr[]) {
        String s1 = arr[0];
        String s2 = arr[1];

        int h1 = Integer.parseInt(s1.substring(0, 2)) * 60 + Integer.parseInt(s1.substring(3));
        int h2 = Integer.parseInt(s2.substring(0, 2)) * 60 + Integer.parseInt(s2.substring(3));

        return new int[] { h1, h2 };
    }
}
