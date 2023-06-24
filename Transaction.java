public class Transaction{
 
  //A constructor for transaction variables
  public Transaction(char tranSymbol, int tranShares, double tranPrice, Trader buyer, 
                     Trader seller, Market maker){
     this.tranSymbol = tranSymbol;
     this.tranShares = tranShares;
     this.tranPrice = tranPrice;
     this.buyer = buyer;
     this.seller = seller;
     this.maker = maker;
  }
 //stores the symbol for the stock
  private char tranSymbol;
  
  //stores the number of shares for the trade transaction
  private int tranShares;
  
  //stores the price per share of this trade transaction
  private double tranPrice;
  
  //stores the buyer of the stock
  private Trader buyer;
  
  //stores the trader that is selling the stock
  private Trader seller;
  
  //stores the market that is currently handling the transaction
  private Market maker;
  
  //stores whether or not the transaction is closed
  private boolean closedOrNot;
  
  //this method returns the symbol of the stock for the trade
  public char getStockSymbol(){
   return tranSymbol; 
  }
  
  //this method returns the number of shares in the transaction
  public int getNumberShares(){
   return tranShares; 
  }
  
  //this method returns the price per share in the transaction
  public double getPrice(){
   return tranPrice; 
  }
  
  //this method returns the trader that is buying the stock
  public Trader getBuyer(){
   return buyer; 
  }
  
  //this method returns the trader that is selling the stock
  public Trader getSeller(){
   return seller; 
  }
  
  //this method displays whether or not the transaction is closed or not
  public boolean isClosed(){
   return closedOrNot;
  }
  
  //this method processes all the changes in values that comes with the transaction
  public void processTransaction(){
  if (closedOrNot == true){
    return;
  }
  else{
    getSeller().withdraw(getNumberShares()*getPrice() + (maker.getTradeFee() 
                            + (maker.getCommission()*getNumberShares()))/2);
  
   getBuyer().deposit(getNumberShares()*getPrice() + (maker.getTradeFee() 
                            + (maker.getCommission()*getNumberShares()))/2);

    }
  }
    
}