package jp.co.systena.tigerscase.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import jp.co.systena.tigerscase.model.login.UserEntity;
import jp.co.systena.tigerscase.model.login.UserRepository;
@Service
public class LoginService implements UserDetailsService {

  @Autowired
  private UserRepository userRepo;
  @Override
  public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
    if (userid == null || userid.isEmpty()) {
      throw new UsernameNotFoundException("");
    }
    UserEntity userInfo = userRepo.findByUsername(userid);
    if (userInfo == null) {
      throw new UsernameNotFoundException("");
    }
    return userInfo;
  }
}