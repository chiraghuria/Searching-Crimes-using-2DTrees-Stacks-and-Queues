/**
 * Name: Chirag Huria
 * Andrew ID: churia [at] andrew.cmu.edu
 * Project: Project 2
 * Course: Data Structures and Algorithms (95771)
 * Class: Fall 2021, Heinz, CMU
 */
package TwoDTree;

import CrimeDataPkg.*;

/**
 * This class defines the model for the TreeNode object containing the CrimeData node,
 * left and right references to the children of the treenode and a splitting line orientation attribute
 */
public class TreeNode {

    private CrimeData dataNode;
    private TreeNode left, right;
    private boolean verticalSplittingLine;
    // splitting line is 'true' for vertical split and false for horizontal split

    /**
     * Default constructor
     * @param crimeData
     * @param verticalSplittingLine
     */
    public TreeNode(CrimeData crimeData, boolean verticalSplittingLine) {
        this.dataNode = crimeData;
        this.left = null;
        this.right = null;
        this.verticalSplittingLine = verticalSplittingLine;
    }

    /**
     * Getter of the crime data node
     * @return
     */
    public CrimeData getDataNode() {
        return dataNode;
    }

    /**
     * Setter of the crime data node
     * @param dataNode
     */
    public void setDataNode(CrimeData dataNode) {
        this.dataNode = dataNode;
    }

    /**
     * Getter of the left child in the tree
     * @return
     */
    public TreeNode getLeft() {
        return left;
    }

    /**
     * Setter of the left child in the tree
     * @param left
     */
    public void setLeft(TreeNode left) {
        this.left = left;
    }

    /**
     * Getter of the right child in the tree
     * @return
     */
    public TreeNode getRight() {
        return right;
    }

    /**
     * Setter of the right child in the tree
     * @param right
     */
    public void setRight(TreeNode right) {
        this.right = right;
    }

    /**
     * Checks if the node is a leaf node
     * @return
     * Boolean value that returns true if the node is a leaf node, false otherwise
     */
    public boolean isLeaf(){
        boolean isLeaf = (left==null && right==null);
        return isLeaf;
    }

    /**
     * Checks if the splitting line is vertical
     * @return
     * Boolean value that returns true if the splitting line of the node is vertical, false otherwise
     */
    public boolean isVerticalSplittingLine() {
        return verticalSplittingLine;
    }

    /**
     * Adds a node on the tree based on the splitting line where each node contains the crime data
     * @precondition
     * Root node is defined with splitting line arbitrarily chosen as vertical or horizontal
     * @postcondition
     * The new node is added onto the 2D tree
     * @param crimeData
     */

    public void addNode(CrimeData crimeData){

        // vertical splitting line
        if(this.verticalSplittingLine==true){
            // if x is less -- insert node on the left when left side is null (or empty)
            if(crimeData.getX() < this.dataNode.getX()){
                // if left side is empty
                if(this.left == null){
                    TreeNode newNode = new TreeNode(crimeData, !(this.verticalSplittingLine));
                    this.left = newNode;

                }
                // if left side is NOT empty
                else{
                    TreeNode leftNode = this.left;
                    leftNode.addNode(crimeData);
                }
            }

            // if x is equal or more -- insert node on the right when right side is null (or empty)
            else{
                // if right side is empty
                if(this.right == null){
                    TreeNode newNode = new TreeNode(crimeData, !(this.verticalSplittingLine));
                    this.right = newNode;
                }
                // if right side is NOT empty
                else{
                    TreeNode rightNode = this.right;
                    rightNode.addNode(crimeData);
                }
            }
        }

        // horizontal splitting line
        else{
            // if y is less -- insert node on the left when left side is null (or empty)
            if(crimeData.getY() < this.dataNode.getY()){
                // if left side is empty
                if(this.left==null){
                    TreeNode newNode = new TreeNode(crimeData, !(this.verticalSplittingLine));
                    this.left = newNode;
                }
                // if left side is NOT empty
                else{
                    TreeNode leftNode = this.left;
                    leftNode.addNode(crimeData);
                }
            }
            // if y is equal or more -- insert node on the right when right side is null (or empty)
            else{
                // if right side is empty
                if(this.right == null){
                    TreeNode newNode = new TreeNode(crimeData, !(this.verticalSplittingLine));
                    this.right = newNode;
                }
                // if right side is NOT empty
                else{
                    TreeNode rightNode = this.right;
                    rightNode.addNode(crimeData);
                }
            }
        }

    }

}
