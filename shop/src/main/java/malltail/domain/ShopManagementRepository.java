package malltail.domain;

import malltail.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="shopManagements", path="shopManagements")
public interface ShopManagementRepository extends PagingAndSortingRepository<ShopManagement, Long>{

}
