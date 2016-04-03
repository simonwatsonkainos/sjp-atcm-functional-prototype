package uk.gov.moj.sjp.atcm.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import uk.gov.moj.sjp.atcm.persistence.dao.Defendant;

import java.util.List;
import java.util.UUID;

@Component
public interface DefendantRepository extends JpaRepository<Defendant, UUID> {

    @Query("select d from Defendant d where d.familyName like %:search% or d.forename like %:search%")
    List<Defendant> searchDefendant(@Param("search") String search);


    /* @Query("select d from Defendant d where d.forename = :search or d.familyName = :search")
    List<Defendant> searchDefendant(@Param("search") String search); */
}
