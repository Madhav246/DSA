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
    
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        int length = 1;
        
        for(int i=1; i<nums.length; i++){
            if(nums[i] > list.get(list.size() - 1)){
                list.add(nums[i]);
                length++;
            }
            else{
                int index = binarySearch(list, nums[i]);
                list.set(index, nums[i]);
            }
        }
        
        return length;
    }
}






