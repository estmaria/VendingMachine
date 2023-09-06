
/**
   A product in a vending machine.
   *@author Maria Esteban
   *@version 1.0
   *@since 2023-04-14
*/
public class Product
{  
   private String description;
   private double price;

   /**
      Constructs a Product object
      @param aDescription the description of the product
      @param aPrice the price of the product
   */
   public Product(String aDescription, double aPrice)
   {  
      this.description=aDescription;
      this.price=aPrice;
   }
   
   /**
      Gets the description.
      @return the description
   */
   public String getDescription()
   { 
      return description;
   }
   
   /**
      Gets the price.
      @return the price
   */
   public double getPrice()
   {  
      return price;
   }

   /**
      Determines of this product is the same as the other product.
      @param other the other product
      @return true if the products are equal, false otherwise
   */

   public boolean equals(Object other)
   { 
      Product otherProduct=(Product) other;
      return description.equals(otherProduct.description);
      
   }
   
   /**
      Formats the product's description and price for output as String
   */
   public String toString()
   { 
      //return description + " @ $" + String.format("%.2f", price);
      return description + " @ $" + price;
   }
}
