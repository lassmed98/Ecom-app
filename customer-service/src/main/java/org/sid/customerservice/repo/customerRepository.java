package org.sid.customerservice.repo;

import org.sid.customerservice.entities.customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface customerRepository extends JpaRepository<customer,Long> {
}
