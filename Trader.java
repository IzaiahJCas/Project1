public class Trader{
  
  //a constructor to hold the trader name
  public Trader(String name){
   this.name = name; 
  }
 
  //stores the name of the trader
  private String name;
  
  //stores the balance of the trader
  private double balance;
  
  //returns the name of the trader
  public String getName(){
   return name; 
  }
  
  //changes the name of the trader
  public void setName(String name){
   this.name = name; 
  }
  
  //returns the value of the traders balance
  public double getBalance(){
    return balance;
  }
  
  //decreases the balance of the trader by the input amount
  public void withdraw(double x){
   this.balance = balance - x;
  }
  
  //increases the balance of the trader by the input amount
  public void deposit(double x){
   this.balance = balance + x; 
  }
  
  
  
  
  
  
  
  
  
}