import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{
    // instance variables - replace the example below with your own
    private String playerName;
    private ArrayList<Item> playerItems; //Array list of items held by the player.
    private int totalWeightCarried;
    private Room currentRoom;
    /**
     * Constructor for objects of class Player
     */
    public Player(String playerName, Room room)
    {
        // initialise instance variables
        playerName = "";
        this.playerItems = new ArrayList<Item>();
        totalWeightCarried = 0;
        currentRoom = room;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
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
}
