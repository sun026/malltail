package malltail.external;

import lombok.Data;
import java.util.Date;
@Data
public class Payment {

    private Long id;
    private Long payId;
    private Long orderNo;
    private String paystatus;
    private Long itemNo;
}


