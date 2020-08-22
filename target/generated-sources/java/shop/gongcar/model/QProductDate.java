package shop.gongcar.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProductDate is a Querydsl query type for ProductDate
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProductDate extends EntityPathBase<ProductDate> {

    private static final long serialVersionUID = 1382718277L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProductDate productDate = new QProductDate("productDate");

    public final NumberPath<Double> bidDepositRate = createNumber("bidDepositRate", Double.class);

    public final StringPath bidDivisionName = createString("bidDivisionName");

    public final StringPath bidEndDateTime = createString("bidEndDateTime");

    public final StringPath bidOpenDateTime = createString("bidOpenDateTime");

    public final StringPath bidOpenPlace = createString("bidOpenPlace");

    public final StringPath bidStartDateTime = createString("bidStartDateTime");

    public final StringPath electronicWarrantyFlag = createString("electronicWarrantyFlag");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath lessTwoPeopleFailBidFlag = createString("lessTwoPeopleFailBidFlag");

    public final StringPath moreTwoSequenceBidFlag = createString("moreTwoSequenceBidFlag");

    public final NumberPath<Long> noticeNum = createNumber("noticeNum", Long.class);

    public final NumberPath<Long> participationFee = createNumber("participationFee", Long.class);

    public final QProduct product;

    public final StringPath publicAuctionDegree = createString("publicAuctionDegree");

    public final NumberPath<Long> publicAuctionNum = createNumber("publicAuctionNum", Long.class);

    public final StringPath publicAuctionSequence = createString("publicAuctionSequence");

    public QProductDate(String variable) {
        this(ProductDate.class, forVariable(variable), INITS);
    }

    public QProductDate(Path<? extends ProductDate> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProductDate(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProductDate(PathMetadata metadata, PathInits inits) {
        this(ProductDate.class, metadata, inits);
    }

    public QProductDate(Class<? extends ProductDate> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.product = inits.isInitialized("product") ? new QProduct(forProperty("product"), inits.get("product")) : null;
    }

}

