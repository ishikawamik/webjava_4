package jp.co.systena.tigerscase.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import jp.co.systena.tigerscase.model.manage.Account;
import jp.co.systena.tigerscase.model.service.ManageService;

@Controller // Viewあり。Viewを返却するアノテーション
public class ManageController {

  @Autowired
  private ManageService manageService;

  //画面に一覧表示
  @RequestMapping(value = "/manage", method = RequestMethod.GET) // URLとのマッピング
  public String index(Model model) {
    model.addAttribute("users", manageService.getAccount());

    return "/manage";
  }

  //削除リンク押下
  @RequestMapping(value = "/delete", method = RequestMethod.GET) // URLとのマッピング
  public String update(@RequestParam(name = "userid", required = true)
      String userid, Model model) {
    model = manageService.delete(userid, model);
    model.addAttribute("userid", userid);

    return "redirect:/manage";
  }

  //登録ボタン押下
  @RequestMapping(value = "/add", method = RequestMethod.POST) // URLとのマッピング
  public String insert(@Valid Account form,
                        BindingResult result, Model model) {
    model = manageService.insert(form, result, model);

    return "redirect:/manage";
  }
}