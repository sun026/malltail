package malltail.domain;

import malltail.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class DeliveryCompleted extends AbstractEvent {

    private Long id;
    private Integer orderNo;
    private String deliveryAddress;
    private String customsStatus;
    private String deliveryStatus;
    private Integer InvoiceNo;
    private String sender;
    private String receiver;
    private Integer phoneNumber;
}
