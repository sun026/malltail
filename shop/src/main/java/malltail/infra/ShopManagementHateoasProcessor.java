package malltail.infra;
import malltail.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class ShopManagementHateoasProcessor implements RepresentationModelProcessor<EntityModel<ShopManagement>>  {

    @Override
    public EntityModel<ShopManagement> process(EntityModel<ShopManagement> model) {
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/acceptorder").withRel("acceptorder"));
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/rejectorder").withRel("rejectorder"));

        
        return model;
    }
    
}
