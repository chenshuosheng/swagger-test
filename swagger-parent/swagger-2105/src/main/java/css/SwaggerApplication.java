package css;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @Description: TODO
 * @Author: CSS
 * @Date: 2024/12/14 23:15
 */

//@ComponentScan(basePackages = {"css.xxx"})
//用于自动发现和注册Spring组件（如@Component、@Service、@Repository、@Controller等标注的类）为Spring容器中的bean。
//区别：这是最通用的扫描注解，适用于大多数Spring组件。它能够自动检测应用程序上下文中的组件，并将它们注册为Spring管理的beans。
//使用方式：可以配置在配置类上，用来定义哪些包需要被扫描以查找组件（@SpringBootApplication包含@ComponentScan，默认会扫描启动类所在包及其所有子包下的组件）

//@ServletComponentScan
//作用：用于自动发现并注册Servlet、Filter和Listener组件（即使用了@WebServlet、@WebFilter、@WebListener注解的类）到Servlet容器中

//@MapperScan
//作用：用于MyBatis框架中，自动扫描接口形式的Mapper（映射器），并将这些接口与XML映射文件关联起来，或者直接通过注解方式创建映射关系

@SpringBootApplication
public class SwaggerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SwaggerApplication.class, args);
        ConfigurableEnvironment environment = run.getEnvironment();
        String serverPort = environment.getProperty("server.port");

        System.out.println(
                "Swagger 文档：http://localhost:"+serverPort+"/swagger-ui.html\n" +
                        "Swagger 文档 API：http://localhost:"+serverPort+"/v2/api-docs"
        );
    }
}
