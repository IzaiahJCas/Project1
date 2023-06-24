public class Order{
  
  //a constructor that holds the inputs
  public Order(char symbol, int shares, double price, boolean allOrNone, Trader trader){
   this.symbol = symbol;
   this.shares = shares;
   this.price = price;
   this.allOrNone = allOrNone;
   this.trader = trader;
  }
  
  //stores the symbol of the stock 
  private char symbol;
  
  //stores the number os shares
  private int shares;
  
  //stores the price per share of the order
  private double price;
  
  //stores whether or not we must trade all the shares of the order
  private boolean allOrNone;
    
  //stores the name of the trader that is in the order
  private Trader trader;
  
  //returns the character symbol of the stock
  public char getStockSymbol(){
   return symbol; 
  }
  
  //returns the number of shares of the order
  public int getNumberShares(){
   return shares; 
  }
  
  //changes the value of the number of shares in the order
  public void setNumberShares(int shares){
   this.shares = shares; 
  }
  
  //changes the value of the price per share
  public void setPrice(double price){
   this.price = price; 
  }
  
  //returns the price per share of the order
  public double getPrice(){
   return price; 
  }
  
  //sets whether we must trade all the shares of the order or not
  public void setAllOrNone(boolean allOrNone){
   this.allOrNone = allOrNone;
  }
  
  //returns the true or false whether or not we must trade all the shares of the order or not
  public boolean isAllOrNone(){
   return allOrNone; 
  }
  
  //returns the trader that placed the order
  public Trader getTrader(){
    return trader;
  }
  
  
  
  
  
}