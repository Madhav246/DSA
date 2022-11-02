class Solution {
    public boolean isPossibleSolu(int[] position, int m, int mid){
        int magnetCount = 1;
        int lastPos = position[0];
        
        for(int i=0; i<position.length; i++){
            if(position[i] - lastPos >= mid){
                magnetCount++;
                if(magnetCount == m){
                    return true;
                }
                lastPos = position[i];
            }
        }
        return false;
    }
    
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int start = 0;
        int end = position[position.length - 1];
        int mid = start + (end - start) / 2;
        int ans = -1;
        
        while(start <= end){
            if(isPossibleSolu(position, m, mid)){
                ans = mid;
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
             mid = start + (end - start) / 2;
        }
        return ans;
    }
}