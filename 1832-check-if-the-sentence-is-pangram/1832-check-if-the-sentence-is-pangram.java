class Solution {
    public boolean checkIfPangram(String sentence) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<sentence.length(); i++){
            char ch = sentence.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        int flag = 0;
        
        for(char i='a'; i<='z'; i++){
            if(map.containsKey(i)){
                continue;
            }
            else{
                flag = 1;
                break;
            }
        }
        
        if(flag == 0){
            return true;
        }
        return false;
    }
}