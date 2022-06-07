package my.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import my.rest.model.tables.TMails;

@Repository
public interface TMailsRepository extends JpaRepository<TMails, Long> {

}
