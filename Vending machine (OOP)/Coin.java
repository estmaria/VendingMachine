
/**
   A coin with a monetary value.
   *@author Maria Esteban
   *@version 1.0
   *@since 2023-04-14
*/
public class Coin
{
   private double value;
   private String name;
   
   public static final Coin NICKEL = new Coin(.05, "nickel");
   public static final Coin DIME = new Coin(.1, "dime");
   public static final Coin QUARTER = new Coin(.25, "quarter");
   public static final Coin DOLLAR = new Coin(1, "dollar");
   // provide additional coints to be used
   
   /**
      Constructs a coin.
      @param aValue the monetary value of the coin.
      @param aName the name of the coin
   */
   public Coin(double aValue, String aName) 
   { 
      this.value=aValue;
      this.name=aName;
   }

   /**
      Gets the coin value.
      @return the value
   */
   public double getValue() 
   {
      return value;
   }

   /**
      Gets the coin name.
      @return the name
   */
   public String getName() 
   {
      return name;
   }

   /**
      Formats the coin's name and value for output as String
   */
   public String toString()
   {
      //return name + " @ " + String.format("%.2f", value);
      return name + " @ " + value;
   }
}
