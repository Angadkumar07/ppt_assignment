package Assignment_8;
/*<aside>
💡 **Question 4**
You need to construct a binary tree from a string consisting of parenthesis and integers.
The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.
You always start to construct the **left** child node of the parent first if it exists.
!*Input:** s = "4(2(3)(1))(6(5))"
**Output:** [4,2,6,3,1,5]
</aside> */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Question4 {
    public TreeNode str2tree(String s) {
        if (s.isEmpty()) {
            return null;
        }

        int firstParen = s.indexOf("(");
        int val = (firstParen == -1) ? Integer.parseInt(s) : Integer.parseInt(s.substring(0, firstParen));
        TreeNode root = new TreeNode(val);

        if (firstParen == -1) {
            return root;
        }

        int start = firstParen, count = 0;
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }

            if (count == 0 && start == firstParen) {
                root.left = str2tree(s.substring(start + 1, i));
                start = i + 1;
            } else if (count == 0) {
                root.right = str2tree(s.substring(start + 1, i));
            }
        }

        return root;
    }

    public static void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        Question4 solution = new Question4();
        String s = "4(2(3)(1))(6(5))";
        TreeNode root = solution.str2tree(s);
        inOrderTraversal(root);
    }
}
