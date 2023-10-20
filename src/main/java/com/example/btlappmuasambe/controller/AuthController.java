package com.example.btlappmuasambe.controller;

import com.example.btlappmuasambe.model.request.LoginRequest;
import com.example.btlappmuasambe.model.response.LoginResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ServerWebExchange;

@RequestMapping("/adm/api/auth")
public interface AuthController {
    /**
     * Đăng Nhập
     */
    @Operation(
            summary = "Đăng Nhập",
            description = "Đăng Nhập",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Thành công"),
                    @ApiResponse(responseCode = "400", description = "Đầu vào không hợp lệ"),
                    @ApiResponse(responseCode = "500", description = "Lỗi dịch vụ")
            }
    )
    @PostMapping(path = "/login")
    LoginResponse postLogin(
            @RequestBody LoginRequest request
    );
}
