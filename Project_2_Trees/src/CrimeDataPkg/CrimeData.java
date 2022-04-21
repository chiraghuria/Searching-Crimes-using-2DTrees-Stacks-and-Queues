/**
 * Name: Chirag Huria
 * Andrew ID: churia [at] andrew.cmu.edu
 * Project: Project 2
 * Course: Data Structures and Algorithms (95771)
 * Class: Fall 2021, Heinz, CMU
 */

package CrimeDataPkg;

/**
 * This class models the crime data with its attributes from the data
 */
public class CrimeData {

    private double x, y, latitude, longitude;
    private String time, street, offense, date;
    private int tract;

    /**
     * Constructor to define the various columns as present in the crime data
     * @param x
     * @param y
     * @param time
     * @param street
     * @param offense
     * @param date
     * @param tract
     * @param latitude
     * @param longitude
     */
    public CrimeData(double x, double y, String time, String street, String offense, String date, int tract, double latitude, double longitude) {
        this.x = x;
        this.y = y;
        this.time = time;
        this.street = street;
        this.offense = offense;
        this.date = date;
        this.tract = tract;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Getter for data attribute X
     * @return
     */
    public double getX() {
        return x;
    }

    /**
     * Getter for data attribute Y
     * @return
     */
    public double getY() {
        return y;
    }

    /**
     * Getter for getting the coordinate X and Y as a double array
     * @return
     * Double array with x and y coordinates
     */
    public double[] getXYCoordinate(){
        return new double[]{x,y};
    }

    /**
     * Getter for data attribute latitude
     * @return
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Getter for data attribute longitude
     * @return
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Getter for data attribute time
     * @return
     */
    public String getTime() {
        return time;
    }

    /**
     * getter for data attribute street
     * @return
     */
    public String getStreet() {
        return street;
    }

    /**
     * Getter for data attribute offense
     * @return
     */
    public String getOffense() {
        return offense;
    }

    /**
     * Getter for data attribute date
     * @return
     */
    public String getDate() {
        return date;
    }

    /**
     * Getter for data attribute tract
     * @return
     */
    public int getTract() {
        return tract;
    }

    /**
     * Overriden toString method to return a comma separated string of crime data attributes
     * @return
     * Comma separated string of crime data attributes
     */
    @Override
    public String toString() {

        String output = x + "," + y + "," + time + "," + street + "," + offense + "," + date + "," + tract + "," + latitude + "," + longitude;
        return output;

    }
}
