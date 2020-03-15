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
    private ArrayList<Item> playerItems; //Array list of items held by the player.
    private int totalWeightCarried;
    private Room currentRoom;
    private int maxWeight;
    /**
     * Constructor for objects of class Player
     * @param playerName for the String field
     * @param room for the Room field
     */
    public Player(String playerName, Room room)
    {
        // initialise instance variables
        playerName = "";
        this.playerItems = new ArrayList<Item>();
        totalWeightCarried = 0;
        currentRoom = room;
        maxWeight = 500; 
    }

    /**
     * 
     * 
     */
    public void pickUpItem(Item item)

    {
        playerItems.add(item);
        totalWeightCarried += item.getItemWeight();
    } 

    public void dropItem(Item item)

    {
        playerItems.remove(item);
        totalWeightCarried -= item.getItemWeight();
    }
    
    
    public Room getCurrentRoom(){
     return currentRoom;   
    }
    
    
    public void setCurrentRoom(Room room){
     currentRoom = room;   
    }
    
    
    /**
     *  setPlayer method returns name
     * 
     */
    public void setPlayerName(String name)
    {
        this.playerName = name; 
    }
    
    /**
     * method should gets name 
     * 
     * 
     */
    public String getName()
    {
        return playerName; 
    }
    
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
}
