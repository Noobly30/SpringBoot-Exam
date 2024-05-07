import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    //配置用户认证
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //使用内存中用户信息进行身份验证
        auth.inMemoryAuthentication()
            .withUser("test")//设置用户
            .password(passwordEncoder().encode("123456"))//设置密码
            .roles("USER");
    }

    @Override
    //配置HTTP请求安全设置
    protected void configure(HttpSecurity http) throws Exception {
        //禁用跨站请求伪造
        http.csrf().disable()
            .authorizeRequests() //对访问请求进行授权
            .antMatchers("/hello").authenticated() //经过身份验证的用户才能访问
            .anyRequest().permitAll()
            .and()
            .formLogin(); //配置基于表单的登录
    }

    @Bean
    //编码密码
    public PasswordEncoder passwordEncoder() {
        return BCryptPasswordEncoder.getInstance(); //BCryptPasswordEncoder对密码进行哈希处理，增加安全性
    }
}
