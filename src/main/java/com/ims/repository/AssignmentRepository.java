package com.ims.repository;

import com.ims.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    List<Assignment> findByStatus(String status);
    List<Assignment> findByDepartment(String department);
    Optional<Assignment> findByAssetIdAndStatus(Long assetId, String status);
    List<Assignment> findByAssignedToContainingIgnoreCase(String name);
    long countByStatus(String status);
}