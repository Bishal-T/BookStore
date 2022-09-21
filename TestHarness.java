package ThapaBishalProject1;

import java.util.*;

public class TestHarness {

    //Scanner object to hold user input.
    public static Scanner keyboard = new Scanner(System.in);

    // ArrayLists to hold products/Members.
    public static ArrayList<Books> books = new ArrayList<Books>();
    public static ArrayList<Cds> CD = new ArrayList<Cds>();
    public static ArrayList<DVDs> dvds = new ArrayList<DVDs>();
    public static ArrayList<RegisterMember> PremiumMember = new ArrayList<RegisterMember>();
    public static ArrayList<RegisterMember> RegularMember = new ArrayList<RegisterMember>();

    public static void main(String[] args) {

        // Declarations for menus
        int menuChoice = 0;
        int userSelectToAddProducts = 0;

        //Declaration to ask user to view the main menu
        String goAgain = "";

        //Declaratios for object of class.
        String title = "";
        double Price = 0.0;
        
        //Declarations to ask user to view different item.
        String viewDifferentItem = "";

        // Object of classes.
        Books b = new Books(title, Price);
        Cds cd = new Cds(title, Price);
        DVDs dvd = new DVDs(title, Price);

        System.out.println("*****************************");
        System.out.println("*  Admin Password= 1234     *");
        System.out.println("*  User must register       *\n*  Before purchasing items  *");
        System.out.println("*****************************");

        do {

            //Menu for users.
            System.out.println("\n----Welcome to ITSC Bookstore!----\n");
            System.out.println("Below are your options");
            System.out.println("\t 1. Admin");
            System.out.println("\t 2. Register");
            System.out.println("\t 3. View Inventory");
            System.out.println("\t 4. Purchase Item");
            System.out.println("\t 5. Exit");
            System.out.print("Please select by typing a number: ");
            menuChoice = keyboard.nextInt();

            //Gets users input and list the appropriate selection.
            switch (menuChoice) {
                //Authenticates admin to add items.
                case 1:
                    //Calls admin method.
                    keyboard.nextLine();
                    admin();

                    break;
                case 2:
                    //Displays menu to register.
                    keyboard.nextLine();
                    menuToRegister();

                    break;
                case 3:

                    //Displays the inventory according to the user input and checks if each inventory is empty.
                    //Prints inventory based on user choice. case 1 = books, case 2 = Cd, case 3 = dvd
                    keyboard.nextLine();
                    System.out.println("\nBooks in stock: " + books.size());
                    if (b.isEmpty(books) == true) {
                        System.out.println("\n********************************************");
                        System.out.println("**Please add books, the inventory is empty**");
                        System.out.println("********************************************\n");
                    } else {
                        b.displayBooks(books);

                    }
                    System.out.println("\n\nCDs in stock: " + CD.size());
                    if (cd.isEmpty(CD) == true) {
                        System.out.println("\n******************************************");
                        System.out.println("**Please add CDs, the inventory is empty**");
                        System.out.println("******************************************\n");
                    } else {
                        cd.displayCds(CD);

                    }
                    System.out.println("\n\nDvDs in stock: " + dvds.size());
                    if (dvd.isEmpty(dvds) == true) {
                        System.out.println("\n*******************************************");
                        System.out.println("**Please add DVDs, the inventory is empty**");
                        System.out.println("*******************************************\n");
                    } else {
                        dvd.displayDVDs(dvds);

                    }
                    break;
                case 4:
                    //Calls CompletePurhcase method to remove item from specific inventory(Books, CD, DvDs).
                    keyboard.nextLine();
                    CompletePurhcase();
                    break;

                case 5:
                    //Program exits
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invaild Input");
                    keyboard.nextLine();
                    break;

            }
            //Asks user if they would like to view the main menu again.
            System.out.print("Would you like to go back to the menu (Y/N)? ");
            goAgain = keyboard.nextLine();

        } while (goAgain.equalsIgnoreCase("Y"));

        System.out.println("Have a wonderful day!");

    }

