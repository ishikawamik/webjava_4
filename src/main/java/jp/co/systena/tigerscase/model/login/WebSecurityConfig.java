package jp.co.systena.tigerscase.model.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    /**
     * セキュリティ設定を無視するリクエスト設定
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
            "/css/**"
            );
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/login")
                .permitAll()
                .antMatchers("/manage").hasAuthority("ROLE_ADMIN")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .usernameParameter("userid")
                .passwordParameter("password")
                .defaultSuccessUrl("/item")
                .permitAll()
                .and()
            .logout()
                // ログアウトでログインページに戻る
                .logoutSuccessUrl("/login")
                // セッションを破棄する
                .invalidateHttpSession(true)
                .permitAll();

    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //ＤＢによる独自認証を行う
        auth.userDetailsService(userDetailsService);
    }

    // パスワードをエンコード
    @Bean
    public PasswordEncoder passwordEncoder(){
          return NoOpPasswordEncoder.getInstance();
    }

}