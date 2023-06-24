public class MarketBuyOrder extends BuyOrder{
  
 //a constructor that holds the values of the market buy order  
   public MarketBuyOrder(char symbol, int shares, double price, boolean allOrNone, Market trader){
    super(symbol, shares, price, false, trader);
  }
  
  //a method that makes sure that isAllOrNone is always false
   public boolean isAllOrNone(){
    return false; 
   }
}
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