    //Prints out menu to register users
    public static void menuToRegister() {

        //Declarations
        String fname = "";
        String lname = "";
        int choice = 0;
        int paymentMethodChoice = 0;
        double totalSpent = 0.0;
        String registerWithus = "";

        //Prompts user if they would like to register.
        System.out.print("Would you like register with us (Y/N)? ");
        registerWithus = keyboard.nextLine();

        //If user input yes the program will ask for info, if not the program will display "have a wonderful day"
        if (registerWithus.equalsIgnoreCase("Y")) {

            //Prompts user to inuput first name.
            System.out.print("Enter your first name: ");
            fname = keyboard.nextLine();
            //Prompts user to input last name.
            System.out.print("Enter your last name: ");
            lname = keyboard.nextLine();

            System.out.println("");

            //Displays option for user to select the type of membership they wish to register with.
            System.out.println("Hi " + fname + ", we have two types of membership.");
            System.out.println("\t 1. Regular");
            System.out.println("\t 2. Premium");
            System.out.print("Please select from above: ");
            choice = keyboard.nextInt();
            while (choice <= 0 || choice > 2) {
                System.out.print("Please select option 1-2: ");
                choice = keyboard.nextInt();
            }

            //Prompts user to select payment method they wish to add.
            System.out.println("Which form of payment would you like to add?");
            System.out.println("\t1.Debit Card");
            System.out.println("\t2.Credit Card");
            System.out.println("\t3.Gift Cards");
            System.out.println("\t4.Paypal");
            System.out.print("Please select from above: ");
            paymentMethodChoice = keyboard.nextInt();
            while (paymentMethodChoice <= 0 || paymentMethodChoice > 4) {
                System.out.print("Please enter options 1-4: ");
                paymentMethodChoice = keyboard.nextInt();
            }

            RegisterMember rg = new RegisterMember(fname, lname, choice, paymentMethodChoice, totalSpent);

            //Adds user to Premium or Regular membership arraylists based on user input.
            switch (choice) {
                case 1:
                    RegularMember.add(rg);
                    break;
                case 2:
                    PremiumMember.add(rg);
                    break;
            }

            System.out.println("Thank you for registering with us!");
            
            keyboard.nextLine();

        } else {
            System.out.println("See you soon.");
        }

       

    }

    //Add books to books class/Araaylist
    public static void addBooks() {
        //Declaration
        String bookAuthor = "";
        double bookPrice = 0.0;
        int bookAmount = 0;
        int authorCounter = 1;

        //Prompts user to enter the amount of books they wish to add.
        System.out.print("\nHow many books would you like to add? ");
        bookAmount = keyboard.nextInt();

        while (bookAmount <= 0) {
            System.out.print("The number of Books must be geater than 0: ");
            bookAmount = keyboard.nextInt();
        }

        // Prompts and loops through amount of books entered to add info. 
        for (int i = 0; i < bookAmount; i++) {
            
            keyboard.nextLine();
            System.out.println("\nPlease enter the information of Book " + authorCounter++);
            
            //Prompts user to enter author of books
            System.out.print("Author: ");
            bookAuthor = keyboard.nextLine();

            //Prompts user to enter price of books
            System.out.print("Price: ");
            bookPrice = keyboard.nextDouble();

            Books b = new Books(bookAuthor, bookPrice);

            //adds user inputs to books list
            books.add(b);
        }

    }

    //Add CDs to CD class/Arraylist 
    public static void addCDS() {
        String cdTitle = "";
        double cdPrice = 0.0;
        int cdAmount = 0;
        int cdAuthorCounter = 1;

        //Prompts user to enter the amount of CDs they wish to add.
        System.out.print("\nHow many CDs would you like to add? ");
        cdAmount = keyboard.nextInt();

        while (cdAmount <= 0) {
            System.out.print("The number of CDs must be geater than 0: ");
            cdAmount = keyboard.nextInt();
        }
        // Prompts and loops through amount of CDs entered to add info. 
        for (int i = 0; i < cdAmount; i++) {
            
            keyboard.nextLine();
            System.out.println("\nPlease enter the information of  CD " + cdAuthorCounter++);
            
            //Prompts user to enter author of CDs
            System.out.print("Author: ");
            cdTitle = keyboard.nextLine();
            
            //Prompts user to enter price of CDs
            System.out.print("Price: ");
            cdPrice = keyboard.nextDouble();

            Cds cd = new Cds(cdTitle, cdPrice);
            CD.add(cd);

        }

    }

