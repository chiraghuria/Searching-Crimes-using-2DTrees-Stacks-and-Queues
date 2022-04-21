/**
 * Name: Chirag Huria
 * Andrew ID: churia [at] andrew.cmu.edu
 * Project: Project 2
 * Course: Data Structures and Algorithms (95771)
 * Class: Fall 2021, Heinz, CMU
 */

package TwoDTree;
import CrimeDataPkg.CrimeData;
import CrimeDataPkg.ListOfCrimes;
import TwoDTree.Queue.Queue;
import TwoDTree.Stack.Stack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class defines the model for the TwoDTree with the TreeNode root as the root of the tree
 * and various operations to traverse the tree, perform range search and nearest neighbor search.
 */
public class TwoDTree {

    private TreeNode root = null;
    private TreeNode currentNode;
    private static ListOfCrimes listOfCrimes = new ListOfCrimes();
    private static Neighbor nearestNeighbor = new Neighbor();
    private static int rangeSearchScannedNodeCount = 0;
    private static int nearestNeighborScannedNodeCount = 0;
    private static int rowNum;
    private static double pastChamp = -99, currentChamp = -99;

    public TwoDTree(TreeNode root){
        this.root = root;
        this.currentNode = root;
    }
    /**
     * @precondition
     * The String crimeDataLocation contains the path to a file formatted in the
     * exact same way as CrimeLatLonXY.csv
     * @postcondition
     * The 2d tree is constructed with each node containing the crime data in a single line from the file
     * @param crimeDataLocation
     */
    public TwoDTree(String crimeDataLocation) throws FileNotFoundException {

        File file = new File(crimeDataLocation);
        Scanner readFile = new Scanner(file);
        rowNum = 0;

        String headerLine = readFile.nextLine();
        while(readFile.hasNextLine()){

            // since first row is a header
            if(rowNum>=1){
                String inputLine = readFile.nextLine();
                String[] lineSplit = inputLine.split(",");
                double x = Double.parseDouble(lineSplit[0]);
                double y = Double.parseDouble(lineSplit[1]);
                String time = lineSplit[2];
                String street = lineSplit[3];
                String offense = lineSplit[4];
                String date = lineSplit[5];
                int tract = Integer.parseInt(lineSplit[6]);
                double latitude = Double.parseDouble(lineSplit[7]);
                double longitude = Double.parseDouble(lineSplit[8]);

                CrimeData crimeData = new CrimeData(x,y,time, street, offense, date, tract, latitude, longitude);

                // first data row becomes the root of the tree with a vertical splitting line and thereafter
                // nodes are added to this tree
                if(rowNum==1){
                    root = new TreeNode(crimeData, true);
                }
                else{
                    root.addNode(crimeData);
                }
            }
            rowNum+=1;
        }
        resetCurrentNode();
    }

    /**
     * Resets the current node reference back the root
     */
    private void resetCurrentNode(){
        this.currentNode = root;
    }

    /**
     * Getter for the number of rows read from the data including the header
     * @return
     */
    public int getRowNum() {
        return rowNum;
    }


    /**
     * Prints the tree based on a pre-order traversal
     * @precondition
     * 2D tree has been constructed
     * @postcondition
     * The 2d tree is displayed with a pre-order traversal.
     */

    public void preOrderPrint(){
        TwoDTree temp;
        System.out.println(root.getDataNode().toString());
        if(root.getLeft() != null){
            temp = new TwoDTree(root.getLeft());
            temp.preOrderPrint();
        }
        if(root.getRight()!=null){
            temp = new TwoDTree(root.getRight());
            temp.preOrderPrint();
        }
    }

    /**
     * Prints the tree based on a in-order traversal
     * @precondition
     * 2D tree has been constructed
     * @postcondition
     * The 2d tree is displayed with an in-order traversal
     */
    // Runtime Analysis:
    // Big Theta(N)
    // Reasoning: If it is a complete and balanced tree the tree will have to traverse
    // all the way to the left most leaf and then to the right. Since each node in the tree is visited once
    // in an in-order traversal, it means that O(N) is the complexity.
    // Printing of node happens in constant time. Therefore, average case is Big Theta(N).
    public void inOrderPrint(){
        TwoDTree temp;
        if(root.getLeft()!=null){
            temp = new TwoDTree(root.getLeft());
            temp.inOrderPrint();
        }
        System.out.println(root.getDataNode().toString());
        if(root.getRight()!=null){
            temp = new TwoDTree(root.getRight());
            temp.inOrderPrint();
        }
    }

