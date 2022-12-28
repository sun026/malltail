package malltail.domain;

import malltail.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class OrderDeliveryStarted extends AbstractEvent {

    private Long id;
    private Long orderNo;
    private String CustomerId;
    private Long ItemNo;
    private Long qty;
    private Date createDate;
    private String orderStatus;
    private String deliveryStatus;
    private String CustomerAddress;
    private String shippingAddress;
    private Long payId;
    private String CustomerName;
    private String phoneNumber;
    private String shopName;
}
