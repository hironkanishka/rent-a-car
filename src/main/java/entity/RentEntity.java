package entity;

import lombok.*;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class RentEntity {
    private String rentID;
    private Date fromDate;
    private Date toDate;
    private Double perDayRent;
    private Double advancedPayment;
    private Double refundable;
    private Double total;
    private Double balance;
    private String cCustId;
    private String cCarId;

}
