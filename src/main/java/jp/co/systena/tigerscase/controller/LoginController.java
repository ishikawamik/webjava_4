package jp.co.systena.tigerscase.controller;

import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import jp.co.systena.tigerscase.model.login.UserEntity;

@Controller
public class LoginController {
    // 最初に商品一覧画面に遷移
    @RequestMapping("/")
    public String index() {
        return "redirect:/item";
    }

    // ログイン画面に遷移
    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    // 商品一覧画面に遷移
    @RequestMapping("/item")
    public String top(Model model,
        @AuthenticationPrincipal UserEntity userEntity) {
        return "/item";
    }

}