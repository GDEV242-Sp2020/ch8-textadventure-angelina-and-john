
import java.util.Random;
import java.util.Stack;
import java.util.Scanner;
import java.util.Iterator;
/**
 *  This class is the main class of the Text Adventure Game. 
 *  Users can walk around some scenery. Pick up and drop objects, and more...
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 * This game contains: 
 * 
 * 19 Rooms
 * 8.14 Look command
 * 8.15 Listen command
 * 8.16 Streamline printing of available commands
 * 8.20 Items
 * 8.21 Rooms that can hold multiple items
 * 8.26 Back command using stacks
 * 8.28 A player which can hold multiple items using stacks
 * 
 * A rudimentary health system : health decrements if you enter kitchen or living room due to a "gas leak"... health increments if you go back outside for "fresh air" 
 * A one way trap door
 * 
 * 
 * allow player to take item
 * allow player to drop item
 * player can have multiple items
 * room can hold multiple items
 * player has a max weight 
 * 
 * @author  Angelina Joy & John Fany
 * @version Spring 2020
 */

public class Game 
{
    
    
    private Parser parser;
    private Player player;
    private Room currentRoom;
    private String playerName;
    private Stack<Room> rooms; // Stack of Rooms for the back Command
    private Room previousRoom; //previous Rooms is for the stack
    
    Scanner input = new Scanner(System.in); // Added scanner to create player
    
    public static void main(String[] args) {
        Game mygame = new Game();
        mygame.play();
    }
    
    /**
     * Create the game and initialise its internal map.
     * CreateRooms
     * Create a new Parser
     * Create the player
     * Create Rooms
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        player = new Player(playerName, currentRoom);
        rooms = new Stack<Room>(); // create Stack 
    }

    /**
     * CreatePlayer method
     * Ask player to input name.
     * Set the player name
     * Set Current room
     * 
     */
    
