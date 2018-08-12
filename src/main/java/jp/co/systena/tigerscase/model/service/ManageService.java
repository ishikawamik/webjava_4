package jp.co.systena.tigerscase.model.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import jp.co.systena.tigerscase.model.manage.Account;

@Service
public class ManageService {

  @Autowired
  JdbcTemplate jdbcTemplate;

  // データベースからアイテムデータ一覧を取得する
  public List<Account> getAccount() {

    //SELECTを使用してテーブルの情報をすべて取得する
    List<Account> accounts = jdbcTemplate.query("SELECT * FROM users ORDER BY userid", new BeanPropertyRowMapper<Account>(Account.class));

    return accounts;
  }

   //「削除」リンク押下時の処理
   // パラメータで受け取ったアイテムIDのデータを削除する
  public Model delete(String userid, Model model) {

    // パラメータで受けとったuseridのデータを削除する
    int deleteCount = jdbcTemplate.update("DELETE FROM users WHERE userid = ?",
        userid);
    return model;
  }

  //「登録」リンク押下時の処理
  // パラメータで受け取ったuseridのデータを登録する

  public Model insert(Account form,
                        BindingResult result,
                        Model model) {

    //画面入力値にエラーがない場合
    if (!result.hasErrors()) {

          //1行分の値をデータベースにINSERTする
          int insertCount = jdbcTemplate.update(
                "INSERT INTO users VALUES( ?, ?, ?, ? )",
                form.getUserid(),
                form.getUsername(),
                form.getPassword(),
                form.getAuthority()
              );
    }
    return model;
  }

}