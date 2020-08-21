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

    @GetMapping
    List<Product> getProdcut(@RequestParam(required = true) Long pageStartNum) {
        return productService.getProduct(pageStartNum);
    }

    // 공매물건 조건에 따른검색 컨트롤러
    @GetMapping(path = "/search")
    List<Product> getProductByCarCondition(@RequestParam(required = true) String pageStartNum,
                                           @RequestParam(required = false) String objectManagementNum,
                                           @RequestParam(required = false) String objectName,
                                           @RequestParam(required = false) String appraisedPriceStart,
                                           @RequestParam(required = false) String appraisedPriceEnd,
                                           @RequestParam(required = false) String bidBeginDateTime,
                                           @RequestParam(required = false) String bidCloseDateTime,
                                           @RequestParam(required = false) String manufacturer,
                                           @RequestParam(required = false) String model,
                                           @RequestParam(required = false) String transmission,
                                           @RequestParam(required = false) String fuelType,
                                           @RequestParam(required = false) String yearAndMonthStart,
                                           @RequestParam(required = false) String yearAndMonthEnd,
                                           @RequestParam(required = false) String displacementStart,
                                           @RequestParam(required = false) String displacementEnd,
                                           @RequestParam(required = false) String distanceDrivenStart,
                                           @RequestParam(required = false) String distanceDrivenEnd) {


        ProductRequest productRequest = new ProductRequest();

        productRequest.setPageStartNum(Long.parseLong(pageStartNum));
        productRequest.setObjectManagementNum(objectManagementNum);
        productRequest.setObjectName(objectName);
        productRequest.setAppraisedPriceStart(Long.parseLong(appraisedPriceStart));
        productRequest.setAppraisedPriceEnd(Long.parseLong(appraisedPriceEnd));
        productRequest.setBidBeginDateTime(Long.parseLong(bidBeginDateTime));
        productRequest.setBidCloseDateTime(Long.parseLong(bidCloseDateTime));
        productRequest.setManufacturer(manufacturer);
        productRequest.setModel(model);
        productRequest.setTransmission(transmission);
        productRequest.setFuelType(fuelType);
        productRequest.setYearAndMonthStart(Long.parseLong(yearAndMonthStart));
        productRequest.setYearAndMonthEnd(Long.parseLong(yearAndMonthEnd));
        productRequest.setDisplacementStart(Long.parseLong(displacementStart));
        productRequest.setDistanceDrivenEnd(Long.parseLong(displacementEnd));
        productRequest.setDistanceDrivenStart(Long.parseLong(distanceDrivenStart));
        productRequest.setDistanceDrivenEnd(Long.parseLong(distanceDrivenEnd));

        return productService.getProductByCondition(productRequest);
    }

    @GetMapping(path = "/{productId}") //상세 조회로 만들기
    public Product getProductWithDetailDate(@PathVariable(name = "productId") Long productId) {
        return productService.getProductWithDetailDate(productId);
    }
}


