package PrintBinaryTree;
import java.util.List;
import java.util.*;


public class Solution {

    public static void main(String args[]){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);

        node1.left = node2;

        int treeHeight = getHeight(node1);
        System.out.println("Tree Height: " + treeHeight);


        printTree(node1);
    }

    public static List<List<String>> printTree(TreeNode root){
        int height = getHeight(root);
        int m = height + 1;
        int n = (int) Math.pow(2, height+1) - 1;

        // Create List of Lists containing all quotations

        List<List<String>> result = new ArrayList<>(m);

        for(int i = 0; i < m; i++){
            result.add(new ArrayList<>(n));

            List<String> row = result.get(i);

            for(int j = 0; j < n; j++){
                row.add("");
            }
        }

        // Fill Quotations List with contents of TreeNode

        bfs(root, 0, (n-1)/2, result, height);

        return null;
    }

    public static void bfs(TreeNode node, int i, int j, List<List<String>> result, int height){
        if(node == null)
            return;

        result.get(i).set(j, Integer.toString(node.val));
        bfs(node.left, i + 1, j - (int) Math.pow(2, height - i - 1), result, height);
        bfs(node.right, i + 1, j + (int) Math.pow(2, height -i - 1), result, height);
    }

    public static int getHeight(TreeNode root){
        if(root == null)
            return -1;

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        
        if(leftHeight > rightHeight)
            return leftHeight + 1;
        else   
            return rightHeight + 1;
    }
    
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}