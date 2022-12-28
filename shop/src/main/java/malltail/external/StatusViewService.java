package malltail.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;


@FeignClient(name = "viewPage", url = "${api.url.viewPage}")
public interface StatusViewService {
    @RequestMapping(method= RequestMethod.GET, path="/statusViews/{id}")
    public StatusView getStatusView(@PathVariable("id") Long id);
}
