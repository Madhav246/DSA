class Solution {
    public void rotate(int[][] matrix) {
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        //Transpose Matrix :
        for(int i=0; i<row; i++){
            for(int j=i; j<col; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        //Reverse Matrix :
        for(int i=0; i<row; i++){
            int start = 0;
            int end = matrix[i].length - 1;
            
            while(start < end){
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                
                start++;
                end--;
            }
            
        }     
    }
}



