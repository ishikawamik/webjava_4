package jp.co.systena.tigerscase.controller;


import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import jp.co.systena.tigerscase.model.form.ItemForm;
import jp.co.systena.tigerscase.model.item.Cart;
import jp.co.systena.tigerscase.model.item.Order;

@Controller
public class CartController {

//セッション
 @Autowired
 HttpSession session;

  @RequestMapping(value = "/cart", method = RequestMethod.GET)
  public String show(Model model) {

    //カート情報を取得
    if(session.getAttribute("cart") != null) {
    Cart cart = (Cart) session.getAttribute("cart");

    //合計金額を設定
    int totalPrice = cart.getTotalPrice();
    model.addAttribute("totalPrice", totalPrice);

    //合計購入回数を設定
    int totalOrder = cart.getNum();
    model.addAttribute("totalOrder", totalOrder);

    //購入履歴を設定
    List<Order> orderList = cart.getorderList();
    model.addAttribute("orderList", orderList);

    } else {
      //カートが空の場合
      model.addAttribute("totalPrice", 0);
      model.addAttribute("totalOrder", 0);
    }

    model.addAttribute("itemForm", new ItemForm());
    return "/cart";
  }

  @RequestMapping(value = "/cart", method = RequestMethod.POST)
  private String remove(@Valid ItemForm itemForm) {

    Cart cart = (Cart) session.getAttribute("cart");
    //履歴を削除
    session.removeAttribute("cart");
    cart.clear();

    return "redirect:/cart";
  }
}