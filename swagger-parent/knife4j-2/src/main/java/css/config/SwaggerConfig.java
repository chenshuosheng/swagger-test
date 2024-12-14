package css.config;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Configuration // 标明是配置类
@EnableSwagger2WebMvc //开启swagger功能
public class SwaggerConfig {

    @Value("${mconfig.swagger-ui-open}")
    private Boolean enable;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(enable)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(security()) // 添加安全模式
                .securityContexts(Arrays.asList(securityContext())); // 应用安全上下文
    }

    // 配置文档信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("文件下载")
                .description("文件下载")
                .version("1.0")
                .build();
    }

    // 配置API安全密钥
    private List<ApiKey> security() {
        ArrayList<ApiKey> apiKeys = new ArrayList<>();
        apiKeys.add(new ApiKey("Authorization", "Authorization", "header"));
        apiKeys.add(new ApiKey("Abp.TenantId", "Abp.TenantId", "header"));
        return apiKeys;
    }

    // 配置安全上下文
    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.any())
                .build();
    }

    // 默认认证引用
    private List<springfox.documentation.service.SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(
                new springfox.documentation.service.SecurityReference("Authorization", authorizationScopes),
                new springfox.documentation.service.SecurityReference("Abp.TenantId", authorizationScopes)
        );
    }
}