    private void createPlayer()
    {
        System.out.println("What is your name, ghost hunter?");
        playerName = input.nextLine(); // reads next line
        player.setPlayerName(playerName);  //sets player's name (if it works?) 
         /////just added Z
        player.setCurrentRoom(currentRoom);
        
        
    }
    
    
    /**
     * Create all the rooms and link their exits together.
     * Create array of items. Each room has its own array. 
     * 
     * Items outsideItems[] for example, is for for the "outside Room" 
     * 
     * 
     */
    private void createRooms()
    {
        Room outside, entranceHallway, stairs, stairs2, livingRoom, diningRoom, office,  kitchen, livingRoom2, bathroom1, upstairsHallway, bedroom1, bedroom2, bathroom2, 
        bathroom3, walkInCloset, study, weirdRoom, trapRoom;
        
        //All the room variables are defined above. 
        
        //Bellow are all the Item arrays
        Item outsideItems[] = { 
                                new Item("bench", 50),
                                new Item("garogyle", 500) 
        };
        Item entranceItems[] = { 
                                new Item("candle-stick", 3)
        };
        Item stairsItems[] =      {
                                new Item("spiderwebs", 0 ) 
        };
        Item stairs2Items[] =  {
                                new Item("spiderwebs", 0),
                                new Item("spider", 0)
        };
        
        Item livingRoomItems[] = {
                                new Item("book", 5),
                                new Item("key", 0.1),
                                new Item("couch", 300)
                               
        };      
        Item diningRoomItems[] = {
                                new Item("plate", 3),
                                new Item("fork", 1) 
        };
        Item officeItems[] = {
                                new Item("book", 4),
                                new Item("papers", 1) 
        };
        Item kitchenItems[] = {
                                new Item("plate", 4),
                                new Item("painting", 120) 
        };
        Item livingRoom2Items[] = {
                                 new Item("book", 5),
                                new Item("couch", 300),
                                new Item("table", 200)
                               
                            };            
        Item bathroom1Items[] = {
                                new Item("mirror", 10),
                                new Item("toothbrush", 2) 
        };
        Item bathroom2Items[] = {
                                new Item("hairbrush", 2) ,
                                new Item("wall-mirror", 101)
                               
        };  
        Item bathroom3Items[] = {
                                new Item("hairbrush", 4),
                                new Item("toothbrush", 2) 
        };  
        Item upstairsHallwayItems[] = {
                                new Item("family-portrait", 101)
        }; 
        Item bedroom1Items[] = {
                                new Item("earrings", 1),
                                new Item("rocking-chair", 120),
                                new Item("bed", 300)
        };
        Item bedroom2Items[] = {
                                
                                new Item("teddy-bear", 5),
                                new Item("journal", 3),
                                new Item("bed", 300)
                             };            
        Item studyItems[] = {
                                new Item("envelope", 0) 
        };
        Item walkInClosetItems[] = {
                                new Item("hanger", 1) 
        };
         Item weirdRoomItems[] = {
                                new Item("voodoo-doll", 1) 
        };
        
        Item trapRoomItems[] = {
                                new Item("barell of red wine", 300),
                                new Item("barrel of white wine", 300),
                                new Item("skeleton", 20)
        };
        
        // bellow all the rooms are made. 
        outside = new Room("outside the door to the house"); //1
        entranceHallway = new Room ("in the entrance hallway"); //2
        stairs = new Room ("on the stair case going upstairs");//3
        stairs2 = new Room ("on the stair case going downstairs");//4
        livingRoom = new Room ("in the living room"); //5
        diningRoom = new Room ("in the dining room");//6
        office = new Room ("in the office");//7
        kitchen = new Room ("in the kitchen");//8
        livingRoom2 = new Room ("in the family room");//9
        bathroom1 = new Room ("in the guest bathroom");//10
        bathroom2 = new Room ("in the master bathroom"); //11
        bathroom3 = new Room ("in small bathroom");//12
        upstairsHallway = new Room ("in the hallway");//13
        bedroom1 = new Room ("in the master bedroom");//14
        bedroom2 = new Room ("in the small bedroom");//15
        walkInCloset = new Room ("in a walk in closet");//16
        study = new Room ("in the study");//17
        weirdRoom = new Room ("in the secret room");//18
        trapRoom = new Room("in the wine cellar");   ///19 trapRoom has no exits. The player gets stuck. 
        
        //Added all the items to the rooms 
        outside = addItemsToRoom(outside, outsideItems); 
        entranceHallway = addItemsToRoom(entranceHallway, entranceItems); 
        stairs = addItemsToRoom(stairs, stairsItems); 
        stairs2 = addItemsToRoom(stairs2, stairs2Items); 
        livingRoom = addItemsToRoom(livingRoom, livingRoomItems); 
        diningRoom = addItemsToRoom(diningRoom, diningRoomItems); 
        office = addItemsToRoom(office, officeItems); 
        kitchen = addItemsToRoom(kitchen, kitchenItems);
        livingRoom2 =  addItemsToRoom(livingRoom2, livingRoom2Items); 
        bathroom1 = addItemsToRoom(bathroom1, bathroom1Items);
        bathroom2 = addItemsToRoom(bathroom2, bathroom2Items);
        bathroom3 = addItemsToRoom(bathroom3, bathroom3Items); 
        upstairsHallway = addItemsToRoom(upstairsHallway, upstairsHallwayItems); 
        bedroom1 = addItemsToRoom(bedroom1, bedroom1Items); 
        bedroom2 = addItemsToRoom(bedroom2, bedroom1Items);
        walkInCloset = addItemsToRoom(walkInCloset, walkInClosetItems); 
        study = addItemsToRoom(study, studyItems); 
        weirdRoom = addItemsToRoom(weirdRoom, weirdRoomItems); 
        trapRoom = addItemsToRoom(trapRoom, trapRoomItems);
        
        
        
        //Bellow are all the exits for the rooms
        
        outside.setExit("north", entranceHallway); 
        
        entranceHallway.setExit("west", livingRoom);
        entranceHallway.setExit("east", kitchen);
        entranceHallway.setExit("south", outside); 
        entranceHallway.setExit("north", stairs);
        
        livingRoom.setExit("west", diningRoom); 
        livingRoom.setExit("east", entranceHallway); 
        livingRoom.setExit("north", office); 
        
        diningRoom.setExit("north", livingRoom2);
        diningRoom.setExit("east", livingRoom);
        
        livingRoom2.setExit("south", diningRoom); 
        livingRoom2.setExit("east", office); 
        
        office.setExit("south", livingRoom);
        office.setExit("west", livingRoom2);
        
        kitchen.setExit("west", entranceHallway);
        kitchen.setExit("north", bathroom1);
        kitchen.setExit("east", trapRoom);
        
        bathroom1.setExit("south", kitchen); 
        
        stairs.setExit("south", entranceHallway);
        stairs.setExit("north", upstairsHallway); 
        
        stairs2.setExit("south", entranceHallway);
        stairs2.setExit("north", upstairsHallway);
        
        upstairsHallway.setExit("west", bedroom1); 
        upstairsHallway.setExit("east", bedroom2);
        upstairsHallway.setExit("north", study); 
        upstairsHallway.setExit("south", stairs2); 
        
        study.setExit("south", upstairsHallway);
        
        
        bedroom1.setExit("south", bathroom2);
        bedroom1.setExit("east", stairs2); 
        
        bathroom2.setExit("north", bedroom1);
        
        
        bedroom2.setExit("west", stairs2); 
        bedroom2.setExit("south", bathroom3);
        bedroom2.setExit("east", walkInCloset);
        
        walkInCloset.setExit("west", bedroom2);
        walkInCloset.setExit("east", weirdRoom);
        
        bathroom3.setExit("north", bedroom2); 
        
        weirdRoom.setExit("west", walkInCloset); 
        
        
        previousRoom = outside; 
        currentRoom = outside;
        
        
        
        
        
       
    }

