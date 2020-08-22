package shop.gongcar.controller.api;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.gongcar.payload.ProductRequest;
import shop.gongcar.model.Product;
import shop.gongcar.service.ProductService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/products")
@Api(value = "main")
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
    List<Product> getProductByCarCondition(@RequestParam(required = true) Optional<Long> pageStartNum,
                                           @RequestParam(required = false) String objectManagementNum,
                                           @RequestParam(required = false) String objectName,
                                           @RequestParam(required = false) Optional<Long> appraisedPriceStart,
                                           @RequestParam(required = false) Optional<Long> appraisedPriceEnd,
                                           @RequestParam(required = false) Optional<Long> bidBeginDateTime,
                                           @RequestParam(required = false) Optional<Long> bidCloseDateTime,
                                           @RequestParam(required = false) String manufacturer,
                                           @RequestParam(required = false) String model,
                                           @RequestParam(required = false) String transmission,
                                           @RequestParam(required = false) String fuelType,
                                           @RequestParam(required = false) Optional<Long> yearAndMonthStart,
                                           @RequestParam(required = false) Optional<Long> yearAndMonthEnd,
                                           @RequestParam(required = false) Optional<Long> displacementStart,
                                           @RequestParam(required = false) Optional<Long> displacementEnd,
                                           @RequestParam(required = false) Optional<Long> distanceDrivenStart,
                                           @RequestParam(required = false) Optional<Long> distanceDrivenEnd) {

        System.out.println("시바 "+ pageStartNum);

        ProductRequest productRequest = new ProductRequest();

        if(pageStartNum.isPresent())
            productRequest.setPageStartNum((Long)pageStartNum.get());
        productRequest.setObjectManagementNum(objectManagementNum);
        productRequest.setObjectName(objectName);
        if(appraisedPriceStart.isPresent())
            productRequest.setAppraisedPriceStart((Long)appraisedPriceStart.get());
        if(appraisedPriceEnd.isPresent())
            productRequest.setAppraisedPriceEnd((Long)appraisedPriceEnd.get());
        if(bidBeginDateTime.isPresent())
            productRequest.setBidBeginDateTime((Long)bidBeginDateTime.get());
        if(bidCloseDateTime.isPresent())
            productRequest.setBidCloseDateTime((Long)bidCloseDateTime.get());
        productRequest.setManufacturer(manufacturer);
        productRequest.setModel(model);
        productRequest.setTransmission(transmission);
        productRequest.setFuelType(fuelType);
        if(yearAndMonthStart.isPresent())
            productRequest.setYearAndMonthStart((Long)yearAndMonthStart.get());
        if(yearAndMonthEnd.isPresent())
            productRequest.setYearAndMonthEnd((Long)yearAndMonthEnd.get());
        if(displacementStart.isPresent())
            productRequest.setDisplacementStart((Long)displacementStart.get());
        if(displacementEnd.isPresent())
            productRequest.setDistanceDrivenEnd((Long)displacementEnd.get());
        if(displacementStart.isPresent())
            productRequest.setDistanceDrivenStart((Long)distanceDrivenStart.get());
        if(displacementEnd.isPresent())
            productRequest.setDistanceDrivenEnd((Long)distanceDrivenEnd.get());

        return productService.getProductByCondition(productRequest);
    }

    @GetMapping(path = "/{productId}") //상세 조회로 만들기
    public Product getProductWithDetailDate(@PathVariable(name = "productId") Long productId) {
        return productService.getProductWithDetailDate(productId);
    }
}


