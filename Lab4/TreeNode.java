package jTreeNodes;

public class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;

    TreeNode() {}

    TreeNode(int val) { this.val = val; }

    TreeNode(int val, TreeNode left, TreeNode right) {

        this.val = val;

        this.left = left;

        this.right = right;

    }
    public TreeNode invertTree(TreeNode root) {
    	if(root == null) {
            return null;
            }
        if(root.left == null &&  root.right == null) {
            return null;
            }
        else{
        	TreeNode node= root.left;
        	root.left = root.right;
        	root.right = node;
        	}
        invertTree(root.left);
        invertTree(root.right);
    	return root;
    }	
    public void printTree(TreeNode self){	
    	if (self.left != null) {
            self.left.printTree(self.left);
            }
        System.out.print(self.val + " ");
        if (self.right != null) {
            self.right.printTree(self.right);
            }
            
    }
    
    public static void main(String args[]) {
    	TreeNode d = new TreeNode(3);
    	TreeNode e = new TreeNode(4);
    	TreeNode b = new TreeNode(2,d,e);
    	TreeNode f = new TreeNode(5);
    	TreeNode g = new TreeNode(6);
    	TreeNode c = new TreeNode(8,f,g);
    	TreeNode a = new TreeNode(1,b,c);
    	a.printTree(a);
    	System.out.println("");
    	a.invertTree(a);
    	a.printTree(a);
    }
 }

