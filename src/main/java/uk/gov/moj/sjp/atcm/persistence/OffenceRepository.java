package uk.gov.moj.sjp.atcm.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import uk.gov.moj.sjp.atcm.persistence.dao.Offence;

import java.util.List;
import java.util.UUID;

@Component
public interface OffenceRepository extends JpaRepository<Offence, Long> {
    Offence getByTflCaseId(String tflCaseId);
    Offence getByCaseId(UUID caseId);
}
