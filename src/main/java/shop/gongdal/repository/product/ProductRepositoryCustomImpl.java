package shop.gongdal.repository.product;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import shop.gongdal.model.Product;
import static shop.gongdal.model.QProduct.product;

import java.util.List;

@RequiredArgsConstructor
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom{

    private final JPAQueryFactory queryFactory;
    private static Long limit =5L;

    @Override
    public List<Product> findAll(Long pageStartNum){
        return queryFactory
                .selectFrom(product)
                .offset(pageStartNum*limit)
                .limit(limit)
                .fetch();
    }

    @Override
    public List<Product> findByCarCondition(
                                    Long pageStartNum ,
                                    String objectManagementNum,
                                    String objectName,
                                    Long appraisedPriceStart,
                                    Long appraisedPriceEnd,
                                    Long bidBeginDateTime,
                                    Long bidCloseDateTime,
                                    String manufacturer,
                                    String model,
                                    String transmission,
                                    String fuelType,
                                    Long yearAndMonthStart,
                                    Long yearAndMonthEnd,
                                    Long displacementStart,
                                    Long displacementEnd,
                                    Long distanceDrivenStart,
                                    Long distanceDrivenEnd){

        BooleanBuilder builder = new BooleanBuilder();


        System.out.println(objectManagementNum);
        System.out.println(objectName);
        System.out.println(appraisedPriceStart);
        System.out.println(appraisedPriceEnd);
        System.out.println(bidBeginDateTime);
        System.out.println(bidCloseDateTime);
        System.out.println(manufacturer);
        System.out.println(model);
        System.out.println(transmission);
        System.out.println(fuelType);
        System.out.println(yearAndMonthStart);
        System.out.println(yearAndMonthEnd);
        System.out.println(displacementStart);
        System.out.println(displacementEnd);
        System.out.println(distanceDrivenStart);
        System.out.println(distanceDrivenEnd);


        // 물건 관리번호
        if(!StringUtils.isEmpty(objectManagementNum)){ // 물건 관리번호 필드가 있다면 쿼리 조건에 추가
            builder.and(product.objectManagementNum.eq(objectManagementNum));
        }

        // 물건명
        if(!StringUtils.isEmpty(objectName)){ // 물건명 필드가 있다면 쿼리 조건에 추가
            builder.and(product.objectName.contains(objectName));
        }

        // 감정가
        if(appraisedPriceStart != null && appraisedPriceEnd != null){
            builder.and(product.appraisedPrice.between(appraisedPriceStart, appraisedPriceEnd));
        }else if(appraisedPriceStart != null){
            builder.and(product.appraisedPrice.gt(yearAndMonthStart));
        }else if(appraisedPriceEnd != null){
            builder.and(product.appraisedPrice.lt(yearAndMonthEnd));
        }

        // 입찰기간
        if(bidBeginDateTime != null && bidCloseDateTime != null){
            builder.and(product.bidBeginDateTime.between(bidBeginDateTime, bidCloseDateTime));
        }else if(bidBeginDateTime != null){
            builder.and(product.bidBeginDateTime.gt(bidBeginDateTime));
        }else if(bidCloseDateTime != null){
            builder.and(product.bidBeginDateTime.lt(bidCloseDateTime));
        }

        // 제조사
        if(!StringUtils.isEmpty(manufacturer)){ // 제조사 필드가 있다면 쿼리 조건에 추가
            System.out.println("예! " + manufacturer);
            builder.and(product.manufacturer.contains(manufacturer));
        }

        // 모델
        if(!StringUtils.isEmpty(model)){ // 모델 필드가 있다면 쿼리 조건에 추가
            builder.and(product.model.contains(model));
        }

        // 변속기
        if(!StringUtils.isEmpty(transmission)){ // 변속기 필드가 있다면 쿼리 조건에 추가
            builder.and(product.transmission.contains(transmission));
        }

        // 연료타입
        if(!StringUtils.isEmpty(fuelType)){ // 연료타입 필드가 있다면 쿼리 조건에 추가
            builder.and(product.fuelType.contains(fuelType));
        }

        // 연월식
        if(!StringUtils.isEmpty(yearAndMonthStart)
                && !StringUtils.isEmpty(yearAndMonthEnd)){ // 연월식 시작, 종료 필드가 있다면 쿼리 조건에 추가
            builder.and(product.yearAndMonth.between(yearAndMonthStart, yearAndMonthEnd));
        }else if(!StringUtils.isEmpty(yearAndMonthStart)){ // 연월식 시작 필드가 있다면 쿼리 조건에 추가
            builder.and(product.yearAndMonth.gt(yearAndMonthStart));
        }else if(!StringUtils.isEmpty(yearAndMonthStart)){ // 연월식 종료 필드가 있다면 쿼리 조건에 추가
            builder.and(product.yearAndMonth.lt(yearAndMonthStart));
        }

        // 배기량
        if(!StringUtils.isEmpty(displacementStart)
                && !StringUtils.isEmpty(displacementEnd)){ // 배기량 필드가 있다면 쿼리 조건에 추가
            builder.and(product.displacement.between(displacementStart, displacementEnd));
        }else if(!StringUtils.isEmpty(displacementStart)){ // 연월식 시작 필드가 있다면 쿼리 조건에 추가
            builder.and(product.displacement.gt(displacementStart));
        }else if(!StringUtils.isEmpty(displacementEnd)){ // 연월식 종료 필드가 있다면 쿼리 조건에 추가
            builder.and(product.displacement.lt(displacementEnd));
        }

        // 주행거리
        if(!StringUtils.isEmpty(distanceDrivenStart)
                && !StringUtils.isEmpty(distanceDrivenEnd)){ // 주행거리 필드가 있다면 쿼리 조건에 추가
            builder.and(product.distanceDriven.between(distanceDrivenStart, distanceDrivenEnd));
        }else if(!StringUtils.isEmpty(distanceDrivenStart)){ // 연월식 시작 필드가 있다면 쿼리 조건에 추가
            builder.and(product.distanceDriven.gt(distanceDrivenStart));
        }else if(!StringUtils.isEmpty(distanceDrivenEnd)){ // 연월식 종료 필드가 있다면 쿼리 조건에 추가
            builder.and(product.distanceDriven.lt(distanceDrivenEnd));
        }

        return queryFactory
                .selectFrom(product)
                .where(builder)
                .offset(pageStartNum*limit)
                .limit(limit)
                .fetch();
    }

}
