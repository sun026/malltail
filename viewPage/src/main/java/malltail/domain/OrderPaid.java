package malltail.domain;

import malltail.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class OrderPaid extends AbstractEvent {

    private Long id;
    private Long payId;
    private Long orderNo;
    private String paystatus;
    private Long itemNo;
}
