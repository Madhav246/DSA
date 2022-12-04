class Solution {

    public long dividePlayers(int[] skill) {
        int n = skill.length;
        if (n == 2) {
            return skill[0] * skill[1];
        }

        Arrays.sort(skill);

        int reqSum = skill[0] + skill[n - 1];
        int low = 0;
        int high = n - 1;
        long ans = 0;

        while (low < high) {
            int sum = skill[low] + skill[high];
            if (reqSum != sum) return -1; 
            else ans = ans + (skill[low] * skill[high]);
            low++;
            high--;
        }

        return ans;
    }
}
