package egovk.infra;

import egovk.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "deliveryPages",
    path = "deliveryPages"
)
public interface DeliveryPageRepository
    extends PagingAndSortingRepository<DeliveryPage, Long> {}
