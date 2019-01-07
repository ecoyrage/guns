/**
 * TreeNode class
 *
 * @author ZhaoMing
 * @data 2019/1/7
 */
package cn.stylefeng.guns.modular.zhao.btree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeTest {

    public static void main(String[] args) {
        int[] data = {0,1,2,3,4,5,6,7};
        TreeNode treeNode = new TreeNode();
        treeNode.createBTree(data);
        System.out.println("先序遍历");
        treeNode.preOrder(treeNode.getRoot());
        System.out.println();
        System.out.println("中序遍历");
        treeNode.inOrder(treeNode.getRoot());
        System.out.println();
        System.out.println("后序遍历");
        treeNode.afterOrder(treeNode.getRoot());
    }
}

/**
 *
 *               0
 *           1       2
 *         3   4   5   6
 *       7
 *
 *
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode root;

    TreeNode(){}
    TreeNode(int data){
        this.left = null;
        this.right = null;
        this.root = null;
        this.val = data;
    }

    public int getVal() {
        return val;
    }

    public TreeNode getRoot() {
        return root;
    }

    @Override
    public String toString() {
        return "根节点-》"+this.root+"左-》"+this.left+"右-》"+this.right;
    }

    public void createBTree(int[] datas){
        List<TreeNode> treeNodes = new ArrayList<>();
        for (int data:datas) {
            treeNodes.add(new TreeNode(data));
        }
        root = treeNodes.get(0);
        for(int i = 0;i < datas.length/2;i++){
            treeNodes.get(i).left = treeNodes.get(2*i+1);
            //避免偶数的时候，下标越界
            if(2*i+2 < datas.length){
                treeNodes.get(i).right = treeNodes.get(2*i+2);
            }
        }

    }

    public void preOrder(TreeNode root){
        if(root != null){
            visit(root.getVal());
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void inOrder(TreeNode root){
        if(root != null){
            inOrder(root.left);
            visit(root.getVal());
            inOrder(root.right);
        }
    }

    public void afterOrder(TreeNode root){
        if(root != null){
            afterOrder(root.left);
            afterOrder(root.right);
            visit(root.getVal());
        }
    }

    public void visit(int data){
        System.out.print(data+"-->");
    }
}
