package hopkq.store.models;

import lombok.Data;

@Data
public class ProductModel {

    private Integer id;
    private String name;
    private Integer categoryId;
    private Float price;
    private String description;
    private Integer quantity;
    private Integer status;
    private String imageLink;
    private String note;

}
