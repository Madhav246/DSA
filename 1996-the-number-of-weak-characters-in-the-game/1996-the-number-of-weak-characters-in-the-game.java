class Solution {

    public int numberOfWeakCharacters(int[][] properties) {
        int n = properties.length;

        Arrays.sort(properties, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    if (a[0] != b[0]) return a[0] - b[0]; 
                    else return b[1] - a[1];
                }
            }
        );
        
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int ans = 0;
        int maxi = -(int)1e8;
        

        for(int index = properties.length - 1; index >=0; index --){
            if(properties[index][1] < maxi){
                ans++;
            }
            maxi = Math.max(maxi, properties[index][1]);
        }

        return ans;
    }
}