    //Add DvDs to DVD class/Arraylist
    public static void addDVDs() {
        String Title = "";
        double Price = 0.0;
        int dvdAmount = 0;
        int dvdAuthorCounter = 1;

        //Prompts user to enter the amount of DvDs they wish to add.
        System.out.print("\nHow many DVDs would you like to add? ");
        dvdAmount = keyboard.nextInt();

        while (dvdAmount <= 0) {
            System.out.print("The number of DvDs must be geater than 0: ");
            dvdAmount = keyboard.nextInt();
        }
        // Prompts and loops through amount of DvDs entered to add info.
        for (int i = 0; i < dvdAmount; i++) {
            
            keyboard.nextLine();
            System.out.println("\nPlease enter the information of Dvd " + dvdAuthorCounter++);
            
            //Prompts user to enter author of DVDs
            System.out.print("Author: ");
            Title = keyboard.nextLine();
            
            //Prompts user to enter price of DVDs
            System.out.print("Price: ");
            Price = keyboard.nextDouble();

            DVDs dvd = new DVDs(Title, Price);
            dvds.add(dvd);

        }

    }

    //Aks user to input correct password to add products
    public static void admin() {

        //Declarations
        int adminPass = 1234;
        String admin = "";
        int adminPassHolder = 0;
        String addAnotherItem = "y";

        //Asks user if they are an admin.
        System.out.print("Are you an Admin (Y/N)? ");
        admin = keyboard.nextLine();

        //Authenticates admin and allows admin to add items.
        if (admin.equalsIgnoreCase("y")) {

            //Prompts admin to enter the admin password.
            System.out.print("Enter the password: ");
            adminPassHolder = keyboard.nextInt();

            //Validates admin password.
            while (adminPassHolder != adminPass) {
                System.out.print("Wrong password! Try Again: ");
                adminPassHolder = keyboard.nextInt();
                keyboard.nextLine();
            }

            //Prompts user to add items by calling the addInventory method.
            do {
                //Calls inventory method to add items.
                addInventory();
                keyboard.nextLine();
                
                //Asks user if they would like to add another item.
                System.out.print("Add another item(Y/N)? ");
                addAnotherItem = keyboard.nextLine();

            } while (addAnotherItem.equalsIgnoreCase("y"));

        } else {
            System.out.println("you are not a admin");
        }
    }

    public static void addInventory() {

        //Declarations
        int adminChoice = 0;

        //Prompts admin to select option 1-3 to add items.
        System.out.println("You can add three different products.");
        System.out.println("\t1. add Books");
        System.out.println("\t2. add CDs");
        System.out.println("\t3. add DVDs");
        System.out.print("Please selcet from above to add products: ");
        adminChoice = keyboard.nextInt();
        while (adminChoice <= 0 || adminChoice > 3) {
            System.out.print("Please select option 1-3: ");
            adminChoice = keyboard.nextInt();
        }

        //Calls add methods based on admin input. case 1= add Books, case 2= add CDs, case 3= add DvDs
        switch (adminChoice) {
            case 1:
                //Calls addBooks method to add books.
                addBooks();
                break;
            case 2:
                //Calls addCDS method to add CDs
                addCDS();
                break;
            case 3:
                //Calls addDVDs method to add DvDs
                addDVDs();
                break;
            default:
                System.out.println("Vaild Selection was not MADE");
                break;
        }

    }

