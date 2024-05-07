import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    //将方法映射到请求的"/hello"路径
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}