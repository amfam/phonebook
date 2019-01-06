package phonebook;
import java.util.*;// Importing all the classes in the particular package

public class PhoneBookengine {
  Scanner sc = new Scanner(System.in); 
  Object [] data = new Object[26];//Creating an array of size 26
 
  public  PhoneBookengine(){
    for(int i=0; i<data.length; i++){
      Node h = new Node("","",null,null);//creating a node
      data[i]=h;
    }
  }

//This method is to help the user navigate around the program by choosing given options
  public int runEngine(int inp){    
    if(inp==1){
      System.out.println("Please enter your Name below:");
      String name=sc.nextLine();//Input User's Name in the String variable name
      System.out.println("Please enter your Phone Number below:");
      String number=sc.nextLine();//Input User's Number in the String variable number
      System.out.println("Please enter your address below:");
      String address=sc.nextLine();//Input User's Address in the String variable name address
      
      AddContact(name,number,address); //Add Contact details
      System.out.println("Your contact has been saved.");
      System.out.println("Thank You!");
      System.out.println("");
      System.out.println("Please choose a new option to proceed.");
      return 0;
    }else if(inp==2){
      System.out.println("Please enter your Name below:");
      String name =sc.nextLine();//Input User's Name in the String variable name
      
      Showinfo(name); //Show Contact details as per the contact name given by the user
      System.out.println("Thank You!");
      System.out.println("");
      System.out.println("Please choose a new option to proceed.");
      return 0;
    }else if (inp==3) {
      System.out.println("Please enter your Name below:");
      String name = sc.nextLine();//Input User's Name in the String variable name
      
      DeleteContact(name); 
      System.out.println("Thank You!");
      System.out.println("");
      System.out.println("Please choose a new option to proceed.");
      return 0;
    } else{
      System.out.println(" Exiting  Now  . Thank you for your trial");
      System.exit(0);
    }
    return 0;
  }

//This method is used to add contacts  
  public void AddContact(String na,String num,String add){
    String t =na.toUpperCase();//converting the name to uppercase letters
    
    char[] a =t.toCharArray();//creating an array to hold each letters of the name
    int x = (int)a[0];//storing the ASCII for the first letter of the name in integer x
    
    Node head=(Node) data[x-65];//to sort the name into the array respectively
    Node h=head;
    int idx = countNode2(h);
    
    if(idx==0){            
      Node n = new Node(t,num,add,null);
      h.next=n;
      h=h.next;
      //System.out.println(h.name+"\t"+h.address+"\t"+h.number);
    }
    else{
      for(int i=1; i<idx-1; i++){
        h=h.next;
      }
      Node y = h.next;
      Node n = new Node(t,num,add,null);
      n.next=y;
      h.next=n;
      // System.out.println(h.name+"\t"+h.address+"\t"+h.number);
    }
    //sort(); 
    
  }
  
//This method is used to delete contact as per the name given  
  public void DeleteContact(String name){
    Node remove;
    String t = name.toUpperCase();//converting the name to uppercase letters
    
    char [] a =t.toCharArray();//creating an array to hold each letters of the name
    int x = (int)a[0];//storing the ASCII for the first letter of the name in integer x
    
    Node head=(Node) data[x-65];//finding the respective index
    Node h= head;
    int idx = countNode(h,t);
  if(idx<0){
    System.out.println("Sorry! The name does not exists!!!");
  }
  else if(idx==0){  //deleting the node
    remove=h.next;
    Node pred=head;
    Node succ=pred.next.next;
    pred.next=succ; 
    System.out.println("Your contact has been deleted.");
    // System.out.println("contact deleted"+"\n"+remove.name+"\t"+remove.address+"\t"+remove.number);
  }
  else{    //deleting node
    Node pred =head.next;
    Node k = head.next.next;
    for(int i =0; i<idx-1; i++){
      pred=pred.next;
      k=k.next;
    }
    pred.next=k.next;
    remove=k;
    k.next=null;
    k=null;
    System.out.println("Your contact has been deleted.");         
// System.out.println("contact deleted"+"\n"+remove.name+"\t"+remove.address+"\t"+remove.number);
  }
  }
 
//This method is use to count the index of the respective node  
  public int countNode(Node h, String name){
    
    String t=name;
    int count = 0;
    for(Node start = h.next; start!=null; start=start.next){
      if(start.name.equals(t)){
        return count;
           }
      count++; //count increases by 1
    }
    
    return -1; // please remove this line!
  }

//This method is used to count the umber of nodes
  public int countNode2(Node h){
  int count = 0;
  for(Node start = h.next; start!=null; start=start.next){
    count++;
  }
  
  return count;
  
}

//This method is used to show the respective contact info  
  public void Showinfo(String name){
    String t = name.toUpperCase();
  
    char [] a =t.toCharArray();
    int x = (int)a[0];
 
    Node head=(Node) data[x-65];
    boolean flag=false;
    for(Node start = head.next; start!=null; start=start.next){
      if(start.name.equals(t)){
        flag=true;
        System.out.println(start.name+"  "+start.number+"  "+start.address);    
      }
    }
    if(flag==false){
      System.out.println("Sorry! The name is not in the contact");
    }
  }
}