    /**
     * Prints the tree based on a post-order traversal
     * @precondition
     * 2D tree has been constructed
     * @postcondition
     * The 2d tree is displayed with an post-order traversal
     */
    public void postOrderPrint(){
        TwoDTree temp;
        if(root.getLeft()!=null){
            temp = new TwoDTree(root.getLeft());
            temp.postOrderPrint();
        }
        if(root.getRight()!=null){
            temp = new TwoDTree(root.getRight());
            temp.postOrderPrint();
        }
        System.out.println(root.getDataNode().toString());
    }

    /**
     * Prints the tree based on a level-order traversal using a queue
     * @precondition
     * 2D tree has been constructed
     * @postcondition
     * The 2d tree is displayed with an level-order traversal
     */
    // Runtime Analysis:
    // Big Theta(N)
    // Reasoning: Each node in the tree is visited at least once and therefore the best case is Big Omega(N).
    // At worst, a node is iterated over thrice, once each time from the dequeues from the left/right subtrees,
    // this leads to the worst case to be Big O(3N) which means Big O(N). Therefore, average case is also Big Theta(N).
    // Please note that enqueue and deque happen in constant time.
    public void levelOrderPrint(){

        Queue queue = new Queue();
        TreeNode currentRoot = this.root;
        queue.addToRear(currentRoot);

        while(!(queue.isEmpty())){
            currentRoot = queue.removeFromFront();
            System.out.println(currentRoot.getDataNode().toString());
            if(currentRoot.getLeft()!=null){
                queue.addToRear(currentRoot.getLeft());
            }
            if(currentRoot.getRight()!=null){
                queue.addToRear(currentRoot.getRight());
            }
        }
    }


    /**
     * Prints the tree based on a reverse level-order traversal using a queue and a stack
     * @precondition
     * 2D tree has been constructed
     * @postcondition
     * The 2d tree is displayed with an reverse level-order traversal
     */
    // Runtime Analysis:
    // Big Theta(N)
    // Each node is traversed in Big Theta(N) to print in level order. Enqueue, dequeue and stack push are
    // constant time operations. Printing of the stack is another N operations. Therefore, worst case is
    // Big O(2N) which is equivalent to Big O(N). Therefore, average case is Big Theta(N).
    public void reverseLevelOrderPrint(){
        Queue queue = new Queue();
        Stack stack = new Stack();
        TreeNode currentRoot = this.root;
        queue.addToRear(currentRoot);

        while(!(queue.isEmpty())){
            currentRoot = queue.removeFromFront();
            stack.push(currentRoot);
            if(currentRoot.getLeft()!=null){
                queue.addToRear(currentRoot.getLeft());
            }
            if(currentRoot.getRight()!=null){
                queue.addToRear(currentRoot.getRight());
            }
        }
        stack.printStack();
    }

