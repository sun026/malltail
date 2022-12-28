package malltail.domain;

import malltail.domain.*;
import malltail.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class OrderDeliveryStarted extends AbstractEvent {

    private Long id;
    private Long orderNo;
    private String customerId;
    private Long itemNo;
    private Long qty;
    private Date createDate;
    private String orderStatus;
    private String deliveryStatus;
    private String customerAddress;
    private String shippingAddress;
    private Long payId;
    private String customerName;
    private String phoneNumber;
    private String shopName;
}


