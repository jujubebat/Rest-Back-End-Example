package com.jujubebat.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long PBCT_NO; // 공매번호

    private Long PLNM_NO; // 공고번호

    @Lob
    private String PLNM_NM; // 공고명
    @Lob
    private String ORG_NM; // 공고기관
    @Lob
    private String RSBY_DEPT; // 담당부점
    @Lob
    private String PSCG_NM; // 담당자명
    @Lob
    private String PSCG_TPNO; // 담당자전화번호
    @Lob
    private String PSCG_EMAL_ADRS; // 담당자이메일주소
    @Lob
    private String PLNM_KIND_NM; // 공고종류
    @Lob
    private String PLNM_DT; // 공고일자
    @Lob
    private String PLNM_YR; // 공고년도
    @Lob
    private String PLNM_SEQ; // 공고회차
    @Lob
    private String PRPT_DVSN_NM; //재산구분
    @Lob
    private String AST_DVSN_NM; //자산구분
    @Lob
    private String PLNM_MNMT_NO; // 공고관리번호
    @Lob
    private String ORG_PLNM_NO; // 기관공고번호
    @Lob
    private String RLTN_PLNM_NO; // 관련공고번호
    @Lob
    private String RLTN_PLNM_TITL; // 관련공고명
    @Lob
    private String BID_MTD_NM; // 입찰방식
    @Lob
    private String DPSL_MTD_NM; //처분방식
    @Lob
    private String CPTN_MTD_NM; // 경쟁방식
    @Lob
    private String TOT_AMT_UNPC_DVSN_NM; // 총액단가구분
    @Lob
    private String PTCT_QLFC; // 참가자격
    @Lob
    private String RBD_YN; // 재입찰여부
    @Lob
    private String COMN_BID_PMSN_YN; //공동입찰허용여부
    @Lob
    private String SUBT_BID_PMSN_YN; // 대리입찰허용여부
    @Lob
    private String PLNM_DOC; // 공고문
    @Lob
    private String bidDateInfosTotalCount; // 공매일정 총 건수
    @Lob
    private String filesTotalCount; // 첨부파일 총 건수

}
