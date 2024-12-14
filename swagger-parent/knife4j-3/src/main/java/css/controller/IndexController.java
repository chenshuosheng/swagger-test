package css.controller;

import css.pojo.LoginDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@Tag(name = "首页接口")
public class IndexController {


    @Operation(summary = "用户登录")
    public String login(@RequestBody LoginDto loginDto) {
        return "login";
    }

    @Operation(summary = "用户退出")
    @Parameters(value = {
            @Parameter(name = "令牌参数" , required = true)
    })
    @GetMapping(value = "/logout")
    public String logout(@RequestHeader(value = "token") String token) {
        return "logout";
    }

}
