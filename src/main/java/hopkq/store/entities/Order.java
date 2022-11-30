package hopkq.store.entities;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "`order`")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "Account_Id")
    private Integer accountId;

    @Column(name = "Create_Date", nullable = false)
    private Timestamp createDate;

    @Column(name = "Total_Price")
    private Float totalPrice;

    @Column(name = "Note", length = 1000)
    private String note;

    @Column(name = "Status")
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public String getFmDate() {
        String timeStamp = new SimpleDateFormat("HH:mm dd-MM-yyyy").format(this.createDate);
        return timeStamp;
    }

}