package uk.gov.moj.sjp.atcm.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import uk.gov.moj.sjp.atcm.persistence.dao.RefSjpOffence;

@Component
public interface RefSjpOffenceRepository extends JpaRepository<RefSjpOffence, Long> {
    RefSjpOffence getByOffenceCode(String offenceCode);
}
