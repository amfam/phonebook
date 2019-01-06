package phonebook;
import java.util.*;// Importing all the classes in the particular package

public class PhoneBooktester {  
  /**  
   * @param args the command line arguments
   */
  
  public static void main(String[] args) {
// TODO code application logic here
    PhoneBookengine t = new PhoneBookengine();
  
    Scanner sc = new Scanner(System.in);     

//The first interaction where the user has to choose an option to proceed
     int x=0;//Initialized an integer x
     

//try and catch statement to handle all kinds of exception 
       try{

//While loop has been implemented and it will run until option4/Exit has been selected     
         while (x==0){
           System.out.println("Please choose an option below:");
           System.out.println("1. Add Contact");
           System.out.println("2. Search Contact");
           System.out.println("3. Delete Contact");
           System.out.println("4. Exit");
           int in = sc.nextInt();//Integer int stores the option choosen by the user  
           
           x = t.runEngine(in);//Integer x wiil store the return value
           
         }
       }
       catch(Exception error){
         
         while (x==0){
           System.out.println("");  
           System.out.println("Sorry you input was wrong! Please try again .");
           main(args);
         }
       }
  }
}