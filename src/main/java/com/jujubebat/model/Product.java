package com.jujubebat.model;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import lombok.Data;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Product {

    @OneToMany(mappedBy = "product")
    private List<Calendar> calendar = new ArrayList<>();

    @Id
    private Long PBCT_NO;
    private Long PLNM_NO;
    private Long PBCT_CDTN_NO;

    private Long CLTR_NO;
    private Long CLTR_HSTR_NO;
    private String SCRN_GRP_CD;
    private String CTGR_FULL_NM;
    private String BID_MNMT_NO;
    private String CLTR_NM;
    private Long CLTR_MNMT_NO;
    private String LDNM_ADRS;
    private String NMRD_ADRS;
    private String DPSL_MTD_CD;
    private String DPSL_MTD_NM;
    @Lob
    private String BID_MTD_NM;
    private String MIN_BID_PRC;
    private String APSL_ASES_AVG_AMT;
    private String FEE_RATE;
    private String PBCT_BEGN_DTM;
    private String PBCT_CLS_DTM;
    private String PBCT_CLTR_STAT_NM;
    private String USCBD_CNT;
    private String IQRY_CNT;
    @Lob
    private String GOODS_NM;
    private String MANF;
    private String MDL;
    private String NRGT;
    private String GRBX;
    private String ENDPC;
    private String VHCL_MLGE;
    private String FUEL;
    private String SCRT_NM;
    private String TPBZ;
    private String ITM_NM;
    private String MMB_RGT_NM;
    private Long ex;
}
