package malltail.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;


@FeignClient(name = "shipping", url = "${api.url.shipping}")
public interface ShippingService {
    @RequestMapping(method= RequestMethod.GET, path="/shippings/{id}")
    public Shipping getShipping(@PathVariable("id") Long id);
}
