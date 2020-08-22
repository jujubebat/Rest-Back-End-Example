package shop.gongdal.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;
import shop.gongcar.model.AuthProvider;
import shop.gongcar.model.Calendar;
import shop.gongcar.model.User;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -172878808L;

    public static final QUser user = new QUser("user");

    public final ListPath<Calendar, QCalendar> calendars = this.<Calendar, QCalendar>createList("calendars", Calendar.class, QCalendar.class, PathInits.DIRECT2);

    public final StringPath email = createString("email");

    public final BooleanPath emailVerified = createBoolean("emailVerified");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imageUrl = createString("imageUrl");

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final EnumPath<AuthProvider> provider = createEnum("provider", AuthProvider.class);

    public final StringPath providerId = createString("providerId");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

