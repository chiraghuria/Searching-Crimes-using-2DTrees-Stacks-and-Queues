/**
 * Name: Chirag Huria
 * Andrew ID: churia [at] andrew.cmu.edu
 * Project: Project 2
 * Course: Data Structures and Algorithms (95771)
 * Class: Fall 2021, Heinz, CMU
 */

package CrimeDataPkg.LinkedListNode;
import CrimeDataPkg.CrimeData;

/**
 * This class models the nodes of the linked list
 */
public class LinkedListNode {

    private CrimeData crimeData;
    private LinkedListNode link;

    /**
     * Constructor to create a new linked list node with crimedata
     * @param crimeData
     */
    public LinkedListNode(CrimeData crimeData){
        this.crimeData = crimeData;
        this.link = null;
    }

    /**
     * Getter for crime data
     * @return
     */
    public CrimeData getCrimeData() {
        return crimeData;
    }

    /**
     * setter for crime data
     * @param crimeData
     */
    public void setCrimeData(CrimeData crimeData) {
        this.crimeData = crimeData;
    }

    /**
     * Getter for link to the node node
     * @return
     */
    public LinkedListNode getLink() {
        return link;
    }

    /**
     * Setter for the link to the next node
     * @param link
     */
    public void setLink(LinkedListNode link) {
        this.link = link;
    }



}
