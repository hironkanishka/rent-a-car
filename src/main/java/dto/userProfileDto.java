package dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class userProfileDto {
    private String id;
    private String name;
    private String nic;
    private String userName;
     private String  password;

}
