import java.util.ArrayList;

/**
 * Write a description of class NPC here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NPC
{
    // instance variables - replace the example below with your own
    private String npcName;
    public ArrayList<Item> npcItems;
    private Room currentRoom;
    /**
     * Constructor for NPC class
     * @param String 
     * @param Room
     */
    public NPC(String npcName, Room room)
    {
       npcName = ""; 
       npcItems = new ArrayList<Item>();
    }
    
    /**
     * Getter method
     * @return name
     */
    public String getName()
    {
        return npcName; 
    } 
    
    /**
     * 
     * void method sets name
     */
    public void setName(String name)
    {
        npcName = name;
    } 
    
    
}
