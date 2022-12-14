package hopkq.store.entities;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "account")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "Email", length = 50)
    private String email;

    @Column(name = "Password", length = 80)
    private String password;

    @Column(name = "Account_Detail_Id")
    private Integer accountDetailId;

    @Column(name = "Role_ID")
    private Integer roleId;

    @Column(name = "Status")
    private Integer status;

    @Column(name = "Create_Date", nullable = false)
    private Timestamp createDate;


    public String getFmDate() {
        String timeStamp = new SimpleDateFormat("dd-MM-yyyy").format(this.createDate);
        return timeStamp;
    }


}