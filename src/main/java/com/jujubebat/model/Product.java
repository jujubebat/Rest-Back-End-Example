package com.jujubebat.model;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import lombok.*;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@ToString(exclude = {"calendar"})
public class Product {

    @OneToMany(mappedBy = "product")
    private List<Calendar> calendar = new ArrayList<>();

    @Id
    private Long publicAuctionNum; // 공매 번호
    private Long noticeNum; //공고 번호
    private Long publicAuctionConditionNum; // 공매 조건 번호
    private Long objectNum; // 물건 번호
    private Long objectRecordNum; //물건 이력 번호
    private String screenGroupCode; // 화면 그룹 코드
    private String bidNum; // 입찰 번호
    private String objectName; // 물건명
    private String useName; // 용도명
    private String objectManagementNum; // 물건 관리 번호
    private String lotNum; // 지번
    private String roadName; // 도로명
    private String disposalMethodCode; // 처분 방식 코드
    private String disposalMethodCodeName; // 처분 방식 코드명
    @Lob
    private String bidMethod; // 입찰 방식명
    private String minimumBidPrice; // 최저 입찰가
    private String appraisedPrice; // 감정가
    private String minimumBidPriceRate; // 최저 입찰가율
    private String bidBeginDateTime; // 입찰 시작 일시
    private String bidCloseDateTime; // 입찰 마감 일시
    private String objectCondition; // 물건 상태
    private String failBidCount; // 유찰횟수
    private String onbidViews; // 온비드 게시글 조회수
    @Lob
    private String productDetailInfo; // 물건 상세 정보
    private String manufacturer; // 제조사
    private String model; // 모델
    private String yearAndMonth; // 연월식
    private String transmission; // 변속기
    private String displacement; // 배기량
    private String distanceDriven; // 주행거리
    private String fuelType; // 연료 종류
    private String corporationName; // 법인명
    private String businessType; // 업종
    private String eventName; // 종목명
    private String membershipName; // 회원권명


}
