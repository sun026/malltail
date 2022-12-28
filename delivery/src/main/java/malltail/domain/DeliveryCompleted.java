package malltail.domain;

import malltail.domain.*;
import malltail.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class DeliveryCompleted extends AbstractEvent {

    private Long id;
    private Integer orderNo;
    private String deliveryAddress;
    private String customsStatus;
    private String deliveryStatus;
    private Integer invoiceNo;
    private String sender;
    private String receiver;
    private Integer phoneNumber;

    public DeliveryCompleted(Delivery aggregate){
        super(aggregate);
    }
    public DeliveryCompleted(){
        super();
    }
}
