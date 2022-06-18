package pl.pjat.jaz21355nbp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pjat.jaz21355nbp.model.RequestRecord;

@Repository
public interface RequestRecordRepository extends JpaRepository<RequestRecord, Long> {
}
