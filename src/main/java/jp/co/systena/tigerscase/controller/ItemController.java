package jp.co.systena.tigerscase.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import jp.co.systena.tigerscase.model.form.ItemForm;
import jp.co.systena.tigerscase.model.item.Cart;
import jp.co.systena.tigerscase.model.item.Item;
import jp.co.systena.tigerscase.model.item.Order;
import jp.co.systena.tigerscase.model.service.ItemService;

@Controller
public class ItemController {

  private ItemService itemList = new ItemService();
  private int num;
  private Item item;
  private Cart cart;

  // セッション
  @Autowired
  HttpSession session;

  @RequestMapping(value = "/item", method = RequestMethod.GET)
    public String show(Model model) {

    // 商品一覧を設定
    model.addAttribute("itemList", itemList.getItemList());

    // 購入数を取得、設定
    if(session.getAttribute("num") != null) {
        num = (int) session.getAttribute("num");
        model.addAttribute("num", num);
        session.removeAttribute("num");
    } else {
      model.addAttribute("num", num);
    }

    // 商品名を取得、設定
    if(session.getAttribute("item") != null) {
      item = (Item) session.getAttribute("item");
      model.addAttribute("itemName", item.getItemName());
      session.removeAttribute("item");
    }

    session.setAttribute("itemForm", new ItemForm());

    return "/item";
  }

  @RequestMapping(value = "/item", method = RequestMethod.POST)
  private String order(@Valid ItemForm itemForm) {

    // 選択された購入情報を設定
    if(itemForm.getNum1() != 0) {
      num = itemForm.getNum1();
      session.setAttribute("num", num);

      item = itemList.getItem(0);
      session.setAttribute("item", item);

    } else if(itemForm.getNum2() != 0) {
      num = itemForm.getNum2();
      session.setAttribute("num", num);

      item = itemList.getItem(1);
      session.setAttribute("item", item);

    } else if(itemForm.getNum3() != 0) {
      num = itemForm.getNum3();
      session.setAttribute("num", num);

      item = itemList.getItem(2);
      session.setAttribute("item", item);

    } else if(itemForm.getNum4() != 0) {
      num = itemForm.getNum4();
      session.setAttribute("num", num);

      item = itemList.getItem(3);
      session.setAttribute("item", item);

    } else if(itemForm.getNum5() != 0) {
      num = itemForm.getNum5();
      session.setAttribute("num", num);

      item = itemList.getItem(4);
      session.setAttribute("item", item);

    } else if(itemForm.getNum6() != 0) {
      num = itemForm.getNum6();
      session.setAttribute("num", num);

      item = itemList.getItem(5);
      session.setAttribute("item", item);

    } else {
      num = 0;
      session.setAttribute("num", num);

      item = null;
      session.setAttribute("item", item);
    }

    // 購入情報をセッションに保存
    Order order = new Order(item, num);
    if (session.getAttribute("cart") != null) {
      cart = (Cart) session.getAttribute("cart");
      cart.addOrder(order);
      session.setAttribute("cart", cart);
    } else {
      cart = new Cart();
      cart.addOrder(order);
      session.setAttribute("cart", cart);
    }

    return "redirect:/item";
  }

}