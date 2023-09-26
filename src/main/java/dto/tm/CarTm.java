package dto.tm;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CarTm {

    private String carId;
    private String brand;
    private String model;
    private String year;
    private String vehicleNo;
    private Double pricePerDay;
    private String cCategoryId;
}
