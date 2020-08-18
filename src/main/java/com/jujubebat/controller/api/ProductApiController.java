package com.jujubebat.controller.api;

import com.jujubebat.dto.CalendarResponseDto;
import com.jujubebat.dto.ProductDetailResponseDto;
import com.jujubebat.dto.ProductResponseDto;
import com.jujubebat.model.*;
import com.jujubebat.repository.CalendarRepository;
import com.jujubebat.repository.ProductRepository;
import com.jujubebat.repository.UserRepository;
import com.jujubebat.service.ProductDetailService;
import com.jujubebat.service.ProductImageService;
import com.jujubebat.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/products")
public class ProductApiController {

    private final ProductService productService;
    private final ProductDetailService productDetailService;
    private final ProductImageService productImageService;

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final CalendarRepository calendarRepository;

    @Autowired
    public  ProductApiController(ProductService productService,
                                 ProductDetailService productDetailService,
                                 ProductImageService productImageService,

                                 UserRepository userRepository,
                                 ProductRepository productRepository,
                                 CalendarRepository calendarRepository){
        this.productService = productService;
        this.productDetailService = productDetailService;
        this.productImageService = productImageService;

        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.calendarRepository = calendarRepository;
    }

    @GetMapping
    public List<ProductResponseDto> getProductsByOption(@RequestParam(defaultValue = "") String searchType,
                                                        @RequestParam(defaultValue = "") String keyword){
        List<Product> productList = new ArrayList<>();

        System.out.println("haha " + searchType + " " + keyword);

        if(searchType.equals("objectName")){
            productList = productService.getProductsLikeObjectName(keyword);
            System.out.println("objectName : " + searchType + " " + keyword);

        }else if(searchType.equals("objectManagementNum")){
            productList.add(productService.getProductByObjectManagementNum(keyword));
            System.out.println("objectManagementNum : " + searchType + " " + keyword);
        }

        List<ProductResponseDto> productResponseDtoList = new ArrayList<>();

        System.out.println(productList.size());

        if(productList.isEmpty()) return productResponseDtoList;

        for(Product product : productList){

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

            //ProductImgeResponseDto productImgeResponseDto = new ProductImgeResponseDto();
            List<String> urls = new ArrayList<>();

            for(ProductImage productImage : productImageService.getProductImageByProductId(product.getId())){
                urls.add(productImage.getImgUrl());
            }

            //productImgeResponseDto.setImgUrls(urls);
            productResponseDto.setImages(urls);
            //productResponseDto.setImages(productImgeResponseDto);
            productResponseDtoList.add(productResponseDto);

        }

        return productResponseDtoList;
    }

    @GetMapping(path = "/{publicAuctionNum}") //상세 조회로 만들기
    public ProductDetailResponseDto getProuct(@PathVariable(name = "publicAuctionNum") Long publicAuctionNum){

        // [DTO - Entity간 변환, model mapper 적용해보기, DTO - Entity 변환을 하는 이유 생각해보기]
        ProductDetail productDetail = productDetailService.getProductDetail(publicAuctionNum);

        ProductDetailResponseDto productDetailResponseDto = new ProductDetailResponseDto();

        productDetailResponseDto.setPublicAuctionNum(productDetail.getPBCT_NO());

        return productDetailResponseDto;
    }

}
