package ThapaBishalProject1;

import java.util.ArrayList;

public class Cds {

    private String nameOfCD;
    private double priceOfCD;


    /* Constructor
    @param String nameCd
    @param double price
     */
    public Cds(String nameCd, double price) {
        this.nameOfCD = nameCd;
        this.priceOfCD = price;
    }

    //Return nameOfCd
    public String getNameOfCD() {
        return nameOfCD;
    }

    /*
    sets nameOfCD
    @param String nameCD
     */
    public void setNameOfCD(String nameCd) {
        this.nameOfCD = nameCd;
    }

    //return price of cd
    public double getPriceOfCD() {
        return priceOfCD;
    }

    /*
    sets priceofCd
    @param double price
     */
    public void setPriceOfCD(double price) {
        this.priceOfCD = price;
    }

    /*
    display cds
    @param ArrayList<Cds> CDS
     */
    public void displayCds(ArrayList<Cds> CDS) {
        int cdNumber = 1;
        for (Cds cd : CDS) {

            System.out.println("CD Number: " + cdNumber++);
            System.out.println("\tAuthor of CD: " + cd.getNameOfCD());
            System.out.printf("\tCD Price: $%.2f%n", cd.getPriceOfCD());

        }

    }

    /*
    Checks if list is empty.
    @Param ArrayList<Cds> CDS arraylist to hold infomation.
     */
    public boolean isEmpty(ArrayList<Cds> CDS) {
        return CDS.isEmpty();
    }

    /*
    Removes item from list based on index
    @param int index index at which to remove element.
    @param ArrayList<Cds> CDS arraylist that holds element.
     */
    public void completePurchase(ArrayList<Cds> CDS, int index) {
        int removeAt = index - 1;
        CDS.remove(removeAt);
    }

}
