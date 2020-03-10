
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
    private String itemDescription;
    private int itemWeight ;
     

    /**
     * Constructor for objects of class Item
     */
    public Item()
    {
        // initialise instance variables
       itemDescription = "";
       itemWeight = 0; 
    }
  
  public Item(String description, int weight)
  {
      itemDescription = description;
      itemWeight = weight; 
    }
   /**
    *  getItemDescription returns String for Item 
    */
   public String getItemDescription()
   {
     String itemString = "\t Item name:  " 
    +
    this.itemDescription + "\n"; 
    itemString += "\t Item weight: " + this.itemWeight; 
    return itemString; 
    
    }
}
