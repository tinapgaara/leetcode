package facebook.tree;

import tree.TreeNode;

/**
 * Created by yingtan on 5/20/17.
 *
 * 235. Lowest Common Ancestor of a Binary Search Tree Add to List
 DescriptionHintsSubmissionsSolutions
 Total Accepted: 134267
 Total Submissions: 347760
 Difficulty: Easy
 Contributor: LeetCode
 Given a binary search tree (BST), find the lowest common ancestor (LowestCommonAncestor) of two given nodes in the BST.

 According to the definition of LowestCommonAncestor on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

 _______6______
 /              \
 ___2__          ___8__
 /      \        /      \
 0      _4       7       9
 /  \
 3   5
 For example, the lowest common ancestor (LowestCommonAncestor) of nodes 2 and 8 is 6. Another example is LowestCommonAncestor of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LowestCommonAncestor definition.
 */
public class LowestCommonAncestorOfBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lowestCommonAncestor_iter(root, p, q);
    }
    // iteration version
    public TreeNode lowestCommonAncestor_iter(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        while(cur != null) {
            if (cur == p || cur == q) {
                return cur;
            }
            if (p.val < cur.val && q.val < cur.val) {
                cur = cur.left;
            }
            else if (p.val > cur.val && q.val > cur.val) {
                cur = cur.right;
            }
            else {
                return cur;
            }
        }
        return cur;
    }
    // recursion version
    public TreeNode lowestCommonAncestor_recur(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        else if ( ( (p.val < root.val) && (q.val > root.val) ) || ((p.val > root.val) && (q.val < root.val)) )
            return root;
        else if ( (p.val < root.val) && (q.val < root.val) ) {
            return lowestCommonAncestor_recur(root.left, p, q);
        }
        else if ( (p.val > root.val) && (q.val > root.val) ) {
            return lowestCommonAncestor_recur(root.right, p, q);
        }
        return null;
    }
}
