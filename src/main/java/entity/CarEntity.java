package entity;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class CarEntity {
    private String carId;
    private String brand;
    private String model;
    private String year;
    private String vehicleNo;
    private Double pricePerDay;
    private String cCategoryId;

}
