
/**
 * This class is for the Item 
 *
 * @author Angelina Joy 
 * @version March 8th, 2020
 */
public class Item
{
    // instance variables - replace the example below with your own
    private int emfReading ;
    private String description; 

    /**
     * Constructor for objects of class Item
     */
    public Item()
    {
        // initialise instance variables
       description = "";
       emfReading = 0; 
    }
 
   /**
    *  getItemDescription returns String for Item 
    */
   public String getItemDescription()
   {
       String itemString = "Item Description: "; 
       itemString += this.description + "\n"; 
       itemString += "EMF reading:" + this.emfReading;
       
       return itemString; 
    }
}
