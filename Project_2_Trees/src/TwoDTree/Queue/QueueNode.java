/**
 * Name: Chirag Huria
 * Andrew ID: churia [at] andrew.cmu.edu
 * Project: Project 2
 * Course: Data Structures and Algorithms (95771)
 * Class: Fall 2021, Heinz, CMU
 */

package TwoDTree.Queue;

import TwoDTree.TreeNode;

/**
 * This class models the nodes of the queue contatining the objects of the TreeNode class
 */
public class QueueNode {

    private TreeNode treeNode;
    private QueueNode link;

    /**
     * Default constructor
     * @param treeNode
     */
    public QueueNode(TreeNode treeNode){
        this.treeNode = treeNode;
        this.link = null;
    }

    /**
     * Getter of the treenode object
     * @return
     */
    public TreeNode getTreeNode() {
        return treeNode;
    }

    /**
     * Getter of the link to the next queue node
     * @return
     */
    public QueueNode getLink() {
        return link;
    }

    /**
     * Setter of the treeNode object in the queue node
     * @param treeNode
     */
    public void setTreeNode(TreeNode treeNode) {
        this.treeNode = treeNode;
    }

    /**
     * Setter of the link to the next queue node in the queue
     * @param link
     */
    public void setLink(QueueNode link) {
        this.link = link;
    }
}
