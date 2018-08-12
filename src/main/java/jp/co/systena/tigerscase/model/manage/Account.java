package jp.co.systena.tigerscase.model.manage;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Account {

  @NotNull
  @Size(min = 1)
  private String userid;    // ユーザID
  public String getUserid() {
    return userid;
  }
  public void setUserid(String userid) {
    this.userid = userid;
  }

  @Size(min = 1)
  private String username;  // ユーザ名
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }

  @Size(min = 1)
  private String password;  // パスワード
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }

  @Pattern(regexp = "ROLE_ADMIN|ROLE_USER")
  private String authority; // 権限

  public String getAuthority() {
    return authority;
  }
  public void setAuthority(String authority) {
    this.authority = authority;
  }

}