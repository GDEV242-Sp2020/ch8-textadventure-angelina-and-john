import java.util.Random;
/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
        
    
   
    
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room outside, entranceHallway, stairs, stairs2, livingRoom, diningRoom, office,  kitchen, livingRoom2, bathroom1, upstairsHallway, bedroom1, bedroom2, bathroom2, 
        bathroom3, walkInCloset, study, weirdRoom;// start game outside
        
        outside = new Room("outside the door to the house"); 
        entranceHallway = new Room ("in the entrance hallway"); 
        stairs = new Room ("on the stair case going upstairs");
        stairs2 = new Room ("on the stair case going downstairs");
        livingRoom = new Room ("in the living room"); 
        diningRoom = new Room ("in the dining room");
        office = new Room ("in the office");
        kitchen = new Room ("in the kitchen");
        livingRoom2 = new Room ("in the family room");
        bathroom1 = new Room ("in the guest bathroom");
        bathroom2 = new Room ("in the Borden's bathroom"); 
        bathroom3 = new Room ("in Lizzie's bathroom");
        upstairsHallway = new Room ("in the hallway");
        bedroom1 = new Room ("in the bedroom of Andrew and Abby Borden");
        bedroom2 = new Room ("in the bedroom of Borden's daughter, Lizzie");
        bathroom2 = new Room ("in the upstairs bathroom");
        walkInCloset = new Room ("in a walk in closet");
        study = new Room ("in the study");
        weirdRoom = new Room ("in the secret room");
        
        outside.setExit("forward",entranceHallway); 
        
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
        
        bathroom1.setExit("south", kitchen); 
        
        stairs.setExit("south", entranceHallway);
        stairs.setExit("west", bedroom1); 
        stairs.setExit("east", bedroom2);
        stairs.setExit("north", study); 
        
        bedroom1.setExit("south", bathroom2);
        bedroom1.setExit("east", stairs2); 
        
        bedroom2.setExit("west", stairs2); 
        bedroom2.setExit("south", bathroom3);
        bedroom2.setExit("east", walkInCloset);
        
        weirdRoom.setExit("west", bedroom2); 
        
        
        currentRoom = outside;
        
        
        
       
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
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
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the Borden house");
        System.out.println("The house has been closed to the public since the axe murder of Sarah and Andrew Borden");
        System.out.println("Many believe that it was their daughter Lizzie, who murdered them in their sleep...");
        System.out.println("Although, no one is really sure...");
        System.out.println("Anyway,the house is very haunted... but an avid paranormal hunter like you should not worry...but go in at your own risk");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;
        boolean wantToLook = false;
        boolean wantToListen = false; 

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
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
            
            
            case LISTEN:
                wantToListen = listen(command); 
                
            case LOOK:
                wantToLook = look(command); 
                
           
            
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the Borden murder house.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }
    
    private boolean look(Command command) 
    {
        if(!command.hasSecondWord())
    {
        System.out.println(currentRoom.getLongDescription());
        return true; 
    } 
    else{
        return false;
        
    }
}
    
    private boolean listen(Command command)
    {
    
    String statement; 
    String[] Statements = {"The silence here is petriying..", "I think I just heard a whisper", "What was that?", "That was probably the wind... I hope",
    "AHH!! Oh wait.. it's just a pigeon", "I smell suflur...", "The floor boards are so creaky", "..." , "I almost thought I heard... nevermind", 
    "I can hear my own heartbeat..."};
    
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

    
    
    
    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
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
}