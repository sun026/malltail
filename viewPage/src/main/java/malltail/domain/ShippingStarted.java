package malltail.domain;

import malltail.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class ShippingStarted extends AbstractEvent {

    private Long id;
    private Integer orderNo;
    private String shippingAddress;
    private String shippingStatus;
    private Integer transportNo;
    private String sender;
    private String receiver;
    private Integer phoneNumber;
}
