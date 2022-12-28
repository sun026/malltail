package malltail.domain;

import malltail.domain.*;
import malltail.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class ShippingCompleted extends AbstractEvent {

    private Long id;
    private Integer orderNo;
    private String shippingAddress;
    private String shippingStatus;
    private Integer transportNo;
    private String sender;
    private String receiver;
    private Integer phoneNumber;
}


