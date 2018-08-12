package jp.co.systena.tigerscase.model.item;

import java.util.ArrayList;
import java.util.List;

public class Cart {


  // 購入情報
  private List<Order> orderList = new ArrayList<Order>();

  public Cart() {
    orderList = new ArrayList<Order>();
  }

  public List<Order> getorderList(){
    return this.orderList;
  }

  public void setOrderList(List<Order> orderList) {
    this.orderList = orderList;
  }

  //購入回数を計算する
  public int getNum() {
    int orderNum = 0;

    for(Order order : orderList) {
      orderNum += order.getNum();
    }
    return orderNum;
  }

  //合計金額を計算する
  public int getTotalPrice() {
    int totalPrice = 0;

    for(Order order : orderList) {
      totalPrice += ((int)order.getItem().getPrice() * order.getNum());
    }
    return totalPrice;
  }

  //購入情報を追加する
  public void addOrder(Order order) {
    orderList.add(order);
  }

  //カート履歴を削除
  public void clear() {
    orderList.clear();
  }
}