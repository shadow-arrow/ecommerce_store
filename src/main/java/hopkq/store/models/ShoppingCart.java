package hopkq.store.models;


import lombok.Data;


@Data
public class ShoppingCart {

    private Integer id;
    private String name;
    private Float unitPrice;
    private Integer quantity;
    private String imageLink;

}
