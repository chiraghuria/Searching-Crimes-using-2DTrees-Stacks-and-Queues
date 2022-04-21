/**
 * Name: Chirag Huria
 * Andrew ID: churia [at] andrew.cmu.edu
 * Project: Project 2
 * Course: Data Structures and Algorithms (95771)
 * Class: Fall 2021, Heinz, CMU
 */
package TwoDTree;

/**
 * This class defines the model to store object containing the nearest neighbor, its distance and the
 * number of nodes scanned before getting to the nearest neighbor in a 2D tree.
 */
public class Neighbor {

    private double distance;
    private TreeNode nearestNeighbor;
    private int nodesExamined;

    /**
     * Default constructor initializing the distance as a negative value
     */
    public Neighbor(){
        distance = -99;
        nearestNeighbor = null;
    }

    /**
     * Getter for the distance to the nearest neighbor from the query point
     * @return
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Setter of the distance ot the nearest neighbor from the query point
     * @param distance
     */
    public void setDistance(double distance) {
        this.distance = distance;
    }

    /**
     * Getter of the nearest neighbor TreeNode object
     * @return
     */
    public TreeNode getNearestNeighbor() {
        return nearestNeighbor;
    }

    /**
     * Setter of the nearest neighbor TreeNode object
     * @param nearestNeighbor
     */
    public void setNearestNeighbor(TreeNode nearestNeighbor) {
        this.nearestNeighbor = nearestNeighbor;
    }

    /**
     * Getter for the number of nodes examined before reaching the nearest neighbor
     * @return
     */
    public int getNodesExamined() {
        return nodesExamined;
    }

    /**
     * Setter for the number of nodes examined before reaching the nearest neighbor
     * @param nodesExamined
     */
    public void setNodesExamined(int nodesExamined) {
        this.nodesExamined = nodesExamined;
    }

}
