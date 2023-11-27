package com.example.btlappmuasambe;

import com.example.btlappmuasambe.consts.RoleType;
import com.example.btlappmuasambe.model.Category;
import com.example.btlappmuasambe.model.UserGroup;
import com.example.btlappmuasambe.model.Users;
import com.example.btlappmuasambe.repository.CategoryRepository;
import com.example.btlappmuasambe.repository.UserGroupRepository;
import com.example.btlappmuasambe.repository.UserRepository;
import com.example.btlappmuasambe.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BtlAppMuaSamBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BtlAppMuaSamBeApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserGroupRepository userGroupRepository,
                          UserRepository userRepository,
                          CategoryRepository categoryRepository,
                          ProductService productService) {
        return args -> {
            UserGroup userGroupNV = userGroupRepository.save(new UserGroup(RoleType.NHAN_VIEN.getValue()));
            UserGroup userGroupAdmin = userGroupRepository.save(new UserGroup(RoleType.Admin.getValue()));
            UserGroup userGroupKH = userGroupRepository.save(new UserGroup(RoleType.KHACH_HANG.getValue()));

            //Thêm User
            Users users = new Users();
            users.setUserGroup(userGroupKH);
            users.setFullName("Đặng Thành Công");
            users.setPhoneNumber("0914133719");
            users.setEmail("dangcong@gmail.com");
            users.setPassword("1");
            userRepository.save(users);

            //Thêm loại sản phẩm
            Category category1 = categoryRepository.save(new Category("Thời trang"));
            Category category2 = categoryRepository.save(new Category("Thiết bị điện tử"));
            Category category3 = categoryRepository.save(new Category("Máy Tính và Laptop"));
            Category category4 = categoryRepository.save(new Category("Điện thoại và Phụ Kiện"));
            Category category5 = categoryRepository.save(new Category("Sức khỏe"));

            //Thêm sản phẩm
            themSanPham(productService);

            //Test service
//            FindProductByCriteriaRequest findProductByCriteriaRequest = new FindProductByCriteriaRequest();
//            findProductByCriteriaRequest.setNameProductOrCategory("áo");
//            findProductByCriteriaRequest.setCategory(new ArrayList<>(Arrays.asList("Sức khỏe","Thiết bị điện tử")));
//            findProductByCriteriaRequest.setSortBy(SortType.NEW.getValue());
//            productService.findProductByCriteria(findProductByCriteriaRequest);
        };
    }

    private void themSanPham(ProductService productService) {
        //Thêm sản phẩm
        productService.addProductTest(
                "áo khoác nữ sinh Harajuku JK 100% ảnh thật",
                "https://i.imgur.com/SH9AozR.jpg",
                4.5,
                true,
                100000,
                50,
                10000000,
                22200,
                "22/10/2023",
                "Thời trang");

        productService.addProductTest(
                "áo thun siêu hot",
                "https://i.imgur.com/kJI23qi.jpg",
                4,
                true,
                150000,
                55,
                1000000000,
                3333000,
                "20/10/2023",
                "Thời trang");

        productService.addProductTest(
                "áo thun nam siêu hot",
                "https://i.imgur.com/Bys2h2s.jpg",
                4,
                true,
                150000,
                50,
                1000,
                200,
                "20/10/2023",
                "Thời trang");

        productService.addProductTest(
                "áo thun dài tay nữ cá tính",
                "https://i.imgur.com/XKiLgrr.jpg",
                5,
                true,
                90000,
                30,
                1000,
                15,
                "25/10/2023",
                "Thời trang");

        productService.addProductTest(
                "ốp lưng điện thoại iphone dễ thương",
                "https://i.imgur.com/jisHoPt.png",
                5,
                true,
                50000,
                35,
                1000,
                150,
                "30/10/2023",
                "Điện thoại và Phụ Kiện");

        productService.addProductTest(
                "điện thoại iphone 11 chính hãng giá rẻ",
                "https://i.imgur.com/FU9aHWK.jpg",
                1.5,
                false,
                15000000,
                35,
                1000,
                150,
                "1/10/2023",
                "Điện thoại và Phụ Kiện");

        productService.addProductTest(
                "tai nghe hình tai mèo màu xanh cute",
                "https://i.imgur.com/S0zMK33.jpg",
                4.5,
                true,
                300000,
                10,
                1000,
                300,
                "10/10/2023",
                "Điện thoại và Phụ Kiện");

        productService.addProductTest(
                "đèn livestream sịn sò",
                "https://i.imgur.com/D4aJAqR.jpg",
                4.5,
                true,
                366000,
                13,
                1000,
                124,
                "10/9/2023",
                "Điện thoại và Phụ Kiện");

        productService.addProductTest(
                "robot hút bụi thông minh",
                "https://i.imgur.com/bMKor2H.jpg",
                0.5,
                false,
                150000,
                3,
                1000,
                60,
                "9/9/2023",
                "Thiết bị điện tử");

        productService.addProductTest(
                "tủ lạnh 2 ngăn dung tích lớn cho đại gia đình",
                "https://i.imgur.com/BuPTCnQ.jpg",
                5,
                true,
                20000000,
                60,
                1000,
                360,
                "9/1/2023",
                "Thiết bị điện tử");

        productService.addProductTest(
                "tủ lạnh 3 ngăn dung tích lớn cho đại gia đình",
                "https://i.imgur.com/BuPTCnQ.jpg",
                5,
                true,
                20000000,
                35,
                1000,
                360,
                "9/1/2023",
                "Thiết bị điện tử");

        productService.addProductTest(
                "máy giặt cửa ngang siêu tiết kiệm nước",
                "https://i.imgur.com/DsMUwrc.jpg",
                3,
                false,
                8200000,
                63,
                1000,
                266,
                "25/1/2023",
                "Thiết bị điện tử");

        productService.addProductTest(
                "máy lọc nước khangkaru hàng chính hãng",
                "https://i.imgur.com/QrycWGx.jpg",
                3.6,
                true,
                5200000,
                53,
                1000,
                133,
                "20/2/2023",
                "Thiết bị điện tử");

        productService.addProductTest(
                "máy tính HP bảo hành trọn đời",
                "https://i.imgur.com/MSfcvUq.jpg",
                4.6,
                true,
                9200000,
                13,
                1000,
                333,
                "23/2/2023",
                "Máy Tính và Laptop");

        productService.addProductTest(
                "macbook hạt rẻ ngon",
                "https://i.imgur.com/YWFohYq.jpg",
                2.6,
                false,
                9230000,
                15,
                1000,
                233,
                "23/3/2023",
                "Máy Tính và Laptop");

        productService.addProductTest(
                "dàn PC siêu chất lương cho game thủ",
                "https://i.imgur.com/ldXj8CM.png",
                4.6,
                true,
                52230000,
                45,
                1000,
                500,
                "23/4/2023",
                "Máy Tính và Laptop");

        productService.addProductTest(
                "máy tính DELL gọn nhẹ",
                "https://i.imgur.com/ch6LU8h.jpg",
                4.6,
                true,
                32000000,
                25,
                1000,
                550,
                "23/3/2023",
                "Máy Tính và Laptop");

        productService.addProductTest(
                "máy đo chỉ số spo2 chính xác",
                "https://i.imgur.com/PzxWaZS.jpg",
                4.6,
                false,
                300000,
                0,
                1000,
                10,
                "23/10/2023",
                "Sức khỏe");

        productService.addProductTest(
                "máy đo nhiệt độ chất lượng cao",
                "https://i.imgur.com/Koztkhp.jpg",
                1.6,
                false,
                330000,
                33,
                1000,
                100,
                "15/6/2023",
                "Sức khỏe");

        productService.addProductTest(
                "nước xát khuẩn tay, loại bỏ 99,99% vi khuẩn",
                "https://i.imgur.com/KHSaNOp.jpg",
                1.6,
                false,
                330000,
                99,
                1000,
                800,
                "15/5/2023",
                "Sức khỏe");

        productService.addProductTest(
                "khẩu trang 4 lớp chắc chắn, bảo vệ bản và mọi người",
                "https://i.imgur.com/c7sfKX5.jpg",
                4,
                false,
                100000,
                88,
                1000,
                860,
                "15/5/2023",
                "Sức khỏe");
    }
}
