package jp.co.systena.tigerscase.model.form;

import java.util.List;
import javax.validation.Valid;
import jp.co.systena.tigerscase.model.manage.Account;

public class ManageForm {

  // アカウント
  @Valid
  private List<Account> accounts;

  public List<Account> getAccount() {
    return accounts;
  }

  public void setAccount(List<Account> accounts) {
    this.accounts = accounts;
  }
}