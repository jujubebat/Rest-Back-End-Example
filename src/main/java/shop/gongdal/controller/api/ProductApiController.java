package shop.gongdal.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.gongdal.model.Product;
import shop.gongdal.model.ProductDetail;
import shop.gongdal.model.ProductImage;
import shop.gongdal.payload.ProductDetailResponse;
import shop.gongdal.payload.ProductResponse;
import shop.gongdal.repository.CalendarRepository;
import shop.gongdal.repository.ProductRepository;
import shop.gongdal.repository.UserRepository;
import shop.gongdal.service.ProductDetailService;
import shop.gongdal.service.ProductImageService;
import shop.gongdal.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/products")
public class ProductApiController {

    private final ProductService productService;
    private final ProductImageService productImageService;


    @Autowired
    public ProductApiController(ProductService productService,
                                ProductImageService productImageService) {
        this.productService = productService;
        this.productImageService = productImageService;
    }

    @GetMapping
    public List<ProductResponse> getProductsByOption(@RequestParam(defaultValue = "") String searchType,
                                                     @RequestParam(defaultValue = "") String keyword) {

        System.out.println(searchType);
        System.out.println(keyword);


        List<Product> productList = new ArrayList<>();

        if (searchType.equals("objectName")) {
            System.out.println("objectName");

            System.out.println(keyword);
            productList = productService.getProductsLikeObjectName(keyword);
        } else if (searchType.equals("objectManagementNum")) {
            System.out.println("objectManagementNum");

            System.out.println(keyword);
            productList.add(productService.getProductByObjectManagementNum(keyword));
        }

        List<ProductResponse> productResponseDtoList = new ArrayList<>();

        System.out.println(productList.size());

        if (productList.isEmpty()) return productResponseDtoList;

        for (Product product : productList) {

            ProductResponse productResponseDto = new ProductResponse();
            productResponseDto.setId(product.getId());
            productResponseDto.setPublicAuctionNum(product.getPublicAuctionNum());
            productResponseDto.setUseName(product.getUseName());
            productResponseDto.setObjectName(product.getObjectName());
            productResponseDto.setObjectManagementNum(product.getObjectManagementNum());
            productResponseDto.setMinimumBidPrice(product.getMinimumBidPrice());
            productResponseDto.setAppraisedPrice(product.getAppraisedPrice());
            productResponseDto.setMinimumBidPriceRate(product.getMinimumBidPriceRate());
            productResponseDto.setBidBeginDateTime(product.getBidBeginDateTime());
            productResponseDto.setBidCloseDateTime(product.getBidCloseDateTime());
            productResponseDto.setObjectCondition(product.getObjectCondition());
            productResponseDto.setFailBidCount(product.getFailBidCount());
            productResponseDto.setOnbidViews(product.getOnbidViews());
            productResponseDto.setNoticeNum(product.getNoticeNum());
            productResponseDto.setPublicAuctionConditionNum(product.getPublicAuctionConditionNum());
            productResponseDto.setObjectRecordNum(product.getObjectRecordNum());
            productResponseDto.setScreenGroupCode(product.getScreenGroupCode());
            productResponseDto.setBidNum(product.getBidNum());
            productResponseDto.setLotNum(product.getLotNum());
            productResponseDto.setRoadName(product.getRoadName());
            productResponseDto.setDisposalMethodCode(product.getDisposalMethodCode());
            productResponseDto.setDisposalMethodCodeName(product.getDisposalMethodCodeName());
            productResponseDto.setBidMethod(product.getBidMethod());
            productResponseDto.setProductDetailInfo(product.getProductDetailInfo());
            productResponseDto.setManufacturer(product.getManufacturer());
            productResponseDto.setModel(product.getModel());
            productResponseDto.setYearAndMonth(product.getYearAndMonth());
            productResponseDto.setTransmission(product.getTransmission());
            productResponseDto.setDisplacement(product.getDisplacement());
            productResponseDto.setDistanceDriven(product.getDistanceDriven());
            productResponseDto.setFuelType(product.getFuelType());
            productResponseDto.setCorporationName(product.getCorporationName());
            productResponseDto.setBusinessType(product.getBusinessType());
            productResponseDto.setEventName(product.getEventName());
            productResponseDto.setMembershipName(product.getMembershipName());

            List<String> urls = new ArrayList<>();

            for (ProductImage productImage : productImageService.getProductImageByProductId(product.getId())) {
                urls.add(productImage.getImgUrl());
            }

            productResponseDto.setImages(urls);
            productResponseDtoList.add(productResponseDto);
        }

        return productResponseDtoList;
    }

    @GetMapping(path = "/{productId}") //상세 조회로 만들기
    public Product getProuct(@PathVariable(name = "productId") Long productId) {
        return productService.getProductWithDetailDate(productId);
    }
}