    public static void CompletePurhcase() {

        //Declarations to complete purchase
        String purchaseProducts = "";
        int productSelection = 0;
        int bookNumber = 0;
        String purchaseAnotherItem = "";

        //Declarations for Books, Cds and DVDs objects
        String title = "";
        double Price = 0.0;

        //Declarations for RegisterMember object.
        String fname = "";
        String lname = "";
        int choice = 0;
        int paymentMethodChoice = 0;
        double totalSpent = 0.0;

        //Object of classes.
        Books b = new Books(title, Price);
        Cds cd = new Cds(title, Price);
        DVDs dvd = new DVDs(title, Price);
        RegisterMember rg = new RegisterMember(fname, lname, choice, paymentMethodChoice, totalSpent);

        //Asks user if they would like to purchase products.
        System.out.print("Would like to purchase our products? (Y/N)");
        purchaseProducts = keyboard.nextLine();

        do {

            //Prompts user to select option 1-3 to view and purchase products.
            if (purchaseProducts.equalsIgnoreCase("y")) {
                System.out.println("\nWe have three products");
                System.out.println("\t 1. Books");
                System.out.println("\t 2. CDs");
                System.out.println("\t 3. DvDs");
                System.out.print("Which product would you like to purchase? ");
                productSelection = keyboard.nextInt();
                while (productSelection <= 0 || productSelection > 3) {
                    System.out.print("Please select option 1-3: ");
                    productSelection = keyboard.nextInt();
                }

                //Displays inventory and complete purchase based on user select. 1-Books, 2-CDs, 3-DvDs
                switch (productSelection) {
                    case 1:

                        System.out.println("\nYou have chosen Books. Below are the titles");
                        //Checks if books inventory is empty and displays inventory.
                        if (b.isEmpty(books) == true) {
                            System.out.println("\n*******************************************");
                            System.out.println("**Please add Books, the inventory is empty**");
                            System.out.println("*******************************************\n");

                        } else {
                            b.displayBooks(books);

                            //Prompts user to enter book number if they wish to purchase.
                            System.out.print("Please enter the Book Number you wise to purchase from above: ");
                            bookNumber = keyboard.nextInt();

                            //Displays total 
                            System.out.printf("\nYour total is: $%.2f%n", books.get(bookNumber - 1).getPrice());
                            rg.setTotalSpent(rg.getTotalSpent() + books.get(bookNumber - 1).getPrice());

                            //Calls method completePurchase from Books to complete purchase.
                            b.completePurchase(books, bookNumber);
                            System.out.println("Thank you for your purchase!");

                        }

                        break;
                    case 2:
                        //Checks if CDs inventory is empty and displays inventory.
                        System.out.println("\nYou have chosen Cds. Below are the titles");
                        if (cd.isEmpty(CD) == true) {
                            System.out.println("\n*******************************************");
                            System.out.println("**Please add CDs, the inventory is empty**");
                            System.out.println("*******************************************\n");
                        } else {
                            cd.displayCds(CD);
                            //Prompts user to enter cd number if they wish to purchase.
                            System.out.print("Please enter the CD Number you wise to purchase from above: ");
                            bookNumber = keyboard.nextInt();

                            //Displays total 
                            System.out.printf("\nYour total is: $%.2f%n", CD.get(bookNumber - 1).getPriceOfCD());
                            rg.setTotalSpent(CD.get(bookNumber - 1).getPriceOfCD());

                            //Calls completePurchase method to remove item from list.
                            cd.completePurchase(CD, bookNumber);
                            System.out.println("Thank you for your purchase!");

                        }
                        break;
                    case 3:
                        //Checks if DvDs inventory is empty and displays inventory.
                        System.out.println("\nYou have chosen DVDs. Below are the titles");
                        if (dvd.isEmpty(dvds) == true) {
                            System.out.println("\n*******************************************");
                            System.out.println("**Please add DVDs, the inventory is empty**");
                            System.out.println("*******************************************\n");
                        } else {
                            //Displays dvd inventory.
                            dvd.displayDVDs(dvds);
                            
                            //Prompts user to enter dvd number if they wish to purchase.
                            System.out.print("Please enter the DVD Number you wise to purchase from above: ");
                            bookNumber = keyboard.nextInt();
                            
                            //Displays total 
                            System.out.printf("\nYour total is: $%.2f%n", dvds.get(bookNumber - 1).getPriceOfDVD());
                            rg.setTotalSpent(dvds.get(bookNumber - 1).getPriceOfDVD());
                            
                            //Calls completePurchase method to remove item from list.
                            dvd.completePurchase(dvds, bookNumber);
                            System.out.println("Thank you for your purchase!");
                        }
                        break;
                    default:
                        System.out.println("Invaild Input");
                        break;

                }

                keyboard.nextLine();
                System.out.print("\nWould you like to purchase another item(Y/N)? ");
                purchaseAnotherItem = keyboard.nextLine();

            }

        } while (purchaseAnotherItem.equalsIgnoreCase("y"));

        // Displays total spent based on user membership.
        try {
            
            if (PremiumMember.size() > 0) {
                System.out.printf("\nHi " + PremiumMember.get(0).getFname() + ", have spent: $%.2f%n", rg.getTotalSpent());
                System.out.println("Your details are below:");
                System.out.println(PremiumMember.get(0));
            } else {
                System.out.printf("\nHi " + RegularMember.get(0).getFname() + ", have spent: $%.2f%n", rg.getTotalSpent());
                System.out.println("Your details are below:");
                System.out.println(RegularMember.get(0));

            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\nPlease register and consult admin\n");
        }

    }

}
