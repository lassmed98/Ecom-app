package org.sid.orderservice.repo;

import org.sid.orderservice.entities.order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface OrderRepository extends JpaRepository<order,Long> {
    @RestResource(path="/byCustomerId")
    List<order> findByCustomerId(@Param("customerId") Long customerId);

}
