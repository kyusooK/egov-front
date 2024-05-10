package egovk.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "DeliveryPage_table")
@Data
public class DeliveryPage {

    private String orderId;
    private String deliveryId;
    private String productId;
    private String productName;
    private Integer qty;

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
}
