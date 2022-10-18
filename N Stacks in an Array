public class NStack {
   int[] arr;
   int[] top;
   int[] next;
    
   int n;
   int s;
   int freespot;
    
    public NStack(int N, int S) {
        this.n = N;
        this.s = S;
        this.arr = new int[s];
        this.top = new int[n];
        this.next = new int[s];
        
        //Initialize top :
        for(int i=0; i<n; i++){
            top[i] = -1;
        }
        
        //Initialize next:
        for(int i=0; i<s; i++){
            next[i] = i + 1;
        }
        next[s-1] = -1;
        
        //Initialize freespot:
        freespot = 0;
    }

    public boolean push(int x, int m) {
        if(freespot == -1){
            return false;
        }
        //Find index :
        int index = freespot;
        
        //update freespot :
        freespot = next[index];
        
        //Push Element :
        arr[index] = x;
        
        //update next :
        next[index] = top[m-1];
        
        //update top :
        top[m-1] = index;
        
        return true;
    }

    public int pop(int m) {
        if(top[m-1] == -1){
            return -1;
        }
        
        int index = top[m-1];
        
        top[m-1] = next[index];
        
        next[index] = freespot;
        
        freespot = index;
        
        return arr[index];
    }
}
