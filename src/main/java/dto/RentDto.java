package dto;

import lombok.*;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RentDto {
    private String rentID;
    private String fromDate;
    private String toDate;
    private Double perDayRent;
    private Double advancedPayment;
    private Double refundable;
    private Double total;
    private Double balance;
    private String cCustId;
    private String cCarId;
    private String isReturned;

}
