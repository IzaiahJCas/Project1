public class BuyOrder extends Order{
 
  //a constructor that holds the inputs of the buy order
  public BuyOrder(char symbol, int shares, double price, boolean allOrNone, Trader trader){
    super(symbol, shares, price, allOrNone, trader);
  
 }
  
}