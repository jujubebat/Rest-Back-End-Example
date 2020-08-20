package shop.gongdal.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProduct is a Querydsl query type for Product
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProduct extends EntityPathBase<Product> {

    private static final long serialVersionUID = -729027726L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProduct product = new QProduct("product");

    public final StringPath appraisedPrice = createString("appraisedPrice");

    public final StringPath bidBeginDateTime = createString("bidBeginDateTime");

    public final StringPath bidCloseDateTime = createString("bidCloseDateTime");

    public final StringPath bidMethod = createString("bidMethod");

    public final StringPath bidNum = createString("bidNum");

    public final StringPath businessType = createString("businessType");

    public final ListPath<Calendar, QCalendar> calendars = this.<Calendar, QCalendar>createList("calendars", Calendar.class, QCalendar.class, PathInits.DIRECT2);

    public final StringPath corporationName = createString("corporationName");

    public final NumberPath<Long> displacement = createNumber("displacement", Long.class);

    public final StringPath disposalMethodCode = createString("disposalMethodCode");

    public final StringPath disposalMethodCodeName = createString("disposalMethodCodeName");

    public final NumberPath<Long> distanceDriven = createNumber("distanceDriven", Long.class);

    public final StringPath eventName = createString("eventName");

    public final StringPath failBidCount = createString("failBidCount");

    public final StringPath fuelType = createString("fuelType");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath lotNum = createString("lotNum");

    public final StringPath manufacturer = createString("manufacturer");

    public final StringPath membershipName = createString("membershipName");

    public final StringPath minimumBidPrice = createString("minimumBidPrice");

    public final StringPath minimumBidPriceRate = createString("minimumBidPriceRate");

    public final StringPath model = createString("model");

    public final NumberPath<Long> noticeNum = createNumber("noticeNum", Long.class);

    public final StringPath objectCondition = createString("objectCondition");

    public final StringPath objectManagementNum = createString("objectManagementNum");

    public final StringPath objectName = createString("objectName");

    public final NumberPath<Long> objectNum = createNumber("objectNum", Long.class);

    public final NumberPath<Long> objectRecordNum = createNumber("objectRecordNum", Long.class);

    public final StringPath onbidViews = createString("onbidViews");

    public final ListPath<ProductDate, QProductDate> productDate = this.<ProductDate, QProductDate>createList("productDate", ProductDate.class, QProductDate.class, PathInits.DIRECT2);

    public final QProductDetail productDetail;

    public final StringPath productDetailInfo = createString("productDetailInfo");

    public final NumberPath<Long> publicAuctionConditionNum = createNumber("publicAuctionConditionNum", Long.class);

    public final NumberPath<Long> publicAuctionNum = createNumber("publicAuctionNum", Long.class);

    public final StringPath roadName = createString("roadName");

    public final StringPath screenGroupCode = createString("screenGroupCode");

    public final StringPath transmission = createString("transmission");

    public final StringPath useName = createString("useName");

    public final NumberPath<Long> yearAndMonth = createNumber("yearAndMonth", Long.class);

    public QProduct(String variable) {
        this(Product.class, forVariable(variable), INITS);
    }

    public QProduct(Path<? extends Product> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProduct(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProduct(PathMetadata metadata, PathInits inits) {
        this(Product.class, metadata, inits);
    }

    public QProduct(Class<? extends Product> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.productDetail = inits.isInitialized("productDetail") ? new QProductDetail(forProperty("productDetail")) : null;
    }

}

