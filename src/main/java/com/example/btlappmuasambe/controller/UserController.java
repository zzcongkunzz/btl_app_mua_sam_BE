package com.example.btlappmuasambe.controller;

import com.example.btlappmuasambe.model.Users;
import com.example.btlappmuasambe.model.request.FindProductByCriteriaRequest;
import com.example.btlappmuasambe.model.request.RegisterRequest;
import com.example.btlappmuasambe.model.request.UpdateUserInformationRequest;
import com.example.btlappmuasambe.model.response.FindProductByCriteriaResponse;
import com.example.btlappmuasambe.model.response.RegisterResponse;
import com.example.btlappmuasambe.model.response.UpdateUserInformationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/adm/api")
public interface UserController {

    @Operation(
            summary = "Đăng kí tài khoản",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Thành công"),
                    @ApiResponse(responseCode = "400", description = "Đầu vào không hợp lệ"),
                    @ApiResponse(responseCode = "500", description = "Lỗi dịch vụ")
            }
    )
    @PostMapping("/user")
    RegisterResponse register(
            @RequestBody RegisterRequest request
    );

    @Operation(
            summary = "Đăng kí tài khoản",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Thành công"),
                    @ApiResponse(responseCode = "400", description = "Đầu vào không hợp lệ"),
                    @ApiResponse(responseCode = "500", description = "Lỗi dịch vụ")
            }
    )
    @PutMapping("/user")
    UpdateUserInformationResponse updateUserInformation(
            @RequestBody UpdateUserInformationRequest request
    );
}
