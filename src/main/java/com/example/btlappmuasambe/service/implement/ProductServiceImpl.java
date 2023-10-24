package com.example.btlappmuasambe.service.implement;

import com.example.btlappmuasambe.consts.SortType;
import com.example.btlappmuasambe.model.Category;
import com.example.btlappmuasambe.model.Product;
import com.example.btlappmuasambe.model.request.FindProductByCriteriaRequest;
import com.example.btlappmuasambe.model.response.FindProductByCriteriaResponse;
import com.example.btlappmuasambe.repository.CategoryRepository;
import com.example.btlappmuasambe.repository.ProductRepository;
import com.example.btlappmuasambe.service.ProductService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import com.example.btlappmuasambe.consts.SortType;

import java.util.ArrayList;
import java.util.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Product addProduct(String name, String linkImage, double rating, boolean favorite, long price, int discount, int inventoryQuantity, String categoryName) {
        Product product = new Product();
        Date currentDate = new Date();
        Timestamp currentTimestamp = new Timestamp(currentDate.getTime());

        product.setName(name);
        product.setLinkImage(linkImage);
        product.setRating(rating);
        product.setFavorite(favorite);
        product.setPrice(price);
        product.setDiscount(discount);
        product.setInventoryQuantity(inventoryQuantity);
        product.setWarehouseQuantity(inventoryQuantity);
        product.setProductImportDate(currentTimestamp);
        Category category = categoryRepository.findCategoriesByName(categoryName);
        if (category != null) {
            product.setCategory(category);
            return productRepository.save(product);
        } else {
            return null;
        }
    }

    @Override
    public Product addProductTest(String name, String linkImage, double rating, boolean favorite, long price, int discount, int inventoryQuantity, int soldQuantity, String productImportDate, String categoryName) {
        Product product = new Product();
        product.setName(name);
        product.setLinkImage(linkImage);
        product.setRating(rating);
        product.setFavorite(favorite);
        product.setPrice(price);
        product.setDiscount(discount);
        product.setInventoryQuantity(inventoryQuantity);
        product.setSoldQuantity(soldQuantity);
        product.setWarehouseQuantity(inventoryQuantity - soldQuantity);
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date parsedDate = dateFormat.parse(productImportDate);
            Timestamp timestamp = new Timestamp(parsedDate.getTime());
            product.setProductImportDate(timestamp);
//            System.out.println("Timestamp từ chuỗi: " + timestamp);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Category category = categoryRepository.findCategoriesByName(categoryName);
        if (category != null) {
            product.setCategory(category);
            return productRepository.save(product);
        } else {
            return null;
        }
    }

    @Override
    public FindProductByCriteriaResponse findProductByCriteria(FindProductByCriteriaRequest request) {
        List<Product> listProduct = productRepository.findAll();

        if (request.getNameProductOrCategory() != null && request.getNameProductOrCategory() != "") {
            listProduct = listProduct.stream().filter((Product product) -> {
                return product.getName().toLowerCase().contains(request.getNameProductOrCategory().toLowerCase())
                        || product.getCategory().getName().toLowerCase().contains(request.getNameProductOrCategory().toLowerCase());
            }).toList();
        }

        if (request.getCategory() != null && !request.getCategory().isEmpty()) {
            listProduct = listProduct.stream().filter((Product product) -> {
                return request.getCategory().contains(product.getCategory().getName());
            }).toList();
        }

        if (request.getSortBy() != null) {
            if (request.getSortBy().equals(SortType.NEW.getValue())) {
                listProduct = listProduct.stream().sorted(ProductServiceImpl::sortByNew).toList();
            }

            if (request.getSortBy().equals(SortType.HOT_SELLING.getValue())) {
                listProduct = listProduct.stream().sorted(ProductServiceImpl::sortByHotSelling).toList();
            }

            if (request.getSortBy().equals(SortType.PRICE_ASC.getValue())) {
                listProduct = listProduct.stream().sorted(ProductServiceImpl::sortByPriceAsc).toList();
            }

            if (request.getSortBy().equals(SortType.PRICE_DESC.getValue())) {
                listProduct = listProduct.stream().sorted(ProductServiceImpl::sortByPriceDesc).toList();
            }
        }

        FindProductByCriteriaResponse findProductByCriteriaResponse = new FindProductByCriteriaResponse();
        findProductByCriteriaResponse.setListProduct(listProduct);

        return findProductByCriteriaResponse;
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.findProductById(id);
    }

    public static int sortByNew(Product product1, Product product2){
        long time1 = product1.getProductImportDate().getTime();
        long time2 = product2.getProductImportDate().getTime();

        if (time1 < time2) {
            return 1; // Trả về số nguyên dương nếu product1 lớn hơn product2
        } else if (time1 > time2) {
            return -1; // Trả về số nguyên âm nếu product1 nhỏ hơn product2
        } else {
            return 0; // Trả về 0 nếu product1 và product2 bằng nhau
        }
    }

    public static int sortByHotSelling(Product product1, Product product2){
        if (product1.getSoldQuantity() < product2.getSoldQuantity()) {
            return 1; // Trả về số nguyên dương nếu product1 lớn hơn product2
        } else if (product1.getSoldQuantity() > product2.getSoldQuantity()) {
            return -1; // Trả về số nguyên âm nếu product1 nhỏ hơn product2
        } else {
            return 0; // Trả về 0 nếu product1 và product2 bằng nhau
        }
    }

    public static int sortByPriceAsc(Product product1, Product product2){
        double price1 = product1.getPrice() * ((100-product1.getDiscount())/100.0);
        double price2 = product2.getPrice() * ((100-product2.getDiscount())/100.0);

        if (price1 > price2) {
            return 1; // Trả về số nguyên dương nếu product1 lớn hơn product2
        } else if (price1 < price2) {
            return -1; // Trả về số nguyên âm nếu product1 nhỏ hơn product2
        } else {
            return 0; // Trả về 0 nếu product1 và product2 bằng nhau
        }
    }

    public static int sortByPriceDesc(Product product1, Product product2){
        double price1 = product1.getPrice() * ((100-product1.getDiscount())/100.0);
        double price2 = product2.getPrice() * ((100-product2.getDiscount())/100.0);

        if (price1 < price2) {
            return 1; // Trả về số nguyên dương nếu product1 lớn hơn product2
        } else if (price1 > price2) {
            return -1; // Trả về số nguyên âm nếu product1 nhỏ hơn product2
        } else {
            return 0; // Trả về 0 nếu product1 và product2 bằng nhau
        }
    }

//    public Specification<Product> searchProducts(String name, ArrayList<String> categories) {
//        return (Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
//            List<Predicate> predicates = new ArrayList<>();
//
//            if(name != null || name != ""){
//                // Tìm kiếm gần đúng trong trường "name" của "Product"
//                 Predicate predicate1 = criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%");
//
//                // Tìm kiếm gần đúng trong trường "name" của "Category"
//                Predicate predicate2 = criteriaBuilder.like(criteriaBuilder.lower(root.get("category").get("name")), "%" + name.toLowerCase() + "%");
//
//                predicates.add(criteriaBuilder.or(predicate1, predicate2));
//            }
//
//            if(!categories.isEmpty()){
//                predicates.add(root.get("category").get("name").in(categories));
//            }
//
//            // Kết hợp các điều kiện bằng and
//            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
//        };
//    }
}
