package malltail.external;

import lombok.Data;
import java.util.Date;
@Data
public class StatusView {

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


