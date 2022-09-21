package ThapaBishalProject1;

import java.util.ArrayList;

public class DVDs {

    //Declaration
    private String nameOfDVD;
    private double priceOfDVD;

    /*
    Construcotr 
    @param String nameDVD
    @param double price
     */
    public DVDs(String nameDVD, double price) {
        this.nameOfDVD = nameDVD;
        this.priceOfDVD = price;
    }

    //return name of dvd
    public String getNameOfDVD() {
        return nameOfDVD;
    }

    /*
    sets name of dvd
    @param String nameDVD
     */
    public void setNameOfDVD(String nameDVD) {
        this.nameOfDVD = nameDVD;
    }

    //returns price of DVD
    public double getPriceOfDVD() {
        return priceOfDVD;
    }

    /*
    sets price of dvd
    @param double price
     */
    public void setPriceOfDVD(double price) {
        this.priceOfDVD = price;
    }

    /*
    Displays Dvds
    @param ArrayList<DVD> dvd
     */
    public void displayDVDs(ArrayList<DVDs> dvd) {
        int dvdNumber = 1;
        for (DVDs ds : dvd) {

            System.out.println("Dvd Number: " + dvdNumber++);
            System.out.println("\tAuthor of DVd: " + ds.getNameOfDVD());
            System.out.printf("\tDvD Price: $%.2f%n", ds.getPriceOfDVD());

        }
    }

    /*
    Checks if list is empty.
    @Param ArrayList<DVDs> dvd arraylist to hold infomation.
     */
    public boolean isEmpty(ArrayList<DVDs> dvd) {
        return dvd.isEmpty();
    }

    /*
    Removes item from list based on index
    @param int index index at which to remove element.
    @param ArrayList<DVDs> dvd arraylist that holds element.
     */
    public void completePurchase(ArrayList<DVDs> dvd, int index) {
        int removeAt = index - 1;
        dvd.remove(removeAt);
    }

}
