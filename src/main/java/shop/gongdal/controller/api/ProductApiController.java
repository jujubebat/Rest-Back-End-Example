package shop.gongdal.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.gongdal.model.Product;
import shop.gongdal.payload.ProductRequest;
import shop.gongdal.service.ProductService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/products")
public class ProductApiController {

    private final ProductService productService;

    @Autowired
    public ProductApiController(ProductService productService) {
        this.productService = productService;
    }

    // 공매물건 조건에 따른검색 컨트롤러
    @GetMapping(path = "/carTest")
    List<Product> getCars(@RequestBody ProductRequest productRequest) {
        // ProductResponse로 변환하여 전달해야함.
        return productService.getProductByCondition(productRequest);
    }

    @GetMapping(path = "/{productId}") //상세 조회로 만들기
    public Product getProductWithDetailDate(@PathVariable(name = "productId") Long productId) {
        return productService.getProductWithDetailDate(productId);
    }
}


