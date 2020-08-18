package shop.gongdal.controller.api;

import shop.gongdal.dto.ProductResponseDto;
import shop.gongdal.model.Product;
import shop.gongdal.service.ProductDetailService;
import shop.gongdal.service.ProductImageService;
import shop.gongdal.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shop.gongdal.model.ProductImage;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/products")
public class ProductApiController {

    private final ProductService productService;
    private final ProductDetailService productDetailService;
    private final ProductImageService productImageService;

    @Autowired
    public ProductApiController(ProductService productService,
                                ProductDetailService productDetailService,
                                ProductImageService productImageService) {
        this.productService = productService;
        this.productDetailService = productDetailService;
        this.productImageService = productImageService;

    }

    @GetMapping
    public List<ProductResponseDto> getProductsByOption(@RequestParam(defaultValue = "") String searchType,
                                                        @RequestParam(defaultValue = "") String keyword) {
        List<Product> productList = new ArrayList<>();

        System.out.println("haha " + searchType + " " + keyword);

        if (searchType.equals("objectName")) {
            productList = productService.getProductsLikeObjectName(keyword);
            System.out.println("objectName : " + searchType + " " + keyword);

        } else if (searchType.equals("objectManagementNum")) {
            productList.add(productService.getProductByObjectManagementNum(keyword));
            System.out.println("objectManagementNum : " + searchType + " " + keyword);
        }

        List<ProductResponseDto> productResponseDtoList = new ArrayList<>();

        System.out.println(productList.size());

        if (productList.isEmpty()) return productResponseDtoList;

        for (Product product : productList) {

            ProductResponseDto productResponseDto = new ProductResponseDto();
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

    @GetMapping(path = "/{publicAuctionNum}") //상세 조회로 만들기
    public Product getProuct(@PathVariable(name = "publicAuctionNum") Long publicAuctionNum) {
        return productService.getProductWithDetailDate(publicAuctionNum);
    }

}
