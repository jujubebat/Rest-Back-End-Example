package shop.gongcar.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    Long pageStartNum;
    String objectManagementNum;
    String objectName;
    Long appraisedPriceStart;
    Long appraisedPriceEnd;
    Long bidBeginDateTime;
    Long bidCloseDateTime;
    String manufacturer;
    String model;
    String transmission;
    String fuelType;
    Long yearAndMonthStart;
    Long yearAndMonthEnd;
    Long displacementStart;
    Long displacementEnd;
    Long distanceDrivenStart;
    Long distanceDrivenEnd;
}
