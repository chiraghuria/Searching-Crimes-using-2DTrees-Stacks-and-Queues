/**
 * Name: Chirag Huria
 * Andrew ID: churia [at] andrew.cmu.edu
 * Project: Project 2
 * Course: Data Structures and Algorithms (95771)
 * Class: Fall 2021, Heinz, CMU
 */

package TwoDTree;

import CrimeDataPkg.ListOfCrimes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This class models the main method and driver for the TwoDTree class and takes the user input to perform
 * operations on the TwoDTree class.
 * Note: The input file name is not taken as a user-input as it was not mentioned in the project's requirement sheet
 */
public class TwoDTreeDriver {

    public static void main(String[] args){

        // variables
        TwoDTree twoDTree = null;
        ListOfCrimes listOfCrimes = null;
        Neighbor neighbor = null;
        int userChoice;
        Scanner scanner = new Scanner(System.in);


        // input file
        String fileName = "CrimeLatLonXY.csv";

        try {
            twoDTree = new TwoDTree(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // excluding 1 since the first row is the header
        System.out.println("\nCrime file is loaded into 2d tree with " + (twoDTree.getRowNum()-1) + " records.");

        // user choice menu
        do{
            System.out.println("\nWhat would you like to do?");
            System.out.println("1: inorder");
            System.out.println("2: preorder");
            System.out.println("3: levelorder");
            System.out.println("4: postorder");
            System.out.println("5: reverseLevelOrder");
            System.out.println("6: search for points within rectangle");
            System.out.println("7: search for nearest neighbor");
            System.out.println("8: quit");

            userChoice = Integer.parseInt(scanner.nextLine());

            switch(userChoice){
                case 1:
                    System.out.println("\n---- Inorder ----\n");
                    twoDTree.inOrderPrint();
                    break;

                case 2:
                    System.out.println("\n---- Preorder ----\n");
                    twoDTree.preOrderPrint();
                    break;

                case 3:
                    System.out.println("\n---- Level-order ----\n");
                    twoDTree.levelOrderPrint();
                    break;

                case 4:
                    System.out.println("\n---- Post-order ----\n");
                    twoDTree.postOrderPrint();
                    break;

                case 5:
                    System.out.println("\n---- Reverse Level Order ----\n");
                    twoDTree.reverseLevelOrderPrint();
                    break;

                case 6:
                    System.out.println("\n---- Rectangle range search ----\n");
                    System.out.print("Enter a rectangle bottom left (X1,Y1) and top right (X2, Y2) as " +
                            "four doubles each separated by a space.\n");
                    double x1,y1,x2,y2;
                    String userInputRectanglePoints = scanner.nextLine();
                    String[] rectanglePoints = userInputRectanglePoints.split(" ");
                    x1 = Double.parseDouble(rectanglePoints[0]);
                    y1 = Double.parseDouble(rectanglePoints[1]);
                    x2 = Double.parseDouble(rectanglePoints[2]);
                    y2 = Double.parseDouble(rectanglePoints[3]);

                    System.out.println("Searching for points within (" + x1 + "," + y1 + ") and (" + x2 + "," + y2 + ")");
                    System.out.print("\n");

                    listOfCrimes = twoDTree.findPointsInRange(x1,y1,x2,y2);
                    TwoDTree.resetVars();
                    System.out.println("Examined " + listOfCrimes.getNodesExamined() + " during search.");
                    System.out.println("Found " + listOfCrimes.countNodes() + " crimes.");
                    System.out.print("\n");
                    if(listOfCrimes.countNodes() > 0){
                        System.out.println(listOfCrimes.toString());
                        String outputFilePath = "PGHCrimes.kml";
                        File fout = new File(outputFilePath);
                        PrintWriter printWriter = null;
                        try {
                            printWriter = new PrintWriter(fout);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        printWriter.write(listOfCrimes.toKML());
                        printWriter.close();
                        System.out.println("The crime data has been written to "+ outputFilePath +". It is viewable in Google Earth Pro.");
                    }
                    else{
                        System.out.println("No points were found within the given search range");
                    }
                    break;

                case 7:
                    System.out.println("\n---- Nearest Neighbor ----\n");
                    System.out.println("Enter a point to find nearest crime. Separate with a space.");
                    String userInputNearestNeighbor = scanner.nextLine();
                    String[] nearestNeighborPoint = userInputNearestNeighbor.split(" ");
                    double xNearestNeighborPoint = Double.parseDouble(nearestNeighborPoint[0]);
                    double yNearestNeighborPoint = Double.parseDouble(nearestNeighborPoint[1]);
                    neighbor = twoDTree.nearestNeighbor(xNearestNeighborPoint, yNearestNeighborPoint);
                    TwoDTree.resetVars();
                    System.out.println("Looked at " + neighbor.getNodesExamined() + " nodes in tree. Found the nearest crime at:");
                    System.out.println(neighbor.getNearestNeighbor().getDataNode().toString());
                    break;

                case 8:
                    System.out.println("Thank you for exploring Pittsburgh crimes in the 1990's.");
                    break;

                /*case 9:
                    //double xV2 = 5; double yV2 = 12;
                    //double xV2 = 1359951.000; double yV2 = 410726.000;
                    double xV2 = 9; double yV2 = 40;
                    Neighbor neighborVersionTwo = twoDTree.nearestNeighborVersionTwo(xV2,yV2);
                    TwoDTree.resetVars();
                    System.out.println("Looked at " + neighborVersionTwo.getNodesExamined() + " nodes in tree. Found the nearest crime at:");
                    System.out.println(neighborVersionTwo.getNearestNeighbor().getDataNode().toString());
                    break;
                case 10:
                    //double xV3 = 5; double yV3 = 12;
                    double xV3 = 1359951.000; double yV3 = 410726.000;
                    //double xV3 = 9; double yV3 = 40;
                    Neighbor neighborVersionThree = twoDTree.nearestNeighborVersionThree(xV3,yV3);
                    TwoDTree.resetVars();
                    System.out.println("Looked at " + neighborVersionThree.getNodesExamined() + " nodes in tree. Found the nearest crime at:");
                    System.out.println(neighborVersionThree.getNearestNeighbor().getDataNode().toString());
                    break;
*/
            }

        } while(userChoice!=8);

    }

}
