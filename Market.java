public class Market extends Trader{
    
  //a constructor for the market class so the variables can be used in the other clases
    public Market(String name, char marketSymbol, double tradeFee, double commission, int size, 
                  double offset){
        super(name);
        this.marketSymbol = marketSymbol;
        this.tradeFee = tradeFee;
        this.commission = commission;
        this.size = size;
        this.offset = offset;
    }
 
  
  //stores the symbol of the stock for the market
  private char marketSymbol;
  
  //stores the value of the commission rate
  private double commission;
  
  //stores the value of the trade fee for the orders made in the market
  private double tradeFee;
  
  //stores the of shares that have been auto-generated by the market maker
  private int size;
  
  //stores the price offset of the order set by the market maker
  private double offset;
  
  //stores the best buy order
  private BuyOrder bestBuy;
  
  //stores the best sell order
  private SellOrder bestSell;
  
  //stores the second best buy order
  private BuyOrder secBestBuy;
  
  //stores the second best sell order
  private SellOrder secBestSell;
  
  //stores the market's maker's buy order
  private MarketBuyOrder marketBuy;
  
  //stores the market's maker's sell order
  private MarketSellOrder marketSell;
  
  //returns the stock symbol that this market is for
  public char getStockSymbol(){
   return marketSymbol; 
  }
  
  //returns the values of the commission rate
  public double getCommission(){
   return commission; 
  }
  
  //changes the commission rate value
  public void setCommission(double commission){
   this.commission = commission; 
  }
  
  //returns the value of the trade fee for the market
  public double getTradeFee(){
   return tradeFee; 
  }
  
  //changes the value of the market's trade fee
  public void setTradeFee(double tradeFee){
   this.tradeFee = tradeFee; 
  }
  
  //this method returns the number of shares auto-generated by the market 
  public int getMarketOrderSize(){
   return size; 
  }
  
  //this method changes the size of the market order size
  public void setMarketOrderSize(int size){
   this.size = size; 
  }
  //tihs method returns the order price offset
  public double getPriceOffset(){
   return offset; 
  }
  
  //this method changes the value of the order price offset
  public void setPriceOffset(double offset){
   this.offset = offset; 
  }
  
  //this method returns the market's best buy order
  public BuyOrder getBestBuyOrder(){
   return bestBuy; 
  }
  
  //this method returns the second best buy order in the market
  public BuyOrder get2ndBestBuyOrder(){
    return secBestBuy;
  }
  
  //this method returns the best sell order in the market
  public SellOrder getBestSellOrder(){
   return bestSell; 
  }
  
  //this method returns the second best sell order in the market
  public SellOrder get2ndBestSellOrder(){
   return secBestSell; 
  }
  
  //this method changes the market buy order to the input order
  public void setMarketBuyOrder(MarketBuyOrder marketBuy){
   this.marketBuy = marketBuy; 
  }
  
  //this method reutrns the market buy order
  public MarketBuyOrder getMarketBuyOrder(){
   return marketBuy; 
  }
  
  //this method returns the value of the current market sell order
  public MarketSellOrder getMarketSellOrder(){
   return marketSell; 
  }
  
  //this method changes the market sell order to the inputed order
  public void setMarketSellOrder(MarketSellOrder marketSell){
   this.marketSell = marketSell; 
  }
  
//this method returns the price of the market's current best buy order
  public double currentMarketSellPrice(){
   if (getBestSellOrder() != null)
     return getMarketSellOrder().getPrice();
   else 
     return getBestSellOrder().getPrice();
  }
  
  //this method returns the price of the market's current best buy order
  public double currentMarketBuyPrice(){
   if (getBestBuyOrder() != null)
     return getMarketBuyOrder().getPrice();
   else 
     return getBestBuyOrder().getPrice();
  }
  
  
  /*this method determines whether or not there is both a market maker buy order
   * and a market sell order exist
   * and the price of the market maker buy order is less than the price of the market maker sell order*/
  public boolean isOpen(){
    return((getMarketBuyOrder() != null && getMarketSellOrder() != null) 
      && (getMarketBuyOrder().getPrice() < getMarketSellOrder().getPrice())); 
  }    

  /*This method determines whether or not the order's stock symbol matches the market's
   * the price of the order is greater than or equal to the market's buy order
   * and the price of the order is less than or equal to the market's sell order*/
  public boolean isValidOrder (Order tradeOrder){
   if((tradeOrder.getStockSymbol() == this.getStockSymbol()) &&  (tradeOrder.getPrice() >= this.getMarketBuyOrder().getPrice()) 
     &&  (tradeOrder.getPrice() <= this.getMarketSellOrder().getPrice())){
     return true;
   }
     else 
     return false;
    }
  
  /* This method checks if the buy order's price is greater than or equal to the sell order's price
   * if either order is all or none
   * if so, the other oder has to have a number of shares equal to or larger than the all or none order's*/
  public boolean matchingOrders(BuyOrder buyOrder, SellOrder sellOrder){
    if((buyOrder.getPrice() >= sellOrder.getPrice()) && (buyOrder.isAllOrNone() == true || sellOrder.isAllOrNone() == true ) 
         || (sellOrder.isAllOrNone() && buyOrder.getNumberShares() >= sellOrder.getNumberShares()) 
         || (buyOrder.isAllOrNone() &&sellOrder.getNumberShares() >= buyOrder.getNumberShares())){
   return true;
    }
  return false;
  }
 /*This method is being used to add an order to the market
  * the order that is added will either be placed into the best sell order or second best sell order*/
  public void addOrderToMarket(SellOrder orderAdd){
    if (orderAdd.getStockSymbol() != this.getStockSymbol())
     return;
      if(bestSell == null)
         bestSell = orderAdd;                    
      else if(orderAdd.getPrice() <= bestSell.getPrice()){
        secBestSell = bestSell;
        bestSell = orderAdd;   
      }
      else if((orderAdd.getPrice() >= bestSell.getPrice()) || (secBestSell == null)){
      orderAdd = secBestSell;
      }
      else if(orderAdd.getPrice() < secBestSell.getPrice()){
       orderAdd = secBestSell; 
      }
      else
        return;
  }
         
  /*This method is being used to add an order to the market
  * the order that is added will either be placed into the best buy order or second best buy order*/
    public void addOrderToMarket(BuyOrder orderAdd){
    if (orderAdd.getStockSymbol() != this.getStockSymbol())
     return;
      if(bestBuy == null)
         bestBuy = orderAdd;                    
      else if(orderAdd.getPrice() <= bestSell.getPrice()){
        secBestBuy = bestBuy;
        bestBuy = orderAdd;   
      }
      else if((orderAdd.getPrice() >= bestBuy.getPrice()) || (secBestBuy == null)){
      orderAdd = secBestBuy;
      }
      else if(orderAdd.getPrice() < secBestBuy.getPrice()){
       orderAdd = secBestBuy; 
      }
      else
        return;
  }
  
    /* this method acts to put in buy orders into the market*/
    public Transaction placeOrder(BuyOrder buyOrder){
      if(this.isOpen() != true || this.isValidOrder(buyOrder) != true){
        return null;
      }
      if(matchingOrders(buyOrder , getBestSellOrder()) == true){
        Transaction transaction = new Transaction(getStockSymbol(), 
        Math.min(buyOrder.getNumberShares(), getBestSellOrder().getNumberShares()),
        getBestSellOrder().getPrice(), buyOrder.getTrader(), getBestSellOrder().getTrader(), this); 
          bestSell = secBestSell;
          secBestSell = null;   
        return transaction;
      }
      
     if(matchingOrders(buyOrder, secBestSell) == true){
         Transaction transaction = new Transaction(getStockSymbol(), 
        Math.min(buyOrder.getNumberShares(), get2ndBestSellOrder().getNumberShares()),
        get2ndBestSellOrder().getPrice(), buyOrder.getTrader(), get2ndBestSellOrder().getTrader(), this); 
          secBestSell = null;
        return transaction;
      }
      
      if(matchingOrders(buyOrder, marketSell) == true){
        Transaction transaction = new Transaction(getStockSymbol(), 
        Math.min(buyOrder.getNumberShares(), getMarketSellOrder().getNumberShares()),
        getMarketSellOrder().getPrice(), buyOrder.getTrader(), getMarketSellOrder().getTrader(), this); 
        marketSell.setNumberShares(this.getMarketOrderSize());
        marketSell.setPrice(marketSell.getPrice() + this.getPriceOffset());
        return transaction;
      }
      else{   
      addOrderToMarket(buyOrder);
      return null;
    }
  }     
    //this method serves to place sell orders into the market
      public Transaction placeOrder(SellOrder sellOrder){
        if(this.isOpen() != true || this.isValidOrder(sellOrder) != true){
        return null;
      }
    
      if(matchingOrders(bestBuy , sellOrder) == true){
         Transaction transaction = new Transaction(getStockSymbol(), 
        Math.min(sellOrder.getNumberShares(), getBestBuyOrder().getNumberShares()),
        getBestBuyOrder().getPrice(), sellOrder.getTrader(), getBestBuyOrder().getTrader(), this); 
          bestBuy = secBestBuy;
          secBestBuy = null;   
        return transaction;
      }
      
      
      if(matchingOrders(secBestBuy , sellOrder) == true){
        Transaction transaction = new Transaction(getStockSymbol(), 
        Math.min(sellOrder.getNumberShares(), get2ndBestBuyOrder().getNumberShares()),
        get2ndBestBuyOrder().getPrice(), sellOrder.getTrader(), get2ndBestBuyOrder().getTrader(), this); 
          secBestBuy = null;
        return transaction;
      }
      
      if(matchingOrders(marketBuy , sellOrder) == true){
         Transaction transaction = new Transaction(getStockSymbol(), 
        Math.min(sellOrder.getNumberShares(), getMarketBuyOrder().getNumberShares()),
        getMarketBuyOrder().getPrice(), sellOrder.getTrader(), getMarketBuyOrder().getTrader(), this); 
        marketBuy.setNumberShares(this.getMarketOrderSize());
       marketBuy.setPrice(marketSell.getPrice() + this.getPriceOffset());
        secBestBuy = null;
        return transaction;
      }
      else{
         addOrderToMarket(sellOrder);
      return null;
      }
    }
    
    
  }


     
  

