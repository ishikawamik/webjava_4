package jp.co.systena.tigerscase.model.service;

import java.util.ArrayList;
import java.util.List;
import jp.co.systena.tigerscase.model.item.Item;

public class ItemService {

  // 商品リスト
  private List<Item>itemList;

  public ItemService() {

    itemList = new ArrayList<>();
    // 商品1
    Item item1 = new Item("トマト", 100);
    itemList.add(item1);

    // 商品2
    Item item2 = new Item("ぶどう", 500);
    itemList.add(item2);

    // 商品3
    Item item3 = new Item("さくらんぼ", 800);
    itemList.add(item3);

    // 商品4
    Item item4 = new Item("ナス", 200);
    itemList.add(item4);

    // 商品5
    Item item5 = new Item("とうもろこし", 100);
    itemList.add(item5);

    // 商品6
    Item item6 = new Item("枝豆", 300);
    itemList.add(item6);

  }

  // 商品リストを取得
  public List<Item> getItemList() {
    return itemList;
  }

  // 商品リストを設定
  public void setItemList(List<Item> itemList) {
    this.itemList = itemList;
  }

  // 指定の商品リストを取得
  public Item getItem(int index) {
    return itemList.get(index);
  }

}
