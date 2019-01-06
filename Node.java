package phonebook;

//Node class
public class Node {
  String name;
  String number;
  String address;
  Node prev;//To move to the previous node
  Node next;//To move to the next node
  public Node(String n,String num,String add,  Node x){
    name = n;
    number = num;
    address = add;
    //prev=p;
    next = x;
  }
}
