import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    //将方法映射到请求的"/login"路径
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        //检查请求中用户名和密码是否相匹配
        if ("test".equals(loginRequest.getUsername()) && "123456".equals(loginRequest.getPassword())) {
            return "Login successful"; //返回登录成功
        } else {
            return "Invalid credentials"; //返回登录失败
        }
    }

    static class LoginRequest {
        //存储登录名
        private String username;
        //存储密码
        private String password;
    }
}
