
import java.util.ArrayList;

/**
   A box of coins.
   *@author Maria Esteban
   *@version 1.0
   *@since 2023-04-14
*/
public class CoinBox
{  
   private ArrayList<Coin> box;

   /**
      Constructs a CoinBox object.
   */
   public CoinBox()
   {  
      box = new ArrayList<Coin>();
   }

   /**
      Adds a coin.
      @param c the coin to add
   */
   public void addCoin(Coin c)
   {  
      box.add(c);
   }

   /**
      Gets the value of all the coins.
      @return total the total value of all the coins
   */
   public double getValue()
   {  
      double total=0;
      for(int i=0; i<box.size(); i++)
      {
         double value=box.get(i).getValue();
         total=total+value;
      }
      return total;
   }
   
   /**
      Removes all the coins. Use ArrayList function.
      Do NOT use a new constructor to a new memory location.
   */
   public void removeAllCoins()
   { 
      box.clear();
   }
}