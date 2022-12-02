
class Solution {
    public int binarySearch(List<Integer> list, int key){
        int start = 0;
        int end = list.size() - 1;
        int ans = (int)1e9;
        
        while(start <= end){
            int mid = start +  (end - start) / 2;
            
            if(list.get(mid) == key){
                return mid;
            }
            
            else if (list.get(mid) < key){
                start = mid + 1;
            }
            
            else {
                ans = mid;
                end = mid - 1;
            }
        }    
        return ans;
    }
    
    public int maxEnvelopes(int[][] envelopes) {
        
        Arrays.sort(envelopes, new Comparator<int[]>(){
        public int compare(int[] arr1, int[] arr2){
            if(arr1[0] == arr2[0])
                return arr2[1] - arr1[1];
            else
                return arr1[0] - arr2[0];
       } 
    });
        
        ArrayList<Integer> list = new ArrayList<>();
        list.add(envelopes[0][1]);
        int length = 1;
        
        for(int i=1; i<envelopes.length; i++){
            if(envelopes[i][1] > list.get(list.size() - 1)){
                list.add(envelopes[i][1]);
                length++;
            }
            else{
                int index = binarySearch(list, envelopes[i][1]);
                list.set(index, envelopes[i][1]);
            }
        }
        
        return length;
    }
}