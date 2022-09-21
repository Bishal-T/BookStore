package ThapaBishalProject1;

import java.util.ArrayList;
import java.util.Random;

public class RegisterMember {

    //Declaration
    private String memberFirstName;
    private String memberLastName;
    private int choice;
    private String membership;
    private final double PREMIUM_MEMBER_FEE = 10.99;
    private int paymentMethodChoice;
    private double totalSpent;

    /*
    Constructor 
    @param String fname first name
    @param String lname last name
    @param int memChoice  choice of membership
    @param int paymentMethod payment method
    @param double totalSpent total spent 
    
     */
    public RegisterMember(String fname, String lname, int memChoice, int paymentMethod, double totalSpent) {
        this.memberFirstName = fname;
        this.memberLastName = lname;
        this.choice = memChoice;
        this.paymentMethodChoice = paymentMethod;
        this.totalSpent = totalSpent;
    }

    /*
    Sets first name 
    @param String fname first name 
     */
    public void setFirstName(String fname) {
        this.memberFirstName = fname;
    }

    /*
    sets total spent 
    @param double totalSpent 
     */
    public void setTotalSpent(double totalSpent) {
        this.totalSpent = totalSpent;
    }

    /*
    Sets last name 
    @parm String lanme 
     */
    public void setLastName(String lname) {
        this.memberLastName = lname;
    }

    /*
    sets type of membership
    @parm String membership
     */
    // return first name 
    public String getFname() {
        return memberFirstName;
    }

    //returns last name 
    public String getLname() {
        return memberLastName;
    }

    // return choice of membership
    public int getChoice() {
        return choice;
    }

    //returns paymentMethodChoice
    public int getPaymentMethodChoice() {
        return paymentMethodChoice;
    }

    //returns totalSpent
    public double getTotalSpent() {
        return totalSpent;
    }

    //Sets fee based on type of membership.
    public double getMonthlyFee() {

        double fee = 0.0;
        if (getChoice() == 2) {
            fee = PREMIUM_MEMBER_FEE;
            
        } else {
            fee = 0.0;
        }

        return fee;
    }

    //Sets type of membership based on user choice. 1- regular, 2- premium
    public String getMembership() {
        
        String typeOfMember = "";
        
        switch (getChoice()) {
            case 2:
                typeOfMember = "Premium";
                break;
            case 1:
                typeOfMember = "Regular";
                break;
            default:
                System.out.println("Membership was not selected");
                break;
        }
        
        return typeOfMember;
    }

    //Sets and gets payment method based getPaymentMethodChoice.
    public String getPaymentMethod() {
        String payMethod = "";

        if (getPaymentMethodChoice() == 1) {
            payMethod = "Debit Card";
        }
        if (getPaymentMethodChoice() == 2) {
            payMethod = "Credit Card";

        }

        if (getPaymentMethodChoice() == 3) {
            payMethod = "Gift Cards";
        }

        if (getPaymentMethodChoice() == 4) {
            payMethod = "Paypal";
        }

        return payMethod;
    }

    @Override
    public String toString() {
        return "\nFirst Name: " + getFname() + "\nLast Name: " + getLname() + "\nMembership Type: " + getMembership() + "\nMembership Fee: " + getMonthlyFee() + "\nPayment Method: " + getPaymentMethod() + "\n";
    }

}
