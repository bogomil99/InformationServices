package my.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import my.rest.model.tables.TPeople;

@Repository
public interface TPeopleRepository extends JpaRepository<TPeople, Long> {

	@Query("SELECT tp FROM TPeople tp " + " WHERE lower(tp.fullName) like lower(concat('%', :name ,'%'))")
	List<TPeople> findTPeopleLikeName(@Param("name") String name);
}
