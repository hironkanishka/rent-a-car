package dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class CustomerDto {
    private String custId;
    private String name;
    private String nic;
     private String address;
     private String phone;

}
