package malltail.domain;

import malltail.domain.*;
import malltail.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class OrderPaid extends AbstractEvent {

    private Long id;
    private Long payId;
    private Long orderNo;
    private String paystatus;
    private Long itemNo;
}


