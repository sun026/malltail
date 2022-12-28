package malltail.domain;

import malltail.domain.Ordered;
import malltail.domain.OrderCanceled;
import malltail.OrderApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="OrderManagement_table")
@Data

public class OrderManagement  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Long orderNo;
    
    
    
    
    
    private String customerId;
    
    
    
    
    
    private Long itemNo;
    
    
    
    
    
    private Long qty;
    
    
    
    
    
    private Date createDate;
    
    
    
    
    
    private String orderStatus;
    
    
    
    
    
    private String deliveryStatus;
    
    
    
    
    
    private String customerAddress;
    
    
    
    
    
    private String customerName;
    
    
    
    
    
    private String phoneNumber;
    
    
    
    
    
    private Date updateDate;

    @PostPersist
    public void onPostPersist(){

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.




        Ordered ordered = new Ordered(this);
        ordered.publishAfterCommit();



        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();

        // Get request from Shipping
        //malltail.external.Shipping shipping =
        //    Application.applicationContext.getBean(malltail.external.ShippingService.class)
        //    .getShipping(/** mapping value needed */);

    }

    public static OrderManagementRepository repository(){
        OrderManagementRepository orderManagementRepository = OrderApplication.applicationContext.getBean(OrderManagementRepository.class);
        return orderManagementRepository;
    }



    public void cancel(){
    }



}
