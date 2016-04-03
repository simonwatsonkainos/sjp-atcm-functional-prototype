package uk.gov.moj.sjp.atcm.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import uk.gov.moj.sjp.atcm.persistence.dao.SjpCase;

import java.util.List;
import java.util.UUID;

@Component
public interface SjpCaseRepository extends JpaRepository<SjpCase, UUID> {
    List<SjpCase> findByStatus(String status);
    List<SjpCase> findByProsecutorId(String prosecutorId);
    SjpCase findByDefendantId(UUID defendantId);
}
