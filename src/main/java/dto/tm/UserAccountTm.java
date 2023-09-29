package dto.tm;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserAccountTm {
    private String userID;
    private String name;
    private String nic;
    private String userName;
    private String password;

}
