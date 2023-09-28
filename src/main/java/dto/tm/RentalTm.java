package dto.tm;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RentalTm {
    private String rentID;
    private String customer_customerId;
    private String car_carId;
    private Double total;
    private Double balance;
    private String Is_returned;

}
