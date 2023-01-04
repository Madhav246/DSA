//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Solution {
    int search(String pat, String txt) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<pat.length(); i++){
            char ch = pat.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        int i = 0;
        int j = 0;
        int size = txt.length();
        int k = pat.length();
        int count = map.size();
        int ans = 0;
        
        
        while(j < size){
            char ch = txt.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) - 1);
                
                if(map.get(ch) == 0){
                    count--;
                }
            }
            
            if(j - i + 1 < k){
                j++;
            }
            
            else if(j - i + 1 == k){
                if(count == 0){
                    ans++;
                }
                
                char ch1 = txt.charAt(i);
                if(map.containsKey(ch1)){
                    map.put(ch1, map.get(ch1) + 1);
                    
                    if(map.get(ch1) == 1){
                        count++;
                    }
                }

                i++;
                j++;
            }
        }
        
        return ans;
    }
}



