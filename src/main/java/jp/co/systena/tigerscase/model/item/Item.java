package jp.co.systena.tigerscase.model.item;

public class Item {

  private String itemName;  // 商品名
  private int price;        // 価格

  public Item(String itemName, int price) {
    setItemName(itemName);
    setPrice(price);
  }

  public String getItemName() {
    return itemName;
  }
  public void setItemName(String itemName) {
    this.itemName = itemName;
  }
  public int getPrice() {
    return price;
  }
  public void setPrice(int price) {
    this.price = price;
  }
}