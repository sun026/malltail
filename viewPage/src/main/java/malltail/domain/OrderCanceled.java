package malltail.domain;

import malltail.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class OrderCanceled extends AbstractEvent {

    private Long id;
    private Long orderNo;
    private Long itemNo;
    private Long qty;
    private Date createDate;
    private String status;
    private String orderStatus;
    private String deliveryStatus;
    private String CustomerId;
    private String customerAddress;
    private String customerName;
    private String phoneNumber;
    private Date updateDate;
}
