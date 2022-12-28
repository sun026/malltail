package malltail.infra;

import malltail.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel="statusViews", path="statusViews")
public interface StatusViewRepository extends PagingAndSortingRepository<StatusView, Long> {

    List<StatusView> findByOrderNo(Long orderNo);


    void deleteByOrderNo(Long orderNo);

}
