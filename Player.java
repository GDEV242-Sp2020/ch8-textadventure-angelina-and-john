import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;
/**
 * Write a description of class Player here.
 *
 * @author John Fahy
 * @version (a version number or a date)
 */
public class Player
{
    // instance variables - replace the example below with your own
    private String playerName;
    public ArrayList<Item> playerItems;//Array list of items held by the player.
    public ArrayList<Item> pocket; 
    private double totalWeightCarried = 0;
    private Room currentRoom;
    private double maxWeight;
    private int playerHealth; 
    /**
     * Constructor for objects of class Player
     * @param playerName for the String field
     * @param room for the Room field
     */
    public Player(String playerName, Room room)
    {
        // initialise instance variables
        playerName = "";
        playerItems = new ArrayList<Item>();
        pocket = new ArrayList<Item>(); 
        totalWeightCarried = 0;
        currentRoom = room;
        maxWeight = 200; 
        playerHealth = 10; 
    }

    /**
     * pickUpItem method picks up item and aadds it to the playerItems array
     * @param Item for item value
     * adds item weight to total weight carried
     * 
     */
    public void pickUpItem(Item item)

    {
        playerItems.add(item);
        totalWeightCarried += item.getItemWeight();
    } 
   
    /**
    * dropItem method removes item from playerItems array
    * @param Item for item value
    * removes weight from total weight
    */
    public void dropItem(Item item)

    {
        playerItems.remove(item);
        totalWeightCarried -= item.getItemWeight();
    }
    /**
     * getCurrentRoom()
     * @returns currentRoom
     */
    public Room getCurrentRoom(){
      return currentRoom;   
     }
    
     /**
      * @returns playerItems
      */
    public ArrayList<Item> getItemList()
    {
        return playerItems;
    }
    
    /**
     * getItemInBackpack works with the look method in Game to display player inventory
     * @returns backpack items
     */
        public String getItemsInBackpack()
    
   {
     String backpackItems = " " ;
     for (Item item : playerItems)
     {
         backpackItems+= item.getItemDescription()+"\n";
        }
       return backpackItems;
    }
    
    /**
     * @param room 
     * sets currentRoom
     */
    public void setCurrentRoom(Room room){
        currentRoom = room;   
    }
    
    
    /**
     *  setPlayer method returns name
     *  @param String name
     */
    public void setPlayerName(String name)
    {
        playerName = name; 
    }
    
    /**
     * method should gets name 
     * @returns name
     * 
     */
    public String getName()
    {
        return playerName; 
    }
    
    /**
     * @param direction
     * @returns exit for currentRoom
     */
    public Room getPlayerExit(String direction){
        return currentRoom.getExit(direction); 
    }
    
    
    
    /**
     * getPlayerDescription is similar to the Long Description, and now gets printed in game instead of long Description
     * 
     */
    public String getPlayerDescription() 
    {
        String describe = "Hey " + playerName + "!" + currentRoom.getLongDescription();
        return describe; 
    } 
    
    
    /**
     * @return totalWeightCarried
     */
    public double getPlayerWeight()
    {
        return totalWeightCarried;
    }
    
    /**
     * Adds to player weight 
     * @return finalWeight
     */
    public double addToWeight(double itemWeight)
    {
     double finalWeight = totalWeightCarried + itemWeight; 
     return finalWeight; 
    }
    
    /**
     * Removes weight from player 
     * @return final weight
     */
    public double removeWeight(double itemWeight)
    {
     double finalWeight = totalWeightCarried - itemWeight; 
     return finalWeight; 
    }
    
    public double getMaxWeight()
    {
        return maxWeight; 
    }

    /**
     * 
     * @return health
     */
    public int getHealth()
    {
        return playerHealth; 
    }
    /**
     * void method injures player's health
     */
    public void hurt()
    {
       playerHealth = playerHealth - 1; 
        
    }
    /**
     * method adds health points when player goes outside
     */
    public void breathe()
    {
        playerHealth = playerHealth + 1; 
        System.out.println("Fresh air helps you feel better... try to avoid those rooms next time...");
        
        
    }
    
}
