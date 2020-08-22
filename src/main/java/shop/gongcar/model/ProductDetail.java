package shop.gongcar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ProductDetail {

    @JsonIgnore // 무한 루프 방지를 위해 사용
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long publicAuctionNum; // 공매번호

    private Long noticeNum; // 공고번호

    @Lob
    private String noticeName; // 공고명
    @Lob
    private String noticeOrganization; // 공고기관
    @Lob
    private String managementDepartment; // 담당부점
    @Lob
    private String managerName; // 담당자명
    @Lob
    private String managerTel; // 담당자전화번호
    @Lob
    private String managerEmail; // 담당자이메일주소
    @Lob
    private String noticeType; // 공고종류
    @Lob
    private String noticeDateTime; // 공고일자
    @Lob
    private String noticeYear; // 공고년도
    @Lob
    private String noticeSequence; // 공고회차
    @Lob
    private String propertyDivision; //재산구분
    @Lob
    private String assetDivision; //자산구분
    @Lob
    private String noticeManagementName; // 공고관리번호
    @Lob
    private String organizationNoticeNum; // 기관공고번호
    @Lob
    private String relateNoticeNum; // 관련공고번호
    @Lob
    private String relateNoticeName; // 관련공고명
    @Lob
    private String bidMethodType; // 입찰방식
    @Lob
    private String disposeType; //처분방식
    @Lob
    private String competitionType; // 경쟁방식
    @Lob
    private String totalAmountUnitPriceDivisionName;  // 총액단가구분
    @Lob
    private String eligibility; // 참가자격
    @Lob
    private String reBidFlag; // 재입찰여부
    @Lob
    private String commonBidFlag; //공동입찰허용여부
    @Lob
    private String substituteBidFlag; // 대리입찰허용여부
    @Lob
    private String noticeDocument; // 공고문
    @Lob
    private String bidDateInfosTotalCount; // 공매일정 총 건수
    @Lob
    private String filesTotalCount; // 첨부파일 총 건수

}
