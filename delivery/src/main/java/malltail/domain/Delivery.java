package malltail.domain;

import malltail.domain.CustomsRejected;
import malltail.domain.DeliveryStarted;
import malltail.domain.DeliveryCompleted;
import malltail.DeliveryApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Delivery_table")
@Data

public class Delivery  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private Integer orderNo;
    
    
    
    
    
    private String deliveryAddress;
    
    
    
    
    
    private String customsStatus;
    
    
    
    
    
    private String deliveryStatus;
    
    
    
    
    
    private Integer invoiceNo;
    
    
    
    
    
    private String sender;
    
    
    
    
    
    private String receiver;
    
    
    
    
    
    private Integer phoneNumber;

    @PostPersist
    public void onPostPersist(){


        CustomsRejected customsRejected = new CustomsRejected(this);
        customsRejected.publishAfterCommit();



        DeliveryStarted deliveryStarted = new DeliveryStarted(this);
        deliveryStarted.publishAfterCommit();



        DeliveryCompleted deliveryCompleted = new DeliveryCompleted(this);
        deliveryCompleted.publishAfterCommit();

    }

    public static DeliveryRepository repository(){
        DeliveryRepository deliveryRepository = DeliveryApplication.applicationContext.getBean(DeliveryRepository.class);
        return deliveryRepository;
    }




    public static void addToCustomsList(ShippingCompleted shippingCompleted){

        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        */

        /** Example 2:  finding and process
        
        repository().findById(shippingCompleted.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);


         });
        */

        
    }


}
