package hw9;

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	if (p.val < root.val && q.val < root.val) {
    		return root.left.lowestCommonAncestor(root.left, p, q);
    	}
    	else if (p.val > root.val && q.val > root.val) {
    		return root.right.lowestCommonAncestor(root.right, p, q);
    	}
    	else {
    		return root;
    	}
    	
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
    	TreeNode n1 = new TreeNode(1);
    	TreeNode n2 = new TreeNode(3,n1,null);
    	TreeNode n4 = new TreeNode(5);
    	TreeNode n6 = new TreeNode(9);
    	TreeNode n5 = new TreeNode(8,n4,n6);
    	TreeNode n3 = new TreeNode(4,n2,n5);
    	TreeNode p = new TreeNode(3);
    	TreeNode q = new TreeNode(1);
    	n3.printTree(n3);
    	System.out.println("");
    	System.out.println(n1.lowestCommonAncestor(n3, p, q).val);
    	p = new TreeNode(1);
    	q = new TreeNode(5);
    	System.out.println(n1.lowestCommonAncestor(n3, p, q).val);
    }
}
