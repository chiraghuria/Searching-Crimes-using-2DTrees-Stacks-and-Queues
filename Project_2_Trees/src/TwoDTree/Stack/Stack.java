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
 * This class models the Stack abstract data type with a front attribute pointing to the top of the stack
 * to mimic the insertion and deletion of a stack node based on LIFO
 */
public class Stack {

    private StackNode front;

    /**
     * Default constructor
     */
    public Stack(){
        front = null;
    }


    /**
     * Push method inserts a node to the top of the stack and updates the front variable accordingly
     * @precondition
     * A valid reference to the TreeNode object is requested to be pushed onto the stack
     * @postcondition
     * Node is added onto the stack
     * @param treeNode
     */
    public void push(TreeNode treeNode){

        StackNode newNode = new StackNode(treeNode);
        if(front==null){
            front = newNode;
        }
        else{
            newNode.setLink(front);
            front = newNode;
        }
    }

    /**
     * The top element of the stack is popped out and the reference to the TreeNode object is returned
     * @precondition
     * Stack is initialized with the front either null or referring to the top of the stack
     * @postcondition
     * TreeNode object is removed from the stack and returned
     * @return
     * Reference to the object of the TreeNode class
     */
    public TreeNode pop(){

        TreeNode data;
        if(front==null){
            return null;
        }

        else{
            StackNode temp = front;
            data = temp.getTreeNode();
            front = front.getLink();
        }
        return data;
    }

    /**
     * Checks if the stack is empty
     * @return
     * Boolean value is true if the stack is empty, false otherwise
     */
    public boolean isEmpty(){
        return (front==null);
    }

    /**
     * Prints the from top to bottom until the stack is empty
     */
    public void printStack(){

        if(front == null){
            return;
        }

        else{
            StackNode temp = front;
            while(temp!=null){
                System.out.println(temp.getTreeNode().getDataNode().toString());
                temp = temp.getLink();
            }
        }
    }

}
