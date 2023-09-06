import java.util.ArrayList;

/**
   A vending machine.
   Needs to store products
   Need to have a coinbox
   Needs to keep track of current coins
   *@author Maria Esteban
   *@version 1.0
   *@since 2023-04-14
*/
public class VendingMachine
{ 
   private CoinBox customerCoinBox;
   private CoinBox mainCoinBox;
   private ArrayList<Product> productsAvaliable; //stores the prducts
   private ArrayList<Integer> quantities; //stores the quantities 

   
   /**
      Constructs a vending machine
   */
   public VendingMachine()
   {
      customerCoinBox= new CoinBox();
      mainCoinBox= new CoinBox();
      productsAvaliable=new ArrayList<Product>();
      quantities= new ArrayList<Integer>();
   }

   /**
      Adds a product and its quantity to the vending machine 
      @param aProduct the product
      @param quantity the number of products
   */
   public void addProduct(Product aProduct, int quantity)
   {
      //if the product is alredy on the array list it sums the quantity to the number on the quantities array list
      boolean repeated=false;
      for (int i=0; i<productsAvaliable.size();i++)
      {
         if (productsAvaliable.get(i).equals(aProduct))
         {
            quantities.set(i, quantities.get(i)+quantity);
            repeated=true;
            break;
         }
      }
      //if the product is not in the array list it adds it and it adds the quantity to the quantities array list (they will have same index)
      if(!repeated)
      {
         productsAvaliable.add(aProduct);
         quantities.add(quantity);
      }
   }

   /**
      Gets the products avaliable in the vending machine
      @return an arraylist with all the products
   */
   public ArrayList<Product> getProductTypes()
   {
      return productsAvaliable;
   }



   /**
      Adds a coin to the coin box
      @param acoin the coin
   */
   public double addCoin(Coin aCoin)
   {
      customerCoinBox.addCoin(aCoin);
      return customerCoinBox.getValue();
   }


   /**
      Let the user buy the product if there is enough money in the coin box
      @param aProduct the product
      @return a string saying "OK" if there is enough money to buy the product or "Insufficient money" if there isn't
   */
   public String buyProduct(Product aProduct)
   {
      String result="";
      //if there is enough mone in the coin box result="OK"
      if (customerCoinBox.getValue()>=aProduct.getPrice())
      {
         result="OK";
         //gives change
         double change=customerCoinBox.getValue()-aProduct.getPrice(); 
         customerCoinBox.removeAllCoins();
         while (change>0)
         {
            if (change>=1)
            {
               customerCoinBox.addCoin(Coin.DOLLAR);
               change-=1;
            }
            else if (change>=0.25)
            {
               customerCoinBox.addCoin(Coin.QUARTER);
               change-=0.25;
            }
            else if (change>=0.1)
            {
               customerCoinBox.addCoin(Coin.DIME);
               change-=0.1;
            }
            else if (change>=0.05)
            {
               customerCoinBox.addCoin(Coin.NICKEL);
               change-=0.05;
            }
         }
         //adds the money to the main coin box
         double price=aProduct.getPrice();
         while (price>0)
         {
            if (price>=1)
            {
               mainCoinBox.addCoin(Coin.DOLLAR);
               price-=1;
            }
            else if (price>=0.25)
            {
               mainCoinBox.addCoin(Coin.QUARTER);
               price-=0.25;
            }
            else if (price>=0.1)
            {
               mainCoinBox.addCoin(Coin.DIME);
               price-=0.1;
            }
            else if (price>=0.05)
            {
               mainCoinBox.addCoin(Coin.NICKEL);
               price-=0.05;
            }
         }
         
         //substracts 1 from the quantity or deletes the product if there are not any left
         for (int i=0; i<productsAvaliable.size();i++)
      {
         if (productsAvaliable.get(i).equals(aProduct))
         {
            quantities.set(i, quantities.get(i)-1);
            if (quantities.get(i)==0)
            {

               productsAvaliable.remove(productsAvaliable.get(i));
               quantities.remove(quantities.get(i));

            }
         }
      }
         
      }
      //if there is not enough money returns error message
      else
      {
         result="Insufficient money";
      }
      return result;
   }
   /**
      Gets the quantities of the products
      @return an arraylist with the quantities of the products
   */
   public  ArrayList<Integer> getQuantity()
   {
      return quantities;
   }

   /**
      @return the amount of money that is in the customer coin box
   */
   public double getMoney()
   {
      return customerCoinBox.getValue();
   }

   /**
      Gets the money that is in the main coin box to the user
      @return the money that has been returned
   */
   public double removeTotalMoney()
   {
      double totalMoney=mainCoinBox.getValue();
      mainCoinBox.removeAllCoins();
      return totalMoney;
   }

   /**
      Gets the money that is in the customer coin box to the user
      @return the money that has been returned
   */
   public double removeUserMoney() 
   {
      double totalMoney=customerCoinBox.getValue();
      customerCoinBox.removeAllCoins();
      return totalMoney;
   }

}
