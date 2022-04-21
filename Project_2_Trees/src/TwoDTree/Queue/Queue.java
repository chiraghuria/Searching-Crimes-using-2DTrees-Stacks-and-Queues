/**
 * Name: Chirag Huria
 * Andrew ID: churia [at] andrew.cmu.edu
 * Project: Project 2
 * Course: Data Structures and Algorithms (95771)
 * Class: Fall 2021, Heinz, CMU
 */

package TwoDTree.Queue;
import TwoDTree.TreeNode;
import com.sun.source.tree.Tree;

/**
 * This class models the queue abstract data type and its operations to add the nodes at rear end
 * and remove from the front thereby mimicking the FIFO structure.
 */
public class Queue {

    private QueueNode front, rear;

    /**
     * Default constructor
     */
    public Queue(){
        this.front = null;
        this.rear = null;
    }

    /**
     * Checks if the queue is currently empty
     * @return
     * boolean value that is true if the queue is empty and false otherwise
     */
    public boolean isEmpty(){
        return (front==null && rear==null);
    }

    /**
     * Adds a node to the rear of the queue
     * @precondition
     * A valid non-null reference to the object of the TreeNode class
     * @postcondition
     * The node is added to the rear end of the queue and front and rear are updated as necessary
     * @param treeNode
     */
    public void addToRear(TreeNode treeNode){

        QueueNode newNode = new QueueNode(treeNode);
        if(rear == null){
            front = newNode;
            rear = newNode;
        }
        else{
            QueueNode temp = rear;
            rear = newNode;
            temp.setLink(rear);
        }

    }

    /**
     * Removes a node from the front of the queue
     * @precondition
     * A valid queue object is initialized with front and rear either null or referring to a node
     * @postcondition
     * The node is removed from the front of the queue and front and rear are updated as necessary
     * @return TreeNode
     * Refernce to the treeNode object that is dequeued
     */
    public TreeNode removeFromFront(){

        TreeNode data;
        if(front == null){
            return null;
        }
        else{
            data = front.getTreeNode();
            front = front.getLink();
        }
        if (this.front == null){
            this.rear = null;
        }
        return data;
    }


}
