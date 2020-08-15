package com.jujubebat.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class ProductDate {

    private Long PLNM_NO;

    @Id
    private Long PBCT_NO;

    private String PBCT_SEQ;

    private String PBCT_DGR;

    private String BID_DVSN_NM;

    private String TWPS_LSTH_USBD_YN;

    private String TWTM_GTHR_BID_PSBL_YN;

    private String ELTR_GRT_DOC_USE_YN;

    private Long PTCT_CMSN;

    private Double TDPS_RT;

    private String PBCT_BEGN_DTM;

    private String PBCT_CLS_DTM;

    private String PBCT_EXCT_DTM;

    private String OPBD_PLC_CNTN;

}
