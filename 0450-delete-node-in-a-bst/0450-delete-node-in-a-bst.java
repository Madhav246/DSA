class Solution {
    
    public int minValue(TreeNode root){
        int min = root.val;
        
        while(root.left != null){
            min = root.left.val;
            root = root.left;
        }
        
        return min;
        
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }
        
        else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }
        
        else {
            // 0 child :
            if(root.left == null && root.right == null){
                return null;
            }
            // 1 Child :
            else if(root.left == null){
                return root.right;
            }
            
            else if(root.right == null){
                return root.left;
            }
            
            //Have both the child :  
            else {
                root.val = minValue(root.right);
                root.right = deleteNode(root.right, root.val);            
            }   
        }
        
        return root;
        
        
    }
}