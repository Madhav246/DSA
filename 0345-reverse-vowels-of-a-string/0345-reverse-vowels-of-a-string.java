class Solution {
    
    boolean isVowel(char c){
         return c == 'a' || c == 'i' || c == 'e' || c == 'o' || c == 'u'
            || c == 'A' || c == 'I' || c == 'E' || c == 'O' || c == 'U';
    }
    
     void swap(char[] chars, int x, int y) {
        char temp = chars[x];
        chars[x] = chars[y];
        chars[y] = temp;
    }
    
    public String reverseVowels(String s) {
       int start = 0;
        int end = s.length() - 1;
        
        char[] chars = s.toCharArray();
        
        while(start < end){
            
            while(start < s.length() && !isVowel(chars[start])){
                start++;
            }
            
            while(end >= 0 && !isVowel(chars[end])){
                end--;
            }
            
            if(start < end){
                swap(chars, start++, end--);
            }
        }
        return new String(chars);
    }
}