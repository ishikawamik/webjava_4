package jp.co.systena.tigerscase.model.item;

public class Order {
  private Item item;    // 商品情報
  private int num;      // 購入数

  public Order(Item item, int num) {
    setItem(item);
    setNum(num);
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }

  public int getNum() {
    return num;
  }
  public void setNum(int num) {
    this.num = num;
  }

}