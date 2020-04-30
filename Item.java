
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
    private double itemWeight ;
     

    /**
     * Constructor for objects of class Item
     */
    public Item()
    {
        // initialise instance variables
       itemDescription = "";
       itemWeight = 0; 
    }
  
  /**
   * @param description for the String field for the Item
   * @param weight for the double field for the Item
   * 
   */
  public Item(String description, double weight)
  {
      itemDescription = description;
      itemWeight = weight; 
    }
    
    
   /**
    *  getItemDescription 
    *  @return itemString
    */
   public String getItemDescription()
   {
     String itemString = "\t Item name:  " 
    +
    this.itemDescription + "\n"; 
    itemString += "\t Item weight: " + this.itemWeight; 
    return itemString; 
    
    }
    
    /**
     * @return itemDescription
     */
    public String getDescription()
    {
        return itemDescription;
    }
    
    /**
     * @return itemDescription
     * 
     */
       public String getItemShortDescrption()
    {
        String shortDescription = itemDescription; 
        return shortDescription;
    }
    
    
    /**
     * getItemWeight method
     * @return this.itemWeight
     * 
     */
    public double getItemWeight(){
      return this.itemWeight;  
    }
}