    /**
     * @precondition
     * The 2d tree has been constructed
     * @postcondition
     * A list of 0 or more crimes is returned. These crimes occurred within the
     * rectangular range specified by the four parameters. The pair (x1, y1) is the left bottom of the
     * rectangle. The pair (x2, y2) is the top right of the rectangle.
     * @param x1
     * x coordinate of the bottom left point of the rectangle
     * @param y1
     * y coordinate of the bottom left point of the rectangle
     * @param x2
     * x coordinate of the top right point of the rectangle
     * @param y2
     * y coordinate of the top right point of the rectangle
     * @return
     * An object of the list of crimes containing all the crimes within a given range
     */
    public ListOfCrimes findPointsInRange(double x1, double y1, double x2, double y2){

        TreeNode comparison = root;

        // checking if the root is a null -- we backtrack
        if(comparison==null){
            return listOfCrimes;
        }
        rangeSearchScannedNodeCount++;
        TwoDTree temp;
        boolean xComparison = comparison.getDataNode().getX() > x1 && comparison.getDataNode().getX() < x2;
        boolean yComparison = comparison.getDataNode().getY() > y1 && comparison.getDataNode().getY() < y2;

        // node in the rectangle -- add node to the list and continue to
        // search for left and right subtree if it exists
        if(xComparison && yComparison){
            listOfCrimes.addAtEndNode(comparison.getDataNode());
            if(root.getLeft()!=null){
                temp = new TwoDTree(root.getLeft());
                listOfCrimes = temp.findPointsInRange(x1,y1,x2,y2);
            }
            if (root.getRight() != null) {
                temp = new TwoDTree(root.getRight());
                listOfCrimes = temp.findPointsInRange(x1,y1,x2,y2);
            }
            if(root.getLeft()==null && root.getRight()==null){
                return listOfCrimes;
            }
        }

        // vertical line passing through the rectangle (xComparison = true)
        else if(comparison.isVerticalSplittingLine()==true && xComparison){
            // search both left and right subtree if it exists
            if(root.getLeft()==null && root.getRight()==null){
                return listOfCrimes;
            }
            temp = new TwoDTree(root.getLeft());
            listOfCrimes = temp.findPointsInRange(x1,y1,x2,y2);
            temp = new TwoDTree(root.getRight());
            listOfCrimes = temp.findPointsInRange(x1,y1,x2,y2);

        }

        // horizontal line passing through the rectangle (yComparison = true)
        else if(comparison.isVerticalSplittingLine()==false && yComparison){
            // search both left and right subtree if it exists
            if(root.getLeft()==null && root.getRight()==null){
                return listOfCrimes;
            }
            temp = new TwoDTree(root.getLeft());
            listOfCrimes = temp.findPointsInRange(x1,y1,x2,y2);
            temp = new TwoDTree(root.getRight());
            listOfCrimes = temp.findPointsInRange(x1,y1,x2,y2);
        }

        else{
            // vertical line --> if rectangle on the left
            if(comparison.isVerticalSplittingLine() && (x2 < comparison.getDataNode().getX())){
                // search only left sub tree if it exists
                if(root.getLeft()==null){
                    return listOfCrimes;
                }
                temp = new TwoDTree(root.getLeft());
                listOfCrimes = temp.findPointsInRange(x1,y1,x2,y2);
            }
            // vertical line --> if rectangle on the right
            else if(comparison.isVerticalSplittingLine() && (x1 >= comparison.getDataNode().getX())){
                // search only right sub tree if it exists
                if(root.getRight()==null){
                    return listOfCrimes;
                }
                temp = new TwoDTree(root.getRight());
                listOfCrimes = temp.findPointsInRange(x1,y1,x2,y2);
            }
            // horizontal line --> if rectangle is below
            else if(comparison.isVerticalSplittingLine()==false && (y2 < comparison.getDataNode().getY())){
                // search only left sub tree if it exists
                if(root.getLeft()==null){
                    return listOfCrimes;
                }
                temp = new TwoDTree(root.getLeft());
                listOfCrimes = temp.findPointsInRange(x1,y1,x2,y2);
            }

            // horizontal line --> if rectangle is above
            else if(comparison.isVerticalSplittingLine()==false && (y1 >= comparison.getDataNode().getY())){
                // search only right sub tree if it exists
                if(root.getRight()==null){
                    return listOfCrimes;
                }
                temp = new TwoDTree(root.getRight());
                listOfCrimes = temp.findPointsInRange(x1,y1,x2,y2);

            }
        }
        listOfCrimes.setNodesExamined(rangeSearchScannedNodeCount);
        return listOfCrimes;
    }

    /**
     * Resets the static variables to initial values for further executions
     */
    public static void resetVars(){
        nearestNeighbor = new Neighbor();
        listOfCrimes = new ListOfCrimes();
        rangeSearchScannedNodeCount = 0;
        nearestNeighborScannedNodeCount = 0;
        pastChamp = -99;
        currentChamp = -99;
    }

