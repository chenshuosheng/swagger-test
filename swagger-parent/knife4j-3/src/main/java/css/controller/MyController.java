package css.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

    @Operation(security = {
        @SecurityRequirement(name = "Authorization"),
        @SecurityRequirement(name = "Abp.TenantId")
    })
    @GetMapping("/data")
    public ResponseEntity<?> getData() {
        // 方法实现
        return ResponseEntity.ok("Hello, compressed download!");
    }
}
