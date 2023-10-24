package com.example.btlappmuasambe.controller;

import com.example.btlappmuasambe.model.Product;
import com.example.btlappmuasambe.model.request.AddCartRequest;
import com.example.btlappmuasambe.model.request.FindProductByCriteriaRequest;
import com.example.btlappmuasambe.model.request.GetCartByUserRequest;
import com.example.btlappmuasambe.model.request.UpdateCartRequest;
import com.example.btlappmuasambe.model.response.AddCartResponse;
import com.example.btlappmuasambe.model.response.FindProductByCriteriaResponse;
import com.example.btlappmuasambe.model.response.GetCartByUserResponse;
import com.example.btlappmuasambe.model.response.UpdateCartResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/adm/api")
public interface CartController {
    @PostMapping("/cart/getCart")
    @Operation(
            summary = "Lấy danh sách giỏ hàng của user",
//            description = "Lấy token",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Thành công"),
                    @ApiResponse(responseCode = "400", description = "Đầu vào không hợp lệ"),
                    @ApiResponse(responseCode = "500", description = "Lỗi dịch vụ")
            }
    )
    GetCartByUserResponse getCartByUser(
            @RequestBody GetCartByUserRequest request
    );

    @PostMapping("/cart")
    @Operation(
            summary = "Thêm sản phẩm vào giỏ hàng",
//            description = "Lấy token",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Thành công"),
                    @ApiResponse(responseCode = "400", description = "Đầu vào không hợp lệ"),
                    @ApiResponse(responseCode = "500", description = "Lỗi dịch vụ")
            }
    )
    AddCartResponse addCart(
            @RequestBody AddCartRequest request
    );

    @PutMapping("/cart")
    @Operation(
            summary = "Sửa giỏ hàng",
//            description = "Lấy token",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Thành công"),
                    @ApiResponse(responseCode = "400", description = "Đầu vào không hợp lệ"),
                    @ApiResponse(responseCode = "500", description = "Lỗi dịch vụ")
            }
    )
    UpdateCartResponse updateCart(
            @RequestBody UpdateCartRequest request
    );

    @DeleteMapping("/cart/{id}")
    @Operation(
            summary = "Tìm kiếm sản phẩn theo id",
//            description = "Lấy token",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Thành công"),
                    @ApiResponse(responseCode = "400", description = "Đầu vào không hợp lệ"),
                    @ApiResponse(responseCode = "500", description = "Lỗi dịch vụ")
            }
    )
    void deleteCartById(
            @PathVariable(value = "id", required = false) Long id
    );
}