    /**
     * Finds the nearest neighbor in the 2D tree from the query point
     * @precondition
     * The 2d tree has been constructed. The (x1,y1) pair represents a point in space near Pittsburgh and
     * in the state plane coordinate system.
     * @postcondition
     * The distance in feet to the nearest node is returned in Neighbor.
     * In addition, the Neighbor object contains a reference to the nearest neighbor in the tree.
     * @param x1
     * x coordinate of the query point
     * @param y1
     * y coordinate of the query point
     * @return
     * A reference to nearest neighbor object containing the treenode, distance and nodes examined
     */
    public Neighbor nearestNeighbor(double x1, double y1){

        TwoDTree temp;

        // tree is empty
        if(root == null){
            return nearestNeighbor;
        }
        nearestNeighborScannedNodeCount++;
        double distance = computeDistance(x1,y1, root.getDataNode().getX(), root.getDataNode().getY());

        // search point in the tree
        if(distance==0){
            nearestNeighbor.setNearestNeighbor(root);
            nearestNeighbor.setDistance(distance);
        }

        // first iteration when default distance is negative
        if(nearestNeighbor.getDistance() < 0 ){
            pastChamp = currentChamp;
            nearestNeighbor.setDistance(distance);
            currentChamp = nearestNeighbor.getDistance();
            nearestNeighbor.setNearestNeighbor(root);
        }

        double distanceFromChamp = nearestNeighbor.getDistance();

        if(distance < distanceFromChamp){
            pastChamp = currentChamp;
            nearestNeighbor.setNearestNeighbor(root);
            currentChamp = nearestNeighbor.getDistance();
            nearestNeighbor.setDistance(distance);
        }

        // vertical line
        if(root.isVerticalSplittingLine()==true){

            double xDistanceFromPartitionLine = x1 - root.getDataNode().getX();

            if(x1 < root.getDataNode().getX()){
                temp = new TwoDTree(root.getLeft());
                nearestNeighbor = temp.nearestNeighbor(x1, y1);

                if(currentChamp >= Math.pow(xDistanceFromPartitionLine,2)){
                    temp = new TwoDTree(root.getRight());
                    nearestNeighbor = temp.nearestNeighbor(x1, y1);
                }
            }

            else{
                temp = new TwoDTree(root.getRight());
                nearestNeighbor = temp.nearestNeighbor(x1, y1);

                if(currentChamp >= Math.pow(xDistanceFromPartitionLine,2)){
                    temp = new TwoDTree(root.getLeft());
                    nearestNeighbor = temp.nearestNeighbor(x1, y1);
                }
            }
        }

        // horizontal line
        else{

            double yDistanceFromPartition = y1 - root.getDataNode().getY();
            if(y1 < root.getDataNode().getY()){
                temp = new TwoDTree(root.getLeft());
                nearestNeighbor = temp.nearestNeighbor(x1, y1);

                if(currentChamp >= Math.pow(yDistanceFromPartition,2)){
                    temp = new TwoDTree(root.getRight());
                    nearestNeighbor = temp.nearestNeighbor(x1, y1);
                }
            }

            else{
                temp = new TwoDTree(root.getRight());
                nearestNeighbor = temp.nearestNeighbor(x1, y1);

                if(currentChamp >= Math.pow(yDistanceFromPartition,2)){
                    temp = new TwoDTree(root.getLeft());
                    nearestNeighbor = temp.nearestNeighbor(x1, y1);
                }
            }

        }

        nearestNeighbor.setNodesExamined(nearestNeighborScannedNodeCount-1); //excluding the final node
        return nearestNeighbor;

    }

    /**
     * Computes the distance between two points in a coordinate plane based on the Euclidean formula
     * @param searchX
     * x coordinate of the query point
     * @param searchY
     * y coordinate of the query point
     * @param x
     * x coordinate of the second point
     * @param y
     * y coordinate of the second point
     * @return
     * Distance between the query point and second point
     */
    private double computeDistance(double searchX, double searchY, double x, double y){

        double xDelta = Math.pow((searchX - x), 2);
        double yDelta = Math.pow((searchY - y), 2);
        double distance = Math.sqrt((xDelta+yDelta));
        return distance;

    }


}
