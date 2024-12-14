package css.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: TODO
 * @Author: CSS
 * @Date: 2024/12/14 23:21
 */

@Api(tags = "swagger 测试接口")
@RestController
public class SwaggerController {

    @ApiOperation(value = "GET", notes = "测试get")
    @GetMapping(value = "/get")
    public String get(String name, String password){
        return name + " " + password;
    }
}
