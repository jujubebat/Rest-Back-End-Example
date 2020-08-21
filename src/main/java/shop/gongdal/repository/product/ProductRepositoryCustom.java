package shop.gongdal.repository.product;

import shop.gongdal.model.Product;

import java.util.List;

public interface ProductRepositoryCustom {

    List<Product> findAll(Long pageStartNum);

    List<Product> findByCarCondition(
                                    Long pageStartNum,
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
                                    Long distanceDrivenEnd);

}
