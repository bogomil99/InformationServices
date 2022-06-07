package my.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import my.rest.model.tables.TAddresses;

@Repository
public interface TAddressesRepository extends JpaRepository<TAddresses, Long> {

}
