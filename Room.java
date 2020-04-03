import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.
    public ArrayList<Item> roomItems;      //Has an ArrayList of Room items

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
        this.roomItems = new ArrayList<Item>(); 
    }
 
    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    
     public void dropItemToTheRoom(Item item)

    {
        roomItems.add(item);
        
    } 
    
    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * 
     * if the current room is the wine cellar, there will be no exits.  
     * game will prompt player to QUIT
     * 
     * 
     * 
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        if(getShortDescription()== "in the wine cellar")
        {
        
            return "You have entered the wine cellar and the heavy metal door locked behind you...and you will die... but atleast you have wine!" +"\n" + " Quit to restart"; 
            
        }
        else 
        
        return "\n"  + "You are " + description + ". \n" + "You see: \n  " + getItemsInRoom() + "\n" + getExitString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            
            returnString += " " + exit;
        }
        
        
        return returnString;
    }

    
     
    public String getItemsInRoom()
    
   {
     String returnItems = " " ;
     for (Item item : roomItems)
     {
         returnItems+= item.getItemDescription()+"\n";
        }
       return returnItems;
    }
    
    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    
    // addItem method 
     public void addItem(Item item)
    
    {
        roomItems.add(item); 
    } 
   
     
    
     public void removeItem(Item item)
    {
        
        roomItems.remove(item); 
    }
    
    
}

