package com.example.btlappmuasambe.controller;

import com.example.btlappmuasambe.model.Product;
import com.example.btlappmuasambe.model.response.GetCategoryResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/adm/api")
public interface CategoryController {
    @GetMapping("/category")
    @Operation(
            summary = "Lấy danh sách danh mục sản phẩm",
//            description = "Lấy token",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Thành công"),
                    @ApiResponse(responseCode = "400", description = "Đầu vào không hợp lệ"),
                    @ApiResponse(responseCode = "500", description = "Lỗi dịch vụ")
            }
    )
    GetCategoryResponse getCategory();
}
