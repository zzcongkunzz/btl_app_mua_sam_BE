package com.example.btlappmuasambe.controller;

import com.example.btlappmuasambe.model.Product;
import com.example.btlappmuasambe.model.request.FindProductByCriteriaRequest;
import com.example.btlappmuasambe.model.response.FindProductByCriteriaResponse;
import com.example.btlappmuasambe.model.response.GetProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/adm/api")
public interface ProductController {

    @GetMapping("/product")
    @Operation(
            summary = "Lấy danh sách sản phẩm",
//            description = "Lấy token",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Thành công"),
                    @ApiResponse(responseCode = "400", description = "Đầu vào không hợp lệ"),
                    @ApiResponse(responseCode = "500", description = "Lỗi dịch vụ")
            }
    )
    GetProductResponse getProduct();

    @GetMapping("/product/{id}")
    @Operation(
            summary = "Tìm kiếm sản phẩn theo id",
//            description = "Lấy token",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Thành công"),
                    @ApiResponse(responseCode = "400", description = "Đầu vào không hợp lệ"),
                    @ApiResponse(responseCode = "500", description = "Lỗi dịch vụ")
            }
    )
    Product findProductById(
            @PathVariable(value = "id", required = false) Long id
    );

    @PostMapping("/product/findByCriteria")
    @Operation(
            summary = "Tìm kiếm và sắp xếp sản phẩm theo điều kiện",
//            description = "Lấy token",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Thành công"),
                    @ApiResponse(responseCode = "400", description = "Đầu vào không hợp lệ"),
                    @ApiResponse(responseCode = "500", description = "Lỗi dịch vụ")
            }
    )
    FindProductByCriteriaResponse findProductByCriteria(
            @RequestBody FindProductByCriteriaRequest request
    );
}
