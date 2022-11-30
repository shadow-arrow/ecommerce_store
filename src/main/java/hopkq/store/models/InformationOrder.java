package hopkq.store.models;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class InformationOrder {

    private String name;
    private String phoneNumber;
    private String address;
    private String note;
}
