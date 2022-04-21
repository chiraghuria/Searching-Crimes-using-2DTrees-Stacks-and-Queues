/**
 * Name: Chirag Huria
 * Andrew ID: churia [at] andrew.cmu.edu
 * Project: Project 2
 * Course: Data Structures and Algorithms (95771)
 * Class: Fall 2021, Heinz, CMU
 */
package TwoDTree.Stack;

import TwoDTree.TreeNode;

/**
 * This class models the nodes for the stack abstract data type
 */
public class StackNode {

    private TreeNode treeNode;
    private StackNode link;

    /**
     * Default constructor
     * @param treeNode
     */
    public StackNode(TreeNode treeNode){
        this.treeNode = treeNode;
        this.link = null;
    }

    /**
     * Getter for the TreeNode data object in the stack
     * @return
     */
    public TreeNode getTreeNode() {
        return treeNode;
    }

    /**
     * Getter for the link of the next node in the stack
     * @return
     */
    public StackNode getLink() {
        return link;
    }

    /**
     * Setter of the treeNode object in the stack
     * @param treeNode
     */
    public void setTreeNode(TreeNode treeNode) {
        this.treeNode = treeNode;
    }

    /**
     * Setter of the link to the next node on the stack
     * @param link
     */
    public void setLink(StackNode link) {
        this.link = link;
    }

}
