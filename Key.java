
/**
 *This class is for the key
 *
 * @author (Angelina Joy)
 * @version 2/11/2020
 */
public class Key
{
   boolean owned; // Is the key owned or not? 
   String keyID; 
   
   public Key()
   {
    
       boolean owned; 
       String identifier; 
       
       
   }
    
   public Key(String keyID)
   {
   owned = false;
   this.keyID= keyID;
       
   }
    
  public void grab() {
  
      owned = true; 
  } 
    
 public String toString() {
 
     return keyID; 
 }
 
 public boolean own() 
 {
  return owned;     
 }
}
