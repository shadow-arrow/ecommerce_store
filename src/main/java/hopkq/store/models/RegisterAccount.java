package hopkq.store.models;

import lombok.Data;


@Data
public class RegisterAccount {

    private String email;
    private String password;
    private String passwordConfirm;
    private String name;
    private String phoneNumber;
    private int gender;

}
