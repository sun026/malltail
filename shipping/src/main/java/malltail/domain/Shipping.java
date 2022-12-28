package malltail.domain;

import malltail.domain.ShippingStarted;
import malltail.domain.ShippingCompleted;
import malltail.ShippingApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Shipping_table")
@Data

public class Shipping  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Integer orderNo;
    
    
    
    
    
    private String shippingAddress;
    
    
    
    
    
    private String shippingStatus;
    
    
    
    
    
    private Integer transportNo;
    
    
    
    
    
    private String sender;
    
    
    
    
    
    private String receiver;
    
    
    
    
    
    private Integer phoneNumber;

    @PostPersist
    public void onPostPersist(){


        ShippingStarted shippingStarted = new ShippingStarted(this);
        shippingStarted.publishAfterCommit();



        ShippingCompleted shippingCompleted = new ShippingCompleted(this);
        shippingCompleted.publishAfterCommit();

    }

    public static ShippingRepository repository(){
        ShippingRepository shippingRepository = ShippingApplication.applicationContext.getBean(ShippingRepository.class);
        return shippingRepository;
    }



    public void completeShipping(){
    }

    public static void startShipping(OrderDeliveryStarted orderDeliveryStarted){

        /** Example 1:  new item 
        Shipping shipping = new Shipping();
        repository().save(shipping);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderDeliveryStarted.get???()).ifPresent(shipping->{
            
            shipping // do something
            repository().save(shipping);


         });
        */

        
    }


}
