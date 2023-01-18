class Solution {
    public int divisorSubstrings(int num, int k) {
        int i = 0;
        String s = Integer.toString(num);
        
        int j = 0;
        int size = s.length();
        int count = 0;
        String st = "";
        
        
        while(j < size){
            char ch = s.charAt(j);
            
            st += ch;
            
            if(j - i + 1 < k){
                j++;
            }
            
            else if(j - i + 1 == k){
                int n = Integer.parseInt(st);
                 if(n != 0 && num % n == 0){
                    count++;
                }
                
                st = st.substring(1);
                i++;
                j++;
            }
        }
        
        return count;
    }
}