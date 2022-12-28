package malltail.external;

import lombok.Data;
import java.util.Date;
@Data
public class Shipping {

    private Long id;
    private Integer orderNo;
    private String shippingAddress;
    private String shippingStatus;
    private Integer transportNo;
    private String sender;
    private String receiver;
    private Integer phoneNumber;
}


