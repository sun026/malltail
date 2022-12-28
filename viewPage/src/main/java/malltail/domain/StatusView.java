package malltail.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;


@Entity
@Table(name="StatusView_table")
@Data
public class StatusView {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long orderNo;
        private String customerId;
        private Long itemNo;
        private Long qty;
        private Date createDate;
        private Date updateDate;
        private String orderStatus;
        private String deliveryStatus;
        private String customerName;
        private String transportNo;
        private String invoiceNo;
        private Boolean isShipped;
        private Boolean isCoutomsApproved;


}
