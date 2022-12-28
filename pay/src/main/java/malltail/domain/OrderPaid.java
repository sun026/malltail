package malltail.domain;

import malltail.domain.*;
import malltail.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderPaid extends AbstractEvent {

    private Long id;
    private Long payId;
    private Long orderNo;
    private String paystatus;
    private Long itemNo;

    public OrderPaid(Payment aggregate){
        super(aggregate);
    }
    public OrderPaid(){
        super();
    }
}
