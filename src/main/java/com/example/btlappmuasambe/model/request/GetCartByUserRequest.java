package com.example.btlappmuasambe.model.request;

import com.example.btlappmuasambe.model.Users;
import lombok.Data;

@Data
public class GetCartByUserRequest {
    private Users user;
}
