package entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class CustomerEntity {
    private String custId;
    private String name;
    private String nic;
     private String address;
     private String phone;

}
