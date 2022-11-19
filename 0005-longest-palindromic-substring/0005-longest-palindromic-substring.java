class Solution {
    public String longestPalindrome(String s) {
        int N = s.length();
        boolean[][] dp = new boolean[N][N];
        int start = 0;
        int end = 0;
        
        for(int gap = 0; gap < N; gap++){
            
            for(int i = 0, j = gap; j < N; i++, j++){
                
                if(gap == 0){
                    dp[i][j] = true;
                }
                
                else if(gap == 1){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = true;
                    }
                    
                    else{
                        dp[i][j] = false;
                    }
                }
                
                else{
                    
                    if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true){
                        dp[i][j] = true;
                    }
                    
                    else{
                        dp[i][j] = false;
                    }
                }
                
                if(dp[i][j] == true){
                    start = i;
                    end = gap + 1;
                }
            }
        }
        
        return s.substring(start, end + start);
    }
}