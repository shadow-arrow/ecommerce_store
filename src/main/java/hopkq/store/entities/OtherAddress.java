package hopkq.store.entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "other_address")
@Data
@ToString
public class OtherAddress {
    @Id
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "Name", length = 200)
    private String name;

    @Column(name = "Phone_Number", length = 100)
    private String phoneNumber;

    @Column(name = "Address", length = 2000)
    private String address;

    @Column(name = "Order_Id")
    private Integer orderId;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

}