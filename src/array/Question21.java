class Solution {

    public int maxDepth(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }

        // recursive calls
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // return max depth
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
