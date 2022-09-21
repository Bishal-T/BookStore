package ThapaBishalProject1;

import java.util.ArrayList;
import java.util.Scanner;

public class Books {

    //Declaration
    private String author;
    private double price;

    /*Constructor 
    @param String bookAuthor
    @param String bookPrice 
     */
    public Books(String bookAuthor, double bookPrice) {
        this.author = bookAuthor;
        this.price = bookPrice;

    }

    // return author
    public String getAuthor() {
        return author;
    }

    /* Sets author 
    @param String bookAuthor
     */
    public void setAuthor(String bookAuthor) {
        this.author = bookAuthor;
    }

    // return price
    public double getPrice() {
        return price;
    }

    /* sets price
    @param double bookPrice 
     */
    public void setPrice(double bookPrice) {
        this.price = bookPrice;
    }

    /*Displays books
    @param ArrayList<Books> books
     */
    public void displayBooks(ArrayList<Books> books) {
        int bookNumber = 1;
        for (Books b : books) {

            System.out.println("Book Number: " + bookNumber++);
            System.out.println("\tAuthor of Book: " + b.getAuthor());
            System.out.printf("\tPrice of Book: $%.2f%n", b.getPrice());

        }

    }

    /*
    Checks if list is empty.
    @Param ArrayList<Books> books arraylist to hold infomation.
     */
    public boolean isEmpty(ArrayList<Books> books) {
        return books.isEmpty();
    }

    /*
    Removes item from list based on index
    @param int index index at which to remove element.
    @param ArrayList<Books> books arraylist that holds element.
     */
    public void completePurchase(ArrayList<Books> books, int index) {
        int removeAt = index - 1;
        books.remove(removeAt);
    }

}
