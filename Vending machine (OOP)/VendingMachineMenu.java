import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;

/**
   A menu from the vending machine.
   *@author Maria Esteban
   *@version 1.0
   *@since 2023-04-14
*/
public class VendingMachineMenu
{
   private Scanner in;
   private static final Coin[] COINS = {
      Coin.NICKEL, Coin.DIME, Coin.QUARTER, Coin.DOLLAR
   };
   
   /**
      Constructs a VendingMachineMenu object
   */
   public VendingMachineMenu()
   {
      in = new Scanner(System.in);
   }

   /**
      Runs the vending machine system.
      @param machine the vending machine
   */
   public void run(VendingMachine machine)
   {
      boolean more = true;

      while (more)
      {
         System.out.print("S)how products A)dd B)uy product I)nsert R)emove coins Q)uit G)et total money: ");
         String command = in.nextLine().toUpperCase();
         //shows the prducts avaliable with its quantities
         if (command.equals("S"))
         {
            if (machine.getProductTypes().size()==0)
            {
               System.out.println("There are not any products in the vending machine");
            }
            for (int i=0; i<machine.getProductTypes().size();i++)
            {
               System.out.println(machine.getProductTypes().get(i)+" -> "+machine.getQuantity().get(i));
            }
         }
         //adds a product to the vending machine
         else if (command.equals("A"))
         {
            System.out.print("Description: ");
            String description = in.nextLine();
            System.out.print("Price: ");
            double price = in.nextDouble();
            System.out.print("Quantity: ");
            int quantity = in.nextInt();
            in.nextLine(); // read the new-line character
            machine.addProduct(new Product(description, price), quantity);
         }
         //inserts a coin to the coin box
         else if (command.equals("I"))
         { 
            Coin chosen = pickCoin();
            System.out.println("Current money: $" + machine.addCoin(chosen));
         }
         //buys a product from the vending machine
         else if (command.equals("B"))
         { 
            
            if (machine.getProductTypes().size()==0)
            {
               System.out.println("There are not any products in the vending machine");
            }
            else
            {
               System.out.println("Current money: $"+machine.getMoney());
               Product p = pickProduct(machine.getProductTypes(), machine.getQuantity());
               String result = machine.buyProduct(p);
               if (result == "OK")
               {
                  System.out.println("Purchased: " + p);
                  System.out.println("Current money: $"+machine.getMoney());  
               }
               else
               {
                  System.out.println("Sorry: " + result);
               }
            }
         }
         //removes the money from the customer coin box
         else if (command.equals("R"))
         {  
            System.out.println("Removed: $" + machine.removeUserMoney());
            System.out.println("Current money: $0");
         }
         //exits the program
         else if (command.equals("Q"))
         {
            more = false;
         }
         //removes the money from the main coin box
         else if (command.equals("G"))
         {
            System.out.println("Total: $" + machine.removeTotalMoney());

         }
      }
   }

   // Pick a coin from the list of all coins
   private Coin pickCoin()
   {
      while (true)
      {
         char c = 'A';
         for (Coin choice : COINS)
         {
            System.out.println(c + ") " + choice); 
            c++;
         }
         String input = in.nextLine();
         int n = input.toUpperCase().charAt(0) - 'A';
         if (0 <= n && n < COINS.length)
         {
            return COINS[n];
         }
      }      
   }

   
   // Pick a product from all products
   private Product pickProduct(ArrayList<Product> allProducts, ArrayList<Integer> allQuantities)
   {
      while (true)
      {
         

         char c = 'A';
         for (int i=0; i<allProducts.size();i++)
            {
               System.out.println(c + ") " +allProducts.get(i)+" -> "+allQuantities.get(i));
               c++;
            }
         String input = in.nextLine();
         int n = input.toUpperCase().charAt(0) - 'A';
         if (0 <= n && n < allProducts.size())
         {
            return allProducts.get(n);
         }
      }      
   }
   
   public static void main(String[] args)
   {
      new VendingMachineMenu()
         .run(new VendingMachine());
   }
}
