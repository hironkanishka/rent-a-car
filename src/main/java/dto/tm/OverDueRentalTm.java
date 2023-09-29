package dto.tm;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OverDueRentalTm {
    private String rentID;
    private String customerId;
    private String carId;
    private Double total;
    private Double balance;
    private Integer overDueDays;
    private Double extraFee;
    private Double  NewTotalBalance;

}
