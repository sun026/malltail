package malltail.infra;
import malltail.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;


@RestController
// @RequestMapping(value="/shippings")
@Transactional
public class ShippingController {
    @Autowired
    ShippingRepository shippingRepository;



    @RequestMapping(value = "shippings/{id}/completeshipping",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public Shipping completeShipping(@PathVariable(value = "id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /shipping/completeShipping  called #####");
            Optional<Shipping> optionalShipping = shippingRepository.findById(id);
            
            optionalShipping.orElseThrow(()-> new Exception("No Entity Found"));
            Shipping shipping = optionalShipping.get();
            shipping.completeShipping();
            
            shippingRepository.save(shipping);
            return shipping;
            
    }
    



}
