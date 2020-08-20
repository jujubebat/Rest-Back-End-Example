package shop.gongdal.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProductDetail is a Querydsl query type for ProductDetail
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProductDetail extends EntityPathBase<ProductDetail> {

    private static final long serialVersionUID = 1627722339L;

    public static final QProductDetail productDetail = new QProductDetail("productDetail");

    public final StringPath assetDivision = createString("assetDivision");

    public final StringPath bidDateInfosTotalCount = createString("bidDateInfosTotalCount");

    public final StringPath bidMethodType = createString("bidMethodType");

    public final StringPath commonBidFlag = createString("commonBidFlag");

    public final StringPath competitionType = createString("competitionType");

    public final StringPath disposeType = createString("disposeType");

    public final StringPath eligibility = createString("eligibility");

    public final StringPath filesTotalCount = createString("filesTotalCount");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath managementDepartment = createString("managementDepartment");

    public final StringPath managerEmail = createString("managerEmail");

    public final StringPath managerName = createString("managerName");

    public final StringPath managerTel = createString("managerTel");

    public final StringPath noticeDateTime = createString("noticeDateTime");

    public final StringPath noticeDocument = createString("noticeDocument");

    public final StringPath noticeManagementName = createString("noticeManagementName");

    public final StringPath noticeName = createString("noticeName");

    public final NumberPath<Long> noticeNum = createNumber("noticeNum", Long.class);

    public final StringPath noticeOrganization = createString("noticeOrganization");

    public final StringPath noticeSequence = createString("noticeSequence");

    public final StringPath noticeType = createString("noticeType");

    public final StringPath noticeYear = createString("noticeYear");

    public final StringPath organizationNoticeNum = createString("organizationNoticeNum");

    public final StringPath propertyDivision = createString("propertyDivision");

    public final NumberPath<Long> publicAuctionNum = createNumber("publicAuctionNum", Long.class);

    public final StringPath reBidFlag = createString("reBidFlag");

    public final StringPath relateNoticeName = createString("relateNoticeName");

    public final StringPath relateNoticeNum = createString("relateNoticeNum");

    public final StringPath substituteBidFlag = createString("substituteBidFlag");

    public final StringPath totalAmountUnitPriceDivisionName = createString("totalAmountUnitPriceDivisionName");

    public QProductDetail(String variable) {
        super(ProductDetail.class, forVariable(variable));
    }

    public QProductDetail(Path<? extends ProductDetail> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProductDetail(PathMetadata metadata) {
        super(ProductDetail.class, metadata);
    }

}

