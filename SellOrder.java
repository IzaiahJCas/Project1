public class SellOrder extends Order{
 
  //a constructor that holds the inputs of the sell order
  public SellOrder(char symbol, int shares, double price, boolean allOrNone, Trader trader){
    super(symbol, shares, price, allOrNone, trader);
  
 }
  
}