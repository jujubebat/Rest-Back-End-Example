package com.jujubebat.controller.api;

import com.jujubebat.dto.ProductDetailResponseDto;
import com.jujubebat.dto.ProductResponseDto;
import com.jujubebat.model.Product;
import com.jujubebat.model.ProductDetail;
import com.jujubebat.service.ProductDetailService;
import com.jujubebat.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/api/products")
public class ProductApiController {

    private final ProductService productService;
    private final ProductDetailService productDetailService;

    @Autowired
    public  ProductApiController(ProductService productService, ProductDetailService productDetailService){
        this.productService = productService;
        this.productDetailService = productDetailService;
    }

    @GetMapping
    public List<ProductResponseDto> getProducts(@RequestParam(defaultValue = "1") int pageNum){

        List<ProductResponseDto> productResponseDtoList = new ArrayList<>() ;

        for(Product product : productService.getProducts(pageNum - 1)){
            ProductResponseDto productResponseDto = new ProductResponseDto();
            productResponseDto.setPublicAuctionNum(product.getPBCT_NO());
            productResponseDto.setNoticeNum(product.getPLNM_NO());
            productResponseDto.setPublicAuctionConditionNum(product.getPBCT_CDTN_NO());
            productResponseDto.setObjectRecordNum(product.getCLTR_NO());
            productResponseDto.setScreenGroupCode(product.getSCRN_GRP_CD());
            productResponseDto.setUseName(product.getCTGR_FULL_NM());
            productResponseDto.setBidNum(product.getBID_MNMT_NO());
            productResponseDto.setObjectName(product.getCLTR_NM());
            productResponseDto.setObjectManagementNum(product.getCLTR_MNMT_NO());
            productResponseDto.setLotNum(product.getLDNM_ADRS());
            productResponseDto.setRoadName(product.getNMRD_ADRS());
            productResponseDto.setDisposalMethodCode(product.getDPSL_MTD_CD());
            productResponseDto.setDisposalMethodCodeName(product.getDPSL_MTD_NM());
            productResponseDto.setBidMethodName(product.getBID_MTD_NM());
            productResponseDto.setMinimumBidPrice(product.getMIN_BID_PRC());
            productResponseDto.setAppraisedPrice(product.getAPSL_ASES_AVG_AMT());
            productResponseDto.setMinimumBidPriceRate(product.getFEE_RATE());
            productResponseDto.setBidBeginDateTime(product.getPBCT_BEGN_DTM());
            productResponseDto.setBidCloseDateTime(product.getPBCT_CLS_DTM());
            productResponseDto.setObjectCondition(product.getPBCT_CLTR_STAT_NM());
            productResponseDto.setFailBidCount(product.getUSCBD_CNT());
            productResponseDto.setOnbidViews(product.getIQRY_CNT());
            productResponseDto.setProductDetailInfo(product.getGOODS_NM());
            productResponseDto.setManufacturer(product.getMANF());
            productResponseDto.setModel(product.getMDL());
            productResponseDto.setYearAndMonth(product.getNRGT());
            productResponseDto.setTransmission(product.getGRBX());
            productResponseDto.setDisplacement(product.getENDPC());
            productResponseDto.setDistanceDriven(product.getVHCL_MLGE());
            productResponseDto.setFuelType(product.getFUEL());
            productResponseDto.setCorporationName(product.getSCRT_NM());
            productResponseDto.setBusinessType(product.getTPBZ());
            productResponseDto.setEventName(product.getITM_NM());
            productResponseDto.setMembershipName(product.getMMB_RGT_NM());
            productResponseDtoList.add(productResponseDto);
        }

        return productResponseDtoList;
    }

    @GetMapping(path = "/search")
    public ProductResponseDto getProductsByOption(@RequestParam(defaultValue = "") String searchType,
                                                        @RequestParam(defaultValue = "") String keyword){

        Product product = new Product();

        if(searchType == "물건명"){


        }else if(searchType == "물건관리번호"){
            product = productService.getProductByObjectManagementNum(Long.parseLong(keyword));
        }

        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setPublicAuctionNum(product.getPBCT_NO());
        productResponseDto.setNoticeNum(product.getPLNM_NO());
        productResponseDto.setPublicAuctionConditionNum(product.getPBCT_CDTN_NO());
        productResponseDto.setObjectRecordNum(product.getCLTR_NO());
        productResponseDto.setScreenGroupCode(product.getSCRN_GRP_CD());
        productResponseDto.setUseName(product.getCTGR_FULL_NM());
        productResponseDto.setBidNum(product.getBID_MNMT_NO());
        productResponseDto.setObjectName(product.getCLTR_NM());
        productResponseDto.setObjectManagementNum(product.getCLTR_MNMT_NO());
        productResponseDto.setLotNum(product.getLDNM_ADRS());
        productResponseDto.setRoadName(product.getNMRD_ADRS());
        productResponseDto.setDisposalMethodCode(product.getDPSL_MTD_CD());
        productResponseDto.setDisposalMethodCodeName(product.getDPSL_MTD_NM());
        productResponseDto.setBidMethodName(product.getBID_MTD_NM());
        productResponseDto.setMinimumBidPrice(product.getMIN_BID_PRC());
        productResponseDto.setAppraisedPrice(product.getAPSL_ASES_AVG_AMT());
        productResponseDto.setMinimumBidPriceRate(product.getFEE_RATE());
        productResponseDto.setBidBeginDateTime(product.getPBCT_BEGN_DTM());
        productResponseDto.setBidCloseDateTime(product.getPBCT_CLS_DTM());
        productResponseDto.setObjectCondition(product.getPBCT_CLTR_STAT_NM());
        productResponseDto.setFailBidCount(product.getUSCBD_CNT());
        productResponseDto.setOnbidViews(product.getIQRY_CNT());
        productResponseDto.setProductDetailInfo(product.getGOODS_NM());
        productResponseDto.setManufacturer(product.getMANF());
        productResponseDto.setModel(product.getMDL());
        productResponseDto.setYearAndMonth(product.getNRGT());
        productResponseDto.setTransmission(product.getGRBX());
        productResponseDto.setDisplacement(product.getENDPC());
        productResponseDto.setDistanceDriven(product.getVHCL_MLGE());
        productResponseDto.setFuelType(product.getFUEL());
        productResponseDto.setCorporationName(product.getSCRT_NM());
        productResponseDto.setBusinessType(product.getTPBZ());
        productResponseDto.setEventName(product.getITM_NM());
        productResponseDto.setMembershipName(product.getMMB_RGT_NM());

        return productResponseDto;
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
