/**
 * Name: Chirag Huria
 * Andrew ID: churia [at] andrew.cmu.edu
 * Project: Project 2
 * Course: Data Structures and Algorithms (95771)
 * Class: Fall 2021, Heinz, CMU
 */

package CrimeDataPkg;

import CrimeDataPkg.LinkedListNode.LinkedListNode;

/**
 * ListOfCrimes class models the list containing the crime data with methods to add a crime
 * to the linked list, define its head, and navigate through the list
 */
public class ListOfCrimes {

    private LinkedListNode cursor;
    private LinkedListNode head;
    private int nodesExamined;

    /**
     * Default Constructor
     */
    public ListOfCrimes(){
        this.cursor = null;
        this.head = null;
    }

    /**
     * Resets the iterator to the head or start of the linked list
     */
    public void reset(){
        cursor = head;
    }


    /**
     * This method adds a node at the end of the list and updates the reference
     * of the head to point at the new start.
     * @precondition
     * crimeData object is not a null reference
     * @postcondition
     * A crimeData node is added at the end of the list
     * @param crimeData
     * The data object that needs to be added
     */
    public void addAtEndNode(CrimeData crimeData){

        LinkedListNode newNode = new LinkedListNode(crimeData);

        if(head == null){
            head = newNode;
        }
        else{
            reset();
            while(cursor.getLink()!=null){
                cursor = cursor.getLink();
            }
            cursor.setLink(newNode);
        }

    }


    /**
     * Computes the count of the nodes in a list
     * @return
     * Number of nodes
     */
    public int countNodes(){
        cursor = head;
        int count = 0;
        while(cursor!=null){
            count++;
            cursor = cursor.getLink();
        }
        return count;
    }

    /**
     * Setter for the number of nodes examined before finishing the computation of creating a list of crime
     * @param nodesExamined
     */
    public void setNodesExamined(int nodesExamined) {
        this.nodesExamined = nodesExamined;
    }

    /**
     * Getter for the number of nodes examined before finishing the computation of creating a list of crime
     * @return
     */
    public int getNodesExamined(){
        return nodesExamined;
    }

    /**
     * Traverses through the list and prints the linked list of crimes from start to end in a String format
     * @return
     * Returns the list as a string
     */
    public String toString(){
        reset();

        // if list is empty
        if(cursor == null){
            return null;
        }

        StringBuilder resString = new StringBuilder();

        while(cursor!=null){
            resString.append(cursor.getCrimeData().toString());
            cursor = cursor.getLink();
            resString.append("\n");
        }
        return resString.toString();
    }

    /**
     * Traverses through the list and prints the linked list of crimes from start to end
     * in a KML document format
     * @return
     * Returns the list as a string in KML document format
     */
    public String toKML(){

        reset();

        // if list is empty
        if(cursor == null){
            return null;
        }

        StringBuilder resString = new StringBuilder();

        resString.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<kml xmlns=\"http://earth.google.com/kml/2.2\">\n" +
                "<Document>\n" +
                " <Style id=\"style1\">\n" +
                " <IconStyle>\n" +
                " <Icon>\n" +
                "\n" +
                "<href>http://maps.gstatic.com/intl/en_ALL/mapfiles/ms/micons/blue\n" +
                "-dot.png</href>\n" +
                " </Icon>\n" +
                " </IconStyle>\n" +
                " </Style>\n");

        while(cursor!=null){

            resString.append(" <Placemark>");
            resString.append(" <name>" + cursor.getCrimeData().getOffense() + "</name>");
            resString.append(" <description>" + cursor.getCrimeData().getStreet() + "</description>");
            resString.append(" \n <styleUrl>#style1</styleUrl>");
            resString.append("\n <Point>\n" +
                    " <coordinates>\n" +
                    cursor.getCrimeData().getLongitude()+ "," + cursor.getCrimeData().getLatitude() + ",0.000000</coordinates>\n" +
                    " </Point>");

            resString.append(" \n</Placemark>\n");

            cursor = cursor.getLink();
        }

        resString.append("</Document>\n" +
                "</kml>");

        return resString.toString();




    }


}