    /**
     *  Main play routine.  Loops until end of play.
     *  creates a player
     */
    public void play() 
    {            
        createRooms();//creates Rooms
        createPlayer(); // now creates player 
       
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     * Game greets the player with their own name.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the haunted house, " + player.getName() +".  \n");
        System.out.println("The house has been closed to the public since the murder..." +"\n" );
        System.out.println("Anyway,the house is very haunted... ");
        System.out.println("A few rooms also have a gas leak... so be careful. Your current health is " + player.getHealth()); 
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(player.getPlayerDescription()); //!!!!!!
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        /*
         * Initilize all the booleans as false 
         */
        boolean wantToQuit = false;
        boolean wantToLook = false;
        boolean wantToListen = false; 
        boolean wantToGoBack = false; 
        boolean wantToTake = false; 
        boolean wantToDrop = false; 
        

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean..." +"\n" );
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
            
            //Added a Listen Command 8,15
            case LISTEN:
                wantToListen = listen(command); 
                break;
            //Added a Look Command for 8.14
            case LOOK:
                wantToLook = look(command); 
                break;
                
            case BACK: 
            
                wantToGoBack = back(command); //added a back command (also check Command enum class)
                break; 
            
            case TAKE:
                  
                 wantToTake = take(command); 
                 break; 
                
            case DROP:
                 wantToDrop = drop(command); 
                 break;
            
                 
         
        }
        
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     * 
     * 
     * The print help method has been edited to not print the commands if you are trapped
     */
    private void printHelp() 
    {
        
        if(currentRoom.getShortDescription() == "in the wine cellar")
        {
        
            System.out.println("I cannot help you, " + player.getName() +"...");
            System.out.println("You have to QUIT the game, or die a slow painful death..");
            
            
        } 
        else {
        System.out.println("You are lost, " +player.getName() +". You are alone. You wander " +"\n" );
        System.out.println("around at the Borden murder house."+"\n" );
        System.out.println();
        System.out.println("Your command words are:"+"\n" );
        parser.showCommands();
    }
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     * @param command The command to be processed.
     */
    private void goRoom(Command command) 
    {
        
        if(player.getHealth() < 1)
        { 
            System.out.println("You lay there motionless in the " + currentRoom.getShortDescription()); 
        }
        
        else
        
             {
            
            
        
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?"+"\n" );
            return;
              } 

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);
        //Room nextRoom = player.getCurrentRoom().getExit(direction)
        
            if (nextRoom == null) {
            System.out.println("There is no door!"+"\n" );
                 }
             else {
            rooms.push(currentRoom); //push is a method of the Stack class
            currentRoom = nextRoom;
            
            
         //player.setCurrentRoom(nextRoom); COMMENTED OUT YOUR STATEMENT JOHN
            System.out.println(currentRoom.getLongDescription());   
             if( rooms.push(currentRoom).getShortDescription() == "in the kitchen" ||  rooms.push(currentRoom).getShortDescription() == "in the living room")
            { 
             player.hurt(); 
             System.out.println(" Dont you feel a little dizzy... maybe go back out for fresh air...");
             System.out.println(" Health is " + player.getHealth());
             
             if(player.getHealth() < 1)
             {
                System.out.println("...I warned you about that gas leak...");
                System.out.println( player.getName() + " is dead... quit to restart"); 
              }
             
              
              
            }
            
            if(rooms.push(currentRoom).getShortDescription() == "outside the door to the house" && player.getHealth() < 10) 
            {
                player.breathe(); 
                System.out.println("Health:" + player.getHealth());
            } 
   
            
        }
        
    
        
          }
        
    }
    
    /**
     * Adds the look command to the game
     * @returns true or false for the boolean field
     *  @param command The command to be processed.
     *  if command does not have a second word, print out long description of the room.
     *  print out that you are looking in the backpack, then print out items in playerItems if there are any
     *  if the backpack is empty print out that its empty 
     *  
     */
    private boolean look(Command command) 
    {
        if(!command.hasSecondWord())
    {
        System.out.println(currentRoom.getLongDescription());
        System.out.println();
        
        if(player.getItemList()!= null)
        {
            System.out.println("Let's take a look in your backpack...");
            System.out.println(player.getItemsInBackpack());
            
        }
        if(player.getItemList().isEmpty())
        {
           System.out.println("Your backpack is empty...");
        }
        
        return true; 
        } 
        else{
        return false;
        
        }
}
    /**
     * 8.15 Adds Listen Command.
     * This command pulls a random statement from an array of statements.
     * @param command The command to be processed.
     * @returns true if command does not have a second word
     * @returns false for else
     *  @param command The command to be processed.
     * 
     * Feel free to add more statements - Angelina
     */
    private boolean listen(Command command)
    {
    
    String statement; 
    
    String[] Statements = {"The silence here is petriying..", "I think I just heard a whisper", "What was that?", "That was probably the wind... I hope",
    "AHH!! Oh wait.. it's just a pigeon", "I smell suflur...", "The floor boards are so creaky", "..." , "I almost thought I heard... nevermind", 
    "must be the rats" }; // add random statements here. 
    
    Random r = new Random(); 
    
    statement = Statements [r.nextInt(Statements.length)];
        
     
        if(!command.hasSecondWord())
      {
        
        
        System.out.print(statement); 
        
        return true; 
      }
      else {
     return false; 
    
    
   }
   
    }

    
    /** Adds the array of items to the room 
     * 
     *  @param Room for room field
     *  @param Item for items array field
     *  @returns value for room
     *
     * 
     * 
     * 
     */
    private Room addItemsToRoom(Room room, Item items[]) 
    {
        for (int i = 0; i < items.length; i++)
        {
            room.addItem(items[i]);
            
        }
        return room; 
    }

    
    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     * @param command The command to be processed.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
    
    /** 
     * "Back" was entered. Check rest of command to see wether player wants to quit the game
     * @param command for command field
     * @return false if room stack is empty
     * @return false if current room is trap room
     * @return true if else, current room is top of the stack. 
     * 
     * 
     * 
     */
    

    private boolean back(Command command)
    {
     
    String statement1; 
    
    String[] Statements1 = {"There is no where to go... " , "This lock is unbreakable.. ", "You can't go back...You will die here... ", "You'll never leave here! Might as well drink some wine ", "You can't go back.. " 
    }; // add random statements here. 
    
    Random r = new Random(); 
    
    statement1 = Statements1 [r.nextInt(Statements1.length)];
        
     
     if(player.getHealth() < 1)
        { 
            System.out.println("You lay there motionless in the " + currentRoom.getShortDescription() + "..."); 
            return false; 
        } 
     
    else {
     if (rooms.empty())
     { System.out.print("You are outside the Borden house."+"\n" ); 
         
       return false;
     }
     else if(currentRoom.getShortDescription() == "in the wine cellar")
     {   
         System.out.println(statement1 + player.getName()); 
         return false; 
     }
     else 
     {
         
         currentRoom = rooms.pop(); 
         if(currentRoom.getShortDescription() == "in the kitchen" || currentRoom.getShortDescription() == "in the living room")
         { 
             player.hurt(); 
             System.out.println(" Dont you feel a little dizzy... maybe go outside for some fresh air");
             System.out.println(" Health is " + player.getHealth());
             
             if(player.getHealth() < 1)
             {
                System.out.println("...I warned you about that gas leak...");
                System.out.println( player.getName() + " is dead... quit to restart."); 
                
             }
             
         }
         
         
          if(rooms.push(currentRoom).getShortDescription() == "outside the door to the house" && player.getHealth() < 10) 
            {
                player.breathe(); 
                System.out.println("Health:" + player.getHealth());
            } 
   
         
         
         System.out.println(currentRoom.getLongDescription()); 
         return true;
     }
    }
    }
    
     /** 
     * if array of items in the currentRoom is empty print out that there is nothing tot take 
     * @return false
     * if the command doesn't have a second word and array of items in the currentroom is NOT empty ask for the second word.
     * @return false
     * if command has a second word, and current room items is not empty use an iterator to find the item by its description.
     * remove item
     * add item to player items
     * @return true
     * @param command The command to be processed.
     */
       public boolean take(Command command)
    {
        if(currentRoom.roomItems.isEmpty())
        {
            System.out.print("There is nothing to take.");
            return false;
        }
        
        if(!command.hasSecondWord() && !currentRoom.roomItems.isEmpty())
        {
            System.out.println("Take what?");
            return false;
            
        }
        
      
        {
            String itemName;
            itemName = command.getSecondWord(); 
            
            Iterator iter = currentRoom.roomItems.iterator(); 
            
            while (iter.hasNext()) {
                Item itemToCheck = (Item)iter.next();
                
              
                if (itemToCheck.getDescription().equals(itemName)) {   // we have found the item
                  // take it out of the room
                
                  if((itemToCheck.getItemWeight() + player.getPlayerWeight()) > player.getMaxWeight())
                  {
                    System.out.println("That is too heavy for you");
                  }
                  else if((itemToCheck.getItemWeight() + player.getPlayerWeight()) < player.getMaxWeight())
                  {
                  iter.remove();
                  player.pickUpItem(itemToCheck);
                  System.out.println("You pick up : " + itemName);
                  return true;
                  }
                  else 
                  {
                      
                  }
              }
            
            // if we get here we didn't find it
              System.out.println("Can't pick up "+itemName+"...");
              return false;
            }                              
        }
        
        
     
        return true; 
    }

    /**
     * public boolean drop
     * if playeritems array is empty
     * @returns true
     * if player
     */
    public boolean drop(Command command)
    {
        if(player.playerItems.isEmpty())
        {
            System.out.println("There is nothing to drop");
            return false;
        }
        if(!command.hasSecondWord() && !player.playerItems.isEmpty())
        {
           System.out.print("Take what?"); 
           return false;
        }
        if(command.hasSecondWord() && !player.playerItems.isEmpty())
        {
            String itemID;
            itemID = command.getSecondWord(); 
            
            Iterator it = player.playerItems.iterator(); 
            
            while (it.hasNext())
            {
                Item itemToCheckDrop = (Item)it.next();
                if(itemToCheckDrop.getDescription().equals(itemID))
                {
                it.remove();
                currentRoom.dropItemToTheRoom(itemToCheckDrop);
                System.out.println("You dropped " + itemID);
                
                player.removeWeight(itemToCheckDrop.getItemWeight()); // removes weight from player
                
                return true;
                
            
                }
                
                System.out.println("I don't see that item in your backpack");
                return false;
        }
        
        } 
        return true;
     }
}