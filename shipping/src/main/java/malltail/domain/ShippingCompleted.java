package malltail.domain;

import malltail.domain.*;
import malltail.infra.AbstractEvent;
import java.util.*;
import lombok.*;


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

    public ShippingCompleted(Shipping aggregate){
        super(aggregate);
    }
    public ShippingCompleted(){
        super();
    }
}
