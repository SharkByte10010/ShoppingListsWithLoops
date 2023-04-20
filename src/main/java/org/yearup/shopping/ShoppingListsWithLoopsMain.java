package org.yearup.shopping;

import java.util.Scanner;

public class ShoppingListsWithLoopsMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Show the user a list of items for sale
        // Only show the product names and IDs, not the prices


        // Invite the user to buy something
        System.out.println(" Hello! Welcome to my shop!");
        while (true) {// keep looping until customer says "no
            System.out.println("Would you like to buy something from this list? (Enter yes/no)");
            // Read in the user's response
            String userResponse = scanner.nextLine();
            if (userResponse.equals("Yes")) {
                System.out.println("Great! Here is a list of items that are available. \n");
            } else if (userResponse.equals("no")) {
                System.out.println("Thanks for stopping by!");
                return;
            }

            Item[] itemsForSale = ItemsForSale.itemsForSale;
            for (Item i : itemsForSale) {
                if (!i.isInStock()) continue;
                // System.out.println(i);
                System.out.println(i.getDescription() + " " + i.getProductID());
            }

            // Parse their choice and get that item from the list
            System.out.println("\nWhat is the product id of the item you desire?");
            String selectedProductId = scanner.nextLine();
            Item selectedItem = null;

            for (Item currentItemInListInTheLoop : itemsForSale) {
                if (selectedProductId.equals(currentItemInListInTheLoop.getProductID())) {
                    selectedItem = currentItemInListInTheLoop;
                    System.out.println("I have found the item! \nIt'll cost you though");

                    // Tell the user they can have it for a price!
                    System.out.printf("This item is currently on sale for: $%8.2f\n", +currentItemInListInTheLoop.getPrice());
                    break;
                }
            }
            // show them the price and ask them to accept it
            System.out.println("Do you accept this price? (yes/no)");
            // Read their response
            String acceptPrice = scanner.nextLine();

            //   if yes, tell them it's theirs
            if (acceptPrice.equals("yes")) {
                System.out.println("Perfect! let me take care of that for you!");
                String otherItems = scanner.nextLine();
                if (otherItems.equals("yes")) {
                    continue;
                } else if (otherItems.equals("no")) {
                    break;
                }


            }else if (acceptPrice.equals("no")){
                System.out.println("Oh no! Please check out some of my other items.");
            }
        }

    }
}