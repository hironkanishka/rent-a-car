package dto.tm;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CustomerTm {
    private String customerId;
    private String customerName;
    private String nic;
    private String address;
    private String phone;

}
