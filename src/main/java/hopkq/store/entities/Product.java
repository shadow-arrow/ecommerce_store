package hopkq.store.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
@Data
@ToString
public class Product {
    @Id
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "Name", length = 200)
    private String name;

    @Column(name = "Category_Id")
    private Integer categoryId;

    @Column(name = "Price")
    private Float price;

    @Column(name = "Description", length = 1200)
    private String description;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "Status")
    private Integer status;

    @Column(name = "Image_Link", length = 200)
    private String imageLink;

    @Column(name = "Note", length = 1000)
    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}