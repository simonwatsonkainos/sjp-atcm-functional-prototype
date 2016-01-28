package uk.gov.moj.sjp.atcm.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import uk.gov.moj.sjp.atcm.persistence.dao.SjpCase;

@Component
public interface SjpCaseRepository extends JpaRepository<SjpCase, Long> {

}
