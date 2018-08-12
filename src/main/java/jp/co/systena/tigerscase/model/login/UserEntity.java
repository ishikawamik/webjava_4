package jp.co.systena.tigerscase.model.login;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

// DBと接続　カラム設定
@Entity
@Table(name = "users")
public class UserEntity implements UserDetails {
  private static final long serialVersionUID = 1L;
  public enum Authority {ROLE_USER, ROLE_ADMIN};

  @Id
  @Column(nullable = false, unique = true)
  private String userid;
  @Column
  private String username;
  @Column(nullable = false)
  private String password;
  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private Authority authority;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority(authority.toString()));
    return authorities;
  }
  @Override
  public boolean isAccountNonExpired() {
      return true;
  }
  @Override
  public boolean isAccountNonLocked() {
      return true;
  }
  @Override
  public boolean isCredentialsNonExpired() {
      return true;
  }
  @Override
  public boolean isEnabled() {
      return true;
  }

  public String getUserid() {
    return this.userid;
  }
  public void setUserid(String userid) {
    this.userid = userid;
  }

  public String getUsername() {
    return this.username;
  }
  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }
  public void setPassword(String password) {
    this.password = password;
  }

}