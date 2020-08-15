package com.jujubebat.dto;

import lombok.Data;

@Data
public class ProductDetailResponseDto {

    private Long publicAuctionNum; // 공매번호
    private Long noticeNum; //공고 번호
    private String noticeName; //공고명
    private String noticeAgency; // 공고기관
    private String chargeDepartment; // 담당 부점
    private String managerName; // 담당자명
    private String managerTel; // 담당자 전화번호
    private String managerEmail; // 담당자 이메일
    private String noticeType; // 공고 종류
    private String noticeDay; // 공고 일자
    private String noticeYear; // 공고 년도
    private String noticeRound; // 공고 회차
    private String propertyClass; // 재산 구분
    private String assetClass; // 자산 구분
    private String noticeManagementNum; // 공고 관리번호
    private String agencyNoticeNum; // 기관 공고 번호
    private String relatedNoticeNum; // 관련 공고 번호
    private String relatedNoticeName; // 관련 공고명
    private String bidMethod; // 입찰 방식
    private String disposalMethod; // 처분 방식
    private String competitionMethod; // 경쟁 방식
    private String totalPriceDivision; // 총액 단가 구분
    private String eligibility; // 참가 자격
    private boolean reBid; // 재입찰 여부
    private boolean jointBid; // 공동 입찰 허용 여부
    private boolean proxyBid; // 대리 입찰 허용 여부
    private String notice; // 공고문
    private String bidDateInfosTotalCount; // 공매일정 총 건수
    private String filesTotalCount; // 첨부파일 총 건수

}
