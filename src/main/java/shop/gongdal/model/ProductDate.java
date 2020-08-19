package shop.gongdal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ProductDate {

    @JsonIgnore // 무한 루프 방지를 위해 사용
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long publicAuctionNum; // 공매 번호

    private Long noticeNum; // 공고번호

    private String publicAuctionSequence; // 공매 회차

    private String publicAuctionDegree; // 공매 차수

    private String bidDivisionName; // 입찰구분

    private String lessTwoPeopleFailBidFlag; // 2인 미만 유찰 여부

    private String moreTwoSequenceBidFlag; //2회 이상 입찰가능 여부

    private String electronicWarrantyFlag; // 전자보증서 여부

    private Long participationFee; // 참가 수수료

    private Double bidDepositRate; // 입찰 보증금률

    private String bidStartDateTime; // 입찰 시작 일시

    private String bidEndDateTime; // 입찰 마감 일시

    private String bidOpenDateTime; // 개찰 일시

    private String bidOpenPlace; // 개찰장소내용

}
