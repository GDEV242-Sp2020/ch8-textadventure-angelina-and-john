
/**
 * This class is for the Item 
 * 8.20 adds items to the game. 
 *
 * @author Angelina Joy 
 * @version March 8th, 2020
 */
public class Item
{
    // instance variables - replace the example below with your own
    private int weight ;
    private String description; 

    /**
     * Constructor for objects of class Item
     */
    public Item()
    {
        // initialise instance variables
       description = "";
       weight = 0; 
    }
  
  public Item(String itemDescription, int itemWeight)
  {
      itemDescription = description;
      itemWeight = weight; 
    }
   /**
    *  getItemDescription returns String for Item 
    */
   public String getItemDescription()
   {
       String itemString = "Item Description: "; 
       itemString += this.description + "\n"; 
       itemString += "Weight:" + this.weight;
       
       return itemString; 
    }
}
