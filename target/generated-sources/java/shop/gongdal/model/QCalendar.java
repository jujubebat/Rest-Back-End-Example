package shop.gongdal.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;
import shop.gongcar.model.Calendar;


/**
 * QCalendar is a Querydsl query type for Calendar
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCalendar extends EntityPathBase<Calendar> {

    private static final long serialVersionUID = -299586277L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCalendar calendar = new QCalendar("calendar");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QProduct product;

    public final QUser user;

    public QCalendar(String variable) {
        this(Calendar.class, forVariable(variable), INITS);
    }

    public QCalendar(Path<? extends Calendar> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCalendar(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCalendar(PathMetadata metadata, PathInits inits) {
        this(Calendar.class, metadata, inits);
    }

    public QCalendar(Class<? extends Calendar> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.product = inits.isInitialized("product") ? new QProduct(forProperty("product"), inits.get("product")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

